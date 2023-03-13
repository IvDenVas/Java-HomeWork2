
import java.util.Scanner;
import java.util.logging.*;


public class task4 {
    
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(task4.class.getName());
        FileHandler fh = new FileHandler("forTask4.xml", true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Запуск калькулятора");

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double inputFirst = iScanner.nextInt();
        System.out.println("Введите логический оператор (+-*/): ");
        String inputOperator = iScanner.next();
        System.out.println("Введите второе число: ");
        double inputSecond = iScanner.nextInt();
        iScanner.close();

        switch (inputOperator) {
            case "+":
                System.out.println(inputFirst + inputSecond);
                logger.info("Сложение");
                break;
            case "-":
                System.out.println(inputFirst - inputSecond);
                logger.info("Вычитание");
                break;
            case "*":
                System.out.println(inputFirst * inputSecond);
                logger.info("Умножение");
                break;
            case "/":
                if (inputSecond != 0) {
                    System.out.println(inputFirst / inputSecond);
                    logger.info("Деление");
                }
                else {
                    System.out.println("На ноль делить нельзя!!!");
                    logger.info("Ошибка деления на 0");
                }
                break;
            default:
                System.out.println("Неверный логический оператор! ");
                logger.info("Неверный логический оператор!");
        }
    }

}
