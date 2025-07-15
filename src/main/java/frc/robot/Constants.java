// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Map;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class Shooter{

    public static enum ShooterMode {
      LOW, 
      MEDIUM,
      HIGH,
    }

    public static final Map<ShooterMode, Double> SHOOTER_RPM_MAP = Map.of(
      ShooterMode.LOW, 2000.0, // TODO: Tune these values
      ShooterMode.MEDIUM, 3000.0, // TODO: Tune these values
      ShooterMode.HIGH, 4000.0 //TODO: Tune these values
    );

    public static final int LEFT_MOTOR_ID = 10;
    public static final int RIGHT_MOTOR_ID = 11;

    public static final double k_LeftFeedForward = 0.1; //TODO tune this
    public static final double k_RightFeedForward = 0.1; //TODO tune this
  
    public static final double RIGHT_FLYWHEEL_P = 0.0001; //TODO tune this
    public static final double LEFT_FLYWHEEL_P = 0.0001; //TODO tune this

    public static final double rpmSpeed = 0.0; //TODO set this to whatever
  }
}

