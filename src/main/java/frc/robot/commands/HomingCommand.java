// Package declaration.
package frc.robot.commands;

// Import dependencies.
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.TestSubsystem;

// Class declaration.
public class HomingCommand extends Command
{
	// Global instances.


	// Constructor method.
	public HomingCommand()
	{
		// Super declaration.
		super("ConstructorCommand");
	}

	@Override
	protected void initialize()
	{
		execute();
	}


	@Override
	protected void execute()
	{

	}


	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
