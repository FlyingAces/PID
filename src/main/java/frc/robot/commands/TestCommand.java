package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.TestSubsystem;
import frc.robot.config.MotorSpeeds;


public class TestCommand extends Command {
    public enum Direction{
        POS, NEG;
    }
    private TestSubsystem _test;
    private double _dir;

    public TestCommand(Direction dir) {
        super("TestCommand");

        _test = TestSubsystem.get_instance();
        requires(_test);

        _dir = dir == Direction.POS ? 1.0 : -1.0;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        _test.drive(_dir * MotorSpeeds.TEST_SPEED_MULTIPLIER);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        _test.drive(0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
