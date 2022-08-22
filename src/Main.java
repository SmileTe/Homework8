import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printIsLeapYearResult(2022); //task1
        printApplicationVersion(1, 2015);
        printNumberOfDeliveryDays(100);
        printAverageSpending();
    }

    public static void printIsLeapYearResult(int NumberYear) {
        if (isLeapYear(NumberYear)) {
            System.out.printf("%d - високосный год", NumberYear );
            System.out.println("");
        }
        else
            System.out.printf("%d - не високосный год", NumberYear);
        System.out.println("");
    }

    private static boolean isLeapYear(int NumberYear) {
        return NumberYear%400==0 && NumberYear%100!=0 ||NumberYear%4==0;
    }

    public static void printApplicationVersion(int ClientType, int clientDeviceYear) {
        if (isClientTypeiOS(ClientType)&&isLessCurrentYear(clientDeviceYear)){
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (isClientTypeiOS(ClientType)){
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (isLessCurrentYear(clientDeviceYear))
        {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else
            System.out.println("Установите версию приложения для Android по ссылке");

    }

    public static boolean isLessCurrentYear(int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        return clientDeviceYear <currentYear;
    }

    public static boolean isClientTypeiOS(int ClientType) {
        return ClientType==1;
    }

    public static void printNumberOfDeliveryDays( int deliveryDistance) {
        //Доставка в пределах 20 км занимает сутки.
        //Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
        //Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
        byte Days = 1;

        if (isBiggerThanNumberKm(deliveryDistance, 20)) {
            Days += 1;
        }
        if (isBiggerThanNumberKm(deliveryDistance, 60)) {
            Days += 1;
        }
        System.out.printf("Потребуется дней: %d", Days);
        System.out.println("");
    }

    public static boolean isBiggerThanNumberKm(int deliveryDistance, int NumberKm) {
        return deliveryDistance >=NumberKm;
    }

    public static void printAverageSpending() {
        /*
        Снова вспоминаем домашнее задание по массивам. В нем была задача,
        которая требовала высчитать среднюю выплату за день.
Был дан сгенерированный массив из 30 значений от 100 до 200 тысяч, для его
 генерации допускается использовать метод из прошлого домашнего задания.
Нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
Нужно написать программу, которая посчитает среднее значение трат за месяц
 (то есть сумму всех трат за месяц поделить на количество дней),
  и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
:восклицательный_знак: Важно помнить: подсчет среднего значения может иметь остаток
(то есть быть не целым, а дробным числом).
Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать
сумму элементов и вычислить среднее значение, которое нужно вернуть из метода в виде результата.
Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
То есть для работы этого метода нужно будет создать еще методы
 (1 или более), которые его будут обслуживать и вычислять промежуточные результаты.
 Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
Критерии оценки
– Методы декомпозированы корректно.
– Программа выводит корректный результат при изменении значений массива.
         */
        int array [] = generateRandomArray();


        int sum = sumArray(array);
        float average = (float)sum/ (array.length);
        System.out.printf("Средняя сумма трат за месяц составила %.2f рублей", average);


    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int i: array
        ) {
            sum+=i;
        }
        return sum;
    }


    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}