import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task1 {
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
        return result.replace("{", "").replace("}", "").replaceAll("\"", "").replace(" ", "").split(",");
    }

    public static StringBuilder LineInList(String[] line) {
        StringBuilder result = new StringBuilder("select * from students where ");
        for (int i = 0; i < line.length; i++) {
            String[] arrData = line[i].split(":");
            if (i < line.length) {
                if(arrData[1].equals("null") == false) {
                    if (i == 0) {
                        result.append(arrData[0]);
                        result.append(" = ");
                        result.append("\'" + arrData[1] + "\'");
                    } else {
                        result.append(" and ");
                        result.append(arrData[0]);
                        result.append(" = ");
                        result.append("\'" + arrData[1] + "\'");
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        String[] list = dataFromFailToArray("forTask1.txt");
        StringBuilder resultSelect = LineInList(list);
        System.out.println(resultSelect);
    }

}

