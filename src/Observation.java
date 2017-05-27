
public class Observation {
	private int id;
	/*members related to our study*/
	private double completionTime;	//time in seconds (s)  to complete the test
	private int nkeystrokes;	//number of total keystrokes
	private int userSatisfaction;	//
	private int persivedDificulty;	// 
	/*private int[] keystrokes;	//number of total keystrokes per key*/
	private double wordpm;		//words per minute
	

	//Methods implementation
	
	public Observation(int id)
	{
		this.id = id;
	}



	
}
