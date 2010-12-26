import javax.swing.*;
public class Notepad extends JFrame 
{
	static public boolean s;
	static public boolean sf;
	public txtData d;
	MyMenu m;
	class txtData extends JTextArea
	{
		txtData()
		{
			super();
		}
	}
	Notepad()
	{
		super("Jnotepad++");
		setSize(400, 400);
		d= new txtData();
		m=new MyMenu(d);
		HNotepad hn= new HNotepad();
		addWindowListener(hn);
		setJMenuBar(m);
		add(d);
		setVisible(true);
	}
	public JTextArea getTxtField()
	{
		return d;
	}
	static
	{
		s=true;
		sf=false;
	}
}
