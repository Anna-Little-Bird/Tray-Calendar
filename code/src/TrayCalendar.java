import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrayCalendar
{
	public static void main(String[] args)	// main method
	{
		JFrame frame = new JFrame("Calendar");	// creating Calendar's main window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// setting the CLOSE button to clote the program
		frame.setSize(200, 200);				// window size
		JButton Button1=new JButton("1");		// adding the Button
		frame.add(Button1);
		frame.setLayout(new FlowLayout());		// might change to GridLayout?
		frame.setVisible(true);
		Button1.addActionListener(new ActionListener()		// adding some interaction to the Button 
		{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()== Button1) {				// when the Button is clicked
					frame.add(new DayTask());				// open a new window
				}	
			}		
		});
	}
}

class DayTask extends JComponent
{
	JFrame task;
	JTextField taskName;
	JTextArea taskText;
	JLabel labelName,labelText;
	
	public DayTask() {					// playing with the window appearance
		task=new JFrame("1");
		task.setSize(350, 150);
		taskName=new JTextField("");
		taskText=new JTextArea("");
		labelName=new JLabel("Name:");
		labelText=new JLabel("<html>Task<br>Description:</html>");
		labelText.setVerticalAlignment(JLabel.TOP);
		task.add(taskName);
		task.add(taskText);
		task.add(labelName);
		task.add(labelText);
		task.setLayout(null);
		Insets insets = task.getInsets();
		labelName.setBounds(25+insets.left,5+insets.top,50,20);
		taskName.setBounds(100+insets.left,5+insets.top,100,20);
		labelText.setBounds(25+insets.left,55+insets.top,70,50);
		taskText.setBounds(100+insets.left,55+insets.top,70,50);
		task.setVisible(true);
	}
}