package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="SWYFT Auto Long Red", group="Competition")
public class SWYFT_Auto_Long_Red extends LinearOpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight, intake, shooterR;
    private DcMotorEx shooterL;
    private Servo hold;

    @Override
    public void runOpMode() {
        // Hardware mapping
        frontLeft  = hardwareMap.get(DcMotor.class, "FrontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "BackLeft");
        backRight  = hardwareMap.get(DcMotor.class, "BackRight");
        intake     = hardwareMap.get(DcMotor.class, "Intake");
        shooterL   = hardwareMap.get(DcMotorEx.class, "ShooterL");
        shooterR   = hardwareMap.get(DcMotor.class, "ShooterR");
        hold       = hardwareMap.get(Servo.class, "hold");

        // Motor directions
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        shooterR.setDirection(DcMotor.Direction.REVERSE);

        hold.setPosition(0.7);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            // Drive forward
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1500);
            stopDrive();

            // Turn right 45 degrees
            frontLeft.setPower(0.4);
            backLeft.setPower(0.4);
            frontRight.setPower(-0.4);
            backRight.setPower(-0.4);
            sleep(600); // adjust for ~45° rotation
            stopDrive();

            // Drive forward tiny bit
            frontLeft.setPower(0.3);
            frontRight.setPower(0.3);
            backLeft.setPower(0.3);
            backRight.setPower(0.3);
            sleep(400);
            stopDrive();

            // Shoot 3 times
            shootRings(3);
        }
    }

    private void stopDrive() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void shootRings(int count) {
        shooterL.setPower(-1.0);
        shooterR.setPower(-1.0);
        sleep(2500);

        for (int i=0; i<count; i++) {
            hold.setPosition(0.5);
            sleep(350);
            hold.setPosition(0.7);
            sleep(450);
        }

        shooterL.setPower(0);
        shooterR.setPower(0);
    }
}
