package cli;

public class Observation {
	private int id;
	/*members related to our study*/
	private String namePersona;
	private long completionTime;	//time in seconds (s)  to complete the test
	private int nkeystrokes;	//number of total keystrokes
	private int userSatisfaction;	//
	private int persivedDificulty;
	private int nCopy;
	private int nPaste;
	private int nCut;
	private int ncomments;
	private int ntabs;
	// 
	/*private int[] keystrokes;	//number of total keystrokes per key*/
	//private double wordpm;		//words per minute
	

	//Methods implementation
	public void print(){
	System.out.println(
			namePersona+"\n"+
			completionTime+"\n"+
			nkeystrokes+"\n"+
			userSatisfaction+"\n"+
			persivedDificulty+"\n"+
			nCopy+"\n"+
			nCut+"\n"+
			nPaste+"\n"+
			ncomments+"\n"+
			ntabs+"\n"
			
			);
	
	}
	public Observation(int id,String name)
	{
		this.setId(id);
		this.namePersona=name;
	}


	public String getNamePersona() {
		return namePersona;
	}


	public void setNamePersona(String namePersona) {
		this.namePersona = namePersona;
	}


	public long getCompletionTime() {
		return completionTime;
	}


	public void setCompletionTime(long completionTime) {
		this.completionTime = completionTime;
	}


	public int getNkeystrokes() {
		return nkeystrokes;
	}


	public void setNkeystrokes(int nkeystrokes) {
		this.nkeystrokes = nkeystrokes;
	}


	public int getUserSatisfaction() {
		return userSatisfaction;
	}


	public void setUserSatisfaction(int userSatisfaction) {
		this.userSatisfaction = userSatisfaction;
	}


	public int getPersivedDificulty() {
		return persivedDificulty;
	}


	public void setPersivedDificulty(int persivedDificulty) {
		this.persivedDificulty = persivedDificulty;
	}


	public int getNCopy() {
		return nCopy;
	}


	public void setNCopy(int nCopy) {
		this.nCopy = nCopy;
	}


	public int getNPaste() {
		return nPaste;
	}


	public void setNPaste(int nPaste) {
		this.nPaste = nPaste;
	}


	public int getTimesCut() {
		return nCut;
	}


	public void setTimesCut(int nCut) {
		this.nCut = nCut;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNcomments() {
		return ncomments;
	}


	public void setNcomments(int ncomments) {
		this.ncomments = ncomments;
	}

	
	
	public void incrementNkeystrokes()
	{
		nkeystrokes++;
	}
	public void incremetNCopy()
	{
		nCopy++;
	}
	public void incrementNPaste()
	{
		nPaste++;
	}
	public void incrementNCut()
	{
		nCut++;
	}
	public void incrementNcomments()
	{
		ncomments++;
	}

	public void incrementNtabs()
	{
		ntabs++;
	}
	public int getNtabs() {
		return ntabs;
	}


	public void setNtabs(int ntabs) {
		this.ntabs = ntabs;
	}
	

	
}
