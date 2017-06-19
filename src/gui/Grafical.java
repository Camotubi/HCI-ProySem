package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafical extends JFrame {
	JPanel mainView;
	JTextArea txtArea;
	JButton btnNext;

	private gui_observation obs;
	private JPanel intructionPanel;
	private JPanel workingPanel;
	private JLabel lblNewLabel;
	private JButton btnSave;
	private JButton btnPaste;
	private JPanel panel_buttons;
	private JButton btnCopy;
	private JButton btnCut;
	private JButton btnTabR;
	private JButton btnTabL;
	private JButton btnComment;
	private JButton btnNewButton_7;
	private String clipboard="";
	public Grafical() throws IOException
	{
		mainView= new JPanel();
		setContentPane(mainView);
		setVisible(true);
		//mainView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		mainView.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		workingPanel = new JPanel();
		panel.add(workingPanel, BorderLayout.CENTER);
		workingPanel.setLayout(new BorderLayout(0, 0));
		txtArea = new JTextArea();
		
		workingPanel.add(txtArea, BorderLayout.CENTER);
		
		panel_buttons = new JPanel();
		workingPanel.add(panel_buttons, BorderLayout.NORTH);
		Image imgSave = ImageIO.read(getClass().getResource("save.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgPaste = ImageIO.read(getClass().getResource("paste.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgCopy = ImageIO.read(getClass().getResource("copy.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgCut = ImageIO.read(getClass().getResource("cut.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgTabR = ImageIO.read(getClass().getResource("tabR.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgTabL = ImageIO.read(getClass().getResource("tabL.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		Image imgComment = ImageIO.read(getClass().getResource("comment.png")).getScaledInstance( 15,15,  java.awt.Image.SCALE_SMOOTH) ;
		
		btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_buttons.add(btnSave);
		 
		btnSave.setIcon(new ImageIcon(imgSave));
		
		btnPaste = new JButton("");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtArea.getDocument().insertString(txtArea.getCaretPosition(), clipboard,null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel_buttons.add(btnPaste);
		btnPaste.setIcon(new ImageIcon(imgPaste));
		
		btnCopy = new JButton("");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtArea.getSelectedText()!=null)
				{
					try {
						
						clipboard=txtArea.getDocument().getText(txtArea.getSelectionStart(), txtArea.getSelectionEnd()-txtArea.getSelectionStart());
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_buttons.add(btnCopy);
		btnCopy.setIcon(new ImageIcon(imgCopy));
		
		btnCut = new JButton("");
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtArea.getSelectedText()!=null)
				{
					try {
						
						clipboard=txtArea.getDocument().getText(txtArea.getSelectionStart(), txtArea.getSelectionEnd()-txtArea.getSelectionStart());
						txtArea.getDocument().remove(txtArea.getSelectionStart(), txtArea.getSelectionEnd()-txtArea.getSelectionStart());
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_buttons.add(btnCut);
		btnCut.setIcon(new ImageIcon(imgCut));
		
		btnTabR = new JButton("");
		btnTabR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(txtArea.getSelectedText()!=null)
				//{
					try {
						txtArea.getDocument().insertString(txtArea.getCaretPosition(), "\t",null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				//}
			}
		});
		panel_buttons.add(btnTabR);
		btnTabR.setIcon(new ImageIcon(imgTabR));
		
		btnTabL = new JButton("");
		btnTabL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(txtArea.getDocument().getText(txtArea.getCaretPosition()-1,1));
					if(txtArea.getDocument().getText(txtArea.getCaretPosition()-1,1)=="\t")
					{
						System.out.println(txtArea.getDocument().getText(txtArea.getCaretPosition()-2,2));
						txtArea.getDocument().remove(txtArea.getCaretPosition()-2,2);
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel_buttons.add(btnTabL);
		btnTabL.setIcon(new ImageIcon(imgTabL));
		
		btnComment = new JButton("");
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtArea.getSelectedText()!=null)
				{
					try {
						txtArea.getDocument().insertString(txtArea.getSelectionStart(), "/*", null);
						txtArea.getDocument().insertString(txtArea.getSelectionEnd(), "*/", null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						txtArea.getDocument().insertString(txtArea.getCaretPosition(), "//", null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_buttons.add(btnComment);
		btnComment.setIcon(new ImageIcon(imgComment));
		
		btnNewButton_7 = new JButton("");
		panel_buttons.add(btnNewButton_7);
		intructionPanel = new JPanel();
		panel.add(intructionPanel, BorderLayout.NORTH);
		intructionPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("New label");
		intructionPanel.add(lblNewLabel);
		btnNext = new JButton("Siguiente");
		panel.add(btnNext, BorderLayout.SOUTH);
		
		//pack();
		setMinimumSize(new Dimension(400, 400));
		
	}
	public static void main(String args[]) throws IOException
	{
		Grafical gra = new Grafical();

	}
}
