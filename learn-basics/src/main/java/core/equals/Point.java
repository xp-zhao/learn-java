package core.equals;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author zhaoxiaoping
 * @date 2023-8-4
 */
public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object other) {
    boolean result = false;
    if (other instanceof Point) {
      Point that = (Point) other;
      return (this.getX() == that.getX() && this.getY() == that.getY());
    }
    return result;
  }

  @Override
  public int hashCode() {
    return (41 * (41 + getX() + getY()));
  }

  public static void main(String[] args) {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1, 2);

    Point q = new Point(2, 3);
    System.out.println(p1.equals(p2)); // prints true
    System.out.println(p1.equals(q)); // prints false
    HashSet<Point> coll = new HashSet<Point>();
    coll.add(p1);
    p1.setX(p1.getX() + 1);
    System.out.println(coll.contains(p1)); // prints false

    Iterator<Point> iterator = coll.iterator();
    boolean flag = false;
    while (iterator.hasNext()) {
      Point next = iterator.next();
      if (next.equals(p1)) {
        flag = true;
        break;
      }
    }
    System.out.println(flag);
  }
}
