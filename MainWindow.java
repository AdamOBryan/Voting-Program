

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainWindow extends JFrame {
    

    
    JButton signIn = new JButton("signIn");
    JButton castVote = new JButton("castVote");
    ArrayList<Ballot> ballotList;
    public MainWindow(ArrayList<Ballot> xB){
        
        super("Adam OBryan's Voting Program");
        setLayout(new FlowLayout());
        setSize(800, 600);
        ballotList = xB;
        for (JPanel J:xB)
            add(J);

        
        
        signIn.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                Voter user = new Voter(xB);
                //Execute when button is pressed
               String voterID = (String) JOptionPane.showInputDialog("Please Enter Your Voter ID:");
               System.out.print(voterID);
                try {
                    user.checkStatus(voterID);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        
        
        castVote.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int response = JOptionPane.showConfirmDialog(null, "Submit Your Vote Submissions?",
                                 "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    System.out.println("Yes button clicked");
                    for(Ballot var: ballotList){
                       
                    int BallotNumber = var.getBallotID();
                    String UChoice = var.getSelection();
                    //open file BallotNumber
                    //while hasnextln..
                    //if starts with Uchoice
                    //
                    
                    }
                }     
            }
        });
        
                    
        //castVote.setEnabled(false);     
        add(signIn);
        add(castVote);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
