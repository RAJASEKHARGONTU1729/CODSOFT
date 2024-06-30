import java.util.Scanner;
public class StudentGradecalculator {
    String[] subject;
    float[] marks;
    String[] grade;
    int n;
    float obtained;
    int fc=0;
    Scanner scan=new Scanner(System.in);
    StudentGradecalculator(){
       System.out.println("STUDENT GRADE CALCULATOR");
       System.out.println("-------------------------------");
       System.out.println("Enter Number of SUBJECTS:");
       n=scan.nextInt();
       subject=new String[n];
       marks=new float[n];
       grade=new String[n];
       for(int i=0;i<n;i++){
          System.out.println("----------------------------------");
          System.out.print("Enter subject "+(i+1)+" name:  ");
          subject[i]=scan.next();
          System.out.print("Enter marks obtained (0-100):  ");
          marks[i]=scan.nextFloat();
          obtained+=marks[i];
          grade[i]=calcGrade(marks[i]);
       }
       print_result();
    }
    public void print_result(){
        System.out.println("------------------------------------------");
        System.out.printf("%-12s %5s   %-6s\n","Subject","Marks","Grade");
        System.out.println("------------------------------------------");
        for(int i=0;i<n;i++){
            System.out.printf("%-12s %3.2f   %-6s\n",subject[i],marks[i],grade[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println(" Total Marks OBTAINED :"+obtained);
        System.out.println("AVERAGE MARKS OBTAINED :"+(obtained/n));
        if(fc!=0)
            System.out.println("Overall GRADE : FAIL");
        else
            System.out.println("Overall GRADE : "+ calcGrade(obtained/n));
    }
    public String calcGrade(float score){
        if(score>=90)
            return "A+";
        else if(score>=80)
            return "A";
        else if(score>=70)
            return "B";
        else if(score>=60)
            return "C";
        else if(score>=50)
            return "D";
        else if(score>=40)
            return "E";
        else{
            fc+=1;
            return "FAIL";
        }
    }
    public static void main(String[] args){
        new StudentGradecalculator();
    }
}
