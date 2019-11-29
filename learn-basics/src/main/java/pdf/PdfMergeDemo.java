package pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * PdfMergeDemo.java pdf文件合并示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/29
 **/
public class PdfMergeDemo {

  public static void main(String[] args) throws IOException {
//    test();
    merge();
  }

  private static void test() throws IOException {
    try (
        FileInputStream fis = new FileInputStream("D:\\user\\pdf\\Elasticsearch学习笔记.pdf");
        FileInputStream fis1 = new FileInputStream("D:\\user\\pdf\\《码出高效：Java开发手册》.pdf");
        FileOutputStream fos = new FileOutputStream("D:\\user\\pdf\\Elasticsearch-copy.pdf")) {
      byte[] bytes = new byte[1024];
      while (true) {
        int temp = fis.read(bytes, 0, bytes.length);
        if (temp == -1) {
          break;
        }
        fos.write(bytes, 0, temp);
      }
      while (true) {
        int temp = fis1.read(bytes, 0, bytes.length);
        if (temp == -1) {
          break;
        }
        fos.write(bytes, 0, temp);
      }
    }
  }

  public static void merge() throws IOException {
    PDFMergerUtility ut = new PDFMergerUtility();
    ut.addSource(new File("D:\\user\\pdf\\Elasticsearch学习笔记.pdf"));
    ut.addSource(new File("D:\\user\\pdf\\《码出高效：Java开发手册》.pdf"));
    ut.setDestinationFileName("D:\\user\\pdf\\merge.pdf");
    ut.mergeDocuments();
  }
}