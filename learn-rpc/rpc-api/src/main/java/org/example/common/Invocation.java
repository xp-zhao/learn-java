package org.example.common;

import java.io.Serializable;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 23:00
 */
public class Invocation implements Serializable {
  private String interfaceName;
  private String methodName;
  private Class[] parameterTypes;
  private Object[] parameters;

  public Invocation(
      String interfaceName, String methodName, Class[] parameterTypes, Object[] parameters) {
    this.interfaceName = interfaceName;
    this.methodName = methodName;
    this.parameterTypes = parameterTypes;
    this.parameters = parameters;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName) {
    this.interfaceName = interfaceName;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  public Class[] getParameterTypes() {
    return parameterTypes;
  }

  public void setParameterTypes(Class[] parameterTypes) {
    this.parameterTypes = parameterTypes;
  }

  public Object[] getParameters() {
    return parameters;
  }

  public void setParameters(Object[] parameters) {
    this.parameters = parameters;
  }
}
