public class Customer extends Bank{
	Scanner sc = new Scanner(System.in);
        int menu = 0;
	
	void startMenu(Account acc){
		while (true){
			System.out.println("(1) View Balance");
			System.out.println("(2) View Last Deposited Amount");
			System.out.println("(3) Deposit");
			System.out.println("(4) Withdraw");
			System.out.println("(5) Tranfer Funds to Another Account");
			System.out.println("(6) Cancel");
			
			menu = sc.nextInt(); 
			
			if (menu == 1){
				
			}
			elseif (menu == 2) {
				
			}
			
		}
		
	}
	
	
	
	
}

