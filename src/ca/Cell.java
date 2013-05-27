/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca;

import java.io.Serializable;

/**
 *
 * @author Andrewman
 */
//Pojedyncza komórka
public class Cell implements Serializable {

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double C) {
        this.value = C;
    }
}
