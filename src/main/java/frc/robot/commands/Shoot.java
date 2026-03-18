package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.CANShooterSubsystem;

public class Shoot extends Command {
    private CANShooterSubsystem sub;

    public Shoot(CANShooterSubsystem subsystem) {
        addRequirements(subsystem);
        sub = subsystem;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        sub.leaderController.set(ShooterConstants.SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        sub.leaderController.set(0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
