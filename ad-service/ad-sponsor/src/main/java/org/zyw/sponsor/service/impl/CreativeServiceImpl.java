package org.zyw.sponsor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyw.sponsor.entity.Creative;
import org.zyw.sponsor.repository.CreativeRepository;
import org.zyw.sponsor.service.ICreativeService;
import org.zyw.sponsor.vo.CreativeRequest;
import org.zyw.sponsor.vo.CreativeResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:07 2019/7/28
 * @Modifyed by:
 */
@Service
public class CreativeServiceImpl implements ICreativeService {
    @Autowired
    private CreativeRepository creativeRepository;

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative save = creativeRepository.save(request.convertToEntity());
        return new CreativeResponse(save.getId(), save.getName());
    }
}
