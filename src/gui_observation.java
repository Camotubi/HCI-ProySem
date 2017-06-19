import cli.Observation;

public class gui_observation extends Observation{

	private int nlclick;	// number of left clicks
	private int nrclick;	// numbe of right clicks
	private double timeMouseMove;	// time in seconds(s) of mouse movement
	
	
	//Methods Implementation
	public gui_observation(int id) {
		super(id);
	}
}
