


public class Withdraw extends Account{
        boolean withdraw;
        double amount;
        
        if (amount < 0.0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }
        if (amount > balance) {
            throw new IllegalStateException("Cannot overdraw an account");
        }
        
        balance = (balance - amount);
}
        
              
