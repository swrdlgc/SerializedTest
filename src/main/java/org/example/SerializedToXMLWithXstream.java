package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author swrd
 * @version 1.0
 * @date 2023/5/15
 */
//常用的方法有：JAXB, XStream, JDOM, DOM4J, JIBX等。
public class SerializedToXMLWithXstream {
    private static final String file = "person.xml";

    public static void main(String[] args) throws Exception {
        SerializedToXMLWithXstream s = new SerializedToXMLWithXstream();
        s.save();
        s.load();
    }

    public void save() throws Exception {
        XStream xs = new XStream();
        xs.alias("Person", Person.class);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            xs.toXML(Person.Instance, fos);
        }
    }

    public void load() throws Exception {
        XStream xs = new XStream();
        xs.alias("Person", Person.class);
        try (FileInputStream fis = new FileInputStream(file)) {
            Person p = (Person) xs.fromXML(fis);
            System.out.println(p);
        }
    }
}
