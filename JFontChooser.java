import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.*;


public class JFontChooser extends JDialog
{
	JPanel p1,p2;
	JComboBox fnt,fsz,fsty;
	HJFontChooser hfc;
	static String fnm[];
	Font font_cur;
	JButton pre,app;
	JTextArea txtxt;
	private JFontChooser(Notepad f,String title,String Defaul_Font)
	{
		super();
		p1=new JPanel(new FlowLayout());
		p2=new JPanel(new FlowLayout());
		fnt=new JComboBox();
		hfc=new HJFontChooser(this,f);
		for(int i=0;i<(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()).length;i++)
		{
			fnt.addItem(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[i]);
		}
		fnt.addActionListener(hfc);
		fsz=new JComboBox();
		for(int i=1;i<=72;)
		{
			if(i<=15)	fsz.addItem(i++);
			else
			{
				fsz.addItem(i);
				i*=2;
			}
		}
		fsz.addActionListener(hfc);
		fsty=new JComboBox();
		fsty.addItem("BOLD");
		fsty.addItem("NORMAL");
		fsty.addItem("IItalic");
		fsty.addActionListener(hfc);
		pre=new JButton("Preview");
		pre.addActionListener(hfc);
		app=new JButton("Apply");
		app.addActionListener(hfc);
		txtxt=new JTextArea("ANGEL");
		txtxt.setEditable(false);
		p1.add(fnt);
		p1.add(fsz);
		p1.add(fsty);
		p2.add(pre);
		p2.add(app);
		add(txtxt,"Center");
		add(p1,"North");
		add(p2,"South");
		setSize(400, 250);
		setTitle(title);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static Font showDialog(Notepad f,String s,Font fo)
	{
		JFontChooser jcc=new JFontChooser(f,s,fo.getFontName());
		System.out.println(jcc.getFont().getName()+jcc.getFont().getSize()+jcc.getFont().getStyle());
//		Font ret_font=new Font(jcc.txtxt.getFont().getFamily(),jcc.txtxt.getFont().getStyle(),jcc.txtxt.getFont().getSize());
		return jcc.txtxt.getFont();
	}
}
