import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrayCalendar
implements ActionListener
{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Calendar");
		//frame.add(new HelloComponent("Hello, Java!"));
		///for 
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

/*class HelloComponent extends JComponent
	implements MouseMotionListener, ActionListener
{
	String theMessage;
	int messageX=125, messageY=95;

	JButton theButton;
	
	int colorIndex;
	static Color[] someColors={Color.BLACK,Color.red,Color.GREEN,Color.blue,Color.magenta};
	
	public HelloComponent(String message) {
		theMessage=message;
		theButton=new JButton("Change Color");
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.drawString(theMessage, messageX, messageY);
	}
	
	public void mouseDragged(MouseEvent e) {
		messageX=e.getX();
		messageY=e.getY();
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==theButton)
			changeColor();
	}
	
	synchronized private void changeColor() {
		if (++colorIndex==someColors.length)
			colorIndex=0;
		setForeground(currentColor());
		repaint();
	}
	
	synchronized private Color currentColor() {
		return someColors[colorIndex];
	}
}*/