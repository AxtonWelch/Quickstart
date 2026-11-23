package org.firstinspires.ftc.teamcode.pedro;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

    private DcMotor intake;
    private DcMotor intaketwo;

    public IntakeSubsystem(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "intake");
        intaketwo = hardwareMap.get(DcMotor.class, "intaketwo");
    }

    public void In() {
        intake.setPower(-1);
        intaketwo.setPower(-1);
    }

    public void stop() {
        intake.setPower(0);
        intaketwo.setPower(0);
    }



}