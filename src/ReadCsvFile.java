import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCsvFile {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("data.csv"));

            while ((line = br.readLine()) != null) {
                printStudent(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchyException) {
                crunchyException.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    private static void printStudent(List<String> student) {
        System.out.println(
                "Student [id= "
                        + student.get(0)
                        + ", name= " + student.get(1)
                        + "]");
    }
}
