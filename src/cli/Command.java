package cli;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Command extends JFrame {
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MODE_INSERT = "insert";
	private static final String MODE_COMMAND = "command";
	private static final String MODE_VISUAL= "visual";
	private static final String MODE_VISUAL_LINE="visual line";
	
	private JPanel mainView;
	private JLabel lblNewLabel;
	private JPanel intructionPanel;
	private JPanel workingPanel;
	private JLabel commandLabel;
	private String workingAreaTxt;
	private String mode;
	private JEditorPane textArea;
	private JPanel commandPanel;
	private JTextField commandTextField;
	public Command() {
		mode = MODE_COMMAND;
		workingAreaTxt= new String();
		mainView= new JPanel();
		setContentPane(mainView);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		mainView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		workingPanel = new JPanel();
		panel.add(workingPanel, BorderLayout.CENTER);
		workingPanel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JEditorPane();
		workingPanel.add(textArea, BorderLayout.CENTER);
		
		commandPanel = new JPanel();
		workingPanel.add(commandPanel, BorderLayout.SOUTH);
		commandPanel.setLayout(new BorderLayout(0, 0));
		
		commandLabel = new JLabel(mode);
		commandPanel.add(commandLabel, BorderLayout.WEST);
		
		commandTextField = new JTextField();
		commandPanel.add(commandTextField, BorderLayout.CENTER);
		commandTextField.setColumns(10);
		intructionPanel =new JPanel();
		panel.add(intructionPanel, BorderLayout.NORTH);
		
		intructionPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Instruccion");
		intructionPanel.add(lblNewLabel);
        
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	// Key mapping
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("I"),MODE_INSERT);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("ESCAPE"),MODE_COMMAND);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("V"),MODE_VISUAL);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.SHIFT_DOWN_MASK),MODE_VISUAL_LINE);
	
	mainView.getActionMap().put(MODE_INSERT, new ChangeModeAction(MODE_INSERT));	
	mainView.getActionMap().put(MODE_COMMAND, new ChangeModeAction(MODE_COMMAND));	
	mainView.getActionMap().put(MODE_VISUAL, new ChangeModeAction(MODE_VISUAL));	
	mainView.getActionMap().put(MODE_VISUAL_LINE, new ChangeModeAction(MODE_VISUAL_LINE));	
	}

	
	public void setMode(String mode)
	{
		this.mode = mode;
		commandLabel.setText(mode);
		switch(this.mode)
		{
			case MODE_INSERT: 
				textArea.setEditable(true);
				textArea.requestFocusInWindow();
				mainView.getActionMap().get(MODE_COMMAND).setEnabled(false);
				mainView.getActionMap().get(MODE_VISUAL_LINE).setEnabled(false);
				mainView.getActionMap().get(MODE_VISUAL).setEnabled(false);
				break;
			case MODE_COMMAND:
				textArea.setEditable(false); 
				commandTextField.requestFocusInWindow();
				break;
			case MODE_VISUAL: break;
			case MODE_VISUAL_LINE: break;
		}
	}
	  

	

	private class ChangeModeAction extends AbstractAction
	{ 
		private String modeToChange;
		ChangeModeAction(String mode)
		{
			modeToChange = mode;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			setMode(modeToChange);
		}
	}
	public static void main(String args[])
	{
		Command c = new  Command();
	}
}
