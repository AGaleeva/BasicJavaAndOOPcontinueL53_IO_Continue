package homework53;

import java.io.*;
import java.util.*;

public class ModificationDataReadFromFile {
    
    /*
    Задача 1
    Дан файл с текстом вида:

    jack:2000
    john:2900
    greta:3100
    john:1300
    nick:1200
    greta:500
    ...

    т.е. имя и сумма оплаты. Ваша задача прочитать файл, и сформировать два файла: part1 cо списком тех, кому 
    перечисленно в сумме менее 2000 и part2 cо списком тех, кому перечисленно в сумме более 2000.
    Обратите внимание, если в исходном файле john фигурирует дважды (как в нашем примере), это означает что один 
    и тот же человек и ему выплачивали дважды. Таким образом, в итоговом файле для john-а должна быть запись
    john:4200 и эта строка должна быть в файле part2.
    */

    public static void main(String[] args) {

        writeToFile(readDataFromFile());
    }

    public static Map<String, Integer> readDataFromFile() {
        Map<String, Integer> resMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("incomingData.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                handleLine(line, resMap);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resMap;
    }

    private static void handleLine(String str, Map<String, Integer> map) {
        String[] arr = str.split(":");
        String key = arr[0];
        Integer val = Integer.parseInt(arr[1]);
        if (map.containsKey(key)) {
            val = map.get(key) + val;
        }
        map.put(key, val);
    }

    public static void writeToFile(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        try (FileWriter fileWriter1 = new FileWriter("part1.txt"); FileWriter fileWriter2 = new FileWriter("part2" +
                ".txt")) {
            for (Map.Entry<String, Integer> entry : entrySet) {
                String str = entry.getKey() + ":" + entry.getValue() + "\n";
                if (entry.getValue() < 2000) {
                    fileWriter1.write(str);
                } else {
                    fileWriter2.write(str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

