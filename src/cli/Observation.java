package cli;

public class Observation {
	private int id;
	/*members related to our study*/
	private String namePersona;
	private long completionTime;	//time in seconds (s)  to complete the test
	private int nkeystrokes;	//number of total keystrokes
	private int userSatisfaction;	//
	private int persivedDificulty;
	private int timesCopy;
	private int timesPaste;
	private int timesCut;
	private int ncomments;
	private int ntabs;
	// 
	/*private int[] keystrokes;	//number of total keystrokes per key*/
	//private double wordpm;		//words per minute
	

	//Methods implementation
	
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


	public int getTimesCopy() {
		return timesCopy;
	}


	public void setTimesCopy(int timesCopy) {
		this.timesCopy = timesCopy;
	}


	public int getTimesPaste() {
		return timesPaste;
	}


	public void setTimesPaste(int timesPaste) {
		this.timesPaste = timesPaste;
	}


	public int getTimesCut() {
		return timesCut;
	}


	public void setTimesCut(int timesCut) {
		this.timesCut = timesCut;
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

	
	
	public void incrementnkeystrokes()
	{
		nkeystrokes++;
	}
	public void incrementTimesCopy()
	{
		timesCopy++;
	}
	public void incrementTimesPaste()
	{
		timesPaste++;
	}
	public void incrementTimesCut()
	{
		timesCut++;
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
