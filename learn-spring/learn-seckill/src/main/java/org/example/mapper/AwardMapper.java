package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Award;

/**
 * ${END}
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
public interface AwardMapper extends BaseMapper<Award> {
  /**
   * 将此行数据加锁，当整个事务提交后，才会解锁
   *
   * @param awardId
   * @return
   */
  Award queryAwardForUpdate(@Param("awardId") Long awardId);
  
  int updateAwardById(@Param("awardId") Long awardId);
  
  int updateAwardByVersion(@Param("awardCount") int awardCount, @Param("awardId") long awardId, @Param("version")int version);
}
