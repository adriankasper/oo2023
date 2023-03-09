import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime timestamp;
    double amount;
    public Transaction(double amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
}
