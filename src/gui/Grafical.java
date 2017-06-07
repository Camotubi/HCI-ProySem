package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class Grafical extends JFrame {
	JPanel mainView;
	JTextArea txtArea;
	JButton btnNext;
	private JPanel intructionPanel;
	private JPanel workingPanel;
	private JLabel lblNewLabel;
	public Grafical()
	{
		mainView= new JPanel();
		setContentPane(mainView);
		setVisible(true);
		mainView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		mainView.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		workingPanel = new JPanel();
		panel.add(workingPanel);
		workingPanel.setLayout(null);
		txtArea = new JTextArea();
		txtArea.setBounds(12, 5, 292, 184);
		workingPanel.add(txtArea);
		btnNext = new JButton("Siguiente");
		btnNext.setBounds(21, 5, 77, 23);
		workingPanel.add(btnNext);
		
		intructionPanel = new JPanel();
		panel.add(intructionPanel);
		intructionPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("New label");
		intructionPanel.add(lblNewLabel);
		
		pack();
		
	}
	public static void main(String args[])
	{
		Grafical gra = new Grafical();

	}
}
