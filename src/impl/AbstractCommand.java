package impl;

import calc.Calcute;

public abstract class  AbstractCommand {
	protected Calcute calc;
	
	public AbstractCommand(Calcute calc){
		this.calc = calc;
	}
	
	public abstract int  execute(int value);
	public int undo() {
		return calc.undo();
	}
	public int redo() {
		return calc.redo();
	}
	public int display(){
		return calc.getSum();
	}
}
