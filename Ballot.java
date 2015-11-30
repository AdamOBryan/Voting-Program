

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class Ballot extends JPanel{
    
    private int id;
    private String posistionTitle;
    private ArrayList<String> choices;
   
    private JLabel ballotName;
    public ChoiceButton theButton;
    public ButtonGroup group;
    String USERPICK;
    
    
    public Ballot(int i, String q, ArrayList<String> c){
            id = i;
            posistionTitle = q;
            choices = c;
            group = new ButtonGroup();
            buildPanel();
    }

    
    public void buildPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ballotName = new JLabel(posistionTitle);
        add(ballotName);
            
        for(String var: choices){
            theButton = new ChoiceButton(var, id);
            
            
            
            group.add(theButton);
            this.add(theButton);
            System.out.println(theButton.buttonName);
            //theButton.getBallot();


        }
            
        isVisible();
    }
    
    
    
    public int getBallotID(){
        
        return id;
    }
    
    public String getUserPick(){
        USERPICK = group.getSelection().toString();
        System.out.println(USERPICK);
        return USERPICK;
    }
    
    public void choiceEnable(){
        Enumeration<AbstractButton> enumeration = group.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(true);
        }
    }
    public void choiceDisable(){
        Enumeration<AbstractButton> enumeration = group.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(false);
        }
    }
    
    public String getSelection(){
       String bName="";
        Enumeration elements = group.getElements();
        while (elements.hasMoreElements()) {
        JRadioButton choiceButton = (JRadioButton)elements.nextElement();
            if (choiceButton.isSelected()) {
                System.out.println("The winner is: " + choiceButton.getText());
               
                bName = choiceButton.getText();
            }
        }
        return bName;
    }

}//end ballot
    

