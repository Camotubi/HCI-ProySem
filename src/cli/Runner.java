package cli;

import javax.swing.SwingUtilities;

public class Runner {

	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
			 
			 	 
			
			 	   @Override
			
			 	   public void run() {
			 
			 		  CliController c= new CliController();
			 		 System.out.println("Working Directory = " +
			 	              System.getProperty("user.dir"));
			 	   }
			
			 	  });
		
			 	 
		

	}

}
