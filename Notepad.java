import java.awt.Font;
import javax.swing.*;
public class Notepad extends JFrame 
{
	static public boolean s;
	static public boolean sf;
	static public String clip;
	public txtData d;
	public JScrollPane sp;
	MyMenu m;
	HtxtDate htt;
	class txtData extends JTextArea
	{
		txtData()
		{
			super();
			htt=new HtxtDate(this);
			addKeyListener(htt);
			setFont(new Font("Tlwg Typist", Font.BOLD, 25));
			setResizable(true);
			setAutoscrolls(true);
		}
	}
	Notepad()
	{
		super("Jnotepad++");
		setSize(400, 400);
		d= new txtData();
		m=new MyMenu(d,this);
		sp=new JScrollPane(d);
		HNotepad hn= new HNotepad(this);
		addWindowListener(hn);
		setJMenuBar(m);
		add(sp);
		setResizable(true);
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
		clip="";
	}
}
