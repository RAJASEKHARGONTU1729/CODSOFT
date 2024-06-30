package Bank;
import java.util.Scanner;
public class BankUser {
    long accno;
    double balance;
    Scanner scan =new Scanner(System.in);
    BankUser(){
        System.out.println("Enter your credentials:");
        System.out.println("Enter account number: ");
        this.accno=scan.nextLong();
        System.out.println("Enter PIN: ");
        this.balance=10000;
        scan.nextDouble();
        System.out.println();
    }
}
