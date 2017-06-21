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
	public String generateReport()
	{
		return new String(super.generateReport()+"\nnInsertMode:"+nInsertMode+"\n"+
				"nVisualMode:"+nVisualMode+"\n"+
				"nVisualLineMode:"+nVisualLineMode+"\n"+
				"nMainMode:"+nMainMode+"\n"+
				"nNewLine:"+nNewLine);
	}

	
	public void incrementNNewLine()
	{
		
		nNewLine++;
		print();
	}
	public void incrementNInsertMode()
	{
		
		nInsertMode++;
		print();
	}
	public void incrementNMainMode()
	
	{
		
		nMainMode++;print();
	}
	public void incrementNVisualLineMode()
	{
		print();
		nVisualLineMode++;
	}
	public void incrementNVisualMode()
	{
		
		nVisualMode++;
		print();
	}
	public int getnNewLine() {
		return nNewLine;
		
	}
	public void setnNewLine(int nNewLine) {
		this.nNewLine = nNewLine;
	}

}
