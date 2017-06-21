package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	System.out.println(generateReport());
	
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
		print();
	}
	public void incrementNCopy()
	{
		nCopy++;
		print();
	}
	public void incrementNPaste()
	{
		nPaste++;
		print();
	}
	public void incrementNCut()
	{
		nCut++;
		print();
	}
	public void incrementNcomments()
	{
		ncomments++;
		print();
	}

	public void incrementNtabs()
	{
		ntabs++;
		print();
	}
	public int getNtabs() {
		return ntabs;
	}


	public void setNtabs(int ntabs) {
		this.ntabs = ntabs;
	}
	public String generateReport()
	{
		String datos =(	"Datos de Observacion\n\n"+
				"ID: "+id+"\n"+
				"Nombre: "+namePersona+"\n"+
				"Tiempo Realizado: "+completionTime+"\n"+
				"# de Teclas Presionadas: "+nkeystrokes+"\n"+
				"Sactifacion del Usuario: "+userSatisfaction+"\n"+
				"Dificultad Percibida: "+persivedDificulty+"\n"+
				"# de Copiar: "+nCopy+"\n"+
				"# de Cortar: "+nCut+"\n"+
				"# de Pegar: "+nPaste+"\n"+
				"# de Comentarios: "+ncomments+"\n"+
				"# de Tabs: "+ntabs
				);
		return datos;
	}
	public void save (String filename){
		//Para la fecha
	

		//String con los datos
		try{
		File f = new File(filename+id+System.currentTimeMillis()+".txt");

		FileWriter fw = new FileWriter(f);

		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(generateReport());        // Writing to the file

		bw.close();                       // Close the BufferedWriter

		fw.close();                       // Close the FileWriter
		}
		catch(Exception e)
		{
			
		}
		
	}
	

	
}
