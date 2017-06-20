package gui;
import cli.Observation;

public class gui_observation extends Observation{

	private int nlclick;	// number of left clicks
	private int nrclick;	// numbe of right clicks
	private double timeMouseMove;	// time in seconds(s) of mouse movement
	private int ncut;
	private int ncopy;
	private int npaste;
	private int ntab;
	private int ncomments;

	
	//Methods Implementation
	public gui_observation(int id) {
		super(id);
	}
}
