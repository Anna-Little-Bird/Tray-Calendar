import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrayCalendar
{
	public static void main(String[] args)	// main method
	{
		JFrame frame = new JFrame("Calendar");	// creating Calendar's main window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(150, 150);
		frame.setVisible(true);
		JButton Button1=new JButton("1");
		frame.add(Button1);
		frame.setLayout(new FlowLayout());
		Button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()== Button1) {
					JFrame frame2;
					frame2=new JFrame("1");
					frame2.setSize(150, 150);
					frame2.setVisible(true);
				}	
			}		
		});
	}
}