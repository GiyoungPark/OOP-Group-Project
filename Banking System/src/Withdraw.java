// in account as a method


import java.util.Scanner;
//<<< header file?


public void withdraw{
        boolean saving;
        double amount;
        
                public Saving() {
                this.savings = True;
                amount = 0;
                }
        
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
              
