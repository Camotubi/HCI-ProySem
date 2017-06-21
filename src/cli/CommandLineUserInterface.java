package cli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.Highlight;

import gui.gui_observation;

public class CommandLineUserInterface extends JFrame  {
	public static final char saveTrigger ='w';
	public static final char insertModeTrigger ='i';
	public static final char visualModeTrigger ='v';
	public static final char commandModeTrigger =':';
	public static final String visualLineModeTrigger ="SHIFT V";
	public static final String mainModeTrigger ="ESC";
	public static final String cutTrigger ="x";
	public static final String copyTrigger ="y";
	public static final String pasteTrigger ="p";
	public static final String commentTrigger ="m";
	public static final String tabTrigger ="p";
	public static final char undoTrigger ='u';
	public static final char redoTrigger ='r';
	DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY);
	
	
	
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	public static final String  MODE_MAIN ="Main";
	private static final String MODE_INSERT = "Insert";
	private static final String MODE_COMMAND = "Command";
	private static final String MODE_VISUAL= "Visual";
	private static final String MODE_VISUAL_LINE="Visual Line";
	
	private String clipboard;
	private ActionListener modeChangeListener;
	private boolean requestingModeChange;
	private String modeToChange;
	private JPanel mainView;
	private JPanel workingPanel;
	private JLabel commandLabel;
	private String mode;
	private JTextArea textArea;
	private JPanel commandPanel;
	private JTextField commandTextField;
	private DocumentListener docListener;
	private CaretListener caretListener;
	private int selectionBegin;
	private int selectionEnd;
	private int lineSelectionBegin;
	private int lineSelectionEnd;
	private JScrollPane scrollPane;
	private Stack<Cli_observation> obs;
	private long initialT;
	private long finalT;
	public CommandLineUserInterface()  {
	
		obs=new Stack<Cli_observation>();
		obs.push(new Cli_observation(1,JOptionPane.showInputDialog("Ingresa tu nombre porfa",null)));
		mode = MODE_MAIN;
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
		
		commandPanel = new JPanel();
		workingPanel.add(commandPanel, BorderLayout.SOUTH);
		commandPanel.setLayout(new BorderLayout(0, 0));
		
		commandLabel = new JLabel(mode);
		commandPanel.add(commandLabel, BorderLayout.WEST);
		
		commandTextField = new JTextField();
		commandPanel.add(commandTextField, BorderLayout.CENTER);
		commandTextField.setColumns(10);
		
		
		setTextArea(new JTextArea());
		textArea.setFocusable(false);
		//workingPanel.add(getTextArea(), BorderLayout.CENTER);
		textArea.getDocument().addDocumentListener(docListener);
		textArea.addCaretListener(new caretListener());
		
		scrollPane = new JScrollPane(textArea);
		workingPanel.add(scrollPane, BorderLayout.CENTER);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //updateGUI();
        
        Action checkCommand = new AbstractAction()
    	{
        	
    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	
    	        if(commandTextField.getText().trim().equals("start"))
    	        {
    	        	initialT=System.currentTimeMillis();
    	        	obs.push(new Cli_observation(((int)obs.peek().getId()+1),obs.peek().getNamePersona()));
    	        }
    	        if(commandTextField.getText().trim().equals("end"))
    	        {
    	        	finalT=System.currentTimeMillis()-initialT;
    	        	textArea.setText("");
    	        	obs.peek().setCompletionTime(finalT);
    	        	System.out.println(finalT);
    	        }
    	        if(commandTextField.getText().trim().equals("exit"))
    	        {
    	        	System.out.println("exit  copiado");
    	        }
    	    commandTextField.setText("");
    	    new requestChangeModeAction(MODE_MAIN).actionPerformed(e);
    	    }
    	};
    	commandTextField.addActionListener(checkCommand);
	// Key mapping
    mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("ESCAPE"),MODE_MAIN);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("I"),MODE_INSERT);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"),MODE_COMMAND);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("V"),MODE_VISUAL);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("L"),MODE_VISUAL_LINE);
	
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("X"),cutTrigger);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("P"),pasteTrigger);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("Y"),copyTrigger);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("M"),commentTrigger);
	mainView.getInputMap(IFW).put(KeyStroke.getKeyStroke("TAB"),tabTrigger);
	
	
	
	mainView.getActionMap().put(MODE_MAIN, new requestChangeModeAction(MODE_MAIN));	
	mainView.getActionMap().put(MODE_INSERT, new requestChangeModeAction(MODE_INSERT));	
	mainView.getActionMap().put(MODE_COMMAND, new requestChangeModeAction(MODE_COMMAND));	
	mainView.getActionMap().put(MODE_VISUAL, new requestChangeModeAction(MODE_VISUAL));	
	mainView.getActionMap().put(MODE_VISUAL_LINE, new requestChangeModeAction(MODE_VISUAL_LINE));	
	
	mainView.getActionMap().put(cutTrigger, new cut());	
	mainView.getActionMap().put(pasteTrigger, new paste());	
	mainView.getActionMap().put(copyTrigger, new copy());	

	updateGUI();
	setMinimumSize(new Dimension(400, 400));
	}

	

	  

	

	private class requestChangeModeAction extends AbstractAction
	{ 
		private String modeToChange;
		requestChangeModeAction(String mode)
		{
			modeToChange = mode;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			setModeToChange(modeToChange);
			modeChangeListener.actionPerformed(e);
			
				
		}
	}

	public String getModeToChange() {
		return modeToChange;
	}
	public void setModeToChange(String modeToChange) {
		this.modeToChange = modeToChange;
	}
	public boolean isRequestingModeChange() {
		return requestingModeChange;
	}
	public void setRequestingModeChange(boolean requestingModeChange) {
		this.requestingModeChange = requestingModeChange;
	}
	public void setCommandLabelText(String text)
	{
		commandLabel.setText(text);
	}
	public ActionListener getModeChangeListener() {
		return modeChangeListener;
	}
	public void setModeChangeListener(ActionListener modeChangeListener) {
		this.modeChangeListener = modeChangeListener;
	}
	
	
	
	public void setMode(String mode)
	{
		this.mode = mode;
		
		if(mode.equals(MODE_VISUAL_LINE))
		{
			
			obs.peek().incrementNVisualLineMode();
			try {
				lineSelectionBegin = textArea.getLineOfOffset(textArea.getCaretPosition());
				lineSelectionEnd = lineSelectionBegin ;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(mode.equals(MODE_VISUAL))
		{
			obs.peek().incrementNVisualMode();
			selectionBegin = textArea.getCaretPosition();
			selectionEnd = selectionBegin;
		}
		if(mode.equals(MODE_MAIN))
		{
			obs.peek().incrementNMainMode();

		}
		if(mode.equals(MODE_INSERT))
		{
			obs.peek().incrementNInsertMode();

		}
		updateGUI();
	}
	public void updateGUI()
	{
		commandLabel.setText(mode);
		
		switch(mode)
		{
		case MODE_MAIN:
			
			getTextArea().getHighlighter().removeAllHighlights();
			//textArea.requestFocus();
			textArea.setEditable(false);
			commandTextField.setEditable(false);
			commandTextField.setEnabled(false);
			break;
		case MODE_COMMAND:
			commandTextField.setEnabled(true);
			commandTextField.setEditable(true);
			commandTextField.requestFocus();
			textArea.setEditable(false);
			break;
		case MODE_INSERT:
			getTextArea().getHighlighter().removeAllHighlights();
			textArea.setFocusable(true);
			textArea.setEditable(true);
			textArea.requestFocus();
			textArea.getCaret().setVisible(true);
			break;
		case MODE_VISUAL:
			try {
				getTextArea().getHighlighter().addHighlight(selectionBegin,selectionEnd,highlightPainter) ;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textArea.setEditable(false);
			
			
			break;
		case MODE_VISUAL_LINE:
			try {
				getTextArea().getHighlighter().addHighlight(textArea.getLineStartOffset(lineSelectionBegin),textArea.getLineEndOffset(lineSelectionEnd),highlightPainter) ;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textArea.setEditable(false);
			//textArea.getCaret().setVisible(true);
			
			break;
		}
	}
	
	

	
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public DocumentListener getDocListener() {
		return docListener;
	}
	public void setDocListener(DocumentListener docListener) {
		this.docListener = docListener;
		textArea.getDocument().addDocumentListener(docListener);
	}
	public void setCaretListener(CaretListener caretListener)
	{
		this.caretListener=caretListener;
		textArea.addCaretListener(this.caretListener);
	}
	
	public class cut extends AbstractAction
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Highlight higlights[] = getTextArea().getHighlighter().getHighlights();
			if(higlights.length>0)
			{
				int begining= higlights[0].getStartOffset();
				int end= higlights[0].getEndOffset();
			
				try {
					clipboard=getTextArea().getDocument().getText(begining, end-begining);
					getTextArea().getDocument().remove(begining, end-begining);
					new requestChangeModeAction(MODE_MAIN).actionPerformed(e);;
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			obs.peek().incrementNCut();

			
		}
	
		
	}
	
	
	public class paste extends AbstractAction
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(mode.equals(MODE_MAIN))
			{
				try {
					getTextArea().getDocument().insertString(getTextArea().getCaretPosition(), clipboard, null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
			
		}
	
		
	}
	
	
	public class copy extends AbstractAction
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {

			if(mode.equals(MODE_MAIN))
			{
				Highlight higlights[] = getTextArea().getHighlighter().getHighlights();
				if(higlights.length>0)
				{
					int begining= higlights[0].getStartOffset();
					int end= higlights[0].getEndOffset();
					
					try {
						clipboard=getTextArea().getDocument().getText(begining, end-begining-1);
						new requestChangeModeAction(MODE_MAIN).actionPerformed(e);;
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	
		
	}
	
	
	public void yank()
	{
		
	}
	public void paste()
	{
		
	}
	
	public String getClipboard() {
		return clipboard;
	}
	public void setClipboard(String clipboard) {
		this.clipboard = clipboard;
	}







	class caretListener implements CaretListener
	{

		@Override
		public void caretUpdate(CaretEvent e) {
	
			
			if(mode.equals(MODE_VISUAL))
			{
				updateGUI();
				selectionEnd = getTextArea().getCaretPosition();
				try {
					getTextArea().getHighlighter().removeAllHighlights();
					if(selectionBegin>selectionEnd)
					{
						getTextArea().getHighlighter().addHighlight(selectionEnd,selectionBegin,highlightPainter) ;
						System.out.println(selectionBegin+""+selectionEnd);
					}
					else
					{
						getTextArea().getHighlighter().addHighlight(selectionBegin,selectionEnd,highlightPainter) ;
					}
					
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
			}
			else
			{
				if(mode.equals(MODE_VISUAL_LINE))
				{
					
					
					try {
						lineSelectionEnd = textArea.getLineOfOffset(textArea.getCaretPosition());
					} catch (BadLocationException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						getTextArea().getHighlighter().removeAllHighlights();
						if(lineSelectionBegin>lineSelectionEnd)
						{
							lineSelectionEnd= textArea.getLineOfOffset(textArea.getCaretPosition());
							getTextArea().getHighlighter().addHighlight(textArea.getLineStartOffset(lineSelectionEnd),textArea.getLineEndOffset(lineSelectionBegin),highlightPainter) ;
						}
						else
						{
							getTextArea().getHighlighter().addHighlight(textArea.getLineStartOffset(lineSelectionBegin),textArea.getLineEndOffset(lineSelectionEnd),highlightPainter) ;
						}
						
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					getTextArea().getHighlighter().removeAllHighlights();
					
				}
			}
			
			
		}
		
	}

	
}


