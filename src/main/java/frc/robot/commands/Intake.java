package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.CANIntakeSubsystem;

public class Intake extends Command {
    private CANIntakeSubsystem sub;

    public Intake(CANIntakeSubsystem subsystem) {
        addRequirements(subsystem);
        sub = subsystem;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
