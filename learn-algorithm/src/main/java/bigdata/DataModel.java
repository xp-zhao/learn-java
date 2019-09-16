package bigdata;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 数据模型类，请基于此类扩充完成数据模型类
 */
public class DataModel {

  private String filePath;
  private boolean isStruct;//是否结构化数据
  private String columnSplit;//结构化数据间隔符
  private String lineSplit;//换行符
  private String content;

  /**
   * 内容类数据
   */
  public DataModel(String filePath) {
    this(filePath, false, null, null);
  }

  /**
   * 结构化数据
   */
  public DataModel(String filePath, boolean isStruct, String columnSplit, String lineSplit) {
    this.filePath = filePath;
    this.isStruct = isStruct;
    this.columnSplit = columnSplit;
    this.lineSplit = lineSplit;
    this.content = getFileContent();
  }

  /**
   * 获取文件内容
   */
  private String getFileContent() {
    try {
      File file = new File(this.filePath);
      return FileUtils.readFileToString(file, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFilePath() {
    return filePath;
  }

  public boolean isStruct() {
    return isStruct;
  }

  public String getColumnSplit() {
    return columnSplit;
  }

  public String getLineSplit() {
    return lineSplit;
  }
}
