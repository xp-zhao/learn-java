package label;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description: 文档相关常量
 * @Date 2020-6-28
 **/
public interface DocumentConstant {

  interface Label {

    String MIDDLE = "middle";
    String RIGHT = "right";
    String MATH = "math";
    String MATH_START = "<math";
    String MATH_END = "</math>";
    Integer IMAGE_INDEX = 1;
  }


  enum LabelEnum {

    /**
     * 粗体
     */
    BOLD("粗体", "b"),
    /**
     * 斜体
     */
    ITALIC("斜体", "i"),
    /**
     * 加点
     */
    SPOT("加点", "spot"),
    /**
     * 波浪线
     */
    WAVYLINE("波浪线", "waveline"),
    /**
     * 下划线
     */
    UNDERLINE("下划线", "u"),
    /**
     * 布局
     */
    ALIGN(Arrays.asList("middle", "right"), "align"),
    /**
     * 字体颜色
     */
    FONT_COLOR(Arrays.asList("red", "blue", "orange", "yellow", "green"), "font");

    private String source;
    private List<String> sources;
    private String target;

    LabelEnum(String source, String target) {
      this.source = source;
      this.target = target;
    }

    LabelEnum(List<String> sources, String target) {
      this.sources = sources;
      this.target = target;
    }

    public String getSource() {
      return source;
    }

    public String getTarget() {
      return target;
    }

    public List<String> getSources() {
      return sources;
    }
  }
}
