import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class task2 {
    public static void main(String[] args) throws IOException {
        int[] arr = { -5, 23, 7, 5, 3, -12, -29, 21, 54, 35, 0 };
        String log = writeToFile();
        FileWriter fileWriter = new FileWriter(log);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    fileWriter.append(Arrays.toString(arr));
                    fileWriter.append("\n");
                }
            }
        }
        fileWriter.close();
        System.out.println(Arrays.toString(arr));
    }
    
    public static String writeToFile() throws IOException {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/forTask2.txt");
            File fileToSave = new File(pathFile);
            try {
                fileToSave.canWrite();
            } catch (Exception e) {
                fileToSave.createNewFile();
            }
            return pathFile;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}
