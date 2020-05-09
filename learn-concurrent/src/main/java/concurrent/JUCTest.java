package concurrent;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020/4/26
 **/
public class JUCTest {

  public static void main(String[] args) {
    // 获取 cpu 的核数
    System.out.println(Runtime.getRuntime().availableProcessors());
    Data data = new Data();
    List<Long> list = Arrays.asList(data.getCategoryId());
    System.out.println(CollectionUtils.isEmpty(list));
    System.out.println(data);
  }

  static class Data {

    private Long categoryId;
    private List<Long> sourceIds;
    private List<Long> tagIds;

    public Long getCategoryId() {
      return categoryId;
    }

    public void setCategoryId(Long categoryId) {
      this.categoryId = categoryId;
    }

    public List<Long> getSourceIds() {
      return sourceIds;
    }

    public void setSourceIds(List<Long> sourceIds) {
      this.sourceIds = sourceIds;
    }

    public List<Long> getTagIds() {
      return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
      this.tagIds = tagIds;
    }

    @Override
    public String toString() {
      return "Data{" +
          "categoryId=" + categoryId +
          ", sourceIds=" + sourceIds +
          ", tagIds=" + tagIds +
          '}';
    }
  }
}
