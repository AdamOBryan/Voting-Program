

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ChoiceButton extends JRadioButton{
    int ButtonPanelID;
    String buttonName;
    boolean isClickable = false;
    
    
    public ChoiceButton(String name, int panelID){
    buttonName = name;
    ButtonPanelID = panelID;
    setText(name); 
    
    
    this.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
               
                System.out.print(buttonName);
                System.out.println(ButtonPanelID);
                
            
            }
        }); 
    
    
    }
    
    
    
    
    public String getButtonName(){
        System.out.println(buttonName);
        return buttonName;
    }
    
    public int getPanelID(){
        System.out.println(ButtonPanelID);
        return ButtonPanelID;
    }
    
}