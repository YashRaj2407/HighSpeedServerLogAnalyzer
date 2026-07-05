import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LogAnalyzer analyzer = new LogAnalyzer("server_logs.txt");

        while (true) {

            System.out.println("\n===== High-Speed Server Log Analyzer =====");
            System.out.println("1. Display Logs");
            System.out.println("2. Count Total Logs");
            System.out.println("3. Count Status Codes");
            System.out.println("4. Count Requested Destinations");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {

                switch (choice) {

                    case 1:
                        analyzer.displayLogs();
                        break;

                    case 2:
                        analyzer.countTotalLogs();
                        break;

                    case 3:
                        analyzer.countStatusCodes();
                        break;

                    case 4:
                        analyzer.countDestinations();
                        break;

                    case 5:
                        System.out.println("Thank You!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (IOException e) {
                System.out.println("Error Reading File : " + e.getMessage());
            }
        }
    }
}