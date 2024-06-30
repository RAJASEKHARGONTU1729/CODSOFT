package Bank;

import Bank.BankUser;

public class AtmMachine extends BankUser {

    AtmMachine() {
        startServices();
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (this.balance > amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return this.balance;
    }

    public void showMenu() {
        System.out.println("\n  WELCOME TO PROD BANK");
        System.out.println(" ------------------------");
        System.out.println("|        MENU            |");
        System.out.println(" ------------------------");
        System.out.println("|   1. DEPOSIT MONEY     |");
        System.out.println("|   2. WITHDRAW MONEY    |");
        System.out.println("|   3. CHECK BALANCE     |");
        System.out.println("|   4. EXIT              |");
        System.out.println(" ------------------------");

    }

    public void startServices() {
        int choice;
        double amount;
        System.out.println("--------------------------------");
        System.out.println("Your ACCOUNT NUMBER : "+accno);
        System.out.println("Your AVAILABLE BALANCE : "+balance);
        while (true) {
            showMenu();
            System.out.println("Enter choice: ");
            choice = scan.nextInt();
            if (choice == 1) {
                while (true) {
                    System.out.println("Enter deposit amount :");
                    amount = scan.nextDouble();
                    if (amount > 0) {
                        deposit(amount);
                        System.out.println("Rs." + amount + " is successfully deposited");
                        break;
                    } else {
                        System.out.println("******INVALID DEPOSIT AMOUNT********");
                        System.out.println("-------------------------------------");
                    }
                }
            }
            else if(choice==2){
                while (true) {
                    System.out.println("Enter WithDrawal amount :");
                    amount = scan.nextDouble();
                    if (amount > 0) {
                        if(withdraw(amount))
                            System.out.println("Rs." + amount + " is successfully Withdrawn");
                        else
                            System.out.println("********INSUFFICIENT FUNDS*********");
                        break;
                    } else {
                        System.out.println("******INVALID WITHDRAW AMOUNT********");
                        System.out.println("-------------------------------------");
                    }
                }
            }
            else if(choice==3){
                System.out.println("---------- ACCOUNT BALANCE :" + balance);
            }
            else if(choice==4){
                System.out.println("Thank you! visit us again...");
                break;
            }
            else{
                System.out.println("********INVALID OPERATION*********");
            }
        }
    }
    public static void main(String[] args){
        new AtmMachine();
    }
}
