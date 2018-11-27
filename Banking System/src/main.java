import java.util.Scanner;

  class main{
   public static void main(String[] args){
	   Bank bank = new Bank();
	   Cust customer = new Cust();
	   BankStaff bankStaff = new BankStaff();

	   Scanner sc = new Scanner(System.in);
	   int menu = 0;

	   while (true){
		   System.out.println("(1) Customer");
		   System.out.println("(2) Bank Staff");
		   System.out.println("(3) Add Interest");
		   System.out.println("(4) Exit");

		   menu = sc.nextInt();

		   if (menu == 1){
			   System.out.println("Account Number?");
			   int acc = sc.nextInt();
			   customer.startMenu(bank.searchAccounts(acc));
			}
		   if (menu == 2){
			   bankStaff.menueChoice();
			}
		   if (menu == 3){
			   // add interest break;
			}
		   if (menu == 4){
			   break;
			}
	   }
   }
}
