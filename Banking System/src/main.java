import java.util.Scanner;

  
   public static void main(String[] args){
	   Bank bank = new Bank();
	   Customer customer = new Customer();
	   
	   Scanner sc = new Scanner(System.in);
	   int menu = 0;
	   
	   while (true){
		   System.out.println("(1) Customer");
		   System.out.println("(2) Bank Staff");
		   System.out.println("(3) Add Interest");
		   
		   menu = sc.nextInt();
		   
		   if (menu == 1){
			   System.out.println("Account Number?");
			   int acc = sc.nextInt();
			   customer.startMenu(bank.searchAccounts(acc));
			}
		   if (menu == 2){
			   //bank staff
			}
		   if (menu == 3){
			   //Add interest
			}
		   
		   
	   }
   }
  
