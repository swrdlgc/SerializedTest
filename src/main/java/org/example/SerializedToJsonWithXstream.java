package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author swrd
 * @version 1.0
 * @date 2023/5/15
 */
public class SerializedToJsonWithXstream {
    private static final String file = "person.json";

    public static void main(String[] args) throws Exception {
        SerializedToJsonWithXstream s = new SerializedToJsonWithXstream();
        s.save();
        s.load();
    }

    public void save() throws Exception {
        XStream xs = new XStream(new JettisonMappedXmlDriver());
        xs.alias("Person", Person.class);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            xs.toXML(Person.Instance, fos);
        }
    }

    public void load() throws Exception {
        XStream xs = new XStream(new JettisonMappedXmlDriver());
        xs.alias("Person", Person.class);
        try (FileInputStream fis = new FileInputStream(file)) {
            Person p = (Person) xs.fromXML(fis);
            System.out.println(p);
        }
    }
}
