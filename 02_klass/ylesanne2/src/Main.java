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
                String action = input;
                System.out.println("Kui palju sisestada?");
                input = scanner.nextLine();
                double amount = Double.parseDouble(input);
                account.transaction(action, amount);
                account.balance.deposit(amount);
                System.out.println("Praegune kontojääk: " + account.balance);

            } else if (input.equals("w")) {
                String action = input;
                System.out.println("Kui palju välja võtta?");
                input = scanner.nextLine();
                double amount = Double.parseDouble(input);
                account.transaction(action, amount);
                account.balance.withdraw(amount);
                System.out.println("Praegune kontojääk: " + account.balance);

            } else if (input.equals("b")) {
                System.out.println("Praegune kontojääk: " + account.balance);

            } else if (input.equals("l")){
                System.out.println("Viimane tehing:");
                System.out.println("Summa "+ account.getLastTransaction().amount + " Aeg: " + account.getLastTransaction().timestamp);
            }
        }
    }
}