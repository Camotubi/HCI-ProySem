package cli;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Command extends JFrame{
	JPanel mainview;
	JTextArea txtArea;
	JLabel lblNewLabel;
	private JPanel intructionPanel;
	private JPanel workingPanel;
	private JLabel lblNewLabel_1;
	
	public Command() {

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
		txtArea = new JTextArea();
		
		workingPanel.add(txtArea, BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel(":");
		workingPanel.add(lblNewLabel_1, BorderLayout.SOUTH);
		intructionPanel =new JPanel();
		panel.add(intructionPanel, BorderLayout.NORTH);
		
		intructionPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Instruccion");
		intructionPanel.add(lblNewLabel);
		
		
	}
}
