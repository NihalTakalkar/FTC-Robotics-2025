# FTC Robotics 2025

Overview

This repository contains the FTC robot control software for my Robotics Team for the 2025-2026 season.
It supports TeleOp driving, intake, flywheel shooter, ring pusher servo, climber, and multiple autonomous routines for competition.

The project is written using the FTC SDK and is compatible with Android Studio and REV Control Hub + Expansion Hub hardware.

## Hardware Requirements

### Control System

- REV Control Hub

- REV Expansion Hub

### Motors

- GoBILDA 5202/3/4 Series DC Motors (with encoders)

  - 4× drivetrain (mecanum)

  - 1× intake

  - 2× shooter (left shooter uses encoder)

  - 1× climb

### Servo

- 1× Standard positional servo

  - Ring pusher / holder

## Motors
| Device | Name | Type |
| ------ | ---- | ---- |
| FrontLeft | GoBILDA | 5202/3/4 |
| FrontRight | GoBILDA | 5202/3/4 |
| BackLeft | GoBILDA | 5202/3/4 |
| BackRight | GoBILDA | 5202/3/4 |
| Intake | GoBILDA | 5202/3/4 |
| Shooter | GoBILDA | 5202/3/4 (encoder used) |
| Climb | GoBILDA | 5202/3/4 |

## Servo
| Device | Name | Type |
| ----- | ---- | ---- |
| hold | Standard | Servo (NOT CRServo) |

## OpModes Included

### TeleOp

- SWYFT_Ri3d
Full driver-controlled mode with mecanum drive, intake, shooter, servo, and climb.

### Autonomous

- SWYFT Auto Long Blue

- SWYFT Auto Long Red

- SWYFT Auto Short

All autonomous routines are time-based and open-loop (no encoders for driving).

## Driver Controls (TeleOp)

#### Driving (Mecanum)

- **Left Stick X** → Strafe left/right

- **Left Stick Y** → Forward/back

- **Right Stick Y** → Forward/back (adds with left stick Y)

- **Right Stick X** → Rotate robot

#### Intake + Ring Pusher

- **X Button** → Intake IN + servo to 0.5 (load position)

- **Right Trigger** → Intake IN (servo unchanged)

- **Left Trigger** → Intake OUT

- **No input** → Intake OFF

- Servo defaults to 0.7 when not pressing X

#### Shooter (Flywheels)

- **A Button** → Toggle shooter ON/OFF

- Shooter uses bang-bang velocity control

- Target velocity ≈ 1500 ticks/sec

#### Climb

- **D-Pad Up** → Climb UP

- **D-Pad Down** → Climb DOWN

- **Neutral** → Climb OFF

## Shooter Control Notes

- Shooter is configured as DcMotorEx and uses encoder velocity.

- Bang-bang control alternates between:

  - Full power (spin-up)

  - Holding power (maintain RPM)

- Shooter motors must be mounted with opposite directions set in code.

## Autonomous Behavior Summary

### Long Autos

1. Drive forward

2. Turn ~45°

3. Drive forward slightly

4. Run intake briefly

5. Shoot 3 rings

### Short Auto

1. Small backward movement

2. Shoot 3 rings
