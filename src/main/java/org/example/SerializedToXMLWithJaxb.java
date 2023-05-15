package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author swrd
 * @version 1.0
 * @date 2023/5/15
 */
//常用的方法有：JAXB, XStream, JDOM, DOM4J, JIBX等。
public class SerializedToXMLWithJaxb {
    private static final String file = "person.xml";

    public static void main(String[] args) throws Exception {
        SerializedToXMLWithJaxb s = new SerializedToXMLWithJaxb();
        s.save();
        s.load();
    }

    public void save() throws Exception {
        JAXBContext c = JAXBContext.newInstance(Person.class);
        Marshaller m = c.createMarshaller();

        //m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(Person.Instance, new File(file));
    }

    public void load() throws Exception {
        JAXBContext c = JAXBContext.newInstance(Person.class);
        Unmarshaller um = c.createUnmarshaller();
        Person p = (Person) um.unmarshal(new File(file));
        System.out.println(p);
    }
}
