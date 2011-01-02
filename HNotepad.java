import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class HNotepad extends WindowAdapter
{
	Notepad n;
	public HNotepad(Notepad n) {
		// TODO Auto-generated constructor stub
		this.n=n;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(!Notepad.s)
		{
			int a=JOptionPane.showConfirmDialog(null, "Do you want to save current file\nbefore exiting?", "exiting...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (a)
			{
				case JOptionPane.YES_OPTION:
				{
					n.m.hmm.save();
				}
				case JOptionPane.NO_OPTION:
				{
					exit();
				}
				case JOptionPane.CANCEL_OPTION:
				{
					return;
				}
			}
		}
	}
	void exit()
	{
		System.out.println("exiting...");
		System.exit(0);
	}
}
