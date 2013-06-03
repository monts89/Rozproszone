/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computing.methodsinterfaces;

import ca.Area;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Andrewman
 */
public interface IterationMethodI {

    public List arguments_list = new ArrayList();
    
    public void set_arguments( int x);
    
    
    
    
    public void nextIteration(Area area);
}




