/*
 * Nilsu Duran and Fiona Au
 * netID: vduran & fau
 * TR 1105 - 1220
 * Project 3 - Fireworks!
 * We did not collaborate with anyone else on this assignment.
 */
//importing classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

//declaring class Canvas which extends JComponent
public class Canvas extends JComponent {
	//serializing
	private static final long serialVersionUID = 1L;
	//declaring variables
	static double angle = 0.0;
	static double speed = 0.0;
	Color color = Color.BLACK;
	char type = 'A';
	int time = 0;
	private Canvas canvas;
	
	//paintComponent for canvas:
	//every time the paintComponent is called, 
	//the color, angle, speed, and time are all set based on what value it has received from another class
	@Override
	public void paintComponent(Graphics g){
		g.setColor(color);
		setAngle(angle);
		setSpeed(speed);
		setTime(time);
	}
	
	//getters and setters for angle, speed, time, color, type and canvas itself
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		this.color = c;
	}
	
	public char getType() {
		return type;
	}
	
	public void setType(char n) {
		this.type = n;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	//main method that creates the frame for the control panel that contains GUI.
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fireworks");
		Canvas canvas = new Canvas();
		ControlPanel2 control2 = new ControlPanel2(canvas);
		frame.add(canvas);
		frame.setSize(770, 150);
		frame.setLayout(new FlowLayout());
		frame.setLayout(new BorderLayout());
		frame.add(control2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
}

