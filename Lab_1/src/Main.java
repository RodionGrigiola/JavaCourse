import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem_1();
        problem_2();
        problem_3();
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
    static void problem_3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Координата клада по оси X: ");
        int treasureCoordX = scanner.nextInt();
        System.out.print("Координата клада по оси Y: ");
        int treasureCoordY = scanner.nextInt();

        int positionX = 0;
        int positionY = 0;

        int stepsTaken = 1;
        int minSteps = 0;

        while(true) {
            System.out.print("Введите направление: ");
            String direction = scanner.next();
            if(direction.equals("стоп")) break;

            System.out.print("Введите количество шагов: ");
            int steps = scanner.nextInt();

            switch (direction) {
                case "север" -> positionY += steps;
                case "юг" -> positionY -= steps;
                case "запад" -> positionX -= steps;
                case "восток" -> positionX += steps;
            }

            if(positionX == treasureCoordX && positionY == treasureCoordY) {
                if(minSteps == 0 || minSteps >= stepsTaken) {
                    minSteps =  stepsTaken;
                    stepsTaken = 0;
                }
                else {
                    stepsTaken = 0;
                }
            }
            else stepsTaken++;

        }
        System.out.println("Минимальное количество указаний карты, которые нужно выполнить, равно " + minSteps);
    }
}















