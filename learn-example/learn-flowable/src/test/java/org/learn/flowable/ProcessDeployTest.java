package org.learn.flowable;

import java.util.List;

import org.flowable.engine.FormService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoxiaoping
 * @date 2024-6-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessDeployTest {
  @Autowired private RepositoryService repositoryService;
  @Autowired private FormService formService;

  @Test
  public void testQueryProcessDefinition() {
    List<Deployment> deploymentList = repositoryService.createDeploymentQuery().list();
    List<ProcessDefinition> definitionList =
        repositoryService.createProcessDefinitionQuery().list();
    
    System.out.println(definitionList);
  }
  
  @Test
  public void testForm(){
  }
}
