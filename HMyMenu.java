import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class HMyMenu implements ActionListener
{
	
	MyMenu o;
	JTextArea d;
	JFileChooser jf;
	HMyMenu(MyMenu m,JTextArea s)
	{
		o=m;
		d=s;
		jf=new JFileChooser();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if(e.getSource()==o.f_mi[o.FILE_NEW])
		{
			System.out.println("new");
			if((!Notepad.s) && (!d.getText().equals("")))
			{
				int i=JOptionPane.showConfirmDialog(null, "do you want to save changes", "Warninig!\nnpp++", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					return;
				}
				else if(i==JOptionPane.YES_OPTION)
				{
					save();
				}
				else
				{
					d.setText("");
				}
			}
		}
		else if(e.getSource()==o.f_mi[o.FILE_OPEN])
		{
			open();
		}
		else if(e.getSource()==o.f_mi[o.FILE_SAVE])
		{
			save();
		}
		else if(e.getSource()==o.f_mi[o.FILE_EXIT])
		{
			System.exit(0);
		}
		else if(e.getSource()==o.e_mi[o.EDIT_CUT])
		{
			//cut code
		}
		else if(e.getSource()==o.e_mi[o.EDIT_COPY])
		{
			//copy code
		}
		else if(e.getSource()==o.e_mi[o.EDIT_PASTE])
		{
			//paste code
		}
		else if(e.getSource()==o.e_mi[o.EDIT_FIND])
		{
			//find();
			String s= JOptionPane.showInputDialog(null, "enter string to find");
			int c=d.getText().indexOf(s);
			d.setCaretPosition(c);
			d.setSelectionStart(c);
			d.setSelectionEnd(c+s.length());
			d.setSelectionColor(Color.orange);
		}
		else if(e.getSource()==o.for_cl[o.FORMAT_COLOR_RED])
		{
			d.setForeground(Color.red);
		}
		else if(e.getSource()==o.for_cl[o.FORMAT_COLOR_GREEN])
		{
			d.setForeground(Color.green);
		}
		else if(e.getSource()==o.for_cl[o.FORMAT_COLOR_BLUE])
		{
			d.setForeground(Color.blue);
		}
		else if(e.getSource()==o.for_cl[o.FORMAT_COLOR_CHOOSE])
		{
			Color c=new Color(255,255,255);
			c=JColorChooser.showDialog(null, "choose color u like", c);
			if(c==null)
				return;
			else
				d.setForeground(c);
		}
	}
	private void save()
	{
		if(!Notepad.s && Notepad.sf)
		{
			System.out.println("f_save");
				if (!Notepad.sf)
				{
					jf.showSaveDialog(null);
					//write code to select file
				}
				//save contents to either this file or specified new file
				//write code to write data to file here...
		}
	}
	private void open()
	{
		System.out.println("f_open");
		jf.showOpenDialog(o);
	}
	private void find()
	{
		//doesn't work now
		String s;
		try
		{
			s=JOptionPane.showInputDialog(null, "enter string regex is allowed");
		Pattern p=Pattern.compile(s);
		StringBuffer b= new StringBuffer(d.getText());
		Matcher m=p.matcher(b);
		if(m.matches())
		{
			d.setSelectionStart(m.start());
			System.out.println(""+m.start());
			d.setSelectionEnd(m.end());
			System.out.println(""+m.start());
			d.setSelectionColor(Color.orange);
		}
		}
		catch(NullPointerException e)
		{
			return;
		}

	}
	
}
