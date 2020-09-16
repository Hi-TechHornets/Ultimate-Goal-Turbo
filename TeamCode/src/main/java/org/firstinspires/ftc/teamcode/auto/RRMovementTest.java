package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.rr.drive.SampleMecanumDrive;

@Autonomous
@Config
public class RRMovementTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.arm.setPosition(0.2);

        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .forward(10)
                .splineToSplineHeading(new Pose2d(30, 20, Math.toRadians(0)), Math.toRadians(180))
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(traj1);
    }
}
