package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.SparkMaxConstants;

public class CANIntakeSubsystem extends SubsystemBase {
    public SparkMax controller;

    public CANIntakeSubsystem() {
        controller = new SparkMax(IntakeConstants.MOTOR_ID, MotorType.kBrushed);

        SparkMaxConfig config = new SparkMaxConfig();

        config.voltageCompensation(12);
        config.smartCurrentLimit(SparkMaxConstants.CURRENT_LIMIT);

        controller.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public Command run() {
        return Commands.runEnd(() -> controller.set(IntakeConstants.SPEED), () -> controller.set(0), this);
    }
}
