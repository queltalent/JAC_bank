package Assignment4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my bank.");
        System.out.print("Please input your name：");
        String name = scanner.nextLine();

        System.out.print("Please input your balance：");
        double balance = getUserInput();

        BankAccount account = new BankAccount(name, balance);
        System.out.println("Account created successfully！\n" + account);

            int choice=0;
            do {
                try{
                    System.out.println("\nPlease select what you want to do：");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Quit");
                    System.out.print("Please input your choice（1-3）：");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Invalid choice." + e.getMessage());
                    choice = 0;// reset choice
                    scanner.next();
                }
                switch (choice) {
                    case 1:
                        try{
                            System.out.print("Please input depositAmount：");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            scanner.nextLine();
                        }catch (BankAccountException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Please input withdrawAmount：");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Thank you！");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        break;
                }
            } while (choice != 3);

        scanner.close();
    }

    public static double getUserInput() {
        Scanner scanner = new Scanner(System.in);
        double value = 0.0;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Balance must be positive.");
                    System.out.print("Please input again: ");
                }
            } else {
                scanner.next();
                System.out.println("Invalid input. Please enter a numeric value.");
                System.out.print("Please input again: ");
            }
        }
        return value;
    }
}
