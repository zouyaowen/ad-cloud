package org.zyw.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:32 2019/7/27
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItRequest {
    private List<UnitIt> unitIts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt {

        private Long unitId;
        private String itTag;
    }
}
