/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team2168;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import org.team2168.commands.ExampleCommand;
import org.team2168.subsystems.Drivetrain;
import org.team2168.subsystems.ExampleSubsystem;
import org.team2168.utils.F310;
import org.team2168.commands.DriveWithConstant;
import org.team2168.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static RobotContainer instance = null;

  private Drivetrain dt;
  private ExampleSubsystem ex;

  private F310 driverJoystick;



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  private RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driverJoystick = new F310(Constants.DRIVER_JOYSTICK_PORT);

    dt = Drivetrain.getInstance();
    dt.setDefaultCommand(new DriveWithJoysticks(Drivetrain.getInstance()));

    ex = new ExampleSubsystem();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // driverJoystick.ButtonA().whenHeld(new DriveWithConstant(0.1));
    driverJoystick.ButtonA().whenHeld(new ExampleCommand(ex));
  }

  public double getLeftStick_Y() {
    return driverJoystick.getLeftStickRaw_Y();
  }

  public double getRightStick_Y() {
    return driverJoystick.getRightStickRaw_Y();
  }

  public double getLeftGunStyle() {
    return driverJoystick.getLeftStickRaw_X();
  }
  
  public double getRightGunStyle() {
    return driverJoystick.getLeftStickRaw_Y();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static RobotContainer getInstance() {
    if (instance == null)
      instance = new RobotContainer();
    return instance;
  }
}
