package calc;

public class State {
	private int value;
	
	public State(){}
	
	public State(int value){
		this.value = value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
