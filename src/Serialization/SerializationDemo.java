package Serialization;

import java.io.*;
public class SerializationDemo {
    public static void main(String args[]) {

        try {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            FileOutputStream fos = new FileOutputStream("serial.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object1);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println("Excepcion durante la serializacion: " + e);
            System.exit(0);
        }
        try {

            MyClass object2;
            FileInputStream fis = new FileInputStream("serial.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object2 = (MyClass)ois.readObject();
            ois.close();
            System.out.println("object2: " + object2);
        }
        catch(Exception e) {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }
    }
}
