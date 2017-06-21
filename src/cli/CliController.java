package cli;

import java.util.*;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import common.Observation;

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

