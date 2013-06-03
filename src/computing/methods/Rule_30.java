/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computing.methods;
import ca.Area;
import computing.methodsinterfaces.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Mati
 */
// oszukane zasady zmiany stanu - nie wyrobie sie dzis z rozkmina w 3d ale wykorzystuje jeden z argumentow
// moze jutro poprawie na prawdziwa regule 30
public class Rule_30 implements IterationMethodI {


    public Rule_30()
    {
        set_arguments(2);  // poki co na sztywno dwa ale mozna dodac w interfejsie pytanie ile ma byc argumentow itd     
    }
    

    @Override
    public void nextIteration(Area area)
    {

        for (int i = 1; i < area.getRealWidth() - 2; i++) {
            for (int j = 1; j < area.getRealHeight() - 2; j++) {
                for (int k = 1; k < area.getRealDepht() - 2; k++) {
                    
                    double newValue = (area.getValue(i, j - 1, k)
                            + area.getValue(i - 1, j, k) + area.getValue(i, j, k) + area.getValue(i + 1, j, k)
                            + area.getValue(i, j + 1, k) + area.getValue(i, j, k + 1) + area.getValue(i, j, k - 1)) / 7;
                    
                        Arguments temp = (Arguments)arguments_list.get(1); 
                        area.setValue(i, j, k, newValue + temp.get_argument_value() ); // nadpisane linijke 
                        area.setValue(i, j, k, newValue);
                }
            }
        }
    }
    
    @Override
    public void set_arguments( int x)
    {
        for(int i=0;i<x;i++)
        {
            try {
                arguments_list.add(new Arguments());
            } catch (IOException ex) {
                Logger.getLogger(Rule_30.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
