/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.ControllerSubsystem;

public class Robot extends TimedRobot {
    //private Command _autonomousCommand;
    //private Command _teleopCommand;
    //private Command _testCommand;

    @Override
    public void robotInit() {
        ControllerSubsystem.getInstance();
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
