package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import cli.CliController;
import common.Cli_observation;
import common.gui_observation;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Grafical extends JFrame {
	JPanel mainView;
	JTextArea txtArea;
	JButton btnNext;
	private Stack<gui_observation> obs;


	private JPanel workingPanel;
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
	private JScrollPane scrollPane;
	public Grafical() throws IOException
	{
		obs=new Stack<gui_observation>();
		obs.push(new gui_observation(1,JOptionPane.showInputDialog("Ingresa tu nombre porfa",null)));
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
		txtArea = new JTextArea(){ 
			
			@Override
			public
			void copy()
			{
				
			}
			@Override
			public
			void cut()
			{
				
			}
			@Override
			public
			void paste()
			{
				
			}
		};
		scrollPane = new JScrollPane(txtArea );
		workingPanel.add(scrollPane, BorderLayout.CENTER);
		

		
		txtArea.getDocument().addDocumentListener(new MyDocumentListener());
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
				obs.peek().incrementClicks();
			}
		});
		panel_buttons.add(btnSave);
		 
		btnSave.setIcon(new ImageIcon(imgSave));
		
		btnPaste = new JButton("");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obs.peek().incrementClicks();
				obs.peek().incrementNPaste();
				try {
					txtArea.getDocument().insertString(txtArea.getCaretPosition(), clipboard,null);
				} catch (BadLocationException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		panel_buttons.add(btnPaste);
		btnPaste.setIcon(new ImageIcon(imgPaste));
		
		btnCopy = new JButton("");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obs.peek().incrementClicks();
				obs.peek().incrementNCopy();
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
				obs.peek().incrementClicks();
				obs.peek().incrementNCut();
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
				obs.peek().incrementClicks();
				obs.peek().incrementNtabs();
				if(txtArea.getSelectedText()==null)
				{
					try {
						txtArea.getDocument().insertString(txtArea.getCaretPosition(), "\t",null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					 try {
						int start =txtArea.getLineOfOffset(txtArea.getSelectionStart());
						
						int end =txtArea.getLineOfOffset(txtArea.getSelectionEnd());
						txtArea.getDocument().insertString(txtArea.getSelectionStart(), "\t",null);
						if(start<end)
						{
						
							for(int i=start+1;i<=end;i++)
							{
								txtArea.getDocument().insertString(txtArea.getLineStartOffset(i), "\t",null);
							}
						}
						
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_buttons.add(btnTabR);
		btnTabR.setIcon(new ImageIcon(imgTabR));
		
		btnTabL = new JButton("");
		btnTabL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obs.peek().incrementClicks();
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
				obs.peek().incrementClicks();
				obs.peek().incrementNcomments();
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
		btnNext = new JButton("Siguiente");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obs.push(new gui_observation(((int)obs.peek().getId()+1),obs.peek().getNamePersona()));
			}
		});
		panel.add(btnNext, BorderLayout.SOUTH);
		
		//pack();
		setMinimumSize(new Dimension(400, 400));
		
		
	}
	
	class MyDocumentListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			//System.out.println("we");
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			obs.peek().setNkeystrokes(obs.peek().getNkeystrokes()+1);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			obs.peek().setNkeystrokes(obs.peek().getNkeystrokes()+1);
			
		}
	 
	 
	
	}
	
	
	

	
	
	public static void main(String args[]) throws IOException
	{
		
		 SwingUtilities.invokeLater(new Runnable() {
			 
		 	 
				
		 	   @Override
		
		 	   public void run() {
		 
		 		  try {
					Grafical gra = new Grafical();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		 	   }
		
		 	  });
	
		 	 
	

}
		
	

	
}

