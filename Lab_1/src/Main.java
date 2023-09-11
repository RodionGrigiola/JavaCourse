import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem_1();
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







}



