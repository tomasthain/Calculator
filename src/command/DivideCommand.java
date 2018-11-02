package command;

import calc.Calcute;
import impl.AbstractCommand;

public class DivideCommand extends AbstractCommand {

	public DivideCommand(Calcute calc) {
		super(calc);
	}

	@Override
	public int execute(int value) {
		return calc.divide(value);
	}
}
