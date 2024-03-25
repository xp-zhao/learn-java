import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-3-25
 */
@Slf4j
public class ApiTest {

  private Deployment deployment;
  private RepositoryService repositoryService;
  private ProcessEngine processEngine;

  @Before
  public void init() {
    ProcessEngineConfiguration processEngineConfiguration =
        new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
            .setJdbcDriver("org.h2.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

    processEngine = processEngineConfiguration.buildProcessEngine();
    repositoryService = processEngine.getRepositoryService();
    deployment =
        repositoryService.createDeployment().addClasspathResource("test.bpmn20.xml").deploy();
  }

  @Test
  public void testProcessDefinitionQuery() {
    ProcessDefinition processDefinition =
        repositoryService
            .createProcessDefinitionQuery()
            .deploymentId(deployment.getId())
            .singleResult();
    log.info(
        "Found process definition id:{}, name:{}",
        processDefinition.getId(),
        processDefinition.getName());
  }

  @Test
  public void testStartProcessInstance() {
    RuntimeService runtimeService = processEngine.getRuntimeService();
    ProcessInstance processInstance = runtimeService.startProcessInstanceById("process_001:1:4");
    log.info(
        "process instance id:{}, name:{}",
        processInstance.getProcessInstanceId(),
        processInstance.getProcessDefinitionName());
  }

  @Test
  public void testTaskQuery() {
    RuntimeService runtimeService = processEngine.getRuntimeService();
    Map<String, Object> params = new HashMap<>();
    // params.put("assignee", "4");
    params.put("INITIATOR", "4");
    ProcessInstance processInstance =
        runtimeService.startProcessInstanceById("process_001:1:4", params);
    TaskService taskService = processEngine.getTaskService();
    List<Task> list = taskService.createTaskQuery().list();
    log.info("task size: {}", list.size());
  }

  @Test
  public void testCommitForm() {
    RuntimeService runtimeService = processEngine.getRuntimeService();
    Map<String, Object> processStartParams = new HashMap<>();
    processStartParams.put("INITIATOR", "4");
    ProcessInstance processInstance =
        runtimeService.startProcessInstanceById("process_001:1:4", processStartParams);
    TaskService taskService = processEngine.getTaskService();
    Task task = taskService.createTaskQuery().taskAssignee("4").singleResult();
    log.info("task id: {}, name: {}", task.getId(), task.getName());
    Map<String, Object> taskCompleteParams = new HashMap<>();
    taskCompleteParams.put("money", 999);
    taskService.complete(task.getId());
    List<Task> taskList = taskService.createTaskQuery().list();
    System.out.println(taskList);
  }
}
