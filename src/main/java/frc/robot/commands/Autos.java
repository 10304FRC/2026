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
        CANIntakeSubsystem intake
    ) {
        return drive.dropIntake().andThen(shooter.run(spindexer, intake)).withTimeout(10);
    }

    public static Command moveToCenter(CANDriveSubsystem drive) {
        // Might need to tweak duration
        return drive.run(() -> 1, () -> 0, false).withTimeout(0.5);
    }
}
