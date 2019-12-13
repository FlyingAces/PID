// Package declaration.
package frc.robot.commands;

// Import dependencies.
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.TestSubsystem;

// Class declaration.
public class HomingCommand extends Command
{
	// Global instances.
	private TestSubsystem _test;

	// Constructor method.
	public HomingCommand()
	{
		// Super declaration.
		super("ConstructorCommand");

		_test = TestSubsystem.get_instance();
		requires(_test);
	}

	@Override
	protected void initialize()
	{
		execute();
	}


	@Override
	protected void execute()
	{
		int currentPosition = _test.getCurrentMotorPosition();

		while(!_test.switchIsTripped())
		{
			_test.driveMotorTo(--currentPosition);
		}
	}


	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
