import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HJFontChooser implements ActionListener 
{
	JFontChooser fc;
	Notepad n;
	Font fnt;
	public HJFontChooser(JFontChooser chr,Notepad n)
	{
		fc=chr;
		this.n=n;
	}
	public void actionPerformed(ActionEvent e) 
	{
		int a=Font.PLAIN;
		Font f;
		if(e.getSource()==fc.fnt || e.getSource()==fc.fsz || e.getSource()==fc.fsty || e.getSource()==fc.pre)
		{
			
			if(((String)fc.fsty.getSelectedItem()).startsWith("B"))
			{
				a=Font.BOLD;
			}
			else if(((String)fc.fsty.getSelectedItem()).startsWith("I"))
			{
				a=Font.ITALIC;
			}
			f=new Font((String)fc.fnt.getSelectedItem(),a,((Integer)fc.fsz.getSelectedItem()).intValue());
			fc.txtxt.setFont(f);
		}
		else
		{
			f=new Font((String)fc.fnt.getSelectedItem(),a,((Integer)fc.fsz.getSelectedItem()).intValue());
			fc.txtxt.setFont(f);
			n.d.setFont(f);
			fc.dispose();
		}
	}	
}