import java.io.*;
import java.util.Arrays;

public class ReadBufferDemo {
    public static void main(String[] args) {
        read();
        read1();
        readWrite();
    }

    public static void read() {

        try (FileReader fr = new FileReader("buf.txt")) {
            char[] data = new char[20];
            int count;
            while ((count = fr.read(data)) != -1) {
                if (count == data.length) {
                    System.out.print(new String(data));
                } else {
                    data = Arrays.copyOf(data, count);
                    System.out.println(data);
                }
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read1() {

        try (BufferedReader br = new BufferedReader(new FileReader("buf.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readWrite() {

        try (BufferedReader br = new BufferedReader(new FileReader("buf.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("buf1.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}