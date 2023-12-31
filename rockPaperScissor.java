import java.util.Scanner;
import java.util.Random;
class RPS  //Rock Paper Scissor
{
    private char userInput; // User input variable
    private int userScore = 0;  //Initial User score is Zero 
    private char Output ; // Computer output variable
    private int computerScore = 0;  //Initial Computer score is Zero
    private String displayUserInput , displayComputerOutput;
    Scanner sc = new Scanner(System.in);
    Random Rand = new Random();
    String Alphabet = "RPS" ; //This String will be used to generate random from R (Rock),P (Paper) and S (Scissor)

    public void playGame()
    {
        //Total number of matches that user want to play
        System.out.print("Enter the number of Matches ");
        int Matches = sc.nextInt();
        //Tell choose
        System.out.println("Enter : \nR for Rock \nP for Paper \nS for Scissor");
        for(int i = 0 ; i< Matches ; i++)  //Run until until the number of matches not achieve
        {
            createOutput();  //Call funtion to generate the random from Rock, Paper,Scissor
            takeInput(); //Take input from the user
        }
        // Tell Score of the User and Computer
        System.out.println("\n\n\n");
        System.out.printf(" ********************* Your Score is  %d *********************\n",userScore);
        System.out.printf("******************** Computer Score is  %d ********************\n\n",computerScore);
    }

    void createOutput()
    {
        //This will generate random from R,P,S
        Output = Alphabet.charAt(Rand.nextInt(Alphabet.length()));
    }

    String Conversion(char character)
    {
        if(character == 'R') 
        {
            return "Rock";
        }
        else if(character == 'P')
        {
            return "Paper";
        }
        else
        {
            return "Scissor";
        }
    }

    void forDisplay(char userInput, char Output)
    {
        displayUserInput = Conversion(userInput);
        displayComputerOutput = Conversion(Output);
        System.out.println("Your's " + displayUserInput + " and Computer's "+displayComputerOutput );
    }

    void takeInput()
    {
        System.out.print("\nEnter the input : ");
        userInput = sc.next().charAt(0);
        userInput = Character.toUpperCase(userInput);
        //Condition where User won the match
        /*
         User           Computer

         Rock           Scissor
         Paper          Rock
         Scissor        Paper
         */
        if((userInput == 'R' && Output == 'S') || (userInput == 'P' && Output == 'R') ||( userInput == 'S' && Output == 'P' ))
        {
            System.out.println("You Won the Game");
            forDisplay(userInput, Output);
            userScore++;
        }
        //Condition where Computer won the match
        /*
         User           Computer

         Rock           Paper
         Paper          Scissor
         Scissor        Rock
         */
        else if((userInput == 'R' && Output == 'P') || (userInput == 'P' && Output == 'S') ||( userInput == 'S' && Output == 'R' ))
        {
            System.out.println("You Loss the Game");
            forDisplay(userInput, Output);
            computerScore++;
        }
        //Match will Draw when User and Computer have the same choose
        else if(userInput == Output)
        {
            System.out.println("Draw");
            //Again call the createOutput() and takeInput because this match is considered
            createOutput();
            takeInput();
        }
        else
        {
            System.out.println("Wrong input");
            //Again call the createOutput() and takeInput because this match is considered
            createOutput();
            takeInput();
        }
    }
    
}
public class rockPaperScissor {
    public static void main(String[] args) {
        System.out.println("\n\n\n********************************** Welcome to game Rock, Paper, Scissor **********************************\n\n");
        RPS game = new RPS();
        game.playGame();
    }
}
