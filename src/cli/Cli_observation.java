package cli;
public class Cli_observation extends Observation {


	//Methods implementation
	private int nInsertMode;
	private int nVisualMode;
	private int nVisualLineMode;
	private int nMainMode;
	public Cli_observation(int id,String name) {
		super(id,name);

	}
	@Override
	public void print(){
		super.print();
		System.out.println(
				nInsertMode+"\n"+
						nVisualMode+"\n"+
						nVisualLineMode+"\n"+
						nMainMode
				);
	}
	
	public void incrementNInsertMode()
	{
		nInsertMode++;
	}
	public void incrementNMainMode()
	{
		nMainMode++;
	}
	public void incrementNVisualLineMode()
	{
		nVisualLineMode++;
	}
	public void incrementNVisualMode()
	{
		nVisualMode++;
	}

}
