package org.zyw.sponsor.entity.unitCondition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zouyaowen
 * @Description: 推广单元限制维度：兴趣限制
 * @Date: 1:25 2019/7/26
 * @Modifyed by:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit_it")
public class AdUnitIt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "it_tag", nullable = false)
    private String itTag;

    public AdUnitIt(Long unitId, String itTag) {
        this.unitId = unitId;
        this.itTag = itTag;
    }

}
