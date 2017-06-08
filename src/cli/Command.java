package cli;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Command extends JFrame{
	JPanel mainview;
	JTextArea txtArea;
	JLabel label1;
	
	public Command() {

		mainview= new JPanel();
		setContentPane(mainview);
		setVisible(true);
		mainview.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainview.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 84, 414, 166);
		mainview.add(textArea);
		
		JLabel Label1 = new JLabel("Aqui va la wea de instruccion");
		Label1.setBounds(10, 11, 414, 52);
		mainview.add(Label1);
		
		
		
	}
}
