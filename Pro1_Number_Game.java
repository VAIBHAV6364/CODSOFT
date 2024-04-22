import java.util.Random;
import java.util.Scanner;

public class Pro1_Number_Game
{
    public static void main(String args[]) {
        int entry = 0, chances, rand, found, playagain = 0;
        int play_count = 0, found_count = 0 ;
        //entry is the user input of the guess
        //chances is the total no of chances available to the user at a time (decremental variable)
        //the rand variable holds the generated random number
        //found is an incremental variable holding the number of times the user guessed correctly
        //playgain is used to determine of the user wants to play again
        double game_score =0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();


        System.out.println("........WELCOME........");
        System.out.println("-> THIS IS A NUMBER GUESSING GAME");
        System.out.println("->TO WIN GUESS A NUMBER FROM 0 TO 10");
        System.out.println("->YOU HAVE 3 CHANCES , ALL THE BEST ..... : ");
        System.out.println("***************************************************");
        do
        {
            play_count =play_count+1;
            chances = 3;
            found =0;
            rand = r.nextInt(11);    //to generate a random number from 0 t0 10
            while(chances > 0 && found != 1)
            {
                System.out.println();
                System.out.println();
                System.out.println("Enter your guess for the random number : ");
                entry = sc.nextInt();
                switch (Integer.compare(entry, rand))
                {
                    case 0:
                        System.out.println("Bravo! You have made the correct guess...");
                        found = 1;
                        found_count = found_count+1;
                        break;
                    case -1:
                        System.out.println("Your guess is lower than the generated number... Try again.");
                        System.out.println("You have " + (chances - 1) + " chances.");
                        break;
                    case 1:
                        System.out.println("Your guess is higher than the generated number... Try again.");
                        System.out.println("You have " + (chances - 1) + " chances.");
                        break;
                    default:
                        System.out.println("You have entered an invalid input. Try with only numbers from 0 to 10.");
                        System.out.println("You have " + (chances - 1) + " chances.");
                        break;
                }

                chances--;
                if (chances == 0 && found != 1)
                    System.out.println("sorry pal your chances are up! better luck next time.");
                System.out.println("***************************************************");

            }
            System.out.println("if u wish to play again press \"0\" else press \"1\":");
            playagain = sc.nextInt();
        }while(playagain==0);
        game_score=(((double)found_count/play_count)*100); //how many times the user found the number out of the number of times played
        System.out.println("your total guess score(out of 100) = "+game_score);
        System.out.println("#################### THANK YOU #####################");
    }
}
