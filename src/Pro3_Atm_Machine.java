import java.util.*;
class User_Account
{
    Scanner s = new Scanner(System.in);
    private double balance=0.0;
    private final double MIN_BALANCE = 500.00;
    public User_Account(double balance)
    {
        super();
        this.balance = balance;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount>=0)
        {
            balance += amount;
            System.out.println("\nthe amount "+amount+" has SUCCESSFULLY been deposited in the account.\n");
            System.out.println("balance available : "+getBalance());
        }
        else
        {
            System.out.println("\nthe entered amount is invalid !!!");
        }
    }

    public void withdraw(double amount)
    {
        if((balance-amount)<=MIN_BALANCE)
        {
            System.out.println("\nsince minimum balance of 500.00 must be maintained cannot withdraw.\nInsufficient balance");
        }
        else
        {
            balance -= amount;
            System.out.println("\n"+amount+" successfully withdrawn.");
            System.out.println("balance available : "+getBalance());
        }
    }

    public void checkBalance()
    {
        System.out.println("\nAvailable balance = "+getBalance()+"\n");
    }
}

public class Pro3_Atm_Machine extends User_Account
{
    Pro3_Atm_Machine(double balance)
    {
        super(balance);
    }
    public static void main(String... args)
    {
        String name, accID;
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*************************  ATM MACHINE **************************");
        System.out.println("###########################  WELCOME  ###########################");
        System.out.println("enter user name : ");
        name = sc.nextLine();
        System.out.println("enter account number : ");
        accID = sc.next();
        System.out.println("\n==> ACCOUNT HOLDER NAME : "+name+"\n==> ACCOUNT NO : "+accID);
        Pro3_Atm_Machine usacc = new Pro3_Atm_Machine(3000.00);
        do
        {
            System.out.println("Choose your choice of operation");
            System.out.println("-->1.CHECK BALANCE\n-->2.DEPOSIT AMOUNT\n-->3.WITHDRAW AMOUNT\n-->4.EXIT\n");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1: usacc.checkBalance();
                    break;

                case 2: double deptamount=0.0;
                    System.out.println("\nenter amount to deposit : ");
                    deptamount=sc.nextDouble();
                    usacc.deposit(deptamount);
                    break;

                case 3: double wdamount;
                    System.out.println("\nenter the amount to withdraw : ");
                    wdamount=sc.nextDouble();
                    usacc.withdraw(wdamount);
                    break;

                case 4: System.out.println("\nEXITING...........");
                    break;

                default:System.out.println("\ninvalid choice entered , please enter a valid choice");
            }
        }while(choice!=4);
        System.out.println("*****************************  THANK YOU ***************************");
    }
}
