package com.example.feature.mock;

import static org.mockito.ArgumentMatchers.any;

import cn.hutool.json.JSONUtil;
import com.example.feature.Application;
import com.example.feature.controller.entity.UserEntity;
import com.example.feature.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 控制层单元测试
 *
 * @author zhaoxiaoping
 * @date 2024-6-3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private UserService userService;

  @Test
  public void testGetMethod() throws Exception {
    Mockito.doNothing().when(userService).register(any());

    mockMvc
        .perform(MockMvcRequestBuilders.get("/getUser").param("userId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testPostMethod() throws Exception {
    UserEntity user = new UserEntity("1", "1");
    user.setUserId("xxx");
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONUtil.toJsonStr(user)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("xxx"));
  }

  @Test
  public void testPostMethodException() throws Exception {
    UserEntity user = new UserEntity("1", "1");
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONUtil.toJsonStr(user)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("参数验证失败: userId 不能为空"));
  }
}
