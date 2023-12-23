import java.util.Scanner;
import java.util.Random;

class GuessKaro
{
    private int randomNumber;   
    private int enteredNumber;
    private int GuessTry = 0;
    Scanner sc = new Scanner(System.in);
    GuessKaro()  //Constructor will generate random number
    {
        Random Numb = new Random();
        randomNumber = Numb.nextInt(101); //Creating random number from 0 to 100 
    }
    public void enterNumber()   //Taking input from the user
    {
        System.out.print("Enter the number ");
        enteredNumber = sc.nextInt();
        GuessTry++;  //Try increase by 1 to count number of tries

        // If user entered number is equal to computer generated number print You win with this number of Guesses
        if(enteredNumber == randomNumber) 
        {
            System.out.println("You Won in "+GuessTry+" Guesses");   
        }
        else
        {
            CorrectEstimate(enteredNumber); //Tell whether the number is small or greater than user entered number
            enterNumber();  //Recall the function to take the new number from User
        }
    }
    void CorrectEstimate(int Correction)
    {
        //If user number is closer to the Computer generated number
        if(Correction < randomNumber && Correction >= randomNumber-5 || Correction > randomNumber && Correction < randomNumber+5)
        {
            System.out.println("You are very closer to number");
        }
        //Tell whether number is greater than Computer generated number
        if(Correction>randomNumber)
        {
            System.out.println("Entered number is Greater than Orignal number\n");
        }
        //Tell whether number is smaller than Computer generated number
        else
        {
            System.out.println("Entered number is Smaller than Orignal number\n");
        }
    }

}
public class GuessNumber {

    public static void main(String[] args)
    {        
        GuessKaro GK = new GuessKaro();  //Creating an instance of Class-> GK
        GK.enterNumber(); //Function call
    }
}
