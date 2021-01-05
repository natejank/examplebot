/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team2168.subsystems;

import org.team2168.Constants;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  private PWMVictorSPX leftMotor1;
  private PWMVictorSPX leftMotor2;
  private PWMVictorSPX rightMotor1;
  private PWMVictorSPX rightMotor2;

  public static Drivetrain instance = null;
  private Drivetrain() {
    leftMotor1 = new PWMVictorSPX(Constants.DT_MOTOR_LEFT_1);
    leftMotor2 = new PWMVictorSPX(Constants.DT_MOTOR_LEFT_2);
    rightMotor1 = new PWMVictorSPX(Constants.DT_MOTOR_RIGHT_1);
    rightMotor2 = new PWMVictorSPX(Constants.DT_MOTOR_RIGHT_2);
  }

  private void setLeftMotor1(double speed) {
    leftMotor1.set(speed);
  }

  private void setLeftMotor2(double speed) {
    leftMotor2.set(speed);
  }

  public void setLeftMotors(double speed) {
    setLeftMotor1(speed);
    setLeftMotor2(speed);
  }

  private void setRightMotor1(double speed) {
    rightMotor1.set(speed);
  }

  private void setRightMotor2(double speed) {
    rightMotor2.set(speed);
  }

  public void setRightMotors(double speed) {
    setRightMotor1(speed);
    setRightMotor2(speed);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    setRightMotors(leftSpeed);
    setRightMotors(rightSpeed);
  }

  public static Drivetrain getInstance() {
    if (instance == null)
      instance = new Drivetrain();
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
