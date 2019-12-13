/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.TestSubsystem;


public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        ControllerSubsystem.getController();
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
        System.out.println("Motor Position: " + TestSubsystem.get_instance().getCurrentMotorPosition());
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
