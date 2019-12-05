package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.DrivetrainSubsystem;


public class MoveVariableCommand extends Command {
    private DrivetrainSubsystem _drive;
    private double _dir;
    private double _angle;

    public MoveVariableCommand(double dir, double angle) {
        super("MoveVariableCommand");

        _drive = DrivetrainSubsystem.getInstance();
        requires(_drive);

        _dir = dir;
        _angle = angle;
    }

    @Override
    protected void initialize() {
        execute();
    }

    @Override
    protected void execute() {
        _drive.arcadeDrive(_dir, _angle);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        _drive.tankDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
