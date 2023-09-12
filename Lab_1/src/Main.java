import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem_1();
        problem_2();
        problem_3();
        problem_4();
        problem_5();
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

    static void problem_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество дорог: ");
        int numberOfRoads = scanner.nextInt();

        int roadToTake = 0;
        int maxHeight = 0;

        for (int i = 1; i <= numberOfRoads; i++) {
            System.out.print("Введите количество туннелей для дороги " + i + ": ");
            int numberOfTunnels = scanner.nextInt();
            int minTunnelHeight = Integer.MAX_VALUE;

            for (int j = 1; j <= numberOfTunnels; j++) {
                System.out.print("Введите высоту туннеля " + j + ": ");
                int currentTunnelHeight = scanner.nextInt();
                minTunnelHeight = Math.min(currentTunnelHeight, minTunnelHeight);
            }

            if(minTunnelHeight > maxHeight) {
                roadToTake = i;
                maxHeight = minTunnelHeight;
            }
        }
        System.out.print(roadToTake + " " + maxHeight);
    }

    static void problem_5() {
        new isTwiceEvenNumber();
    }
}

class isTwiceEvenNumber {
    public isTwiceEvenNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();
        while(number < 100 || number > 999) {
            System.out.println("Число должно быть трехзначным, повторите ввод: ");
            number = scanner.nextInt();
        }
        calc(number);
    }
    public void calc(int number) {
        int digitSum = 0;
        int digitProduct = 1;

        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }

        if (digitSum % 2 == 0 && digitProduct % 2 == 0) {
            System.out.println("Число " + number + " является дважды четным.");
        } else {
            System.out.println("Число " + number + " не является дважды четным.");
        }
    }
}

















