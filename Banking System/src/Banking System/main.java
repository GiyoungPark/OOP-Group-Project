// Daniel, Lora, GiYoung, Chase
import java.util.Scanner;

  class main{
   public static void main(String[] args){
	   BankSystem bank = new BankSystem();

	   Scanner sc = new Scanner(System.in);
	   int menu = 0;

	   while (true){
		   System.out.println("(1) Customer");
		   System.out.println("(2) Bank Staff");
		   System.out.println("(3) Exit");

		   menu = sc.nextInt();

		   if (menu == 1){
			   System.out.println("Account Number?");
			   int acc = sc.nextInt();
               Account tmpAccnt = bank.searchAccounts(acc);
			   System.out.println("Account Number: " + tmpAccnt.getAccountNumber());
               bank.customerMenu(tmpAccnt);
			}
		   if (menu == 2){
			   bank.staffMenue();
			}
		   if (menu == 3){
			   break;
			}
	   }
   }
}
