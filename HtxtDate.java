import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class HtxtDate extends KeyAdapter
{
	private Notepad.txtData data;
	HtxtDate(Notepad.txtData p)
	{
		data=p;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyTyped(e);
		Notepad.s=false;
	}
}
