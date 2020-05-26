package com.xp.serializer.v2;

import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description: 测试
 * @Date 2020-5-26
 **/
public class SerializationTest {
  
  @Test
  public void testSerialize(){
    Serializable serializer = new Serialization();
    serializer.serialize(new Object());
  }
  
  @Test
  public void testDeserialize(){
    Deserializable deserializer = new Serialization();
    deserializer.deserialize("");
  }
}
