
/* ADAM OBRYAN
 * ASSIGNMENT 4 
 * CLASS: WED @ 1
 * T/A: SHELLEY GOLDBERG
 * THIS PROGRAM READS IN BALLOTS AND LETS THE USER VOTE 
 * SAVES RESPONSES, AND MOVES ON TO THE NEXT VOTER
 */



import java.util.*;
import java.io.*;


public class AOVoteProgram {
    
    ArrayList<Ballot> ballotArray = new ArrayList<>();
    int numBallots = 0;
    
    
    
    public  AOVoteProgram() throws FileNotFoundException{
        
        Scanner input;
        
        //input = new Scanner(new File(args[2])); use for actual assignment
        File DATAFILE = new File("/Users/adamobryan/Desktop/AOVoteProgram/src/aovoteprogram/ballots.txt");
        input = new Scanner(DATAFILE); // for testing
        
        
        numBallots = Integer.parseInt(input.nextLine());
        
        
        //GET BALLOT DATA
        while(input.hasNext()){
            ArrayList<String> inChoices = new ArrayList<>();
            
            String inString = input.nextLine();
            String[] tokens = inString.split("[:,]");
            
            int id = Integer.parseInt(tokens[0]);
            String bName = tokens[1];
            
            for (int i=2; i<tokens.length;i++){
                System.out.println(tokens[i]);
                inChoices.add(tokens[i]);
            }
            
            Ballot xB = new Ballot(id, bName, inChoices);
            xB.choiceDisable();
            ballotArray.add(xB);
        }
        
        input.close();
        new MainWindow(ballotArray);
        
    }//END AOVoteProgram constructor
    
    
    public static void main(String[] args) throws FileNotFoundException {
        new AOVoteProgram();
        
    }//end main method 
    
}//end AOVoteProgram class


