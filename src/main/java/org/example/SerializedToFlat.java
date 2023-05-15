package org.example;

import java.io.*;

/**
 * @author swrd
 * @version 1.0
 * @date 2023/5/15
 */
public class SerializedToFlat {
    private static final String file = "person.txt";

    public static void main(String[] args) throws Exception {
        SerializedToFlat s = new SerializedToFlat();
        s.save();
        s.load();
    }

    public void save() throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(Person.Instance);
            oos.flush();
        }
    }

    public void load() throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        }
    }
}
