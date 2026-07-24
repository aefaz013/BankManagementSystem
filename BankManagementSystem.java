import java.util.InputMismatchException;
import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {

            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:

                    if (account != null) {
                        System.out.println("Account already exists.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    System.out.print("Enter Initial Deposit: ");
                    double initialBalance = sc.nextDouble();

                    if (initialBalance < 0) {
                        System.out.println("Initial balance cannot be negative.");
                    } else {
                        account = new BankAccount(name, accNo, initialBalance);
                        System.out.println("Account created successfully.");
                    }
                    break;

                case 2:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 3:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 4:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        account.checkBalance();
                    }
                    break;

                case 5:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                    } else {
                        account.displayAccount();
                    }
                    break;

                case 6:

                    System.out.println("Thank you for using Bank Management System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}