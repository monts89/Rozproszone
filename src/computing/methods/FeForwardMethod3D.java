/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computing.methods;

import computing.methodsinterfaces.*;
import ca.Area;

/**
 *
 * @author Andrewman
 */
//Klasa implementująca IterationMethodI będzie używana do obliczania kolejnego kroku iteracji
//Będzie wykorzystywana przez węzły sieci
public class FeForwardMethod3D implements IterationMethodI {

    public FeForwardMethod3D() {
    }

    @Override
    public void nextIteration(Area area) {
        for(int i=0; i<area.getRealWidth(); i++){
            for(int j=0; j<area.getRealHeight(); j++){
                for(int k=0; k<area.getRealDepht(); k++){
                    area.setValue(i, j, k, 2.0);
                }
            }
        }
    }
}
