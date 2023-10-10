package org.example.common;

import java.io.Serializable;

/**
 * @author zhaoxiaoping
 * @date 2023-10-10
 */
public class URL implements Serializable {
  private String hostname;
  private Integer port;

  public URL(String hostname, Integer port) {
    this.hostname = hostname;
    this.port = port;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }
}
