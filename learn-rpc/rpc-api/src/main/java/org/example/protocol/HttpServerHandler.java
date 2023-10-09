package org.example.protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.example.common.Invocation;
import org.example.register.LocalRegister;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 22:58
 */
public class HttpServerHandler {

  public void handler(HttpServletRequest req, HttpServletResponse resp) {
    // 处理请求 --> 接口, 方法, 参数
    try {
      Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
      String interfaceName = invocation.getInterfaceName();
      Class classImpl = LocalRegister.get(interfaceName, "1.0");
      Method method =
          classImpl.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
      String result = (String) method.invoke(classImpl.newInstance(), invocation.getParameters());
      IOUtils.write(result, resp.getOutputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    }
  }
}
