import java.util.*;

class ATMProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pin = "1234";
        double balance = 5000;
        ArrayList<String> history = new ArrayList<>();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (!enteredPin.equals(pin)) {
            System.out.println("Wrong PIN!");
            sc.close();
            return;
        }

        System.out.println("Login Successful!");

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Balance: Rs." + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double deposit = Double.parseDouble(sc.nextLine());

                        if (deposit > 0) {
                            balance += deposit;
                            history.add("Deposited Rs." + deposit);
                            System.out.println("Deposit Successful!");
                        } else {
                            System.out.println("Invalid amount!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        double withdraw = Double.parseDouble(sc.nextLine());

                        if (withdraw <= 0) {
                            System.out.println("Invalid amount!");
                        } else if (withdraw <= balance) {
                            balance -= withdraw;
                            history.add("Withdrawn Rs." + withdraw);
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 4:
                        System.out.println("Transaction History:");
                        for (String t : history) {
                            System.out.println(t);
                        }
                        if (history.isEmpty()) {
                            System.out.println("No transactions yet.");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        sc.close();
    }
}
