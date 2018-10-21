import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame {
	JFrame mainFrame;
	JLabel label;
	JButton openBt;
	
	public MainFrame(){
		initComponent();
	}
	
	public void initComponent(){
		mainFrame = new JFrame("Frame 1");
		mainFrame.setSize(300, 300);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(),BoxLayout.PAGE_AXIS));
		
		label = new JLabel("Frame 1");
		mainFrame.add(label);
		
		openBt = new JButton("Click");
		openBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SecondFrame().secondFrame.setVisible(true);
				
			}
		});
		mainFrame.add(openBt);
		
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}


}