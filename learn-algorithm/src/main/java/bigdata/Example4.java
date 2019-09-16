package bigdata;

/**
 * Example4.java
 * <pre>
 * 假设数据接入程序支持接入txt文件，并对文件进行处理。处理过程由多个处理单元形成串行的处理链路，每个处理单元都具有独立的数据处理能力。
 * 处理链路的配置通过XML实现，XML中配置处理链路名称、处理单元类路径和处理单元顺序，数据接入程序在启动时读取XML配置文件按照处理单元顺序组装处理链路。
 * 假设现在要创建一个“文章处理链”，包含两个处理单元，对接入的txt文件中的文章内容进行已处理。
 * 一个是民生类敏感词替换程序，另一类是暴恐类敏感词替换程序，都是将文章中涉及到敏感词设置为“*”，一个字节占一个“*”，
 * 民生类敏感词见程序包中的“livelihood_sensitive_words.txt”，暴恐类敏感词见“fear_sensitive_words.txt”。处理完成后将内容返回。
 *
 * 请编写数据处理程序实现上述的“文章处理链”，配置文件见“resources/chain_config.xml”。要求如下：
 * 1.	配置文件对象在内存中应该是单例的；
 * 2.	接入数据对象（见类DataModel.java）应该支持设置文件中的数据是结构化数据还是内容类数据，以及结构化数据之间的分隔符；
 * 3.	数据处理单元应该实现统一的接口（见接口类IDataProcessor）；
 * 4.	数据处理程序启动数据处理链应该是支持多线程处理的，并且需要限制启动的线程数。
 * </pre>
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/09
 **/
public class Example4 {
  /**
   * txt文件路径
   *
   * @param filePath txt文件路径
   */
  public String execute(String filePath) throws Exception {
    return null;
  }
}