package cli;
import java.util.Stack;

public class WorkingText
{ 
	private Stack<String> state;
	

	public WorkingText()
	{
		state= new Stack<String>();
		state.push("");
	}

	private String peek()
	{
		return state.peek();
	}

	private void push(String lastState)
	{
		state.push(lastState);
	}

	private String pop()
	{
		return state.pop();
	}

	public void updateSelection() {
		// TODO Auto-generated method stub
		
	}
	
}
