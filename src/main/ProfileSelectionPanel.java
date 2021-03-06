/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import data.Controller;
import data.Function;
import data.Phase;
import data.Profile;
import data.Pump;
import functionpanels.EmptyFunctionPanel;
import functionpanels.EventFunctionPanel;
import functionpanels.FunctionPanel;
import functionpanels.JumpFunctionPanel;
import functionpanels.LoopToPreviousFunctionPanel;
import functionpanels.OutFunctionPanel;
import functionpanels.PauseFunctionPanel;
import functionpanels.RateFunctionPanel;

/**
 *
 * @author Ries
 */
public class ProfileSelectionPanel extends javax.swing.JPanel {

	private Controller controller;
	private boolean newProfile;
	private MainPanel owner;

    public ProfileSelectionPanel(Controller controller, MainPanel owner) {
    	this.controller = controller;
    	this.owner = owner;
    	newProfile = false;
    	    	
    	initComponents();
    }

    private void instanciateComponents(){
        jPanel_pumpproperties = new javax.swing.JPanel();
        jLabel_diameter = new javax.swing.JLabel();
        jTextField_diameter = new javax.swing.JTextField();
        jLabel_name = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel_address = new javax.swing.JLabel();
        jComboBox_address = new javax.swing.JComboBox();
        jPanel_phases = new javax.swing.JPanel();
        jButton_addphase = new javax.swing.JButton();
        jButton_removephase = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_phases = new javax.swing.JList();
        jLabel_phases = new javax.swing.JLabel();
        jButton_moveup = new javax.swing.JButton();
        jButton_movedown = new javax.swing.JButton();
        jPanel_pumps = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_pumps = new javax.swing.JList();
        jLabel_pumps = new javax.swing.JLabel();
        jButton_addpump = new javax.swing.JButton();
        jButton_removepump = new javax.swing.JButton();
        jPanel_phaseproperties = new javax.swing.JPanel();
        jPanel_cardlayout = new javax.swing.JPanel();
        rateFunctionPanel1 = new RateFunctionPanel();
        outFunctionPanel1 = new OutFunctionPanel();
        pauseFunctionPanel1 = new PauseFunctionPanel();
        emptyFunctionPanel1 = new EmptyFunctionPanel();
        eventFunctionPanel1 = new EventFunctionPanel();
        jumpFunctionPanel1 = new JumpFunctionPanel();
        loopToPreviousFunctionPanel1 = new LoopToPreviousFunctionPanel();
        jLabel_function = new javax.swing.JLabel();
        jComboBox_function = new javax.swing.JComboBox();
        jPanel_actions = new javax.swing.JPanel();
        jButton_save = new javax.swing.JButton();
        jCheckBox_preview = new javax.swing.JCheckBox();
        jButton_quit = new javax.swing.JButton();

        listPhases =  new DefaultListModel();
        comboAddresses = new DefaultComboBoxModel();
        listPumps =  new DefaultListModel();
        
        ///////////// pumps
        int n = controller.getNumberPumps();
        String[] s = controller.getPumpList();
        for(int i=0;i<n;i++){
        	listPumps.addElement(s[i]);
        }
        
        jList_pumps.setModel(listPumps);
        
        ///////////// pump properties
        jPanel_pumpproperties.setBorder(javax.swing.BorderFactory.createTitledBorder(controller.getPumpName()));
        for(int i=0;i<100;i++){
        	comboAddresses.addElement(String.valueOf(i));
        }
        jComboBox_address.setModel(comboAddresses);
        jTextField_diameter.setText(String.valueOf(controller.getPumpDiameter()));
        jTextField_name.setText(String.valueOf(controller.getPumpName()));

        
        //////////// phases
        jList_phases.setModel(listPhases);
        
        /////////// phase properties
        jPanel_phaseproperties.setBorder(javax.swing.BorderFactory.createTitledBorder(controller.getPhaseFunction()));
        jComboBox_function.setModel(new javax.swing.DefaultComboBoxModel(Function.availableFunction));
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	instanciateComponents();

    	 ///////////////////////////////////////////////////////////////// Pumps
        jList_pumps.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent e){
        		if (e.getValueIsAdjusting() == false){
        			if(controller.hasPump(jList_pumps.getSelectedIndex())){
        				setPump(jList_pumps.getSelectedIndex());
        			}
        		}
        	}
        });
        jScrollPane1.setViewportView(jList_pumps);

        jLabel_pumps.setText("Pumps:");

        jButton_addpump.setText("+");
        jButton_addpump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addPump();
            }
        });

        jButton_removepump.setText("-");
        jButton_removepump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           		removePump();
            }
        });

        javax.swing.GroupLayout jPanel_pumpsLayout = new javax.swing.GroupLayout(jPanel_pumps);
        jPanel_pumps.setLayout(jPanel_pumpsLayout);
        jPanel_pumpsLayout.setHorizontalGroup(
            jPanel_pumpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pumpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel_pumpsLayout.createSequentialGroup()
                    .addComponent(jButton_addpump)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton_removepump))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel_pumps)
        );
        jPanel_pumpsLayout.setVerticalGroup(
            jPanel_pumpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pumpsLayout.createSequentialGroup()
                .addComponent(jLabel_pumps)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_pumpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_removepump)
                    .addComponent(jButton_addpump)))
        );
    	
        ///////////////////////////////////////////////////////////////// Pumps properties
        jLabel_diameter.setText("D (mm):");

        jTextField_diameter.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) {
				String s = jTextField_diameter.getText();
				if(isInteger(s)){
					changePumpDiameter(Integer.valueOf(s));
				} else {
					jTextField_diameter.setText(String.valueOf(controller.getPumpDiameter()));
				}
		}});
        jTextField_diameter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = jTextField_diameter.getText();
				if(isInteger(s)){
					changePumpDiameter(Integer.valueOf(s));
				} else {
					jTextField_diameter.setText(String.valueOf(controller.getPumpDiameter()));
				}
        }});

        jLabel_name.setText("Name:");

        jTextField_name.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) {
				changePumpName(jTextField_name.getText());
		}});
        jTextField_name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePumpName(jTextField_name.getText());
        }});

        jLabel_address.setText("Address:");

        jComboBox_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	changePumpAddress(jComboBox_address.getSelectedIndex());
            }
        });
        
        javax.swing.GroupLayout jPanel_pumppropertiesLayout = new javax.swing.GroupLayout(jPanel_pumpproperties);
        jPanel_pumpproperties.setLayout(jPanel_pumppropertiesLayout);
        jPanel_pumppropertiesLayout.setHorizontalGroup(
            jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                        .addComponent(jLabel_diameter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_diameter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                        .addGroup(jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                                .addComponent(jLabel_name)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                                .addComponent(jLabel_address)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel_pumppropertiesLayout.setVerticalGroup(
            jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pumppropertiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_name)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_diameter)
                    .addComponent(jTextField_diameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_pumppropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_address)
                    .addComponent(jComboBox_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ///////////////////////////////////////////////////////////////// Phases
        jButton_addphase.setText("+");
        jButton_addphase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("add phase triggered");
            	addPhase();
            }
        });

        jButton_removephase.setText("-");
        jButton_removephase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("remove phase triggered");

				removePhase();
            }
        });
        

        jList_phases.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
                    if (jList_phases.getSelectedIndex() != -1) {
                        int index = jList_phases.locationToIndex(evt.getPoint());
                        setPhase(index);
                    }
                }
            }
        });
        
      /*  jList_phases.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent e){
        		if (e.getValueIsAdjusting() == false){
        	    	System.out.println("phase list action triggered");

        			setPhase(jList_phases.getSelectedIndex());
        		}
        	}
        });*/
        jScrollPane2.setViewportView(jList_phases);

        jLabel_phases.setText("Phases:");

        jButton_moveup.setText("^");
        jButton_moveup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("move up phase triggered");
	            movePhaseUp();
            }
        });

        jButton_movedown.setText("v");
        jButton_movedown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("move down phase triggered");
            	movePhaseDown();
            }
        });

        javax.swing.GroupLayout jPanel_phasesLayout = new javax.swing.GroupLayout(jPanel_phases);
        jPanel_phases.setLayout(jPanel_phasesLayout);
        jPanel_phasesLayout.setHorizontalGroup(
            jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_phasesLayout.createSequentialGroup()
                .addGroup(jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_phasesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_moveup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_movedown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_phasesLayout.createSequentialGroup()
                        .addGroup(jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_phases)
                            .addGroup(jPanel_phasesLayout.createSequentialGroup()
                                .addComponent(jButton_addphase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_removephase)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_phasesLayout.setVerticalGroup(
            jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_phasesLayout.createSequentialGroup()
                .addComponent(jLabel_phases)
                .addGroup(jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_phasesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_phasesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton_moveup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_movedown)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_phasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_removephase)
                    .addComponent(jButton_addphase)))
        );

        
       

        ////////////////////////////////////////////////////////////////////////////////////////////// phase properties
        jPanel_cardlayout.setLayout(new java.awt.CardLayout());
        jPanel_cardlayout.add(rateFunctionPanel1, "card0");
        jPanel_cardlayout.add(outFunctionPanel1, "card1");
        jPanel_cardlayout.add(pauseFunctionPanel1, "card2");
        jPanel_cardlayout.add(emptyFunctionPanel1, "card3");
        jPanel_cardlayout.add(eventFunctionPanel1, "card4");
        jPanel_cardlayout.add(jumpFunctionPanel1, "card5");
        jPanel_cardlayout.add(loopToPreviousFunctionPanel1, "card6");

        jLabel_function.setText("Function:");

        jComboBox_function.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	setFunction((String) jComboBox_function.getSelectedItem());
            }
        });

        javax.swing.GroupLayout jPanel_phasepropertiesLayout = new javax.swing.GroupLayout(jPanel_phaseproperties);
        jPanel_phaseproperties.setLayout(jPanel_phasepropertiesLayout);
        jPanel_phasepropertiesLayout.setHorizontalGroup(
            jPanel_phasepropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_phasepropertiesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_function)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox_function, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel_cardlayout, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        jPanel_phasepropertiesLayout.setVerticalGroup(
            jPanel_phasepropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_phasepropertiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_phasepropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_function)
                    .addComponent(jComboBox_function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPanel_cardlayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ///////////////////////////////////////////////////////////////// lower panel
        jButton_save.setText("Save");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("PumpItUp profile","piuprofile");

            	JFileChooser fileChooser = new JFileChooser();
            	fileChooser.setFileFilter(filter);
            	fileChooser.setDialogTitle("Save profile");   
            	 
            	int userSelection = fileChooser.showSaveDialog(new JFrame());
            	 
            	if (userSelection == JFileChooser.APPROVE_OPTION) {
            		File fileToSave;
            		if(!fileChooser.getSelectedFile().getName().contains(".piuprofile")){
            			fileToSave = new File(fileChooser.getSelectedFile()+".piuprofile");
            		} else {
            			fileToSave = fileChooser.getSelectedFile();
            		}
            		controller.saveCurrentProfile(fileToSave);
            	    owner.closeProfileSelection();
            	}
            }
        });
        
        jCheckBox_preview.setText("Preview");

        jButton_quit.setText("Quit");
        jButton_quit.setVisible(false);
        jButton_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	owner.closeProfileSelection();
            }
        });

        javax.swing.GroupLayout jPanel_actionsLayout = new javax.swing.GroupLayout(jPanel_actions);
        jPanel_actions.setLayout(jPanel_actionsLayout);
        jPanel_actionsLayout.setHorizontalGroup(
            jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_actionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_quit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox_preview)
                .addGap(18, 18, 18)
                .addComponent(jButton_save)
                .addContainerGap())
        );
        jPanel_actionsLayout.setVerticalGroup(
            jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_actionsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_preview)
                    .addComponent(jButton_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_pumps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_pumpproperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_phases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_phaseproperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel_actions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_phases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_pumpproperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_pumps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_phaseproperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jPanel_actions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    
    
    //////////////////////////////////////////////////////////////////////// modify pump
    public void changePumpName(String name){
    	controller.setPumpName(name);
    	updatePumpList();
    }
    
    public void changePumpDiameter(int diam){
    	controller.setPumpDiameter(diam);
    }
    
    public void changePumpAddress(int add){
    	controller.setPumpAddress(add);
    }
    
    //////////////////////////////////////////////////////////////////////// modify phase
    public void setFunction(String fun){
    	controller.setFunction(fun);
    	//updatePhaseList();
    	System.out.println(fun);
    	renameObjectList(listPhases,jList_phases.getSelectedIndex(),fun);
    	setSelectedFunction(controller.getCurrentPhase());
    }
    
    //////////////////////////////////////////////////////////////////////// Jlist models
    public void removePump(){
    	controller.removePump();
		updatePumpList();
    }
    
    public void addPump(){
		controller.addPump();
		updatePumpList();
    }
    
    public void removePhase(){
	    if(jList_phases.getSelectedIndex()!=-1){
	   		controller.removePhase();
	    	System.out.println("remove");
	   		listPhases.remove(jList_phases.getSelectedIndex());
	    }
    	//updatePhaseList();	
    } 
    
    public void addPhase(){
    	System.out.println("add");
    	controller.addPhase();
    	String[] s = controller.getPhaseList();
    	listPhases.addElement(s[s.length-1]);
    	//updatePhaseList();	
    }
    
    public void movePhaseUp(){
    	controller.movePhaseUp();
    	moveUpEntry(listPhases,jList_phases.getSelectedIndex());
    	//updatePhaseList();
    	//exchangeEntries(listPhases,jList_phases.getSelectedIndex(),jList_phases.getSelectedIndex()-1);
    }
    
    public void movePhaseDown(){
    	controller.movePhaseDown();
    	int index =jList_phases.getSelectedIndex();
    	moveDownEntry(listPhases,index);
    	jList_phases.setSelectedIndex(index+1);
    	//exchangeEntries(listPhases,jList_phases.getSelectedIndex(),jList_phases.getSelectedIndex()+1);
    	//updatePhaseList();	
    }
    
    public void renameObjectList(DefaultListModel list, int i, String name){
    	System.out.println("rename");
    	if(i>=0 && i<list.size()){
    		list.set(i, name);
    	} 
    }
    
    public void moveUpEntry(DefaultListModel list, int i){

    	System.out.println("move up");
    	if(i>0 && i<list.size()){
    		Object o = list.remove(i-1);
    		list.add(i,o);
    	}
    }
    
    public void moveDownEntry(DefaultListModel list, int i){
    	System.out.println("move down");
    	if(i>=0 && i<list.size()-1){
    		Object o = list.remove(i+1);
    		list.add(i,o);
    		
    	}
    }
   
    public void exchangeEntries(DefaultListModel list, int i, int j){
    	System.out.println("exchange");

    	if(i!=j){
    		if((i>=0 && i<list.size()) && (j>=0 && j<list.size())){
	    									// [...; i ; ~~~ ; j ; ...] or [...; j ; ~~~ ; i ; ...] 
	    		Object o2 = list.remove(j); // [...; i ; ~~~ ; ...] or [... ; ~~~ ; i ; ...] 
	    		list.insertElementAt(o2, i); // [...; j ; i ; ~~~ ; ...] or [... ; ~~~ ; i ; j ; ...] 
	    		Object[] o = new Object[Math.abs(j-i)-1];
	    		int index=0;
	    		
	    		if(i<j){
		    		for(int k = 0; k< j-i-1; k++){ // [...; j ; i ; ~~~ ; ...]
		    			index = k+i+2;
		    			o[k] = list.remove(index);  // [~~~] 
		    		} 								// [...; j ; i ; ...] 
		    		for(int k = 0; k< j-i-1; k++){
		    			index = k+i+1;
		    			list.insertElementAt(o[k], index); // [...; j ; ~ ; i ; ...] 
		    		} 										// [...; j ; ~~~ ; i ; ...]
	    		} else if(i>j){
		    		for(int k = 0; k< i-j-1; k++){   // [... ; ~~~ ; i ; j ; ...] 
		    			index = k+j;
		    			o[k] = list.remove(index);  // [~~~] 
		    		} 								// [...; i ; j ; ...] 
		    		for(int k = 0; k< i-j-1; k++){
		    			index = k+j+1;
		    			list.insertElementAt(o[k], index); // [... ; i ; ~ ; j ; ...] 
		    		} 										// [... ; i ; ~~~ ; j ; ...] 
	    		}
	    	}
    	}
    }
    
   
    
    public void updatePumpList(){
    	System.out.println("update");
    	
    	listPumps.clear();
    	int n = controller.getNumberPumps();
    	String[] s = controller.getPumpList();
    	
    	listPumps.clear();
    	for(int i=0;i<n;i++){
    		listPumps.addElement(s[i]);
    	}
    }
    
    public void updatePhaseList(){    	
    	if(arePhasesOutDated()){
        	System.out.println("clear phase");

	    	listPhases.clear();
	    	int n = controller.getNumberPhases();
	    	String[] s = controller.getPhaseList();
	    	
	    	listPhases.clear();
	    	for(int i=0;i<n;i++){
	    		listPhases.addElement(s[i]);
	    	}
    	}
    }
    
    public boolean arePhasesOutDated(){
    	System.out.println("are outdate?");

    	String[] s = controller.getPhaseList();
    	if(listPhases.getSize()!=s.length){
    		return true;
    	}
    	
    	for(int i=0;i<s.length;i++){
    		if(!s[i].equals((String) listPhases.get(i))){
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    ///////////////////////////////////// move to (pump, phase)
    public void setPump(int i){
    	controller.setCurrentPump(i);
    	fillPumpProperties();
    	updatePhaseList();
    	setPhase(0);
    }
    
    public void setPhase(int i){
    	System.out.println("set phase");
    	controller.setCurrentPhase(i);
    	fillPhaseProperties();
    }
  
    private void fillPumpProperties(){    	
        jPanel_pumpproperties.setBorder(javax.swing.BorderFactory.createTitledBorder(controller.getPumpName()));
        jTextField_diameter.setText(String.valueOf(controller.getPumpDiameter()));
        jTextField_name.setText(controller.getPumpName());
        jComboBox_address.setSelectedIndex(controller.getPumpAddress());    	
    }
    
    private void fillPhaseProperties(){
    	System.out.println("fill phase properties");

        jPanel_phaseproperties.setBorder(javax.swing.BorderFactory.createTitledBorder(controller.getPhaseFunction()));
        jComboBox_function.setSelectedItem(controller.getPhaseFunction());
        setSelectedFunction(controller.getCurrentPhase());
    }
    
	private void setSelectedFunction(Phase p) { // when selecting the phase	
    	System.out.println("set selected function");

		CardLayout cl = (CardLayout)(jPanel_cardlayout.getLayout());
	    cl.show(jPanel_cardlayout, getCardName(p.getFunction()));
	    getPanelCard(getCardName(p.getFunction())).setPhase(p);
	} 
	
	
	public FunctionPanel getPanelCard(String key){
		if(key.equals("card0")){
			return rateFunctionPanel1;
		}else if(key.equals("card1")){
			return outFunctionPanel1;
		}else if(key.equals("card2")){
			return pauseFunctionPanel1;						
		}else if(key.equals("card3")){
			return emptyFunctionPanel1;
		}else if(key.equals("card4")){
			return eventFunctionPanel1;
		}else if(key.equals("card5")){
			return jumpFunctionPanel1;
		}else{
			return loopToPreviousFunctionPanel1;
		}
	}
	public String getCardName(String function){
		if(function.equals(Function.STP.getName())){
			return "card3";
		}else if(function.equals(Function.RAT.getName())){
			return "card0";
		}else if(function.equals(Function.PRL.getName())){
			return "card3";						
		}else if(function.equals(Function.PRI.getName())){
			return "card3";
		}else if(function.equals(Function.PAS.getName())){
			return "card2";
		}else if(function.equals(Function.OUT.getName())){
			return "card1";
		}else if(function.equals(Function.LPE.getName())){
			return "card6";
		}else if(function.equals(Function.LOP.getName())){
			return "card6";
		}else if(function.equals(Function.JMP.getName())){
			return "card5";
		}else if(function.equals(Function.INC.getName())){
			return "card0";
		}else if(function.equals(Function.IF.getName())){
			return "card5";
		}else if(function.equals(Function.EVS.getName())){
			return "card4";
		}else if(function.equals(Function.EVN.getName())){
			return "card4";
		}else if(function.equals(Function.DEC.getName())){
			return "card0";
		}else if(function.equals(Function.BEP.getName())){
			return "card3";
		}
		return "card3";
	}
    
    public static boolean isInteger(String s) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),10) < 0) return false;
        }
        return true;
    }
    
    private EmptyFunctionPanel emptyFunctionPanel1;
    private EventFunctionPanel eventFunctionPanel1;
    private javax.swing.JButton jButton_addphase;
    private javax.swing.JButton jButton_addpump;
    private javax.swing.JButton jButton_movedown;
    private javax.swing.JButton jButton_moveup;
    private javax.swing.JButton jButton_quit;
    private javax.swing.JButton jButton_removephase;
    private javax.swing.JButton jButton_removepump;
    private javax.swing.JButton jButton_save;
    private javax.swing.JCheckBox jCheckBox_preview;
    private javax.swing.JComboBox jComboBox_address;
    private javax.swing.JComboBox jComboBox_function;
    private javax.swing.JLabel jLabel_address;
    private javax.swing.JLabel jLabel_diameter;
    private javax.swing.JLabel jLabel_function;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_phases;
    private javax.swing.JLabel jLabel_pumps;
    private javax.swing.JList jList_phases;
    private javax.swing.JList jList_pumps;
    private javax.swing.JPanel jPanel_actions;
    private javax.swing.JPanel jPanel_cardlayout;
    private javax.swing.JPanel jPanel_phaseproperties;
    private javax.swing.JPanel jPanel_phases;
    private javax.swing.JPanel jPanel_pumpproperties;
    private javax.swing.JPanel jPanel_pumps;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_diameter;
    private javax.swing.JTextField jTextField_name;
    private JumpFunctionPanel jumpFunctionPanel1;
    private LoopToPreviousFunctionPanel loopToPreviousFunctionPanel1;
    private OutFunctionPanel outFunctionPanel1;
    private PauseFunctionPanel pauseFunctionPanel1;
    private RateFunctionPanel rateFunctionPanel1;
    
    private DefaultListModel listPumps;
    private DefaultListModel listPhases;
    private DefaultComboBoxModel comboAddresses;
    // End of variables declaration//GEN-END:variables
}
