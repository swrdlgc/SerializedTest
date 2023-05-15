package org.example;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author swrd
 * @version 1.0
 * @date 2023/5/15
 */
public class SerializedToJson {
    public static void main(String[] args) throws Exception {
        withGson();
        withJackson();
        withFastjson();
    }

    private static void withGson() {
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(Person.Instance);
        System.out.println(s);
        Person p = gson.fromJson(s, Person.class);
        System.out.println(p);
    }

    private static void withJackson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(Person.Instance);
        System.out.println(s);
        Person p = om.readValue(s, Person.class);
        System.out.println(p);
    }

    private static void withFastjson() {
        String s = JSON.toJSONString(Person.Instance);
        System.out.println(s);
        Person p = JSON.parseObject(s, Person.class);
        System.out.println(p);
    }
}
