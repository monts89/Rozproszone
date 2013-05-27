/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualization;

import ca.CellSpace;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;

/**
 *
 * @author Lukasz
 */
public class VisualizationPanel extends JPanel {
    private CellSpace cellSpace;
    private JSlider slider;
    private double diffHight;
    private double diffLow;

    /**
     * Creates new form VisualizationPanel
     */
    public VisualizationPanel() {
    }

    
    public VisualizationPanel(CellSpace cellSpace, JSlider slider) {
        this.cellSpace = cellSpace;
        this.slider = slider;
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cellSpace != null) { //for editor
            double tH;
            if (diffHight != 0) {
                tH = diffHight / 255;
            } else {
                tH = 1;
            }
            for (int i = 0; i < cellSpace.getHeight(); i++) {
                for (int j = 0; j < cellSpace.getWidth(); j++) {
                    int layer = (int) slider.getValue() - 1;
                    Color c = null;
                    if (cellSpace.getValue(i, j, layer) > diffLow) {
                        c = new Color(255, 0, 0, (int) (cellSpace.getValue(i, j, layer) / tH));
                    } else if (cellSpace.getValue(i, j, layer) == diffLow) {
                        c = new Color(0, 0, 255, 80);
                    } else {
                        c = Color.BLACK;
                    }
                    g.setColor(c);
                    g.fillRect(i * 5, j * 5, 5, 5);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 5, j * 5, 5, 5);
                }
            }
        }
    }

    public void setCellSpace(CellSpace cellSpace) {
        this.cellSpace = cellSpace;
        this.repaint();
    }
    
    public void setDiffHight(double diffHight){
        this.diffHight = diffHight;
    }

    public void setDiffLow(double diffLow) {
        this.diffLow = diffLow;
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
