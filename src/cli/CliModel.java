package cli;

public class CliModel
{
	public static final String  mainMode="Main";
	public static final String  commandMode="Command";
	public static final String  insertMode="Insert";
	public static final String  visualMode="Visual";
	public static final String  visualLineMode="Visual Line";
	
	public static final char saveTrigger ='w';
	public static final char insertModeTrigger ='i';
	public static final char visualModeTrigger ='v';
	public static final char commandModeTrigger =':';
	public static final String visualLineModeTrigger ="SHIFT V";
	public static final String mainModeTrigger ="ESC";
	public static final char cutTrigger ='x';
	public static final char copyTrigger ='y';
	public static final char pasteTrigger ='p';
	public static final char undoTrigger ='u';
	public static final char redoTrigger ='r';
	private int selectedBegin;
	private int selectedEnd;
	private String workingText;
	private String mode;
	private String clipboard;
	private String highlightedText;
	private boolean changesSaved;
	public CliModel()
	{
		setMode(mainMode);
		clipboard = new String();
		highlightedText = new String();
		changesSaved = true;
		workingText="";
	}

	public boolean changeMode(String mode)
	{
		
		switch(mode)
		{
			case mainMode:
				this.setMode(mainMode);
				return true;
			case commandMode:

				if(this.mode.equals(mainMode))
				{
					this.setMode(commandMode);	
					return true;
				}
				break;
			case insertMode:
				if(this.mode.equals(mainMode))
				{	
					this.setMode(insertMode);
					return true;
				}
				break;
			case visualMode:
				if(this.mode.equals(mainMode) || this.mode.equals(visualLineMode))
				{
					
					this.setMode(visualMode);
					setSelectedBegin(1);
				return true;
				}	
				break;	
			case visualLineMode:
				
				if(this.mode.equals(mainMode) || this.mode.equals(visualMode))
				{
					this.setMode(visualLineMode);
				return true;
				}
				break;	
			default:return false;
		}
		return false;
	}
	public void updateWorkingText(String text)
	{
		if(this.mode.equals(insertMode))
		{
			workingText=text;
		}
	}
	
	public void setCliboard(String text)
	{
		this.clipboard = text;
	}
	public String getCliboad()
	{
		return clipboard;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getSelectedEnd() {
		return selectedEnd;
	}

	public void setSelectedEnd(int selectedEnd) {
		this.selectedEnd = selectedEnd;
	}

	public int getSelectedBegin() {
		return selectedBegin;
	}

	public void setSelectedBegin(int selectedBegin) {
		this.selectedBegin = selectedBegin;
	}

	public void updateSelection() {
		// TODO Auto-generated method stub
		
	}


}
