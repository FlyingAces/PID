package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.config.RobotMap;


public class TestSubsystem extends Subsystem {
    private static TestSubsystem _instance;
    private TalonSRX _testMotor;

    private TestSubsystem() {
        super("TestSubsystem");

        _testMotor = new WPI_TalonSRX(RobotMap.Talon.TEST.get_channel());

        _testMotor.configFactoryDefault();
        _testMotor.setNeutralMode(NeutralMode.Brake);
        _testMotor.configNominalOutputForward(0.0, RobotMap.K_TIMEOUT_MS);
        _testMotor.configNominalOutputReverse(0.0, RobotMap.K_TIMEOUT_MS);
        _testMotor.configPeakOutputForward(0.3, RobotMap.K_TIMEOUT_MS);
        _testMotor.configPeakOutputReverse(-0.3, RobotMap.K_TIMEOUT_MS);
        _testMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.setSensorPhase(true);
        _testMotor.setSelectedSensorPosition(-(_testMotor.getSensorCollection().getPulseWidthPosition() & 0xfff), 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.getSensorCollection().setQuadraturePosition(0, RobotMap.K_TIMEOUT_MS);

        _testMotor.configAllowableClosedloopError(0, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_kP(0, 1, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_kD(0, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_kI(0, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_kF(0, 0, RobotMap.K_TIMEOUT_MS);
        _testMotor.config_IntegralZone(0, 0, RobotMap.K_TIMEOUT_MS);
    }

    /*
    public void drive(double moveValue) {
        _testMotor.set(ControlMode.PercentOutput, moveValue);
    }
     */

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

    public void driveMotorTo(int position) {
        //double combatGravity = 1.0 - (Math.abs(getAngle(Angle.SHOULDER)) / RobotMap.Angle.SHOULDER_START_ANGLE.getAngle());
        //combatGravity *= (RobotMap.SHOULDER_MAX_COMBAT_GRAVITY - RobotMap.SHOULDER_MIN_COMBAT_GRAVITY);
        //combatGravity += RobotMap.SHOULDER_MIN_COMBAT_GRAVITY;

        //double shouldRadians = Conversions.degreeToRadian(getAngle(Angle.SHOULDER));
        //_testMotor.set(ControlMode.Position, position, DemandType.ArbitraryFeedForward, -(combatGravity * Math.sin(shouldRadians)));
        _testMotor.set(ControlMode.Position, position);
    }

    @Override
    public void initDefaultCommand() {
    }
}
