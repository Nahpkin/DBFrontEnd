import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		
		MyFrame MyFrame = new MyFrame();
		JLabel label = new JLabel();
		label.setText("SQLDatabase");
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		
		MyFrame.add(label);
		
	}
}
