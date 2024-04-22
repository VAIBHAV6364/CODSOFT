import java.util.*;
public class Pro2_Student_Grade_Calculator
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String name,student_grade;
        int n;
        int total_marks=0;
        double percentage=0;
        System.out.println("\n");
        System.out.println("----------##############  Student Grade Calculator  #############---------");
        System.out.println("enter the number of subjects the student studies : ");
        n=sc.nextInt();

        String[] subjects = new String[n];
        int[] marks = new int[n];
        char[] grade = new char[n];
        System.out.println("Enter the student's name : ");
        name=sc.next();

        for(int i =0;i<n;i++) {
            System.out.println("enter the name of subject " + (i + 1) + " : ");
            subjects[i] = sc.next();
            System.out.println("enter the marks (out of 100) in " + subjects[i] + " : ");
            marks[i] = sc.nextInt();
            if (marks[i] > 100 || marks[i] < 0) {
                System.out.println("you have entered an invalid marks please re-enter appropriate marks : ");
                marks[i] = sc.nextInt();
            }
            total_marks += marks[i];
        }

        percentage = total_marks/n;

        //grade calculation in each subject
        for(int i=0;i<n;i++)
        {
            if(marks[i]>=85)
                grade[i]='A';
            else if(marks[i]<85 && marks[i]>=70)
                grade[i]='B';
            else if(marks[i]<70 && marks[i]>=60)
                grade[i]='C';
            else if(marks[i]<60 && marks[i]>=50)
                grade[i]='D';
            else if(marks[i]<50 && marks[i]>=40)
                grade[i]='E';
            else
                grade[i]='F';
        }

        if(percentage>=80.00)
            student_grade="DISTINCTION";
        else if(percentage<80.00 && percentage>=65.00)
            student_grade="FIRST CLASS";
        else if(percentage<65.00 && percentage>=50.00)
            student_grade="SECOND CLASS";
        else if(percentage<50.00 && percentage>=40.00)
            student_grade="PASS CLASS";
        else
            student_grade="FAIL";

        System.out.println("\n\n================================" +
                "= STUDENT REPORT CARD ==============================");
        System.out.println("NAME : "+name);
        System.out.println("TOTAL MARKS OBTAINED : "+total_marks);
        System.out.println("SUBJECT\t\t\tMARKS\t\t\tSUBJECT GRADE");
        for(int i=0;i<n;i++)
            System.out.println(subjects[i]+"\t\t\t\t"+marks[i]+"\t\t\t\t\t"+grade[i]);
        System.out.println("PERCENTAGE : "+percentage+"%");
        System.out.println("STUDENT'S GRADE : "+student_grade);
        System.out.println("=========================================================================================");
    }
}
