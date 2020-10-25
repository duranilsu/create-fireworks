Fiona Au, Nilsu Duran
netID: fau & vduran

Project 3

To use this application, use the sliders to decide what angle, speed, and time you want. 
Then, simply press the button saying which color you would like the explosion to be.
Lastly, choose a type of explosion and click launch to see your firework trajectory and explosion.

This program was created with three classes. The Canvas class contains the main method which creates the
window for the GUI where the user can set the values, color, and type of explosion. The canvas also contains
the paint method, which sets the color and values.

The colors and values are put into the system through the GUI which is designed in the class ControlPanel2.
In this class, all the buttons and sliders are created. Then, in the actionPerformed method, the program
determines the color and type of explosion based on which button was pressed. This is done by using conditionals
and e.getSource(). Also in the actionPerformed method is the conditional for the launch button. Once this button
is pressed, a new Fireworkss object will be created and set to visible. This allows a new window to open once
the user presses launch; the new window will have firework trajectory and explosion. The stateChanged method
allows the program to change the labels in the GUI based on which value the sliders have landed on. Then, whatever
value the slider lands on last is the value that is set for the firework trajectory.

Those values get accessed by the class Fireworkss. This object is created when launch is pressed, and opens up a
window with the trajectory and explosion. The trajectory is painted in the first part of the paint method.
Graphics2D is imported so that we can transform the graph so that (0,0) is at the bottom left corner. Then, the
trajectory is drawn by drawing many small circles that each have very little space in between them which makes the
final product look like a curved line. Then, the explosions are drawn based on what type the user picked.

EXTRA CREDIT part: After initial explosion, firework types B and C break into two trajectories with smaller explosions.
For best results, set angle to above 50 degrees and speed higher than 60 m/s.