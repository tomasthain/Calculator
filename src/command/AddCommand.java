package command;

import calc.Calcute;
import impl.AbstractCommand;

public class AddCommand extends AbstractCommand{
	
	public AddCommand(Calcute calc){
		super(calc);
	}

	@Override
	public int execute(int value) {
		return calc.add(value);
	}
}
