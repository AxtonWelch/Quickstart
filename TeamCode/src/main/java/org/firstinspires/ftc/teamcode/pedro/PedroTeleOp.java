package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;

@TeleOp(name = "Pedro TeleOp")
public class PedroTeleOp extends OpMode {

    private Follower follower;

    private IntakeSubsystem intake;

    private ShooterSubsystem Shooter;
    //private IntakeSubsystem intaketwo;


    //private ShooterSubsystem smallshoot;
    //private ShooterSubsystem bigshooter;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        Shooter = new ShooterSubsystem(hardwareMap);
        //intaketwo = new IntakeSubsystem(hardwareMap);
        //smallshoot = new ShooterSubsystem(hardwareMap);
        //bigshooter = new ShooterSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()
        );

        if (gamepad1.a) {
            intake.In();
        } else {
            intake.stop();
        }

        if (gamepad1.b) {
            Shooter.Shoot();
        } else if (gamepad1.x){
            Shooter.ShootBig();
        } else {
            Shooter.stop();
        }

        ManualDrive.driveOrHold(follower, powers);
        follower.update();
        Pose robotPose = follower.pose(); // returns a Pose object

        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
        // Math.toDegrees() is a built-in java method
    }
}

