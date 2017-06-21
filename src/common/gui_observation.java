package common;

public class gui_observation extends Observation{

	private int nclick;	// number of left clicks



	
	//Methods Implementation
	public gui_observation(int id, String name) {
		super(id,name);

	}

	@Override
	public String generateReport()
	{
		return (super.generateReport()+"\nnClick:"+nclick);
	}

	public void incrementClicks() {
		setNclick(getNclick() + 1);
		print();
		
	}



	public int getNclick() {
		return nclick;
		
	}



	public void setNclick(int nclick) {
		this.nclick = nclick;
		print();
	}
	
	@Override
	public void print()
	{
		super.print();
		System.out.println("nclick:" +nclick);
	}
}
