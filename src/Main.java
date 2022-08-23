import javax.swing.*;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printIsLeapYearResult(2022); //task1
        printApplicationVersion(1, 2015);
        printNumberOfDeliveryDays(95);
    }

    public static void printIsLeapYearResult(int NumberYear) {
        if (isLeapYear(NumberYear)) {
            System.out.printf("%d - високосный год", NumberYear );
        }
        else{
            System.out.printf("%d - не високосный год", NumberYear);
        }
        System.out.println();
    }

    private static boolean isLeapYear(int NumberYear) {
        return NumberYear%400==0 && NumberYear%100!=0 ||NumberYear%4==0;
    }

    public static void printApplicationVersion(int ClientType, int clientDeviceYear)  {


         if (isLiteVersionForOS(clientDeviceYear,ClientType,1))
            {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            }
        else if (ClientType==1){
            System.out.println("Установите версию приложения для iOS по ссылке");
            }
        else if (isLiteVersionForOS(clientDeviceYear,ClientType,0))
            {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
            }
        else if (ClientType==0){
            System.out.println("Установите версию приложения для Android по ссылке");
             }
        else
            {
                throw new NullPointerException("Значение типа ОС должно быть 0 или 1");
            }

    }

    public static boolean isLiteVersionForOS(int clientDeviceYear, int ClientType, int TypeOS) {
       int currentYear = LocalDate.now().getYear();
        return  ClientType==0&&clientDeviceYear <currentYear;
    }

    public static void printNumberOfDeliveryDays( int deliveryDistance) {
        int Days = 1;
        Days= calculateDays(deliveryDistance,Days);

        System.out.printf("Потребуется дней: %d", Days);
        System.out.println();
    }

    public static int calculateDays(int deliveryDistance, int Days) {
        if (deliveryDistance >=20) {
            Days += 1;
        }
        if (deliveryDistance >=60) {
            Days += 1;
        }
        return Days;
    }
}