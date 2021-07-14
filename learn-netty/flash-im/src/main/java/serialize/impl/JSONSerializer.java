package serialize.impl;

import com.alibaba.fastjson.JSON;
import serialize.Serializer;
import serialize.SerializerAlgorithm;

/**
 * @description: json 序列化实现类
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class JSONSerializer implements Serializer {

  @Override
  public byte getSerializerAlgorithm() {
    return SerializerAlgorithm.JSON;
  }

  @Override
  public byte[] serialize(Object object) {
    return JSON.toJSONBytes(object);
  }

  @Override
  public <T> T deserialize(Class<T> clazz, byte[] bytes) {
    return JSON.parseObject(bytes, clazz);
  }
}