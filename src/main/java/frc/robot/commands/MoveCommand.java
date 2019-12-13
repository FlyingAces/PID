package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.TestSubsystem;


public class MoveCommand extends Command {
	public enum Direction {
		POS, NEG;
	}
	private TestSubsystem _test;
	private double _dir;

	public MoveCommand(Direction dir) {
		super("MoveCommand");

		_test = TestSubsystem.get_instance();
		requires(_test);

		_dir = dir == Direction.POS ? 1.0 : -1.0;
	}

	@Override
	protected void initialize() {
		execute();
	}

	@Override
	protected void execute() {
		_test.driveMotor(_dir);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		_test.driveMotor(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
