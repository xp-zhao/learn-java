package mapstruct;

/**
 * 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-10-26
 */
public class Example {
  public static void main(String[] args) {
    Source source = Source.builder().id(1L).age(18L).userNick("nick").build();
//    Target target = Converter.INSTANCE.convert(source);
//    System.out.println(target);
    DTO dto = Converter.INSTANCE.convert(source);
    System.out.println(dto);
  }
}
