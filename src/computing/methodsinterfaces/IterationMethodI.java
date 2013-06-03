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
import java.util.Map.Entry;
import java.util.*;


/**
 *
 * @author Andrewman
 */
public interface IterationMethodI {

    public Map<String, Double> parameters = new HashMap<String, Double>();
    
    public abstract void nextIteration(Area area);
}




