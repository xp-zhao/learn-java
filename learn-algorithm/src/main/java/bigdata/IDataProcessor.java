package bigdata;

/**
 * 数据处理单元接口，数据处理单元应该实现该类
 */
public interface IDataProcessor {

  /**
   * 执行数据处理操作
   *
   * @param dataModel 数据模型
   */
  void process(DataModel dataModel);
}
