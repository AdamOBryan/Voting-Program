
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;



public class Voter {
    String voterID;
    String voterName; 
    boolean validity = false;
    boolean registered = false;
    ArrayList<Ballot> BallotList;

    public Voter(ArrayList<Ballot> BallotList){
     this.BallotList= BallotList;
    }
public boolean checkStatus(String ID) throws FileNotFoundException{

    String hasVoted;
    Scanner input;
        //input = new Scanner(new File(args[2])); use for actual assignment
        File quizFile = new File("/Users/adamobryan/Desktop/AOVoteProgram/src/aovoteprogram/voters.txt");

        input = new Scanner(quizFile); // for testing

    while(input.hasNext()){
        String data = input.nextLine();
        if(data.startsWith(ID)){
            hasVoted = data.trim().substring(data.lastIndexOf(":") + 1);
               if (hasVoted.equalsIgnoreCase("false")){
                   validity = false;
                   registered = true;
                   String tokens[] = data.split(":");
                   voterID = tokens[0];
                   voterName = tokens[1];
                   JOptionPane.showMessageDialog(null, "Welcome, "+voterName+", Let's Vote!");
                   for(Ballot var: BallotList){
                   var.choiceEnable();
                   }
                System.out.println("false -woord");}
               if (hasVoted.equalsIgnoreCase("true")){
                   validity = true;
                   registered = true;
                                      String tokens[] = data.split(":");
                   voterID = tokens[0];
                   voterName = tokens[1];
                   JOptionPane.showMessageDialog(null, "You Already Voted\n"+voterName+"!");
               System.out.println("true -woord");}
    
    
        }
    }
  
    
    if(registered == false){
    JOptionPane.showMessageDialog(null, "You're Not Registered!");
    }
    
    return validity;
    
}
}
