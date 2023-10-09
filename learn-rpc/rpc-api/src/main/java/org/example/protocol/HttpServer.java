package org.example.protocol;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 22:45
 */
public class HttpServer {
  public void start(String hostname, Integer port) {
    // 读取用户的配置 server.name = netty/tomcat
    Tomcat tomcat = new Tomcat();

    Server server = tomcat.getServer();
    Service service = server.findService("Tomcat");

    Connector connector = new Connector();
    connector.setPort(port);

    Engine engine = new StandardEngine();
    engine.setDefaultHost(hostname);

    Host host = new StandardHost();
    host.setName(hostname);

    String contextPath = "";
    Context context = new StandardContext();
    context.setPath(contextPath);
    context.addLifecycleListener(new FixContextListener());

    host.addChild(context);
    engine.addChild(host);

    service.setContainer(engine);
    service.addConnector(connector);

    tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
    context.addServletMappingDecoded("/*", "dispatcher");

    try {
      tomcat.start();
      tomcat.getServer().await();
    } catch (LifecycleException e) {
      throw new RuntimeException(e);
    }
  }
}
