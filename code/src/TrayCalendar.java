import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;

public class TrayCalendar
{	
	public static void main(String[] args)	// main method
	{
		JFrame frame = new JFrame("Tray Calendar");	// creating Calendar's main window
		MainWindow mainwindow=new MainWindow();
		frame.add(mainwindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// setting the CLOSE button to close the program
		frame.setSize(350, 350);					// window size
		frame.setVisible(true);
	}
}

class MainWindow extends JComponent implements ActionListener
{
	int i,days;
	JButton [] buttons;
		
	public MainWindow()
	{
		int month;
		Calendar now=Calendar.getInstance();		// getting the number of days of this month
		month=now.get(Calendar.MONTH);
		switch (month)
		{
			case 0: case 2: case 4: case 6: case 7: case 9: case 11: 
				days=31;
				break;
			case 3: case 5: case 8: case 10:
				days=30;
				break;
			case 1:
				days=28;		// LEAP YEAR!!!
				break;
		}
		setLayout(new GridLayout(0,7));			// setting the layout
		buttons=new JButton[days];				// initializing array 
		for (int i=0;i<days;i++)
		{
			buttons[i]=new JButton(Integer.toString(i+1));
			add(buttons[i]);					// adding buttons to the frame
			buttons[i].addActionListener(this);	// adding ActionListener
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		for (i=0;i<days;i++)
		{
			if (e.getSource()== buttons[i])					// when the Button is clicked
			{				
				add(new DayTask(Integer.toString(i+1)));	// open a new window
			}
		}
	}
}

class DayTask extends JComponent
{
	JFrame task;
	JTextField taskName;
	JTextArea taskText;
	JLabel labelName,labelText;
	JButton save,clear;

	
	public DayTask(String number)
	{							// playing with the window appearance
	
		task=new JFrame(number);
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