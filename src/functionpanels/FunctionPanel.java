package functionpanels;

import java.util.ArrayList;

import javax.swing.JPanel;

import data.Instruction;
import data.Phase;

public abstract class FunctionPanel extends JPanel {

	protected String[] possibleFunction; 
	protected Phase currentphase;
	protected ArrayList<Instruction> instructions;
	
	public FunctionPanel(){
		instructions = new ArrayList<Instruction>();
		currentphase = new Phase();

		initComponents();

		setPossibleFunctions();
		setInstructions();
	}
	
	public ArrayList<Instruction> getInstructions(){
		return instructions;
	}
	
	public int getNumberInstructions(){
		return instructions.size();
	}
	
	public abstract void setPhase(Phase p);
	public abstract void updatePhase();
	public abstract void setInstructions();
	public abstract void setPossibleFunctions();
	protected abstract void initComponents();
}
