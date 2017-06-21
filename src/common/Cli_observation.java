package common;

public class Cli_observation extends Observation {


	//Methods implementation
	private int nInsertMode;
	private int nVisualMode;
	private int nVisualLineMode;
	private int nMainMode;
	private int nNewLine;
	public Cli_observation(int id,String name) {
		super(id,name);

	}
	@Override
	public void print(){
		super.print();
		System.out.println(
				"nInsertMode:"+nInsertMode+"\n"+
						"nVisualMode:"+nVisualMode+"\n"+
						"nVisualLineMode:"+nVisualLineMode+"\n"+
						"nMainMode:"+nMainMode
				);
	}
	
	public void incrementNNewLine()
	{
		print();
		nNewLine++;
	}
	public void incrementNInsertMode()
	{
		print();
		nInsertMode++;
	}
	public void incrementNMainMode()
	
	{
		print();
		nMainMode++;
	}
	public void incrementNVisualLineMode()
	{
		print();
		nVisualLineMode++;
	}
	public void incrementNVisualMode()
	{
		print();
		nVisualMode++;
	}
	public int getnNewLine() {
		return nNewLine;
	}
	public void setnNewLine(int nNewLine) {
		this.nNewLine = nNewLine;
	}

}
