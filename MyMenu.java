import javax.swing.*;

public class MyMenu extends JMenuBar 
{
	public JMenuBar m;						//menubar
	public JMenu me[];						//menuelement
	
	public JMenuItem f_mi[];				//file menu items
	public JMenuItem e_mi[];				//edit menu items
	public JMenu for_m[];					//format menu items
	
	public JMenuItem for_cl[];				//format color
	public JMenuItem for_fo[];				//format fonts
	
	public final int FORMAT_COLOR=0;
	public final int FORMAT_FONT=1;
	
	public final int FORMAT_COLOR_RED=0;
	public final int FORMAT_COLOR_GREEN=1;
	public final int FORMAT_COLOR_BLUE=2;
	public final int FORMAT_COLOR_CHOOSE=3;
	
	public final int FILE_NEW=0;
	public final int FILE_OPEN=1;
	public final int FILE_SAVE=2;
	public final int FILE_SAVE_AS=3;
	public final int FILE_PRINT=4;
	public final int FILE_EXIT=5;
	
	public final int EDIT_CUT=0;
	public final int EDIT_COPY=1;
	public final int EDIT_PASTE=2;
	public final int EDIT_FIND=3;
	public final int EDIT_FORMAT=4;
	
	public final int Menu_FILE=0;
	public final int Menu_EDIT=1;
	public final int Menu_FORMAT=2;
	public MyMenu(JTextArea t)
	{
		super();									//menubar initialised
		HMyMenu hmm=new HMyMenu(this,t);			//handles menubar events sending this and text area
		me = new JMenu[Menu_FORMAT+1];							//menubar has 3 elements 
		
		me[Menu_FILE]=new JMenu("File");			//0th is file
			add(me[Menu_FILE]);						//adding to menubar 
			me[Menu_EDIT]=new JMenu("Edit");		//1th is edit
			add(me[Menu_EDIT]);						
			me[Menu_FORMAT]=new JMenu("Format");	//2nd is format
			add(me[Menu_FORMAT]);
		
		f_mi =new JMenuItem[FILE_EXIT +1];					
			f_mi[FILE_NEW]=new JMenuItem("new");
			me[Menu_FILE].add(f_mi[FILE_NEW]);
			f_mi[FILE_OPEN]=new JMenuItem("open...");
			me[Menu_FILE].add(f_mi[FILE_OPEN]);
			f_mi[FILE_SAVE]=new JMenuItem("save...");
			me[Menu_FILE].add(f_mi[FILE_SAVE]);
			f_mi[FILE_SAVE_AS]=new JMenuItem("save as...");
			me[Menu_FILE].add(f_mi[FILE_SAVE_AS]);
			f_mi[FILE_PRINT]=new JMenuItem("print");
			me[Menu_FILE].add(f_mi[FILE_PRINT]);
			f_mi[FILE_EXIT]=new JMenuItem("Exit");
			me[Menu_FILE].add(f_mi[FILE_EXIT]);	
			
		
		
		e_mi =new JMenuItem[EDIT_FIND+1];
			e_mi[EDIT_CUT]=new JMenuItem("Cut");
			me[Menu_EDIT].add(e_mi[EDIT_CUT]);
			e_mi[EDIT_COPY]=new JMenuItem("Copy");
			me[Menu_EDIT].add(e_mi[EDIT_COPY]);
			e_mi[EDIT_PASTE]=new JMenuItem("Paste");
			me[Menu_EDIT].add(e_mi[EDIT_PASTE]);
			e_mi[EDIT_FIND]=new JMenuItem("Find");
			me[Menu_EDIT].add(e_mi[EDIT_FIND]);
			
		for_m=new JMenu[FORMAT_FONT+1];
			for_m[FORMAT_COLOR]=new JMenu("color");
			me[Menu_FORMAT].add(for_m[FORMAT_COLOR]);
			for_m[FORMAT_FONT]=new JMenu("font");
			me[Menu_FORMAT].add(for_m[FORMAT_FONT]);
			
			for_cl=new JMenuItem[FORMAT_COLOR_CHOOSE+1];
				for_cl[FORMAT_COLOR_RED]=new JMenuItem("Red");
				for_m[FORMAT_COLOR].add(for_cl[FORMAT_COLOR_RED]);
				for_cl[FORMAT_COLOR_GREEN]=new JMenuItem("Green");
				for_m[FORMAT_COLOR].add(for_cl[FORMAT_COLOR_GREEN]);
				for_cl[FORMAT_COLOR_BLUE]=new JMenuItem("Blue");
				for_m[FORMAT_COLOR].add(for_cl[FORMAT_COLOR_BLUE]);
				for_cl[FORMAT_COLOR_CHOOSE]=new JMenuItem("Choose...");
				for_m[FORMAT_COLOR].add(for_cl[FORMAT_COLOR_CHOOSE]);
			
		
		for(int i=0;i<me.length;i++)
		{
			me[i].addActionListener(hmm);
		}
		for(int i=0;i<f_mi.length;i++)
		{
			f_mi[i].addActionListener(hmm);
		}
		for(int i=0;i<e_mi.length;i++)
		{
			e_mi[i].addActionListener(hmm);
		}
		for(int i=0;i<for_cl.length;i++)
		{
			for_cl[i].addActionListener(hmm);
		}
	}
}
