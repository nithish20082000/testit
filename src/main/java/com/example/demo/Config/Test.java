package com.example.demo.Config;

import com.fasterxml.jackson.annotation.JsonProperty;
//import org.msgpack.annotation.Message;
//import org.msgpack.annotation.Index;

//@Message // Marks this class as serializable for MessagePack
public class Test {
  // @Index(0) // Specifies the order of fields for serialization
   private String key;
  private int id;
 //  @Index(1)
   private String value;

   public Test() {
   }

   public Test(@JsonProperty("key") String key, @JsonProperty("value") String value){
      this.key = key;
      this.value = value;

   }
   public Test(int id){
      this.id=id;
   }

   // Getters and setters
   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }
}
