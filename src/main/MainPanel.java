/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import data.Controller;
import data.Profile;

/**
 *
 * @author Ries
 */
public class MainPanel extends javax.swing.JPanel {

  
	private Controller controller;
	
    public MainPanel(Controller controller) {
    	this.controller = controller;
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

        jPanel_controls = new javax.swing.JPanel();
        jButton_start = new javax.swing.JButton();
        jButton_stop = new javax.swing.JButton();
        jToggleButton_pause = new javax.swing.JToggleButton();
        jToggleButton_resume = new javax.swing.JToggleButton();
        jPanel_graph = new javax.swing.JPanel();
        jPanel_profile = new javax.swing.JPanel();
        jTextField_name = new javax.swing.JTextField();
        jLabel_number = new javax.swing.JLabel();
        jTextField_number = new javax.swing.JTextField();
        jLabel_length = new javax.swing.JLabel();
        jTextField_length = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_pumps = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_profile = new javax.swing.JList();
        jSeparator = new javax.swing.JSeparator();
        jButton_newprofile = new javax.swing.JButton();
        jButton_modifyprofile = new javax.swing.JButton();
        jButton_addprofile = new javax.swing.JButton();

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Controls
        jButton_start.setText("Start");
        jButton_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	controller.startPumps();
            }
        });
        
        jButton_stop.setText("Stop");
        jButton_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	controller.startPumps();
            }
        });
        
        jToggleButton_pause.setText("||");

        jToggleButton_resume.setText(">");

        javax.swing.GroupLayout jPanel_controlsLayout = new javax.swing.GroupLayout(jPanel_controls);
        jPanel_controls.setLayout(jPanel_controlsLayout);
        jPanel_controlsLayout.setHorizontalGroup(
            jPanel_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_controlsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_pause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_resume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_stop)
                .addGap(169, 169, 169))
        );
        jPanel_controlsLayout.setVerticalGroup(
            jPanel_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_start, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton_resume, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Graph
        javax.swing.GroupLayout jPanel_graphLayout = new javax.swing.GroupLayout(jPanel_graph);
        jPanel_graph.setLayout(jPanel_graphLayout);
        jPanel_graphLayout.setHorizontalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_graphLayout.setVerticalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Profiles
        listprofileAvailable = new DefaultListModel();
        fillList(listprofileAvailable);
   
        listPumps = new DefaultListModel();

        jTextField_name.setEditable(false);
        jTextField_name.setText("");

        jLabel_number.setText("N:");

        jTextField_number.setEditable(false);
        jTextField_number.setText("");

        jLabel_length.setText("Length (min):");

        jTextField_length.setEditable(false);
        jTextField_length.setText("");

        jList_pumps.setModel(listPumps);
        jScrollPane2.setViewportView(jList_pumps);

        jList_profile.setModel(listprofileAvailable);
        jScrollPane1.setViewportView(jList_profile);
        jList_profile.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent e){
        		if (e.getValueIsAdjusting() == false){
        			Profile p = controller.getProfileFromList(jList_profile.getSelectedIndex());
        			controller.setCurrentProfile(p);
        			jTextField_name.setText(p.getName());
        			jTextField_number.setText(String.valueOf(p.getNumberPumps()));
        			fillList(listPumps);
        		}
        	}
        });
        
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton_newprofile.setText("+");
        jButton_newprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JFrame frame = new JFrame();
            	controller.setCurrentProfile(new Profile());
            	frame.add(new ProfileSelectionPanel(controller));
            	frame.pack();
            	frame.setVisible(true);
            }
        });

        jButton_modifyprofile.setText("~");
        jButton_modifyprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JFrame frame = new JFrame();
            	frame.add(new ProfileSelectionPanel(controller));
            	frame.pack();
            	frame.setVisible(true);
            }
        });

        jButton_addprofile.setText(">");
        jButton_addprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	loadProfile();
            }
        });
        

        javax.swing.GroupLayout jPanel_programsLayout = new javax.swing.GroupLayout(jPanel_profile);
        jPanel_profile.setLayout(jPanel_programsLayout);
        jPanel_programsLayout.setHorizontalGroup(
            jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_programsLayout.createSequentialGroup()
                .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_programsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_newprofile, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_modifyprofile, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel_programsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_addprofile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_programsLayout.createSequentialGroup()
                        .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_length)
                            .addComponent(jLabel_number))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_length, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_number, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_programsLayout.setVerticalGroup(
            jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_programsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_programsLayout.createSequentialGroup()
                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_number)
                            .addComponent(jTextField_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_length)
                            .addComponent(jTextField_length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel_programsLayout.createSequentialGroup()
                            .addComponent(jButton_newprofile)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton_modifyprofile)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                            .addComponent(jButton_addprofile))
                        .addComponent(jSeparator)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    
    private void fillList(DefaultListModel list) {
    	list.clear();
        String[] availableprofiles = controller.getStringProfiles();
     	for(int i=0;i<availableprofiles.length;i++){
     		list.add(i, availableprofiles[i]);
     	}		
	}

	protected void loadProfile() {
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("piuprofile","piuprofile");
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileFilter(filter);
    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    	int result = fileChooser.showOpenDialog(this);
    	if (result == JFileChooser.APPROVE_OPTION) {
    	    File selectedFile = fileChooser.getSelectedFile();
    	    controller.loadNewProfile(selectedFile);
    	    fillList(listprofileAvailable);
    	    jList_profile.setSelectedIndex(listprofileAvailable.size()-1);
    	}
	}

	private javax.swing.JButton jButton_addprofile;
    private javax.swing.JButton jButton_modifyprofile;
    private javax.swing.JButton jButton_newprofile;
    private javax.swing.JButton jButton_start;
    private javax.swing.JButton jButton_stop;
    private javax.swing.JLabel jLabel_length;
    private javax.swing.JLabel jLabel_number;
    private javax.swing.JList jList_profile;
    private javax.swing.JList jList_pumps;
    private javax.swing.JPanel jPanel_controls;
    private javax.swing.JPanel jPanel_graph;
    private javax.swing.JPanel jPanel_profile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTextField jTextField_length;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_number;
    private javax.swing.JToggleButton jToggleButton_pause;
    private javax.swing.JToggleButton jToggleButton_resume;
    
    private DefaultListModel listprofileAvailable;
    private DefaultListModel listPumps;
    // End of variables declaration//GEN-END:variables
}
