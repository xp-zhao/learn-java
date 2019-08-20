package bigdata;

/**
 * <pre>
 * Example2.java IO 假设有一个1G大小的文件，内容是英文文章。 有多名审核人员对里面的文章进行审核，并对违规的句子通过下标的方式进行标识，
 * 下标从1开始。例如[102,156]表示从第102个字母到第156个字母组成的句子是违规的。
 * 由于是多名审核人员审核，所以可能会存在交叉，例如审核人员A标识[2,32],[98,119]，审核人员B标识[19,48],[56,72]，
 * 那么合并之后就是[2,48],[56,72],[98,119]。
 * 最终将多名审核人员的结果合并后，从文章中提取出对应的句子，提交给总编审核。
 * 假设有多名审核人员，每个审核人员将审核结果保存到统一的指定目录下，文件名以各自工号形成的例如“B0001.txt”，内容诸如“2,32;16,24;112,209…”，
 * 需要根据所有审核人员合并的结果提取文章内容，区间按从小到大排列，提取句子放到数组中返回。
 * </pre>
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/20
 **/
public class Example2 {

  public static void main(String[] args) {
    String srcFilePath = "D:\\user\\code\\file\\bigdata\\example2\\src";
    String approveResultDir = "D:\\user\\code\\file\\bigdata\\example2\\result";
    execute(srcFilePath, approveResultDir);
  }

  /**
   * 程序入口
   *
   * @param srcFilePath 源文件路径
   * @param approveResultDir 审核结果目录
   */
  public static String[] execute(String srcFilePath, String approveResultDir) {
    return null;
  }
}