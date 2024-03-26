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
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
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
  private HistoryService historyService;

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
    historyService = processEngine.getHistoryService();
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
    // 用户 4 发起报销流程
    processStartParams.put("INITIATOR", "4");
    ProcessInstance processInstance =
        runtimeService.startProcessInstanceById("process_001:1:4", processStartParams);
    TaskService taskService = processEngine.getTaskService();
    // 用户任务：用户4填写报销单，录入金额并提交
    Task userTask = taskService.createTaskQuery().taskAssignee("4").singleResult();
    log.info("user task id: {}, name: {}", userTask.getId(), userTask.getName());
    Map<String, Object> userTaskCompleteParams = new HashMap<>();
    userTaskCompleteParams.put("money", 999);
    taskService.complete(userTask.getId(), userTaskCompleteParams);
    // 用户任务：主管选择同意or拒绝
    Task leaderTask = taskService.createTaskQuery().taskCandidateGroup("leader").singleResult();
    log.info("leader task id: {}, name: {}", leaderTask.getId(), leaderTask.getName());
    Map<String, Object> leaderTaskCompleteParams = new HashMap<>();
    leaderTaskCompleteParams.put("form_leader_approve_or_reject_outcome", "拒绝");
    taskService.complete(leaderTask.getId(), leaderTaskCompleteParams);
    // 历史任务查询
    HistoricTaskInstanceQuery historicTaskQuery = historyService.createHistoricTaskInstanceQuery();
    List<HistoricTaskInstance> list = historicTaskQuery.list();
    System.out.println(list.size());
  }
}
