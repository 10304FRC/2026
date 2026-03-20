package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.CANDriveSubsystem;

public class Drive extends Command {
    private CANDriveSubsystem sub;
    private CommandXboxController controller;
    
    public Drive(CANDriveSubsystem subsystem, CommandXboxController xbox) {
        // Prevents two commands of the same subsystem from being scheduled
        addRequirements(subsystem);
        sub = subsystem;
        controller = xbox;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Need to negate right, otherwise it's inverted
        sub.drive(controller.getLeftY() * DriveConstants.DRIVE_SPEED, -controller.getRightX() * DriveConstants.TURN_SPEED);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
