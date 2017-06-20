package gui;
import cli.Observation;

public class gui_observation extends Observation{

	private int nclick;	// number of left clicks



	
	//Methods Implementation
	public gui_observation(int id, String name) {
		super(id,name);

	}



	public void incrementClicks() {
		setNclick(getNclick() + 1);
		
	}



	public int getNclick() {
		return nclick;
	}



	public void setNclick(int nclick) {
		this.nclick = nclick;
	}
}
