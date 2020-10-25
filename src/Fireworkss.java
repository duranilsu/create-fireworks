/*
 * Nilsu Duran and Fiona Au
 * netID: vduran & fau
 * TR 1105 - 1220
 * Project 3 - Fireworks!
 * We did not collaborate with anyone else on this assignment.
 */
//importing classes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;

//declaring class Fireworkss which extends JFrame. Drawing happens here
public class Fireworkss extends JFrame {
	//serializing
	private static final long serialVersionUID = 1L;
	//declaring variables (that we get from ControlPanel2) and JFrame-Canvas objects
	JFrame frame2 =  new JFrame();
	Canvas canvas2 =  new Canvas();
	int speed = ControlPanel2.getSpeedVal();
	int time = ControlPanel2.getTimeVal();
	int angle = ControlPanel2.getAngleVal();
	char type = ControlPanel2.getType();
	Color color = ControlPanel2.getColor();
	
	//Class constructor
	public Fireworkss() {
		super("Fireworks");
		frame2.add(canvas2);
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
	}
	
	//Paint method
	public void paint(Graphics g) {
	    	super.paint(g);
	    	Graphics2D g2d = (Graphics2D) g;
		     // saving the "old" transform
		    AffineTransform old = g2d.getTransform();
		     //using transform to set the origin to the lower left corner
		    g2d.translate(0, getHeight() - 1);
		    g2d.scale(1, -1);
		    	//drawing firework trajectory using for loop
			    for (double i = 0; i < time; i+=0.01) {
			     	double p = speed * Math.cos(Math.toRadians(angle))*i;
			     	double o = (p * Math.tan(Math.toRadians(angle)) - ((9.8 * p * p) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
					int a = (int) Math.round(p);
					int b = (int) Math.round(o);
					g2d.fillOval(a, b, 5, 5);
					g2d.setColor(color);	
			    }
			    //getting firework's x and y coordinates for drawing explosions
			    double u = speed * Math.cos(Math.toRadians(angle))*time;
			    double v = (u * Math.tan(Math.toRadians(angle)) - ((9.8 * u * u) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
		    
		    //drawing 5 different explosion types using transformations, rotations, etc.
		    if (type == 'A') {
		    		//squares explosion
			    	g2d.fillRect((int)u-15, (int)v-15, 50, 50);        
	    			g2d.drawRect((int)u-40, (int)v-40, 100, 100);
	    			g2d.rotate(Math.toRadians(45), (int)u + 100/2, (int)v + 100/2);
	    			g2d.drawRect((int)u-55, (int)v+2, 100, 100);
	    	  	
		    } else if (type == 'B') {
		    		//circles explosion
			    	g2d.fillOval((int)u-5, (int)v-5, 20, 20);
				    g2d.drawOval((int)u-15, (int)v-15, 40, 40);
				    g2d.drawOval((int)u-25, (int)v-25, 60, 60);
				    g2d.drawOval((int)u-35, (int)v-35, 80, 80);
				    g2d.drawOval((int)u-55, (int)v-55, 120, 120);
				    g2d.drawOval((int)u-75, (int)v-75, 160, 160);
				    g2d.translate((int)u, (int)v);
				    
					    //(extra credit) - this type divides into two smaller trajectories
				    	for (double extra = 0; extra < time*1.5; extra+=0.01) {
					     	double am = speed * Math.cos(Math.toRadians(angle))*extra;
					     	double l = (am * Math.tan(Math.toRadians(angle)) - ((9.8 * am * am) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
					     	double af = (speed+16)* Math.cos(Math.toRadians(angle+30))*extra;
					     	double lf = (af * Math.tan(Math.toRadians(angle+30)) - ((9.8 * af * af) / (2 * ((speed+16)* (Math.cos(Math.toRadians(angle+30))) * ((speed+16) * (Math.cos(Math.toRadians(angle+30))))))));
					     	g2d.fillOval((int)am, (int)l, 3, 3);
					     	g2d.fillOval((int)af, (int)lf, 3, 3);
							g2d.setColor(color);	
				    	}
				    	//smaller trajectories' xy coordinates
				    	double ma = speed * Math.cos(Math.toRadians(angle))*time*1.5;
				     	double la = (ma * Math.tan(Math.toRadians(angle)) - ((9.8 * ma * ma) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
				     	double fa = (speed+16) * Math.cos(Math.toRadians(angle+30))*time*1.5;
				     	double fl = (fa * Math.tan(Math.toRadians(angle+30)) - ((9.8 * fa * fa) / (2 * ((speed+16) * (Math.cos(Math.toRadians(angle+30))) * ((speed+16) * (Math.cos(Math.toRadians(angle+30))))))));
					    //and their smaller explosions
				     	g2d.drawOval((int)ma-3, (int)la-5, 10, 10);
					    g2d.drawOval((int)ma-8, (int)la-10, 20, 20);
					    g2d.drawOval((int)ma-18, (int)la-20, 40, 40);
					    g2d.drawOval((int)ma-28, (int)la-30, 60, 60);
					    
					    g2d.drawOval((int)fa-5, (int)fl-3, 10, 10);
					    g2d.drawOval((int)fa-10, (int)fl-8, 20, 20);
					    g2d.drawOval((int)fa-20, (int)fl-20, 40, 40);
					    g2d.drawOval((int)fa-30, (int)fl-30, 60, 60);	     
			     
		    } else if (type == 'C') {
		    		//star explosion
        			g2d.fillOval((int)u-5, (int)v-5, 20, 20);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);
    			    g2d.rotate(Math.toRadians(45), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawLine((int)u-60, (int)v-60, (int)u-10, (int)v-10);   
    			    g2d.translate((int)u, (int)v);
    			    
	    			    //(extra credit) - this type also divides into two smaller trajectories
				    	for (double extra = 0; extra < time*1.5; extra+=0.01) {
					     	double am = speed * Math.cos(Math.toRadians(angle))*extra;
					     	double l = (am * Math.tan(Math.toRadians(angle)) - ((9.8 * am * am) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
					     	double af = (speed)* Math.cos(Math.toRadians(angle+30))*extra;
					     	double lf = (af * Math.tan(Math.toRadians(angle+30)) - ((9.8 * af * af) / (2 * ((speed)* (Math.cos(Math.toRadians(angle+30))) * ((speed) * (Math.cos(Math.toRadians(angle+30))))))));
					     	g2d.fillOval((int)am, (int)l, 3, 3);
					     	g2d.fillOval((int)af, (int)lf, 3, 3);
							g2d.setColor(color);	
				    	}
				    	//smaller trajectories' xy coordinates
				    	double ma = speed * Math.cos(Math.toRadians(angle))*time*1.5;
				     	double la = (ma * Math.tan(Math.toRadians(angle)) - ((9.8 * ma * ma) / (2 * (speed * (Math.cos(Math.toRadians(angle))) * (speed * (Math.cos(Math.toRadians(angle))))))));
				     	double fa = (speed) * Math.cos(Math.toRadians(angle+30))*time*1.5;
				     	double fl = (fa * Math.tan(Math.toRadians(angle+30)) - ((9.8 * fa * fa) / (2 * ((speed) * (Math.cos(Math.toRadians(angle+30))) * ((speed) * (Math.cos(Math.toRadians(angle+30))))))));
				     	//and their smaller explosions
				     	g2d.fillOval((int)ma, (int)la, 10, 10);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    g2d.drawLine((int)ma-30, (int)la-45, (int)ma-10, (int)la-10);
	    			    g2d.rotate(Math.toRadians(45), (int)ma-45 + 100/2, (int)la-45 + 100/2);
	    			    
	    			    g2d.fillOval((int)fa-3, (int)fl, 10, 10);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			    g2d.rotate(Math.toRadians(45), (int)fa-45 + 100/2, (int)fl-45 + 100/2);
	    			    g2d.drawLine((int)fa-30, (int)fl-45, (int)fa-10, (int)fl-10);
	    			  
    			    	 		
		    } else if (type == 'D') {
		    		//dandelion explosion		
    				g2d.fillOval((int)u-5, (int)v-5, 20, 20);
    				g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
    			    g2d.rotate(Math.toRadians(25), (int)u-45 + 100/2, (int)v-45 + 100/2);
    			    g2d.drawOval((int)u-40, (int)v-40, 80, 20);
			        			    
		    } else if (type == 'E') {
			    		//smiley face explosion
						g2d.drawOval((int)u-75, (int)v-75, 160, 160);
				    	g2d.fillOval((int)u-45, (int)v+25, 25, 25);
				    	g2d.fillOval((int)u+30, (int)v+25, 25, 25);
				    	g2d.fillOval((int)u-5, (int)v-5, 15, 15);
				    	int a = (int) u;
						int b = (int) (v-50);
						g2d.drawArc(a-45, b, 100, 200, 50, 80);
						g2d.rotate(Math.toRadians(180), a + 100/2, b + 100/2);
					    }
				   
	     // restore the old transform
	     g2d.setTransform(old);
	     
	 }
}






