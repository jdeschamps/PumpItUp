/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functionpanels;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import data.Function;
import data.Phase;

/**
 *
 * @author Ries
 */
public class EventFunctionPanel extends FunctionPanel {

    /**
     * Creates new form RateFunctionPanel
     */
    public EventFunctionPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_trigger = new javax.swing.JLabel();
        jComboBox_edge = new javax.swing.JComboBox();
        jLabel_jump = new javax.swing.JLabel();
        
        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 99, 1);  
        jSpinner_phase = new javax.swing.JSpinner(model1);
        jSpinner_phase.addChangeListener(new ChangeListener() {      
			@Override
			public void stateChanged(ChangeEvent arg0) {
				updatePhase();
			}
        });
        
        jLabel_trigger.setText("Trigger:");

        jComboBox_edge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Falling edge", "Any edge" }));
        jComboBox_edge.setEditable(false);
        
        jLabel_jump.setText("Jump to phase:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_jump)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner_phase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_trigger)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_edge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_trigger)
                    .addComponent(jComboBox_edge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_jump)
                    .addComponent(jSpinner_phase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox_edge;
    private javax.swing.JLabel jLabel_jump;
    private javax.swing.JLabel jLabel_trigger;
    private javax.swing.JSpinner jSpinner_phase;
    // End of variables declaration//GEN-END:variables
	@Override
	public void setInstructions() {}

	@Override
	public void setPossibleFunctions() {
		possibleFunction = new String[2];
		possibleFunction[1] = Function.EVS.getName();
		possibleFunction[0] = Function.EVN.getName();
	}

	@Override
	public void setPhase(Phase p) {
		this.currentphase = p;
		if(p.getFunction().equals(possibleFunction[0])){
			jComboBox_edge.setSelectedIndex(0);
		} else if(p.getFunction().equals(possibleFunction[1])){
			jComboBox_edge.setSelectedIndex(0);
		}
		int param=0;
		try{
			param = Integer.parseInt(p.getCommand().substring(3, 2));
		} catch (Exception e){}
		jSpinner_phase.setValue(param);
	}
	

	@Override
	public void updatePhase() {
		this.currentphase.setParameter(String.valueOf((Integer) jSpinner_phase.getValue()));
	}
}
