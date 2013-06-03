/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.visualization;

import ca.CellSpace;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.SpinnerNumberModel;
import server.ServerController;
import server.SimulationController;

/**
 *
 * @author Lukasz
 */
public class MyWindow extends javax.swing.JFrame {

    private CellSpace cellSpace;
    private SimulationController simulationController;
    private ServerController serverController;

    /**
     * Creates new form MyWindow
     */
    public MyWindow() {
        cellSpace = new CellSpace(100, 100, 100);

        initComponents();
    }

    public void setSimulationController(SimulationController simulationController) {
        this.simulationController = simulationController;
        minTextField.setText(String.valueOf(simulationController.getMin()));
        maxTextField.setText(String.valueOf(simulationController.getMax()));
        setCellSpace(simulationController.getSpace());
    }

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
        startButton.setEnabled(true);
    }

    public void setCellSpace(CellSpace cellSpace) {
        this.cellSpace = cellSpace;
        visualizationPanel2.setCellSpace(cellSpace);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider(JSlider.HORIZONTAL,
            1, cellSpace.getDepth(), 1);
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        maxTextField = new javax.swing.JTextField();
        setMaxButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        minTextField = new javax.swing.JTextField();
        setMinButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        layerTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nodesListTextArea = new javax.swing.JTextArea();
        visualizationPanel2 = new server.visualization.VisualizationPanel(cellSpace, jSlider1);
        jLabel5 = new javax.swing.JLabel();
        hostAdressTextField = new javax.swing.JTextField();
        addHostButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 720));
        setMinimumSize(new java.awt.Dimension(700, 720));
        setPreferredSize(new java.awt.Dimension(700, 720));

        jSlider1.setMajorTickSpacing(9);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintTrack(false);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setMaximumSize(new java.awt.Dimension(500, 45));
        jSlider1.setMinimumSize(new java.awt.Dimension(500, 45));
        jSlider1.setPreferredSize(new java.awt.Dimension(500, 45));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        startButton.setText("Start");
        startButton.setEnabled(false);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });

        stopButton.setLabel("Stop");
        stopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Max diff value");
        jLabel1.setToolTipText("");

        maxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        setMaxButton.setText("Set");
        setMaxButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setMaxButtonMouseClicked(evt);
            }
        });

        jLabel2.setText("Min diff value");

        minTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        setMinButton.setText("Set");
        setMinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setMinButtonMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Selected layer:");

        layerTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        layerTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        layerTextField.setText("1");
        layerTextField.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nodes list");

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        nodesListTextArea.setColumns(20);
        nodesListTextArea.setRows(5);
        nodesListTextArea.setFocusable(false);
        jScrollPane1.setViewportView(nodesListTextArea);

        visualizationPanel2.setMaximumSize(new java.awt.Dimension(500, 500));
        visualizationPanel2.setMinimumSize(new java.awt.Dimension(500, 500));
        visualizationPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add host:");

        hostAdressTextField.setText("Adress");

        addHostButton.setText("Add");
        addHostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addHostButtonMouseClicked(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.setToolTipText("");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visualizationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(260, 260, 260))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(242, 242, 242))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addComponent(layerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(setMaxButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(minTextField)
                                    .addComponent(setMinButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(stopButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hostAdressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addHostButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setMaxButton)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(minTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setMinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostAdressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addHostButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(visualizationPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        setMaxButton.getAccessibleContext().setAccessibleName("setButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        visualizationPanel2.repaint();
        layerTextField.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked

        serverController.makeRemoteCall();
        visualizationPanel2.repaint();
    }//GEN-LAST:event_startButtonMouseClicked

    private void stopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopButtonMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_stopButtonMouseClicked

    private void setMaxButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setMaxButtonMouseClicked
        visualizationPanel2.setDiffHight(Double.parseDouble(maxTextField.getText()));
        visualizationPanel2.repaint();
    }//GEN-LAST:event_setMaxButtonMouseClicked

    private void setMinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setMinButtonMouseClicked
        visualizationPanel2.setDiffLow(Double.parseDouble(minTextField.getText()));
        visualizationPanel2.repaint();
    }//GEN-LAST:event_setMinButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        serverController.clearCurrentNodes();
        serverController.addHost("localhost");
        nodesListTextArea.setText("");
        serverController.bindRemoteNodes();
        for (String hostName : serverController.getHostsNames()) {
            nodesListTextArea.append(String.format("%s \n", hostName));
        }
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void addHostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHostButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addHostButtonMouseClicked

    private void resetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHostButton;
    private javax.swing.JTextField hostAdressTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField layerTextField;
    private javax.swing.JTextField maxTextField;
    private javax.swing.JTextField minTextField;
    private javax.swing.JTextArea nodesListTextArea;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton setMaxButton;
    private javax.swing.JButton setMinButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private server.visualization.VisualizationPanel visualizationPanel2;
    // End of variables declaration//GEN-END:variables
}
