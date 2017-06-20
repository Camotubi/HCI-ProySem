package cli;

import java.util.*;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CliController
{
	private WorkingText modelText;
	private CliModel cliModel;
	private ArrayList<Observation> obsModel;
	private CommandLineUserInterface view;

	public CliController(WorkingText modelText,CliModel cliModel ,ArrayList<Observation> obsModel, CommandLineUserInterface view)
	{
		this.modelText = modelText;
		this.view = view;
		this.obsModel=obsModel;
		this.cliModel = cliModel;
	}


	public CliController()
	{
		this.modelText = new WorkingText();
		this.view = new CommandLineUserInterface();
		this.obsModel= new ArrayList<Observation>();
		this.cliModel = new CliModel();
		view.setModeChangeListener(new RequestChangeModeListener());
		view.setDocListener(new docListener());
	}
	
	
	
	
	class docListener implements DocumentListener
	{
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			cliModel.updateWorkingText(view.getTextArea().getText());

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
	
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
		
	}
	class RequestChangeModeListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			if(cliModel.changeMode(view.getModeToChange()))
			{
				view.setMode(cliModel.getMode());
				
			}
		}
		
		
	}

}

