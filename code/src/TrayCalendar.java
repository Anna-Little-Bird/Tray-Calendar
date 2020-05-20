import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TrayCalendar
{
	public static void main(String[] args)	// main method
	{
		JFrame frame = new JFrame("Calendar");	// creating Calendar's main window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// setting the CLOSE button to close the program
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
	JButton save,clear;

	
	public DayTask()
	{							// playing with the window appearance
		task=new JFrame("1");
		task.setSize(350, 250);
		task.setLayout(null);
		task.setVisible(true);
		Insets insets = task.getInsets();
		
		taskName=new JTextField();
		taskName.setBounds(100+insets.left,5+insets.top,100,20);
		task.add(taskName);
		
		taskText=new JTextArea();
		taskText.setBounds(100+insets.left,55+insets.top,70,50);
		task.add(taskText);
		
		labelName=new JLabel("Name:");
		labelName.setBounds(25+insets.left,5+insets.top,50,20);
		task.add(labelName);
		
		labelText=new JLabel("<html>Task<br>Description:</html>");
		labelText.setVerticalAlignment(JLabel.TOP);
		labelText.setBounds(25+insets.left,55+insets.top,70,50);
		task.add(labelText);
		
		save=new JButton("Save");
		save.setBounds(25+insets.left,110+insets.top,100,50);
		task.add(save);
		
		clear=new JButton("Clear");
		clear.setBounds(150+insets.left,110+insets.top,100,50);
		task.add(clear);
		
		File out=new File("/out.txt");		// creating a new file
		String s;

		if (!out.exists()||!out.canRead())	// if the file doesn't exists just print the error message
		{
			System.out.println("Cannot read the file");
			return;
		}
		
		try
		{
			FileReader fr=new FileReader(out);			// creating a file stream
			BufferedReader br=new BufferedReader(fr);	// wrapping buffered stream around fr
			while ((s=br.readLine())!=null)				// read until the end of the file
			{
				if (s.equals("1"))						// checking the contents of the file to fill in the fields
				{
					s=br.readLine();
					taskName.setText(s);
					s=br.readLine();
					taskText.setText(s);
				}
			}
			br.close();									// close the file stream
		} catch (FileNotFoundException fnf)				// handling the exceptions
		{
			System.out.println("Cannot find the file");
		}
		catch (IOException ioe)
		{
			System.out.println("Something went wrong!");
		}
		
		save.addActionListener(new ActionListener()		// saving the file
		{												// !!!think on the format of the .txt file!!!
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource()== save)
				{
					try
					{
						FileWriter fw=new FileWriter(out);		// writing the data from the fields into the file
						PrintWriter pw=new PrintWriter(fw);
						pw.println("1");
						pw.println(taskName.getText());
						pw.println(taskText.getText());
						pw.close();								// closing the file
					} catch (IOException ioe)					// handling?? the exception
					{
						// do something!
					}
				}
			}				
		});
		
		clear.addActionListener(new ActionListener()			// clear the file
		{
			public void actionPerformed(ActionEvent l)
			{
				if (l.getSource()==clear)
				{
					// do something!
				}
			}
		});
	}
}