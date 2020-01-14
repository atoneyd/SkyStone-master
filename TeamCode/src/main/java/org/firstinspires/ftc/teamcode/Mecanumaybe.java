package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "NightOwls", group = "A")
public class Mecanumaybe extends OpMode {

    public DcMotor fl;//names the parts
    public DcMotor fr;
    public DcMotor bl;
    public DcMotor br;
    public DcMotor slide;

    public Servo servoleft;
    public Servo servoright;
    public Servo armleft;
    public Servo armright;

    @Override
    public void init() {

        fl = hardwareMap.dcMotor.get("fl"); //names motors in phones
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");
        slide = hardwareMap.dcMotor.get("slide");

        servoleft = hardwareMap.servo.get("servo1");
        servoright = hardwareMap.servo.get("servo2");
        armleft = hardwareMap.servo.get("grableft");
        armright = hardwareMap.servo.get("grabright");

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
        slide.setPower(0);

        servoleft.setPosition(.2);
        servoright.setPosition(.6);
        armleft.setPosition(.6);
        armright.setPosition(.4);

        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    @Override
    public void loop() {


        double lefty = -gamepad1.left_stick_y; //add negative because y axis is flipped on gamepad
        double rightx = gamepad1.right_stick_x;
        double leftx = gamepad1.left_stick_x;

        fl.setPower(((lefty + rightx + leftx)*-1)*.5); //sets power (in a joystick its between 1 to -1)
        fr.setPower((lefty - rightx - leftx)*.5);
        bl.setPower(((lefty +  rightx - leftx)*.5)*-1);
        br.setPower((lefty - rightx + leftx)*.5);

        //sonic
        if (gamepad1.left_trigger == 1) {
            fl.setPower((lefty + rightx + leftx)*-1); //sets power (in a joystick its between 1 to -1)
            fr.setPower(lefty - rightx - leftx);
            bl.setPower(lefty +  rightx - leftx);
            br.setPower(lefty - rightx + leftx);
        }

        //servos
        if (gamepad1.y) {
            // grab foundation
            servoleft.setPosition(.1);
            servoright.setPosition(.7);
        } else if (gamepad1.b) {
            // move back up
            servoleft.setPosition(0.2);
            servoright.setPosition(0.6);
        }
        if (gamepad1.a) {
            servoleft.setPosition(0.6);
            servoright.setPosition(0.2);
        }
        if (gamepad1.dpad_up) {
            slide.setPower(.5);
        }
        else if (gamepad1.dpad_down) {
            slide.setPower(-.5);
        }
        else {
            slide.setPower(0);
        }
        if (gamepad1.left_bumper) {
            armleft.setPosition(.6);
            armright.setPosition(.4);
        }
        else if (gamepad1.right_bumper) {
            armleft.setPosition(1);
            armright.setPosition(0);
        }


        telemetry.addData("Servo 1 Position", servoleft.getPosition());
        telemetry.addData("Servo 2 Position", servoright.getPosition());
        telemetry.addData("left arm servo", armleft.getPosition());
        telemetry.addData("right arm servo", armright.getPosition());
        telemetry.addData("Status", "Running");
        telemetry.addData("Front left", fl.getCurrentPosition());
        telemetry.addData("Front left", fr.getCurrentPosition());
        telemetry.addData("Front left", bl.getCurrentPosition());
        telemetry.addData("Front left", br.getCurrentPosition());
        telemetry.update();
    }
}
