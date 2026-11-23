package org.firstinspires.ftc.teamcode.pedro;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterSubsystem {

    private DcMotor smallshoot;
    private DcMotor bigshooter;

    public ShooterSubsystem(HardwareMap hardwareMap) {
        smallshoot = hardwareMap.get(DcMotor.class, "smallshoot");
        bigshooter = hardwareMap.get(DcMotor.class, "bigshooter");
    }

    public void Shoot() {
        smallshoot.setPower(0.8);
    }

    public void ShootBig() {
        bigshooter.setPower(-1);
    }

    public void stop() {
        smallshoot.setPower(0);
        bigshooter.setPower(0);
    }



}