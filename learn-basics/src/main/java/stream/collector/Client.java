package stream.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class Client {

  public static void main(String[] args) {
    List<Book> bookList = new ArrayList<>();
    bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
    bookList.add(new Book("The Two Towers", 1954, "0345339711"));
    bookList.add(new Book("The Return of the King", 1955, "0618129111"));

    listToMap(bookList).forEach((k, v) -> System.out.println(k + ": " + v));
  }

  private static Map<String, String> listToMap(List<Book> books) {
    return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
  }
}