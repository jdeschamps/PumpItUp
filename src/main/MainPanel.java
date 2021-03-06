/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import data.Controller;
import data.Instruction;
import data.Profile;
import data.Program;
import data.Pump;

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
        jPanel_graph = new javax.swing.JPanel();
        jPanel_profile = new javax.swing.JPanel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_number = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_pumps = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_profile = new javax.swing.JList();
        jSeparator = new javax.swing.JSeparator();
        jButton_newprofile = new javax.swing.JButton();
        jButton_modifyprofile = new javax.swing.JButton();
        jButton_addprofile = new javax.swing.JButton();
        

        jPanel_empty1 = new javax.swing.JPanel();
        jPanel_empty4 = new javax.swing.JPanel();
        jPanel_empty6 = new javax.swing.JPanel();
        jPanel_empty5 = new javax.swing.JPanel();
        jPanel_empty3 = new javax.swing.JPanel();
        jPanel_empty2 = new javax.swing.JPanel();

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
            	controller.stopPumps();
            }
        });
        

        jPanel_controls.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanel_empty1Layout = new javax.swing.GroupLayout(jPanel_empty1);
        jPanel_empty1.setLayout(jPanel_empty1Layout);
        jPanel_empty1Layout.setHorizontalGroup(
            jPanel_empty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty1Layout.setVerticalGroup(
            jPanel_empty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty1);

        javax.swing.GroupLayout jPanel_empty4Layout = new javax.swing.GroupLayout(jPanel_empty4);
        jPanel_empty4.setLayout(jPanel_empty4Layout);
        jPanel_empty4Layout.setHorizontalGroup(
            jPanel_empty4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty4Layout.setVerticalGroup(
            jPanel_empty4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty4);

        javax.swing.GroupLayout jPanel_empty6Layout = new javax.swing.GroupLayout(jPanel_empty6);
        jPanel_empty6.setLayout(jPanel_empty6Layout);
        jPanel_empty6Layout.setHorizontalGroup(
            jPanel_empty6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty6Layout.setVerticalGroup(
            jPanel_empty6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty6);

        jPanel_controls.add(jButton_start);
        jPanel_controls.add(jButton_stop);

        javax.swing.GroupLayout jPanel_empty5Layout = new javax.swing.GroupLayout(jPanel_empty5);
        jPanel_empty5.setLayout(jPanel_empty5Layout);
        jPanel_empty5Layout.setHorizontalGroup(
            jPanel_empty5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty5Layout.setVerticalGroup(
            jPanel_empty5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty5);

        javax.swing.GroupLayout jPanel_empty3Layout = new javax.swing.GroupLayout(jPanel_empty3);
        jPanel_empty3.setLayout(jPanel_empty3Layout);
        jPanel_empty3Layout.setHorizontalGroup(
            jPanel_empty3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty3Layout.setVerticalGroup(
            jPanel_empty3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty3);

        javax.swing.GroupLayout jPanel_empty2Layout = new javax.swing.GroupLayout(jPanel_empty2);
        jPanel_empty2.setLayout(jPanel_empty2Layout);
        jPanel_empty2Layout.setHorizontalGroup(
            jPanel_empty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel_empty2Layout.setVerticalGroup(
            jPanel_empty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel_controls.add(jPanel_empty2);
        
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Graph

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);
        
        javax.swing.GroupLayout jPanel_graphLayout = new javax.swing.GroupLayout(jPanel_graph);
        jPanel_graph.setLayout(jPanel_graphLayout);
        jPanel_graphLayout.setHorizontalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(js)
        );
        jPanel_graphLayout.setVerticalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_graphLayout.createSequentialGroup()
                .addComponent(js, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
   /*     javax.swing.GroupLayout jPanel_graphLayout = new javax.swing.GroupLayout(jPanel_graph);
        jPanel_graph.setLayout(jPanel_graphLayout);
        jPanel_graphLayout.setHorizontalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_graphLayout.setVerticalGroup(
            jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );*/

        
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Profiles
        listprofileAvailable = new DefaultListModel();
        fillListProfiles();
   
        listPumps = new DefaultListModel();
/*
        jTextField_name.setEditable(false);
        jTextField_name.setText("");

        jLabel_number.setText("N:");

        jTextField_number.setEditable(false);
        jTextField_number.setText("");

        jLabel_length.setText("Length (min):");

        jTextField_length.setEditable(false);
        jTextField_length.setText("");*/

        jList_pumps.setModel(listPumps);
     /*   jList_pumps.addMouseListener( new MouseAdapter()
        {
           public void mousePressed(MouseEvent e)
           {
               if ( SwingUtilities.isRightMouseButton(e) )
               {
                   
               }
           }
        });*/
        
        
        jScrollPane2.setViewportView(jList_pumps);

        jList_profile.setModel(listprofileAvailable);
        jScrollPane1.setViewportView(jList_profile);
        jList_profile.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent e){
        		if (e.getValueIsAdjusting() == false){
        			if(controller.hasProfile(jList_profile.getSelectedIndex())){
	        			Profile p = controller.getProfileFromList(jList_profile.getSelectedIndex());
	        			if(p!=null){
		        			controller.setCurrentProfile(p);
		        			jTextField_name.setText(p.getName());
		        			jTextField_number.setText(String.valueOf(p.getNumberPumps()));
		        			fillListPumps();
		        			fillTable();
	        			}
        			}
        		}
        	}
        });
        
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton_newprofile.setText("+");
        jButton_newprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	controller.setCurrentProfile(new Profile());
            	profileSelection();
            }
        });

        jButton_modifyprofile.setText("~");
        jButton_modifyprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(jList_profile.getSelectedIndex()==-1){
                	controller.setCurrentProfile(new Profile());
            	} else {
            		controller.setCurrentProfile(new Profile(controller.getCurrentProfile()));
            	}
            	profileSelection();
            }
        });

        jButton_addprofile.setText(">");
        jButton_addprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	loadProfile();
            }
        });

        jButton_newprofile.setToolTipText("New profile");
        jButton_modifyprofile.setToolTipText("Modify existing profile");
        jButton_addprofile.setToolTipText("Add existing profile");

        javax.swing.GroupLayout jPanel_programsLayout = new javax.swing.GroupLayout(jPanel_profile);
        jPanel_profile.setLayout(jPanel_programsLayout);
        jPanel_programsLayout.setHorizontalGroup(
            jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_programsLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_newprofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_modifyprofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_addprofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_programsLayout.setVerticalGroup(
            jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_programsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_programsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    private void fillTable(){
    	int npumps = controller.getNumberPumps();
    	if(npumps>0){
	    	Profile p = controller.getCurrentProfile();
	    	
	    	int m = 0;
	    	String[] columnsName = new String[npumps+1];
	    	columnsName[0] = "Phase";
	    	for(int i=1;i<=npumps;i++){
	    		columnsName[i]=p.getPump(i-1).getName();
	    		if(p.getPump(i-1).getNumberPhases()>m){
	    			m = p.getPump(i-1).getNumberPhases();
	    		}
	    	}
	    	
	    	m=m+2;
	    	String[][] data = new String[m][npumps+1];
	    	for(int i=1;i<=npumps;i++){
	    		Pump pu = p.getPump(i-1);
	    		data[0][i] = String.valueOf(pu.getAddress());
	    		data[1][i] = String.valueOf(pu.getDiameter());
	    		for(int j=2;j<m;j++){
	    			if(pu.hasPhase(j-1)){
	    				data[j][i] = "FUN "+pu.getPhase(j-1).getFunction()+" "+pu.getPhase(j-1).getParameter()+"\n";
	    				if(pu.getPhase(j-1).getNumberInstructions()>0){
	    					ArrayList<Instruction> ins = pu.getPhase(j-1).getInstructions();
	    					for(int k=0;k<ins.size();k++){
	    						data[j][i] += ins.get(k).getCommand()+" "+ins.get(k).getParameter()+"\n";
	    					}
	    				}
	    			} else {
	    				data[j][i] = "";
	    			}
	    		}
	    	}
	    	data[0][0] = "Address";
	    	data[1][0] = "Diameter (mm)";
	    	for(int j=2;j<m;j++){
	    		data[j][0] = "Phase"+j;
	    	}
	    	System.out.println("Set new table model");
	    	tableModel = new DefaultTableModel(data,columnsName);
	    	table.setModel(tableModel);
    	}
    }

    private void fillListProfiles() {
    	listprofileAvailable.clear();
        String[] availableprofiles = controller.getStringProfiles();
     	for(int i=0;i<availableprofiles.length;i++){
     		listprofileAvailable.add(i, availableprofiles[i]);
     	}		
	}

    private void fillListPumps() {
    	listPumps.clear();
        String[] availablepumps = controller.getPumpList();
     	for(int i=0;i<availablepumps.length;i++){
     		listPumps.add(i, availablepumps[i]);
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
    	    fillListProfiles();
    	    jList_profile.setSelectedIndex(listprofileAvailable.size()-1);
    	}
	}

	private void profileSelection(){
		selectionFrame = new JFrame();
		selectionFrame.add(new ProfileSelectionPanel(controller, this));
		selectionFrame.pack();
		selectionFrame.setVisible(true);
	}

	public void closeProfileSelection(){
		if(selectionFrame != null){
			selectionFrame.setVisible(false);
			selectionFrame.dispose();
			
			fillListProfiles();
		}
	}
	
	private javax.swing.JButton jButton_addprofile;
    private javax.swing.JButton jButton_modifyprofile;
    private javax.swing.JButton jButton_newprofile;
    private javax.swing.JButton jButton_start;
    private javax.swing.JButton jButton_stop;
    private javax.swing.JList jList_profile;
    private javax.swing.JList jList_pumps;
    private javax.swing.JPanel jPanel_controls;
    private javax.swing.JPanel jPanel_graph;
    private javax.swing.JPanel jPanel_profile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_number;
    private javax.swing.JPanel jPanel_empty1;
    private javax.swing.JPanel jPanel_empty2;
    private javax.swing.JPanel jPanel_empty3;
    private javax.swing.JPanel jPanel_empty4;
    private javax.swing.JPanel jPanel_empty5;
    private javax.swing.JPanel jPanel_empty6;
    
    private DefaultListModel listprofileAvailable;
    private DefaultListModel listPumps;
    
    private DefaultTableModel tableModel;
    private JTable table;
    
    private JFrame selectionFrame;
}
