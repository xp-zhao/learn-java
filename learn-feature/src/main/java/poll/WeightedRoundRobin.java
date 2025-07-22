package poll;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权轮询负载均衡策略实现
 *
 * @author zhaoxiaoping
 * @date 2025-07-22
 */
public class WeightedRoundRobin {
  private List<Server> servers = new ArrayList<>();
  private int currentIndex = -1;
  private int remaining = 0;

  static class Server {
    String name;
    int weight;
    int currentWeight;

    public Server(String name, int weight) {
      this.name = name;
      this.weight = weight;
      this.currentWeight = weight;
    }
  }

  public void addServer(String name, int weight) {
    servers.add(new Server(name, weight));
    remaining += weight;
  }

  public String getNextServer() {
    if (remaining == 0) {
      resetWeights();
    }
    while (true) {
      currentIndex = (currentIndex + 1) % servers.size();
      Server server = servers.get(currentIndex);
      if (server.currentWeight > 0) {
        server.currentWeight--;
        remaining--;
        return server.name;
      }
    }
  }

  private void resetWeights() {
    for (Server server : servers) {
      server.currentWeight = server.weight;
      remaining += server.weight;
    }
  }

  public static void main(String[] args) {
    WeightedRoundRobin wrr = new WeightedRoundRobin();
    wrr.addServer("Server1", 1);
    wrr.addServer("Server2", 2);
    wrr.addServer("Server3", 3);
    for (int i = 0; i < 12; i++) {
      System.out.println("request " + (i + 1) + " -> " + wrr.getNextServer());
    }
  }
}
