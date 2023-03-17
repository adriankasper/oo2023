import java.util.ArrayList;
import java.util.List;

public class Account {
    Balance balance;
    List<Transaction> transactions;
    public Account(double balance) {
        this.transactions = new ArrayList<>();
        this.balance = new Balance(balance);
    }

    public void transaction(String action, double amount){
        if (action.equals("d")){
            balance.deposit(amount);
            transactions.add(new Transaction(amount));
        } else if (action.equals("w")) {
            balance.withdraw(amount);
            transactions.add(new Transaction(amount));
        }

    }

    public Transaction getLastTransaction(){
        Transaction lastTransaction = transactions.get(transactions.size() - 1);
        return lastTransaction;
    }

}
