package Array;

import java.io.*;
import java.net.*;

public class ArrayClient {
    public static void main(String argv[]) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        int dataset1[] = {2, 2, 2, 2, 2, 2, 2};
        int dataset2[] = {5, 5, 5, 5, 5, 5, 5};

        try {
            Socket socket = new Socket("localhost", 4000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            SerializedObject so1 = new SerializedObject();
            SerializedObject so2 = new SerializedObject();
            SerializedObject result = null;
            int outArray[] = new int[7];
            so1.setArray(dataset1);
            so2.setArray(dataset2);

            oos.writeObject(so1);
            oos.writeObject(so2);
            oos.flush();

            result = (SerializedObject) ois.readObject();
            outArray = result.getArray();
            System.out.print("The new array is: ");

            for(int i=0;i<outArray.length;i++) {
                System.out.print(outArray[i] + "   ");
            }
            oos.close();
            ois.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
