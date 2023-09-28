package BytesDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadInputStream {
    public static void main(String[] args) {
        read();
    }

    public static void read() {
        try (FileInputStream fr = new FileInputStream("buf.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((int) data);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
