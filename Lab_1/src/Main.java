import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem_1();
        problem_2();
    }

    static void problem_1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int steps = 0;

        while(true) {
            if(number % 2 == 0) {
                number = number / 2;
            }
            else {
                number = number * 3 + 1;
            }
            steps++;

            if(number == 1) break;
        }
        System.out.println("Для создания последовательности Коллатца для заданного числа потребовалось " + steps + " шагов.");
    }
    static void problem_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        while(number < 0) {
            System.out.println("Число должно быть больше нуля! Давайте по новой:");
            number = scanner.nextInt();
        }

        int alternatingSum = 0;
        boolean toggleOperator = true;
        for(int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            if(toggleOperator) {
                alternatingSum += n;
                toggleOperator = false;
            }
            else {
                alternatingSum -= n;
                toggleOperator = true;
            }
        }
        System.out.println("Сумма знакочередующегося ряда равна " + alternatingSum);
    }





}



