import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class HMyMenu implements ActionListener
{
	
	MyMenu o;
	JTextArea d;
	JFileChooser jf;
	Notepad n;
	HMyMenu(JTextArea s,Notepad n,MyMenu m)
	{
		o=m;
		d=s;
		this.n=n;
		jf=new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		jf.addChoosableFileFilter(new FileNameExtensionFilter("Java(tm) Sources", "java"));
		jf.addChoosableFileFilter(new FileNameExtensionFilter("C/C++", "c", "cpp", "C","h","hxx","hpp"));
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if(e.getSource()==o.f_mi[o.FILE_NEW])
		{
			if(!Notepad.s)
			{
				save();
			}
			init();
		}
		else if(e.getSource()==o.f_mi[o.FILE_OPEN])
		{
			open();
		}
		else if(e.getSource()==o.f_mi[o.FILE_SAVE])
		{
			System.out.println("f_save");
			save();
		}
		else if(e.getSource()==o.f_mi[o.FILE_SAVE_AS])
		{
			System.out.println("f_save_as");
			saveas();
		}
		else if(e.getSource()==o.f_mi[o.FILE_EXIT])
		{
			System.exit(0);
		}
		else if(e.getSource()==o.e_mi[o.EDIT_CUT])
		{
			d.cut();
		}
		else if(e.getSource()==o.e_mi[o.EDIT_COPY])
		{
			d.copy();
		}
		else if(e.getSource()==o.e_mi[o.EDIT_PASTE])
		{
			d.paste();
		}
		else if(e.getSource()==o.e_mi[o.EDIT_FIND])
		{
			find();
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
			color();
		}
		else if(e.getSource()==o.for_fo[o.FORMAT_FONT_CHOOSE])
		{
			font();
		}
		//else if(e.getSource()==o.for_fo[])
	}
	void save()
	{
		if(!Notepad.s && !Notepad.sf)
		{
			System.out.println("f_save");
			if (!Notepad.sf)
			{
				if(JFileChooser.APPROVE_OPTION==jf.showSaveDialog(null));
				//write code to select file
			}
				//save contents to either this file or specified new file
				//write code to write data to file here...
				try
				{
					FileWriter rd=new FileWriter(jf.getSelectedFile());
					BufferedWriter brd=new BufferedWriter(rd);
					brd.write(d.getText());	
					brd.flush();
					brd.close();
				}
				catch(IOException e)
				{}
				Notepad.sf=true;
				Notepad.s=true;
		}
		n.setTitle(jf.getSelectedFile().getName()+"    -    Jnotepad++");
	}
	
	void saveas()
	{

			System.out.println("f_save_as");

				if(JFileChooser.APPROVE_OPTION==jf.showSaveDialog(null));
				//write code to select file
				
				Notepad.sf=true;
				Notepad.s=true;
		n.setTitle(jf.getSelectedFile().getName()+"    -    Jnotepad++");
	}
	
	private void init()
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
	private void open()
	{
		System.out.println("f_open");
		if(JFileChooser.APPROVE_OPTION==jf.showOpenDialog(o))
		{
			try
			{
				FileReader rd=new FileReader(jf.getSelectedFile());
				BufferedReader brd=new BufferedReader(rd);
				String s;
				while((s=brd.readLine())!=null)
				{
					d.append(s+"\n");
				}
				brd.close();
			}
			catch(IOException e)
			{}
			
		}
		Notepad.sf=false;
		n.setTitle(jf.getSelectedFile().getName()+"    -    Jnotepad++");
	}
	private void find()
	{
		String s= JOptionPane.showInputDialog(null, "enter string to find");
		int c=d.getText().indexOf(s);
		d.setCaretPosition(c);
		d.setSelectionStart(c);
		d.setSelectionEnd(c+s.length());
		d.setSelectionColor(Color.orange);
		/*
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
		}	*/

	}
	private void color()
	{
		Color c=new Color(255,255,255);
		c=JColorChooser.showDialog(null, "choose color u like", c);
		if(c==null)
			return;
		else
			d.setForeground(c);
	}
	private void font()
	{
		d.setFont(JFontChooser.showDialog(n,"choose font u like",d.getFont()));
	}
}