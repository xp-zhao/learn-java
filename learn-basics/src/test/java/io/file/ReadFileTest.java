package io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

/**
 * ReadFileTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/12/04
 **/
public class ReadFileTest {

  @Test
  public void testReadFileFromClassPath() {
    String expectedData = "Hello World from fileTest.txt!!!";
    Class clazz = ReadFileTest.class;
    InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
    String data = readFromInputStream(inputStream);

    Assert.assertEquals(data.trim(), expectedData.trim());
  }

  @Test
  public void testUsingFilesReadAllBytes() throws URISyntaxException, IOException {
    String expectedData = "Hello World from fileTest.txt!!!";
    Path path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());
    byte[] fileBytes = Files.readAllBytes(path);
    String data = new String(fileBytes);
    Assert.assertEquals(data, expectedData.trim());
  }

  @Test
  public void testUsingFilesLines() throws URISyntaxException, IOException {
    String expectedData = "Hello World from fileTest.txt!!!";
    Path path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());

    Stream<String> lines = Files.lines(path);
    String data = lines.collect(Collectors.joining("\n"));
    lines.close();
    Assert.assertEquals(data, expectedData.trim());
  }

  private String readFromInputStream(InputStream inputStream) {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}