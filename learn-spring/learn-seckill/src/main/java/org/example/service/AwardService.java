package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Award;
import org.example.mapper.AwardMapper;
import org.springframework.stereotype.Service;

/**
 * ${END}
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Service
public class AwardService extends ServiceImpl<AwardMapper, Award> {
  public Award queryAwardForUpdate(Long awardId) {
    return this.baseMapper.queryAwardForUpdate(awardId);
  }

  public Integer updateAwardById(Long awardId) {
    return this.baseMapper.updateAwardById(awardId);
  }

  public Integer updateAwardByVersion(Long awardId, Integer awardCount, Integer version) {
    return this.baseMapper.updateAwardByVersion(awardCount, awardId, version);
  }
}
