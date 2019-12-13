package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.config.MotorSpeeds;
import frc.robot.config.RobotMap;


public class TestSubsystem extends Subsystem {
    private static TestSubsystem _instance;
    private TalonSRX _testMotor;

    private TestSubsystem() {
        super("TestSubsystem");

        _testMotor = new WPI_TalonSRX(RobotMap.Talon.TEST.getChannel());
        _testMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen,  RobotMap.K_TIMEOUT_MS);

        // Test talon configuration
        _testMotor.configFactoryDefault();  // Revert all settings to factory default
        _testMotor.setNeutralMode(NeutralMode.Brake);  // When not moving, brake
        _testMotor.configNominalOutputForward(0.0, RobotMap.K_TIMEOUT_MS);
        _testMotor.configNominalOutputReverse(0.0, RobotMap.K_TIMEOUT_MS);
        _testMotor.configPeakOutputForward(MotorSpeeds.TELEOP_SPEED_MULTIPLIER, RobotMap.K_TIMEOUT_MS);
        _testMotor.configPeakOutputReverse(-MotorSpeeds.TELEOP_SPEED_MULTIPLIER, RobotMap.K_TIMEOUT_MS);
        _testMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.setSensorPhase(true);
        _testMotor.setSelectedSensorPosition(-(_testMotor.getSensorCollection().getPulseWidthPosition() & 0xfff), 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.getSensorCollection().setQuadraturePosition(0, RobotMap.K_TIMEOUT_MS);

        // P.I.D. Controller.
        _testMotor.configAllowableClosedloopError(0, 0, RobotMap.K_TIMEOUT_MS);

        // Configure "P" until oscillation.
        _testMotor.config_kP(0, RobotMap.K_P, RobotMap.K_TIMEOUT_MS);

        // Configure "I" to reduce P's oscillation.
        _testMotor.config_kI(0, RobotMap.K_I, RobotMap.K_TIMEOUT_MS);

        // Configure "D" to refine the effects of "P" and "I". Will revisit this comment later.
        _testMotor.config_kD(0, RobotMap.K_D, RobotMap.K_TIMEOUT_MS);

        // Configure "F" to specify the range in which P.I.D configurations take effect.
        _testMotor.config_kF(0, RobotMap.K_F, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_IntegralZone(0, 0, RobotMap.K_TIMEOUT_MS);
    }


    public static TestSubsystem get_instance() {
        if (_instance == null) {
            _instance = new TestSubsystem();
        }
        return _instance;
    }

    public int getCurrentMotorPosition() {
        return _testMotor.getSelectedSensorPosition(0);
    }

    public int getCurrentMotorVelocity() {
        return _testMotor.getSelectedSensorVelocity(0);
    }

    /**
     * Configure the motor to move until a specified quadrature encoder position has been reached.
     * @param position the specified quadrature encoder tick position.
     */
    public void driveMotorTo(int position) {
        _testMotor.set(ControlMode.Position, position);
    }

    /**
     * Configure the motor to move at a given speed in between 1.0 and -1.0.
     * @param move a speed and direction. The number's sign dictates direction, and the number's size dictates speed.
     */
    public void driveMotor(double move) {
        _testMotor.set(ControlMode.PercentOutput, move);
    }

    @Override
    public void initDefaultCommand() {
    }
}
