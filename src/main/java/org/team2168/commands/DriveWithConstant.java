/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team2168.commands;

import org.team2168.Robot;
import org.team2168.RobotContainer;
import org.team2168.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveWithConstant extends CommandBase {
  /**
   * Creates a new DriveWithConstant.
   */
  Drivetrain dt;
  RobotContainer rc;

  private double _speed;


  public DriveWithConstant(double inputSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    dt = Drivetrain.getInstance();
    _speed = inputSpeed;
    
    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    rc = RobotContainer.getInstance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dt.tankDrive(_speed, _speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
