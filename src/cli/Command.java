package cli;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Command extends JFrame implements KeyListener{
	JPanel mainview;
	JLabel lblNewLabel;
	private JPanel intructionPanel;
	private JPanel workingPanel;
	private JLabel lblNewLabel_1;
	private String workingAreaTxt;
	private char mode;
	private String enter = "enter";
	private JTextArea textArea;
	public Command() {
		mode = 'c';
		workingAreaTxt= new String();
		mainview= new JPanel();
		setContentPane(mainview);
		setVisible(true);
		mainview.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainview.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		mainview.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		workingPanel = new JPanel();
		panel.add(workingPanel, BorderLayout.CENTER);
		workingPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel(":");
		workingPanel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		workingPanel.add(textArea, BorderLayout.CENTER);
		intructionPanel =new JPanel();
		panel.add(intructionPanel, BorderLayout.NORTH);
		
		intructionPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Instruccion");
		intructionPanel.add(lblNewLabel);
        
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
		
	
	}
	
	
	  

	
    public void keyPressed(KeyEvent e) {
    	if(mode =='c')
    	{
    		switch(e.getKeyChar())
    		{
    		case 'i':
    			textArea.setEditable(true);
    			mode ='i';
    			System.out.println("mode:"+mode);
    		break;
    		}
    		
    	}
    	if(mode=='i')
    	{
    		switch(e.getKeyCode())
    		{
    		case KeyEvent.VK_ESCAPE:
    			requestFocus();
    			textArea.setEditable(false);
    			mode ='c';
    			System.out.println("mode:"+mode);
    			break;
    		}
    	}
        System.out.println(e.getKeyChar());
        workingAreaTxt+=e.getKeyChar();
        //lblTxt.setText(workingAreaTxt);
    }
    
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		Command c = new  Command();
	}
}
