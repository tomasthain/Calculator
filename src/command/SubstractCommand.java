package command;

import calc.Calcute;
import impl.AbstractCommand;

public class SubstractCommand extends AbstractCommand{

	public SubstractCommand(Calcute calc) {
		super(calc);
	}

	@Override
	public int execute(int value) {
		return calc.substract(value);
	}
}
