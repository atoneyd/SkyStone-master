package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Drive {

    private DcMotor fl;//names the parts
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    private Servo servoleft;
    private Servo servoright;
    private DcMotor slide;
    private Servo armleft;
    private Servo armright;

    public void stop() {
        //this.fl = fl;
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }
    public void mecanum(double x, double y, double yawPower) {

    }

    public DcMotor getFl() {
        return fl;
    }
}
