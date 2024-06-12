package org.learn.flowable.controller;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 流程部署控制层
 *
 * @author zhaoxiaoping
 * @date 2024-6-12
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProcessDeployController {
  private final RepositoryService repositoryService;

  @PostMapping("/deploy")
  public String deploy(MultipartFile file) throws IOException {
    DeploymentBuilder deploymentBuilder =
        repositoryService
            .createDeployment()
            .category("工作流分类")
            .name("工作流名称")
            .addInputStream(file.getOriginalFilename(), file.getInputStream())
            .key("工作流key");
    Deployment deployment = deploymentBuilder.deploy();
    return deployment.getId();
  }
  
  public void list(){
    repositoryService.createProcessDefinitionQuery();
  }
}
