#include <SoftwareSerial.h>
#include <AFMotor.h>
#include <SimpleSoftwareServo.h>

//Declare variable and const for the rest of the program
const int leftMotorPort = 1; //This corresponds to M1 on the Adafruit motor shield
const int rightMotorPort = 2; //This corresponds to M2 on the Adafruit motor shield
const int shootingMotorPort = 3; //This corresponds to M3 on the Adafruit motor shield
const int bluetoothTxPin = A1; //Pin 14 maps to Analog pin 0
const int bluetoothRxPin = A0; //Pin 15 maps to Analog pin 1
const int elbowServoPort = 10;
const int wristServoPort = 9;
const int armServoPort = 5;
//There are still 3,5,6,11 pins available for additional servos

//Variables
float xAxis, yAxis;
int velocityL, velocityR, arm;
int xAxisMultiplier = 2;
int yAxisMultiplier = 2;
int armPos = 90;
int elbowPos = 90;
int wristPos = 25;

int turn = 0;
int velocity = 0;
int intake = 0;
int dumpButton = 0;
int pickupButton = 0;
int cargoButton = 0;
int lowRocketButton = 0;
int midRocketButton = 0;
int armButton = 0;
int elbowButton = 0;
int wristButton = 0;
int autoDriveButton = 0;

//Initiate items
SoftwareSerial bluetooth(bluetoothRxPin, bluetoothTxPin); //RX,TX
SimpleSoftwareServo elbowServo;
SimpleSoftwareServo wristServo;
SimpleSoftwareServo armServo;
AF_DCMotor rightMotors(rightMotorPort);
AF_DCMotor leftMotors(leftMotorPort);
AF_DCMotor shootingMotors(shootingMotorPort);

void setup() {
  Serial.begin(9600);
  bluetooth.begin(9600);
  
  elbowServo.attach(elbowServoPort);
  wristServo.attach(wristServoPort);
  armServo.attach(armServoPort);
  
  drive(0,0);
  //moveServos('h');
}

void loop() {
  while(bluetooth.available() > 0){
    if((bluetooth.read()) == 'z'){
      xAxis = (bluetooth.parseFloat()) * (100) * xAxisMultiplier;
      yAxis = (bluetooth.parseFloat()) * (100) * yAxisMultiplier;
      intake = bluetooth.parseFloat();
      dumpButton = bluetooth.parseInt();
      pickupButton = bluetooth.parseInt();
      midRocketButton = bluetooth.parseInt();
      lowRocketButton = bluetooth.parseInt();
      cargoButton = bluetooth.parseInt();
      armButton = bluetooth.parseInt();
      elbowButton = bluetooth.parseInt();
      wristButton = bluetooth.parseInt();
      autoDriveButton = bluetooth.parseInt();
      
      if(dumpButton == 1){
        moveWrist();
      }else if(pickupButton == 1){
        moveServos('p');
      }else if(cargoButton == 1){
        moveServos('c');
      }else if(lowRocketButton == 1){
        moveServos('l');
      }else if(midRocketButton == 1){
        moveServos('h');
      }else if(armButton == 1){
        moveArm();
      }else if(elbowButton == 1){
        moveElbow();
      }else if(wristButton == 1){
        moveWrist();
      }else if(autoDriveButton == 1){
        autoDrive();
      }
      
      drive(xAxis,yAxis);
      SimpleSoftwareServo::refresh();
    }
  }
}

void drive(int xAxis, int yAxis) {
  float V = (100 - abs(xAxis)) * (yAxis/100) + yAxis;    // This is where the X and Y axis inputs are converted into tank drive logic
  float W = (100 - abs(yAxis)) * (xAxis/100) + xAxis;
  velocityL = ((((V-W)/2)/100)*255);
  velocityR = ((((V+W)/2)/100)*255);

  rightMotors.run((velocityR >= 0) ? FORWARD : BACKWARD);     // These comands tell the motors what speed and direction to move at
  rightMotors.setSpeed(abs(velocityR));
  leftMotors.run((velocityL >= 0) ? FORWARD : BACKWARD);
  leftMotors.setSpeed(abs(velocityL));
}

void dump() {
  if(intake == -1) {
    Serial.println("Dumping Cargo");
    //wrist.write();
  }else{
    Serial.println("Returning Cargo Mech");
    //wrist.write();
  }
}

void autoDrive() {
  Serial.println("Enabling AutoDrive");
  drive((-1.0 * 100 * xAxisMultiplier),0);
  delay(750);
  drive(0,0);
}

void moveServos(char var){
  switch(var){
    case 'p':
      Serial.println("Moving to pickup position");
      armServo.write(150);
      elbowServo.write(89);
      //wristServo.write();
      break;
    case 'c':
      Serial.println("Moving to Cargo position");
      armServo.write(90);
      elbowServo.write(177);
      //wristServo.write();
      break;
    case 'l':
      Serial.println("Moving to Lower Rocket position");
      armServo.write(105);
      elbowServo.write(150);
      //wristServo.write();
      break;
    case 'm':
      Serial.println("Moving to Middle Rocket position");
      //armServo.write();
      //elbowServo.write();
      //wristServo.write();
      break;
    case 'h':
      Serial.println("Moving to the Home position");
      armServo.write(35);
      elbowServo.write(95);
      wristServo.write(25);
      break;
    default:
      break;
  }
}

void moveArm(){
  if(intake == 1) {
    Serial.print("Manually moving ARM + to ");
    armPos += 5;
    if(armPos >= 180){
      armPos = 179;
    }
    Serial.println(armPos);
    armServo.write(armPos);
  } else if(intake == -1){
    Serial.print("Manually moving ARM - to ");
    armPos -= 5;
    if(armPos <= 0){
      armPos = 1;
    }
    Serial.println(armPos);
    armServo.write(armPos);
  }
}

void moveElbow(){
  if(intake == -1) {
    Serial.print("Manually moving ELBOW + to ");
    elbowPos += 5;
    if(elbowPos >= 180){
      elbowPos = 179;
    }
    Serial.println(elbowPos);
    elbowServo.write(elbowPos);
  } else if(intake == 1){
    Serial.print("Manually moving ELBOW - to ");
    elbowPos -= 5;
    if(elbowPos <= 0){
      elbowPos = 1;
    }
    Serial.println(elbowPos);
    elbowServo.write(elbowPos);
  }
}

void moveWrist(){
  if(intake == -1) {
    Serial.print("Manually moving WRIST + to ");
    wristPos += 2;
    if(wristPos >= 180){
      wristPos = 179;
    }
    Serial.println(wristPos);
    wristServo.write(wristPos);
  } else if(intake == 1){
    Serial.print("Manually moving WRIST - to ");
    wristPos -= 2;
    if(wristPos <= 0){
      wristPos = 1;
    }
    Serial.println(wristPos);
    wristServo.write(wristPos);
  }
}
