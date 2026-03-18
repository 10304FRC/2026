package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.*;

import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.SparkMaxConstants;

public class CANShooterSubsystem extends SubsystemBase {
    public SparkMax leaderController;
    public SparkMax followerController;

    public CANShooterSubsystem() {
        leaderController = new SparkMax(ShooterConstants.LEADER_ID, MotorType.kBrushed);
        followerController = new SparkMax(ShooterConstants.FOLLOWER_ID, MotorType.kBrushed);

        SparkMaxConfig config = new SparkMaxConfig();

        config.smartCurrentLimit(SparkMaxConstants.CURRENT_LIMIT);
        config.voltageCompensation(12);
        
        // No persist just in case some config is messed up, we use only the ones we define
        leaderController.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        config.follow(ShooterConstants.LEADER_ID, true);

        followerController.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
}
