package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.commands.TestCommand;
import frc.robot.commands.MoveVariableCommand;
import frc.robot.config.RobotMap;


public class ControllerSubsystem extends Subsystem {
    private Joystick _joystick;
    //private JoystickButton _leftBumper;
    //private JoystickButton _rightBumper;

    private static ControllerSubsystem _instance;

    private ControllerSubsystem() {
        _joystick = new Joystick(RobotMap.Controller.JOYSTICK_PORT.getChannel());

        // TEST BACKWARD
        JoystickButton leftBumper = new JoystickButton(_joystick, RobotMap.Controller.TRIGGER_LB.getChannel());
        leftBumper.whileHeld(new TestCommand(TestCommand.Direction.NEG));

        // TEST FORWARD
        JoystickButton rightBumper = new JoystickButton(_joystick, RobotMap.Controller.TRIGGER_RB.getChannel());
        rightBumper.whileHeld(new TestCommand(TestCommand.Direction.POS));

        // LEFT
        JoystickButton xButton = new JoystickButton(_joystick, RobotMap.Controller.X_BUTTON.getChannel());
        xButton.whileHeld(new MoveVariableCommand(0.0, 1.0));

        // FORWARD
        JoystickButton yButton = new JoystickButton(_joystick, RobotMap.Controller.Y_BUTTON.getChannel());
        yButton.whileHeld(new MoveVariableCommand(1.0, 0.0));

        // RIGHT
        JoystickButton bButton = new JoystickButton(_joystick, RobotMap.Controller.B_BUTTON.getChannel());
        bButton.whileHeld(new MoveVariableCommand(0.0, -1.0));

        // BACKWARD
        JoystickButton aButton = new JoystickButton(_joystick, RobotMap.Controller.A_BUTTON.getChannel());
        aButton.whileHeld(new MoveVariableCommand(-1.0, 0.0));
    }

    public static ControllerSubsystem getInstance() {
        if (_instance == null) {
            _instance = new ControllerSubsystem();
        }
        return _instance;
    }

    public Joystick getController() {
        return _joystick;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
