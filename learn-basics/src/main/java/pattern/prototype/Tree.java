package pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tree.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree implements Cloneable {

  private float mass;
  private float height;
  private int position;

  public Tree(float mass, float height) {
    this.mass = mass;
    this.height = height;
  }

  @Override
  public Tree clone() {
    Tree tree = null;
    try {
      tree = (Tree) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return tree;
  }
}