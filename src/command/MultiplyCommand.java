package command;

import calc.Calcute;
import impl.AbstractCommand;

public class MultiplyCommand extends AbstractCommand {

	public MultiplyCommand(Calcute calc) {
		super(calc);
	}

	@Override
	public int execute(int value) {
		return calc.multiply(value);
	}
}
