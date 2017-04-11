/**
 *
 */
package com.nanoutech.lime.test.activiti;

import com.nanoutech.lime.test.base.SpringBaseTestCase;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cmd.GetDeploymentProcessDiagramCmd;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author YZhi
 * @since 2015-11-18 下午3:36:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-activiti.xml")
public class ActivitiTestCase extends SpringBaseTestCase {

    @Resource
    ProcessEngine engine;

    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void init() {

    }

    /**
     * 部署流程
     */
    @Test
    public void testDeploy() {
        RepositoryService service = engine.getRepositoryService();
        String processName = "Hello.bpmn";
        service.createDeployment().addClasspathResource("diagrams/" + processName).deploy();
        List<ProcessDefinition> processDefinitions = service.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : processDefinitions) {
            System.out.println(processDefinition.toString());
        }
    }

    /**
     * 已部署流程列表
     */
    @Test
    public void testDeployed() {
        RepositoryService service = engine.getRepositoryService();
        List<ProcessDefinition> processDefinitions = service.createProcessDefinitionQuery().list();
        System.out.println(processDefinitions.toArray());
    }

    /**
     * 启动一个流程实例
     */
    @Test
    public void testStart() {
        String id = "hello:2:104";
        RuntimeService service = engine.getRuntimeService();
        service.startProcessInstanceById(id);
        List<ProcessInstance> processInstances = service.createProcessInstanceQuery().list();
        System.out.println(processInstances.toArray());
    }

    /**
     * 所有已启动流程实例
     */
    @Test
    public void testStarted() {
        RuntimeService service = engine.getRuntimeService();
        List<ProcessInstance> processInstances = service.createProcessInstanceQuery().list();
        System.out.println(processInstances.toArray());
    }

    /**
     * 进入任务列表
     */
    @Test
    public void testTask() {
        TaskService service = engine.getTaskService();
        List<Task> tasks = service.createTaskQuery().list();
        System.out.println(tasks.toArray());
    }

    /**
     * 完成当前节点
     */
    @Test
    public void testComplete() {
        String id = "204";
        TaskService service = engine.getTaskService();
        service.complete(id);
    }

    /**
     * 所有已启动流程实例
     *
     * @throws Exception
     */
    @Test
    public void graphics() throws Exception {
        String definitionId = "hello:2:104";
        String instanceId = null;
        String taskId = "302";
        Command<InputStream> cmd = null;
        if (definitionId != null) {
            cmd = new GetDeploymentProcessDiagramCmd(definitionId);
        }
        if (taskId != null) {
            Task task = engine.getTaskService().createTaskQuery().taskId(taskId).singleResult();
            //cmd = new (task.getProcessInstanceId());
        }
        if (cmd != null) {
            InputStream is = engine.getManagementService().executeCommand(cmd);
            int len = 0;
            byte[] b = new byte[1024];
            OutputStream os = new FileOutputStream("test.png");
            while ((len = is.read(b, 0, 1024)) != -1) {
                os.write(b, 0, len);
            }
        }
    }

}
