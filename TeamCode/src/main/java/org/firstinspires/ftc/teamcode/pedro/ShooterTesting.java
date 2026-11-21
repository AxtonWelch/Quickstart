package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.controllers.Controller;
import com.pedropathing.controllers.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


public class ShooterTesting extends LinearOpMode {

    private DcMotorEx Shooter;

    private PIDController shooterPID = Controller.pid(30,0,0);

    private double targetVelocity = 0.0;


    private static final double NOMINAL_VOLTAGE = 13.0;

    /*public void setTargetVelocity(double velocity) {
        targetVelocity = velocity;
    }

     */


    @Override
    public void runOpMode() {
        Shooter = hardwareMap.get(DcMotorEx.class, "Shooter");

        Shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        waitForStart();

        while (opModeIsActive()) {


            if (gamepad2.x) {
                targetVelocity = 1200;
            }

            double currentVel = Shooter.getVelocity();

            //shooterPID.setTarget(targetVelocity);
            

            double power = shooterPID.calculate(targetVelocity, currentVel);

            power = Math.max(0.0, Math.min(1.0, power));
            Shooter.setPower(power);

            telemetry.addData("Velocity", currentVel);
            telemetry.update();
        }
    }

}