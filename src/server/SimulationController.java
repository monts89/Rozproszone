/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ca.CellSpace;

/**
 *
 * @author Andrewman
 */
public class SimulationController {

    private double maxC;
    private double minC;
    private CellSpace space;
    private int spaceX;
    private int spaceY;
    private int spaceZ;
    private PREDEFINED_CONDITIONS chosenModel;

    public SimulationController(CellSpace space, double max, double min) {
        spaceX = space.getWidth();
        spaceY = space.getHeight();
        spaceZ = space.getDepth();
        maxC = max;
        minC = min;
        chosenModel = PREDEFINED_CONDITIONS.Ball;
        this.space = space;
    }

    public double getMax() {
        return maxC;
    }

    public void setMax(double max) {
        maxC = max;
    }

    public double getMin() {
        return minC;
    }

    public void setMin(double min) {
        minC = min;
    }
    
    public void changeConditions(PREDEFINED_CONDITIONS choice){
        this.chosenModel = choice;
        this.reset();
    }

    public void init(PREDEFINED_CONDITIONS choice) {
        switch (choice) {
            case Ball:
                //Kula duże stężenie
                putBackground(minC);
                putCircle(spaceX / 2, spaceY / 2, spaceZ / 2, 40, maxC);
                break;
            case ReverseBall:
                //Kula małe stężenie
                putBackground(maxC);
                putCircle(spaceX / 2, spaceY / 2, spaceZ / 2, 40, minC);
                break;
            case MoreBalls:
                //Wiele kul, duże stężenie
                int r = 10;
                putBackground(minC);
                for (int i = 0; i < spaceX; i += 2 * r) {
                    for (int j = 0; j < spaceY; j += 2 * r) {
                        for (int k = 0; k < spaceZ; k += 2 * r) {
                            putCircle(j, i, k, r / 2, maxC);
                        }
                    }
                }
                break;
            case MoreBallsReverse:
                //Wiele kul, małe stężenie
                int r1 = 10;
                putBackground(maxC);
                for (int i = 0; i < spaceX; i += 2 * r1) {
                    for (int j = 0; j < spaceY; j += 2 * r1) {
                        for (int k = 0; k < spaceZ; k += 2 * r1) {
                            putCircle(j, i, k, r1 / 2, minC);
                        }
                    }
                }
                break;
            default:
                break;
        }
        chosenModel = choice;
    }

    private void putCircle(int x, int y, int z, int r, double value) {
        for (int i = 0; i < spaceX; i++) {
            for (int j = 0; j < spaceY; j++) {
                for (int k = 0; k < spaceZ; k++) {
                    double d = (double) Math.sqrt(Math.pow(x - j, 2) + Math.pow(y - i, 2) + Math.pow(z - k, 2));
                    if (d < r) {
                        space.setValue(j, i, k, value);
                    }
                }
            }
        }
    }

    private void putBackground(double value) {
        for (int i = 0; i < spaceX; i++) {
            for (int j = 0; j < spaceY; j++) {
                for (int k = 0; k < spaceZ; k++) {
                    space.setValue(j, i, k, value);
                }
            }
        }
    }

    public void reset() {
        init(chosenModel);
    }
    
    public enum PREDEFINED_CONDITIONS{
        Ball,
        ReverseBall,
        MoreBalls,
        MoreBallsReverse
    }
}
