package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANIntakeSubsystem;
import frc.robot.subsystems.CANShooterSubsystem;
import frc.robot.subsystems.CANSpindexerSubsystem;

public class Autos {
    public static Command shootCenter(
        CANDriveSubsystem drive,
        CANShooterSubsystem shooter,
        CANSpindexerSubsystem spindexer,
        CANIntakeSubsystem intakeSubsystem
    ) {
        return drive.dropIntake().andThen(shooter.run(spindexer, intakeSubsystem)).withTimeout(10);
    }
}
