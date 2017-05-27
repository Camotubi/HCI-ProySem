import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
static int userOption;
	public static void main(String[] args) throws Exception{

				
		
	userOption =Integer.parseInt(JOptionPane.showInputDialog(null, "1. Graphical User Interface (GUI)\n"
				+ "2. Command Line Interface (CLI)\n"));
	
	System.out.println(userOption); //test
	
	}
	

	public void GUI(){
		guiTest GUI = new guiTest();
	}
	
	public void CLI(){
		cliTest CLI = new cliTest();
	}
}
