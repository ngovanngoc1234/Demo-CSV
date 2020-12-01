import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteCsvFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,name";
    public static void main(String[] args) {
        String csvFile = "data.csv";
        writeCsvFile(csvFile);
    }
    public static void writeCsvFile(String fileName) {
        ArrayList<Student> studentList = new ArrayList<>();

        Student student1 = new Student(1,"Bao");
        Student student2 = new Student(2,"Ngoc");
        Student student3 = new Student(3,"dat");
        studentList.addAll(student1,student2,student3);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Student s : studentList) {
                fileWriter.append(String.valueOf(s.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(s.getName());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file ghi thành công !!!");

        } catch (Exception e) {
            System.out.println("Lỗi ghi thất bại !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi !!!");
                e.printStackTrace();
            }
        }
    }
}

