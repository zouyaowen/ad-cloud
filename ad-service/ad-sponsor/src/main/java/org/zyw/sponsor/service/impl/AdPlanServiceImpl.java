package org.zyw.sponsor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zyw.exception.AdException;
import org.zyw.sponsor.constant.CommonStatus;
import org.zyw.sponsor.constant.Constants;
import org.zyw.sponsor.entity.AdPlan;
import org.zyw.sponsor.entity.AdUser;
import org.zyw.sponsor.repository.AdPlanRepository;
import org.zyw.sponsor.repository.AdUserRepository;
import org.zyw.sponsor.service.IAdPlanService;
import org.zyw.sponsor.util.CommonUtils;
import org.zyw.sponsor.vo.AdPlanGetRequest;
import org.zyw.sponsor.vo.AdPlanRequest;
import org.zyw.sponsor.vo.AdPlanResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 16:46 2019/7/27
 * @Modifyed by:
 */
@Service
public class AdPlanServiceImpl implements IAdPlanService {

    @Autowired
    private AdPlanRepository planRepository;
    @Autowired
    private AdUserRepository userRepository;

    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest adPlanRequest) {
        if (!adPlanRequest.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_REEOR);
        }
        //确保关联的user是存在的
        Optional<AdUser> adUser = userRepository.findById(adPlanRequest.getUserId());
        if (!adUser.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        AdPlan oldPlan = planRepository.findByUserIdAndAndAndPlanName(adPlanRequest.getUserId(), adPlanRequest.getPlanName());
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }
        AdPlan newAdPlan = planRepository.save(
                new AdPlan(adPlanRequest.getUserId(),
                        adPlanRequest.getPlanName(),
                        CommonUtils.parseStringDate(adPlanRequest.getStartDate()),
                        CommonUtils.parseStringDate(adPlanRequest.getEndDate())
                )
        );
        return new AdPlanResponse(newAdPlan.getId(), newAdPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest adPlanGetRequest) {
        if (!adPlanGetRequest.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_REEOR);
        }
        return planRepository.findAllByIdInAndAndUserId(adPlanGetRequest.getIds(), adPlanGetRequest.getUserId());
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest adPlanRequest) {
        if (!adPlanRequest.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_REEOR);
        }
        AdPlan plan = planRepository.findByIdAndAndUserId(adPlanRequest.getId(), adPlanRequest.getUserId());

        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        if (adPlanRequest.getPlanName() != null) {
            plan.setPlanName(adPlanRequest.getPlanName());
        }
        if (adPlanRequest.getStartDate() != null) {
            plan.setStartDate(CommonUtils.parseStringDate(adPlanRequest.getStartDate()));
        }
        if (adPlanRequest.getEndDate() != null) {
            plan.setEndDate(CommonUtils.parseStringDate(adPlanRequest.getEndDate()));
        }
        plan.setUpdateTime(new Date());
        AdPlan save = planRepository.save(plan);
        return new AdPlanResponse(save.getId(), save.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest adPlanRequest) {
        if(!adPlanRequest.deleteValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_REEOR);
        }
        AdPlan plan = planRepository.findByIdAndAndUserId(adPlanRequest.getId(), adPlanRequest.getUserId());
        if(plan==null){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        planRepository.save(plan);
    }
}
