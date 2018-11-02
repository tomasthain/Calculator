package calc;

import java.util.ArrayList;
import java.util.List;

public class Calcute {
	private int sum;
	private Memento mto;
	
	public Calcute(){
		sum = 0;
		mto = new Memento();
	}
	
	public Calcute(int n){
		sum = n;
		mto = new Memento(n);
	}
	
	public int add(int value){
		sum += value;
		mto.todo(sum);
		return sum;
	}
	
	public int substract(int value){
		sum -= value;
		mto.todo(sum);
		return sum;
	}
	
	public int multiply(int value){
		sum *= value;
		mto.todo(sum);
		return sum;
	}
	
	public int divide(int value){
		sum /= value;
		mto.todo(sum);
		return sum;
	}
	
	public int undo(){
		this.sum = mto.undo();
		return sum;
	}
	
	public int redo(){
		this.sum = mto.redo();
		return sum;
	}
	
	public int getSum(){
		return sum;
	}
	
	private class Memento{
		private List<State> history;
		private State pre;
		
		private Memento(){
			history = new ArrayList<State>();
			history.add(new State(0));
		}
		
		private Memento(int n){
			history = new ArrayList<State>();
			history.add(new State(n));
		}
		
		private void todo(int value){
			history.add(new State(value));
		}
		
		private int undo(){
			if(history.size() > 1){
				pre = history.remove(history.size() -1);
			}
			return history.get(history.size() -1).getValue();
		}
		
		private int redo(){
			if(pre != null){
				history.add(pre);
				pre = null;
			}
			return history.get(history.size() - 1).getValue();
		}
	}
}
