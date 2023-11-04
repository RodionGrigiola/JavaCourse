import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Theatre cinema = new Theatre("Cinema", 10, 100);
        Theatre kinopolis = new Theatre("Kinopolis", 5, 50);

        bookSeat(cinema, 'A', 3);
        bookSeat(cinema, 'B', 1);
        bookSeats(cinema, 4, 'B', 'C', 1, 10);

        bookSeats(cinema, 4, 'I', 4, 10);
        bookSeats(kinopolis, 5, 'D', 6, 10);

        Scanner scanner = new Scanner(System.in);
        Theatre chosenTheatre = null;
        boolean flag = true;

        while (flag) {
            System.out.println("Choose a theatre: ");
            System.out.println("1. Cinema ");
            System.out.println("2. Kinopolis ");
            System.out.println("3. Exit ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You selected " + " Cinema");
                    chosenTheatre = cinema;
                    flag = false;
                    break;
                case 2:
                    System.out.println("You selected " + " Kinopolis");
                    chosenTheatre = kinopolis;
                    flag = false;
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        while(true) {
            System.out.println("Menu:");
            System.out.println("1. Print seat map");
            System.out.println("2. Book a seat");
            System.out.println("3. Book seats in a row");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    chosenTheatre.printSeatMap();
                    break;
                case 2:
                    System.out.println("Enter the row: ");
                    char row = scanner.next().charAt(0);
                    System.out.println("Enter the seat number: ");
                    int seatNumber = scanner.nextInt();
                    bookSeat(chosenTheatre, row, seatNumber);
                    break;
                case 3:
                    System.out.println("Enter number of tickets: ");
                    int tickets = scanner.nextInt();
                    System.out.println("Enter the row: ");
                    char minRow = scanner.next().charAt(0);
                    System.out.println("Enter the min seat number: ");
                    int minSeatNumber = scanner.nextInt();
                    System.out.println("Enter the max seat number: ");
                    int maxSeatNumber = scanner.nextInt();
                    bookSeats(chosenTheatre, tickets, minRow, minSeatNumber, maxSeatNumber);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat ) {
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat) {
        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: " + minRow + " - " + maxRow);
        }
    }


}




