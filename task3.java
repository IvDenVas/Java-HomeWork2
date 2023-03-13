import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

public class task3 {
    public static String[] dataFromFailToArray(String args) {
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader(args))) {
            String s;
            while ((s = br.readLine()) != null) {
                result = s;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result.replace("[", "").replace("]", "")
                .replace("}", "").replaceAll("\"", "")
                .replace(" ", "").split("\\{");
    }

    public static void main(String[] args) {
        String[] result = dataFromFailToArray("forTask3.json");
        for (String string : result) {
            System.out.println(string.replace("фамилия:", "Студент ")
                    .replace(",оценка:", " получил ").replace(",предмет:", " по предмету ")
                    .replace(",", "") + ".");
        }
    }
}
    