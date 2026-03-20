package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class CANSpindexerSubsystem extends SubsystemBase {
    public SparkMax controller;

    public CANSpindexerSubsystem() {
        controller = new SparkMax(SpindexerConstants.MOTOR_ID, MotorType.kBrushed);

        SparkMaxConfig config = new SparkMaxConfig();

        config.smartCurrentLimit(SparkMaxConstants.CURRENT_LIMIT);
        config.voltageCompensation(12);

        controller.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public Command run() {
        return Commands.runOnce(() -> controller.set(SpindexerConstants.SPEED), this).andThen(() -> controller.set(0), this);
    }
}
