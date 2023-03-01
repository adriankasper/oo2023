import java.util.Scanner;

public class Main {
    static Account account = new Account(100.0);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "b";

        while (!input.equals("exit")) {
            System.out.println();
            System.out.println("Deposit - d");
            System.out.println("Withdraw - w");
            System.out.println("Balance - b");
            input = scanner.nextLine();
            if (input.equals("d")) {
                System.out.println("Kui palju sisestada?");
                input = scanner.nextLine();
                double amount = Double.parseDouble(input);
                account.deposit(amount);
                System.out.println("Praegune kontojääk: " + account.balance);
            } else if (input.equals("w")) {
                System.out.println("Kui palju välja võtta?");
                input = scanner.nextLine();
                double amount = Double.parseDouble(input);
                account.withdraw(amount);
                System.out.println("Praegune kontojääk: " + account.balance);
            } else if (input.equals("b")) {
                System.out.println("Praegune kontojääk: " + account.balance);
            }
        }
    }
}