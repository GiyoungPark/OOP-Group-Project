# OOP-Group-Project

CS2365 Due: November 26, 2018 Banking System
1. Problem Description
You are required to develop a simplified banking system in which a customer can deposit cash to a checking account, withdraw cash from the account, query the balance of an account, or transfer funds from one account to another. A transaction is initiated when a customer enter an account number (5 digits) and a user-entered PIN (4 digit personal identification number) into the system. The customer is allowed three attempts to enter the correct account number and PIN.
If the PIN is validated satisfactorily, the customer is prompted for a withdrawal, deposit, view balance, transfer, view last deposit amount, or cancel transaction. Before a withdrawal transaction can be approved, the system determines that sufficient funds exist in the requested account. If the transaction is approved, the requested amount of cash is reduced (dispensed). Before a transfer transaction can be approved, the system determines that the source and destination accounts are available and that there are sufficient funds in the account to be debited. A bank staff can open and close a checking or savings account with customer PIN, SSN, and zero balance, and the system creates an account number.
A customer can have a checking account or a savings account or both checking and savings accounts in the bank. A checking account will show the amount that a customer has deposited the most recently. The interest will be added to savings accounts for the account balance with the interest rate 5% at the end of year.
For implementation, Account class should be created as a super class of Checking Account and Savings Account classes.

2. Use Case Model
The use case model for the banking system is given in Figure 1, followed by each use case description.
1
   Customer
Bank Staff
Timer
   Deposit Funds
Withdraw Funds
View Balance
Transfer Funds
View Last Deposit Amount
Cancel
«include»
  «include»
«include»
«include»
Validate PIN
Open Account
Close Account
Add Interest
                    Figure 1 Use Case model for Banking System
Use Case Name: Validate PIN
Summary: System validates customer PIN. Actor: Customer
Description:
1. The system prompts customer to enter an account number and a PIN.
2. Customer enters an account number and a PIN to the system.
3. If the account number and PIN number match those maintained in the system, system prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternatives:
 If the customer-entered PIN and account do not match the PIN number and account in the
system, the system re-prompts for the PIN and account number.
 If the customer enters the incorrect PIN three times, the system terminates the transaction. Postcondition: Customer account and PIN have been validated.
Use Case Name: Deposit Funds
Summary: Customer deposits a specific amount of funds to a valid bank account.
2

Actor: ATM Customer
Dependency: Include Validate PIN use case. Description:
1. Include V alidate PIN use case.
2. Customer selects Deposit and enters the amount.
3. System credits the amount to the account and displays the result.
4. System prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternatives:
 None
Postcondition: Customer funds have been deposited.
Use Case Name: Withdraw Funds
Summary: Customer withdraws a specific amount of funds from a valid bank account. Actor: ATM Customer
Dependency: Include Validate PIN use case.
Description:
1. Include V alidate PIN use case.
2. Customer selects Withdrawal and enters the amount.
3. System checks whether customer has enough funds in the account.
4. If money is enough, system withdraws the amount from the account and displays the withdrawal result.
5. System prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternatives:
 If the system determines that there are insufficient funds in the customer’s account, it
displays an apology.
Postcondition: Customer funds have been withdrawn.
Use Case Name: Query Balance
Summary: Customer receives the balance of a valid bank account. Actor: ATM Customer
Dependency: Include Validate use case.
Description:
3

1. Include V alidate PIN use case.
2. Customer selects Query.
3. System reads account balance.
4. System displays the balance for the account.
5. System prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternative: None
Postcondition: Customer account has been queried.
Use Case Name: Transfer Funds
Summary: Customer transfers funds from one valid bank account to another. Actor: ATM Customer
Dependency: Include Validate PIN use case.
Description:
1. Include V alidate PIN use case.
2. Customer selects Transfer and enters amount and to-account.
3. If the system determines that the customer has enough funds in the from-account and that the to-account is valid, it performs the transfer.
4. System prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternatives:
 If the system determines that the to-account is invalid, it displays an error message.
 If the system determines that there are insufficient funds in the customer’s from-account, it
displays an apology.
Postcondition: Customer funds have been transferred.
Use Case Name: View Last Deposit Amount
Summary: Customer views the last deposit amount in a checking account. Actor: ATM Customer
Dependency: Include Validate use case.
Description:
1. Include V alidate PIN use case.
2. Customer selects View Last Deposit Amount.
3. System reads the customer’s last deposit amount in a checking account.
4. System displays the amount to the customer.
4

5. System prompts customer for transaction type: Deposit, Withdrawal, Query Balance, Transfer, View Last Deposit Amount, or Cancel.
Alternative: None
Postcondition: Customer had viewed the last deposit amount in a checking account.
Use Case Name: Cancel
Summary: Customer cancels transaction. Actor: ATM Customer
Dependency: Include Validate PIN use case. Description:
1. Include V alidate PIN use case.
2. Customer selects Cancel.
3. System terminates the transaction.
Alternatives:
 None
Postcondition: Transaction has been terminated.
Use Case Name: Open Account
Summary: Customer opens a bank account.
Actor: Bank Staff
Description:
1. Bank Staff selects Open Account.
2. System prompts bank staff to enter customer PIN, SSN, and account type (checking or savings).
3. If the PIN is a 4-digit number and the SSN is a 9 digit number, the system stores customer PIN.
4. System creates an account number (5 digits) and displays it.
Alternatives:
 None
Postcondition: An account has been created.
Use Case Name: Close Account Summary: Customer closes a bank account. Actor: Bank Staff
5

Description:
1. Bank Staff selects Close account.
2. System prompts bank staff to enter an account number.
3. If the account number is valid, the system makes the balance to zero and removes the account.
4. System displays a message about closing an account.
Alternatives:
 None
Postcondition: An account has been closed.
Use Case Name: Add Interest
Summary: System adds the interest to savings accounts. Actor: Timer
Dependency:
Description:
1. Timer activates the use case.
2. System calculates the interest for each savings account and adds it to the accounts.
Alternatives:
 None
Postcondition: System has added the interest to savings accounts.
3. Account data
An account will be created with 5-digit account number, 4-digit PIN, 9-digit SSN, balance: Checking Accounts:
00001 5678 123456789 300
00002 4567 234567890 4000
00003 3456 345678901 70 00004 2345 456789012 5000
Savings Accounts:
10001 1234 567890123 700 10002 0123 234567890 2000 10003 6789 789012345 9000 10004 7890 890123456 1000
6

4. Submission to blackboard
a. Class description by team
- Describe the classes in your program using the class notation in Unified Modeling Language (UML). Each class is described with class name, attributes of class, and method specifications.
- A method specification needs to show its parameters and return values. But You do not need to describe the detailed logic of a method.
b. Source Code by team
c. Project Cross Evaluation Form by each team member
7
