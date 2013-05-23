/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca;

/**
 *
 * @author Andrewman
 */
//Klasa obsługująca operacje na przestrzeni automatów
//boxTable3D - przestrzeń automatów
public class CellSpace {

    private Cell[][][] boxTable3D;
    private int width, height, depth;
    private boolean periodic = true;

    public Cell[][][] getBoxTable3D() {
        return boxTable3D;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //private Random rand = new Random();
    public CellSpace(int panelCountX, int panelCountY, int panelCountZ) {
        boxTable3D = new Cell[panelCountX][panelCountY][panelCountZ];
        for (int i = 0; i < panelCountX; i++) {
            for (int j = 0; j < panelCountY; j++) {
                for (int k = 0; k < panelCountZ; k++) {
                    boxTable3D[i][j][k] = new Cell();
                }
            }
        }
        width = panelCountX;
        height = panelCountY;
        depth = panelCountZ;
    }

    public CellSpace(CellSpace temp) {
        this.periodic = temp.periodic;
        this.width = temp.width;
        this.height = temp.height;
        this.depth = temp.depth;

        boxTable3D = new Cell[width][height][depth];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < depth; k++) {
                    boxTable3D[i][j][k] = temp.boxTable3D[i][j][k];
                }
            }
        }
    }

    private int checkCoord(int x, int axis) {
        int tempX = x;
        int dimension;
        switch (axis) {
            case 0:
                dimension = width;
                break;
            case 1:
                dimension = height;
                break;
            case 2:
                dimension = depth;
                break;
            default:
                dimension = width;
                break;
        }

        if (periodic) {
            if (x > dimension - 1) {
                tempX = 0;
            }
            if (x < 0) {
                tempX = dimension - 1;
            }
        }
        return tempX;
    }

    //BOX LOGIC   
    public double getValue(int x, int y, int z) {
        int tempX = checkCoord(x, 0);
        int tempY = checkCoord(y, 1);
        int tempZ = checkCoord(z, 2);

        return boxTable3D[tempX][tempY][tempZ].getValue();
    }

    public void setValue(int x, int y, int z, double concentration) {
        int tempX = checkCoord(x, 0);
        int tempY = checkCoord(y, 1);
        int tempZ = checkCoord(z, 2);

        boxTable3D[tempX][tempY][tempZ].setValue(concentration);
    }

    public Area getArea(int startHeight, int endHeight) {
        return new Area(this, startHeight, endHeight);
    }

    public void resetSpace() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < depth; k++) {
                    boxTable3D[i][j][k].setValue(0);
                }
            }
        }
    }
}