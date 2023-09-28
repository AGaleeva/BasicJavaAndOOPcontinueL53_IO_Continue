import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class SymbolConversionDemo {
    public static void main(String[] args) {

        /*Set<Map.Entry<String, Charset>> charSet = Charset.availableCharsets().entrySet();
        for (Map.Entry<String, Charset> e : charSet) {
            System.out.println(e.getKey());
        }*/
        read();
    }
    public static void read() {
        // нужна перекодировка в KOI8-R
        try (FileReader fr = new FileReader("2.t", Charset.forName("KOI8-R"))) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
