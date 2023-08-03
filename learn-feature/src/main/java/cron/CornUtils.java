import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import java.util.Locale;

/**
 * cron 表达式解析工具测试
 *
 * @author zhaoxiaoping
 * @date 2023-8-3
 */
public class CornUtils {
  public static void main(String[] args) {
//    String cronExpression = "0/2 * * * * ?";
//    String cronExpression = "0 15 10 ? * MON-FRI";
    String cronExpression = "0 0 12 ? * WED";
    CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
    CronParser parser = new CronParser(cronDefinition);
    Cron cron = parser.parse(cronExpression);
    CronDescriptor descriptor = CronDescriptor.instance(Locale.CHINA);
    String description = descriptor.describe(cron);
    System.out.println(description);
  }
}
