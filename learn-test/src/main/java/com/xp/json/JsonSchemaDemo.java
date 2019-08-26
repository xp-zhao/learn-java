package com.xp.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

/**
 * JsonSchemaDemo.java 使用 JsonSchema 校验 json 串示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/26
 **/
public class JsonSchemaDemo {

  public static void main(String[] args) throws IOException, ProcessingException {
    ClassLoader loader = JsonSchemaDemo.class.getClassLoader();
    URL schemaUrl = loader.getResource("json/user-schema.json");
    JsonNode schema = JsonLoader.fromURL(schemaUrl);
    URL userUrl = loader.getResource("json/user.json");
    JsonNode user = JsonLoader.fromURL(userUrl);
    ProcessingReport validate = JsonSchemaFactory.byDefault().getJsonSchema(schema).validate(user);
    Iterator<ProcessingMessage> iterator = validate.iterator();
    while (iterator.hasNext()) {
      ProcessingMessage next = iterator.next();
      // 校验的错误信息
      System.out.println(next.getMessage());
    }
    System.out.println(validate.isSuccess());
  }
}