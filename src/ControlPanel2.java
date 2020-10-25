/*
 * Nilsu Duran and Fiona Au
 * netID: vduran & fau
 * TR 1105 - 1220
 * Project 3 - Fireworks!
 * We did not collaborate with anyone else on this assignment.
 */
//importing classes
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

//declaring class ControlPanel2 which extends JPanel and implements listeners
public class ControlPanel2 extends JPanel implements ActionListener, ChangeListener {
	//serializing
	private static final long serialVersionUID = 1L;
	//declaring variables
	JLabel fireworkType;
	JButton typeButtonOne, typeButtonTwo, typeButtonThree, typeButtonFour, typeButtonFive;
	JButton start;
	JButton colorButtonRed, colorButtonBlue, colorButtonYellow;
	JLabel fireworkColor;
	JSlider angleSlider, speedSlider, timeSlider;
	JLabel speedLabel, angleLabel, timeLabel;
	JPanel control2;
	Canvas canvas;
	Fireworkss fireworkss;
	//static variables that we used between classes
	static int speed, angle, time;
	static Color color;
	static char type;

	
	//Class constructor
	public ControlPanel2(Canvas canvas) {
		//setting canvas
		this.canvas = canvas;
		this.setLayout(new FlowLayout());
		
		//adding 3 sliders: 1 for angle, 1 for time, 1 for speed
		angleLabel = new JLabel("Angle");
		add(angleLabel);
		angleSlider = new JSlider(0, 90);
		angleSlider.addChangeListener(this);
		add(angleSlider);
		speedLabel = new JLabel("Speed");
		add(speedLabel);
		speedSlider = new JSlider(0, 100);
		speedSlider.addChangeListener(this);
		add(speedSlider);
		timeLabel = new JLabel("Time");
		add(timeLabel);
		timeSlider = new JSlider(0, 7);
		timeSlider.addChangeListener(this);
		add(timeSlider);			
		
		//adding 3 buttons for firework colors
		fireworkColor = new JLabel("Color");
		add(fireworkColor);
		colorButtonRed = new JButton("Red");
		colorButtonRed.addActionListener(this);
		add(colorButtonRed);
		colorButtonBlue = new JButton("Blue");
		colorButtonBlue.addActionListener(this);
		add(colorButtonBlue);
		colorButtonYellow = new JButton("Yellow");
		colorButtonYellow.addActionListener(this);
		add(colorButtonYellow);
				
		//adding 5 buttons for 5 types of explosions
		fireworkType = new JLabel("Type");
		add(fireworkType);
		typeButtonOne = new JButton("A");
		typeButtonOne.addActionListener(this);
		add(typeButtonOne);
		typeButtonTwo = new JButton("B");
		typeButtonTwo.addActionListener(this);
		add(typeButtonTwo);
		typeButtonThree = new JButton("C");
		typeButtonThree.addActionListener(this);
		add(typeButtonThree);
		typeButtonFour = new JButton("D");
		typeButtonFour.addActionListener(this);
		add(typeButtonFour);
		typeButtonFive = new JButton("E");
		typeButtonFive.addActionListener(this);
		add(typeButtonFive);
		
		//adding launch button
		start = new JButton("Launch!");
		start.addActionListener(this);
		add(start);
	}

	//actionPerformed method to get action made on given button
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		//button presses set firework type
		if (src == typeButtonOne) {
			type = 'A';
		} else if (typeButtonTwo == e.getSource()) {
			type = 'B';
		} else if (typeButtonThree == e.getSource()) {
			type = 'C';
		} else if (typeButtonFour == e.getSource()) {
			type = 'D';
		} else if (typeButtonFive == e.getSource()) {
			type = 'E';
		} 
		//button presses set firework color
		if (colorButtonRed == e.getSource()) {
			color = Color.red;
		} else if(colorButtonBlue == e.getSource()) {
			color = Color.blue;
		} else if (colorButtonYellow == e.getSource()) {
			color = Color.yellow;
		}
		//button press that launches firework rendering by creating a new instance of the Fireworkss object
		//allowing for a new window to pop up once "Launch" is pressed
		if (start == e.getSource()) {
			new Fireworkss().setVisible(true);
		}
	}
	
	//stateChanged method for getting slider values
	@Override
	public void stateChanged(ChangeEvent e) {
		Object src = e.getSource();
		if (src == speedSlider) {
			speedLabel.setText("Speed: " + speedSlider.getValue());
		}
		if (src == angleSlider) { 
			angleLabel.setText("Angle: " + angleSlider.getValue());
		}
		if (src == timeSlider) {
			timeLabel.setText("Time: " + timeSlider.getValue());
		}
		if (src == speedSlider) {
			speed = speedSlider.getValue();
		} else if (src == angleSlider) {
			angle = angleSlider.getValue();
		} else if (src == timeSlider) {
			time = timeSlider.getValue();	
		}
	}
	
	//getter methods for user-set speed, time, angle, color and type
	public static int getSpeedVal() {
	    return speed;
	}
	public static int getTimeVal() {
		return time;
	}
	public static int getAngleVal() {
		return angle;
	}
	public static char getType() {
		return type;
	}
	public static Color getColor() {
		return color;
	}
}

		

