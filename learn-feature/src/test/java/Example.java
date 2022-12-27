import com.alibaba.excel.EasyExcel;
import excel.ExcelData;
import excel.ExcelDataListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zhaoxiaoping
 * @date 2022-12-26
 */
public class Example {

  public static void main(String[] args) throws IOException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      while (reader.ready()) {
        String line = reader.readLine();
        String[] arr = line.split(",");
        System.out.println("手机号: " + arr[0]);
        System.out.println("金额: " + arr[1]);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Resource resource = new ClassPathResource("example.xlsx");
    EasyExcel.read(resource.getInputStream(), ExcelData.class, new ExcelDataListener())
        .sheet()
        .headRowNumber(1)
        .doRead();
  }
}
