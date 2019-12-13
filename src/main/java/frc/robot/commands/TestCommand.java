package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.config.MotorSpeeds;
import frc.robot.subsystems.TestSubsystem;


public class TestCommand extends Command {
    public enum Direction{
        POS, NEG;
    }
    private TestSubsystem _test;
    private double _dir;

    private int _outCount =0;
    public TestCommand(Direction dir) {
        super("TestCommand");

        _test = TestSubsystem.get_instance();
        requires(_test);

        _dir = dir == Direction.POS ? 1.0 : -1.0;
    }

    @Override
    protected void initialize() {
        _test.driveMotorTo(_dir > 0? 6144 : 0);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        //_test.drive(0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
