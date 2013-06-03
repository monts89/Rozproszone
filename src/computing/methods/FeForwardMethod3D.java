/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computing.methods;

import computing.methodsinterfaces.*;
import ca.Area;
import java.util.Random;

/**
 *
 * @author Andrewman
 */
//Klasa implementująca IterationMethodI będzie używana do obliczania kolejnego kroku iteracji
//Będzie wykorzystywana przez węzły sieci
public class FeForwardMethod3D implements IterationMethodI {

    public FeForwardMethod3D() {
        parameters.put(DiffusionParams.Random.name, new Random().nextDouble());
    }
    
    @Override
    public void nextIteration(Area area) {
        for (int i = 1; i < area.getRealWidth() - 2; i++) {
            for (int j = 1; j < area.getRealHeight() - 2; j++) {
                for (int k = 1; k < area.getRealDepht() - 2; k++) {

                    double newValue = (area.getValue(i, j - 1, k)
                            + area.getValue(i - 1, j, k) + area.getValue(i, j, k) + area.getValue(i + 1, j, k)
                            + area.getValue(i, j + 1, k) + area.getValue(i, j, k + 1) + area.getValue(i, j, k - 1)) / 7;
                    area.setValue(i, j, k, newValue + parameters.get(DiffusionParams.Random.name));
                }
            }
        }
    }
    
    enum DiffusionParams{
        
        Random("Random");    
        String name;
        
        DiffusionParams(String name) {
            this.name = name;
        }
    }
}
