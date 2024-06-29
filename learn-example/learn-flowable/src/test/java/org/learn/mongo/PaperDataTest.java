package org.learn.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.flowable.FlowableApplication;
import org.learn.flowable.entity.mongo.PaperData;
import org.learn.flowable.mapper.repository.PaperDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2024-6-29
 */
@SpringBootTest(classes = FlowableApplication.class)
@RunWith(SpringRunner.class)
public class PaperDataTest {
  @Autowired private PaperDataRepository paperDataRepository;

  @Test
  public void testSave() {
    List<PaperData> list = new ArrayList<>();
    PaperData d1 = new PaperData();
    d1.setPaperId("1231231");
    d1.setPaperName("testName");
    list.add(d1);
    PaperData d2 = new PaperData();
    d2.setPaperId("2222");
    list.add(d2);
    paperDataRepository.saveAll(list);
  }
}
