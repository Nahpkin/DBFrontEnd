import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame implements ActionListener{

	JButton button;
	JLabel UserNameText;
	JLabel PassWordText;
	
	MyFrame(){
		 
		UserNameText = new JLabel();
		UserNameText.setText("Username");
		UserNameText.setBounds(100,100,250,250);
		UserNameText.setVisible(false);
		
		PassWordText = new JLabel();
		PassWordText.setText("Password");
		PassWordText.setVerticalAlignment(JLabel.CENTER);
		PassWordText.setHorizontalAlignment(JLabel.LEFT);
		PassWordText.setVisible(true);
		
		button = new JButton();
		button.setBounds(200, 100, 100, 50);
		button.addActionListener(this);
		button.setText("Clear");
		button.setFocusable(true);
		
		//Initialize JFrame 
		/*this.setTitle("MyJFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(600,600);
		this.setVisible(true);*/
		initialize(this);
		
		this.add(button);
		this.add(UserNameText);
		this.add(PassWordText);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("poo");
		}
		
	}
	
	public MyFrame initialize(MyFrame MyJFrame) {
		this.setTitle("MyJFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(600,600);
		this.setVisible(true);
		return MyJFrame;
	}

}
