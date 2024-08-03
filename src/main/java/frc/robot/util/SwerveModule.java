package frc.robot.util;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;


public class SwerveModule() {
  // Drive Motor Components w/ relative encoder & PID
  private CANSparkMax m_driveMotor;
  private RelativeEncoder m_driveEncoder;
  private SparkPIDController m_drivePIDController;

  // Turn Motor Components w/ absolute encoder & PID
  private CANSparkMax m_turnMotor;
  private SparkPIDController m_drivePIDController;
  private AbsoluteEncoder m_absoluteEncoder;

  
  
  public SwerveModule(int drivePort, int turnPort) {
    m_driveMotor = new CANSparkMax(drivePort, CANSparkLowLevel.MotorType.kBrushless);
    m_turnMotor = new CANSparkMax(turnPort, CANSparkLowLevel.MotorType.kBrushless);
    
    m_driveEncoder = m_driveMotor.getEncoder();
    m_divePIDController = m_driveMotor.getPIDController();

    m_drivePIDController = m_turnMotor.getPIDController();
    m_absoluteEncoder = m_turnMotor.getAbsoluteEncoder();


    m_driveMotor.restorFactoryDefaults();
    m_turnMotor.restorFactoryDefaults();
    // Set the controller's feedback device; set relative position to position of absolute
    m_driverMotor.setFeedbackDevice(m_absoluteEncoder);

    m_driveMotor.restorFactoryDefaults();
    m_turnMotor.restorFactoryDefaults();
  }
}