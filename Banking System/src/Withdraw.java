
import java.util.Scanner;
//<<< header file?


public Withdraw extends Account{
        boolean withdraw;
        double amount;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("withdraw amount : ");
        amount = scan.nextDouble();
        
        
        
            if (amount <= 0.0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount or 0 ");
        
            if (amount > balance) {
                throw new IllegalStateException("Cannot overdraw an account");
            }

            balance = (balance - amount);
}
        
              
}
              
