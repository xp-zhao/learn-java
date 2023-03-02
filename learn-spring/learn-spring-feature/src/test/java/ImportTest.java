import com.example.feature.annotation.ImportConfig;
import com.example.feature.annotation.SimpleClass;
import com.example.feature.annotation.SimpleRegistry;
import com.example.feature.annotation.SimpleSelector;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaoxiaoping @Import 注解测试
 * @date 2023-3-2
 */
@Slf4j
public class ImportTest {
  @Test
  public void testImportSimpleClass() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(ImportConfig.class);
    SimpleClass bean = applicationContext.getBean(SimpleClass.class);
    bean.test();
  }

  @Test
  public void testImportRegistry() {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ImportConfig.class);
    SimpleRegistry bean = applicationContext.getBean(SimpleRegistry.class);
    bean.test();
  }

  @Test
  public void testImportSelector() {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ImportConfig.class);
    SimpleSelector bean = applicationContext.getBean(SimpleSelector.class);
    bean.test();
  }
}
