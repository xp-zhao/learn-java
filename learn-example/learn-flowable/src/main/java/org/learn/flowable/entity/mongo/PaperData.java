package org.learn.flowable.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 试卷数据
 *
 * @author zhaoxiaoping
 * @date 2024-6-29
 */
@Data
@Document(collection = "paper_data")
public class PaperData {
  @Field("paperId")
  private String paperId;

  @Field("paperName")
  private String paperName;

  @Field("totalTime")
  private Integer totalTime;

  @Field("totalScore")
  private Double totalScore;
}
