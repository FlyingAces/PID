package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
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

        TalonSRX testMotor = new WPI_TalonSRX(RobotMap.Talon.TEST.get_channel());

        _testMotor = testMotor;

        testMotor.configFactoryDefault();
        testMotor.setNeutralMode(NeutralMode.Brake);
        testMotor.configNominalOutputForward(0, RobotMap.K_TIMEOUT_MS);
        testMotor.configNominalOutputReverse(0, RobotMap.K_TIMEOUT_MS);
        testMotor.configPeakOutputForward(1.0, RobotMap.K_TIMEOUT_MS);
        testMotor.configPeakOutputReverse(-1.0, RobotMap.K_TIMEOUT_MS);
        testMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.K_TIMEOUT_MS);
        testMotor.setSensorPhase(true);
        testMotor.setSelectedSensorPosition(-(testMotor.getSensorCollection().getPulseWidthPosition() & 0xfff), 0, RobotMap.K_TIMEOUT_MS);
        testMotor.getSensorCollection().setQuadraturePosition(0, RobotMap.K_TIMEOUT_MS);
    }

    public void drive(double moveValue) {
        _testMotor.set(ControlMode.PercentOutput, moveValue);
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

    @Override
    public void initDefaultCommand() {
    }
}

