/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import mmcorej.CMMCore;

import org.micromanager.api.MMPlugin;
import org.micromanager.api.ScriptInterface;

import data.Controller;

/**
 *
 * @author Ries
 */
public class PumpItUp implements MMPlugin{
	
	public static String menuName = "PumpItUp";
	public static final String tooltipDescription = "Aladdin pumps controller";
	private JFrame frame;
	private Controller controller;
	
	@Override
	public String getCopyright() {
		return "Joran Deschamps";
	}

	@Override
	public String getDescription() {
		return tooltipDescription;
	}

	@Override
	public String getInfo() {
		return "";
	}

	@Override
	public String getVersion() {
		return "0.0";
	}

	@Override
	public void dispose() {
		if (frame!=null){
			frame.setVisible(false);
			frame.dispose();
			frame = null;
		}
	}

	@Override
	public void setApp(ScriptInterface app) {		
		ScriptInterface app_ = app;
		CMMCore core_ = app.getMMCore();
		controller = new Controller(core_);
	}

	@Override
	public void show() {
		if (frame==null){
			frame = new JFrame();
			frame.add(new MainPanel(controller));
			frame.pack();
			frame.setVisible(true);
		}
		else{
			frame.setVisible(true);
			frame.toFront();
		}
	}
}

