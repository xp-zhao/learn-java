package core.exception;

import core.exception.custom.IncorrectFileExtensionException;
import core.exception.custom.IncorrectFileNameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ExceptionDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class ExceptionDemo {

  public static void main(String[] args) {

  }

  public String getLine(String fileName) throws IncorrectFileNameException {
    try (Scanner file = new Scanner(new File(fileName))) {
      if (file.hasNextLine()) {
        return file.nextLine();
      } else {
        throw new IllegalArgumentException("Non readable file");
      }
    } catch (FileNotFoundException e) {
      if (fileName.equals("")) {
        throw new IncorrectFileNameException("Incorrect filename:" + fileName, e);
      }
      return fileName;
    } catch (IllegalArgumentException e) {
      if (!fileName.contains(".jpg")) {
        throw new IncorrectFileExtensionException(
            "Filename does not contain extension : " + fileName, e);
      }
    }
    return null;
  }

  public static List<String> loadString() throws TimeoutException {
    List<String> list = new ArrayList<>();
    if (list.size() < 0) {
      throw new IllegalArgumentException("");
    }
    while (true) {
      if (list.size() > 100) {
        break;
      }
    }
    return list;
  }
}