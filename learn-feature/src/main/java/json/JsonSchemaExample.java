package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.util.Set;
import lombok.Data;

/**
 * json schema 使用示例
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
public class JsonSchemaExample {
  public static void main(String[] args) {
    JsonSchema jsonSchema =
        JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7)
            .getSchema(
                JsonSchemaExample.class.getClassLoader().getResourceAsStream("validation.json"));
    ObjectMapper objectMapper = new ObjectMapper();
    User user = new User();
    user.setUserId("1");
    user.setUserName("name");
    JsonNode jsonNode = objectMapper.valueToTree(user);
    Set<ValidationMessage> error = jsonSchema.validate(jsonNode);
    System.out.println(error);
  }

  @Data
  public static class User {
    private String userId;
    private String userName;
  }
}
