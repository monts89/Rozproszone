/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca;

/**
 *
 * @author Andrewman
 */
//Obiekt przechowujący zadany wycinek przestrzeni
//Przestrzeń jest dzielona tylko w jednym wymiarze
//Czyli podajemy poczatkowa i koncową wysokość
public class Area {

    private int realHeight;
    private int realWidth;
    private int realDepht;
    private int startHeight, endHeight;
    private Cell[][][] area;

    public double getValue(int x, int y, int z) {
        return area[x][y][z].getValue();
    }

    public int getRealDepht() {
        return realDepht;
    }

    public int getRealHeight() {
        return realHeight;
    }

    public int getRealWidth() {
        return realWidth;
    }

    public int getEndHeight() {
        return endHeight;
    }

    public int getStartHeight() {
        return startHeight;
    }
    //Konstruktor od razu pobiera odpowiednią część cellspace w zależności od argumentów
    public Area(CellSpace space, int startHeight, int endHeight) {
        this.realWidth = space.getWidth() + 2;
        if(space.getDepth() > 1){
            this.realDepht = space.getDepth() + 2;
        }else{
            this.realDepht = 1;
        }
        this.realHeight = ((endHeight + 1) - startHeight) + 2;
        this.startHeight = startHeight;
        this.endHeight = endHeight;

        this.area = new Cell[realWidth][realHeight][realDepht];
        for (int i = 0; i < realWidth; i++) {
            for (int j = 0; j < realHeight; j++) {
                    for (int k = 0; k < realDepht; k++) {
                        this.area[i][j][k] = new Cell();
                        this.area[i][j][k].setValue(space.getValue(i, (startHeight - 1) + j, k));
                        //this.area[i][j][k].setValue(2.0);
                    }
            }
        }

    }
}
