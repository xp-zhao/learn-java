import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

/**
 * @author zhaoxiaoping
 * @date 2024-3-25
 */
@Slf4j
public class ProcessRequest {
  public static void main(String[] args) {
    ProcessEngineConfiguration processEngineConfiguration =
        new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
            .setJdbcDriver("org.h2.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

    ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    RepositoryService repositoryService = processEngine.getRepositoryService();
    Deployment deployment =
        repositoryService.createDeployment().addClasspathResource("request.bpmn20.xml").deploy();
    ProcessDefinition processDefinition =
        repositoryService
            .createProcessDefinitionQuery()
            .deploymentId(deployment.getId())
            .singleResult();
    log.info("Found process definition : {}", processDefinition.getName());
  }
}
