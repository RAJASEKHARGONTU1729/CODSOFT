import java.util.Random;
import java.util.Scanner;
public class NumberGuessr {
    int random_number, lb, ub, guess, chances, score;
    Scanner scan = new Scanner(System.in);
    NumberGuessr() {
        initvalues();
    }
    public void initvalues() {
        try{
            System.out.printf("%10s\n", "Number Guess Game");
        
        System.out.println("------------------------------------------------------------");
        System.out.println("Enter Lower bound:");
        this.lb = scan.nextInt();
        System.out.println("Enter Upper bound");
        this.ub = scan.nextInt();
        this.random_number = new Random().nextInt(ub - lb + 1) + lb;
        this.chances = (int) ((Math.log(ub - lb + 1) / Math.log(2)) + 1);
        this.score = chances * 100+100;
        start();
        }catch(Exception e){
            System.out.println("Invalid Bounds set...");
        }
    }
    public void start() {
        try{
        do {
            System.out.println("---------------------------------------------------------");
            if (chances > 0) {
                System.out.println("Enter your Guess:");
                this.guess = scan.nextInt();
                if (guess < lb || guess > ub) {
                    System.out.println("You guess is outside bounds");
                } else if (guess > random_number) {
                    System.out.println("You guess is TOO_HIGH...");
                } else if (guess < random_number) {
                    System.out.println("You guess is TOO_LOW...");
                } else {
                    System.out.println("Congratulations! You guess is CORRECT... It's " + this.guess);
                    System.out.println("Well Played! you have scored "+this.score+" points" + "\n");
                    System.out.println("Do you Wish to Restart the game (Y/n)?");
                    if (scan.next().equalsIgnoreCase("Y")) {
                        initvalues();
                    } else {
                        System.out.println("Exiting......");
                        System.exit(0);
                    }
                }
                chances--;
                score -= 100;
                System.out.println("chances left: " + chances + "  Score: " + score);
            }
            if(chances==0){
                System.out.println("You are out of moves!...");
                System.out.println("Do you Wish to Restart the game (Y/n)?");
                if (scan.next().equalsIgnoreCase("Y")) {
                    initvalues();
                } else {
                    System.out.println("Exiting......");
                    System.exit(0);
                }
            }
            } while (true);}
        catch(Exception e){
            System.out.println("You have entered invalid values");
        }
    }

    public static void main(String[] args) {
        new NumberGuessr();
    }
}
