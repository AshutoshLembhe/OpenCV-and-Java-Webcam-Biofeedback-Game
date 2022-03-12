package swing.windows;
import java.awt.GridLayout;//grid layout library.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;//GUI library.
import javax.swing.JLabel;//label library for jlabel.
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Inheriting jframe.
class Framewindows extends JFrame{
	//constructor.
	JLabel labelmessage;
	JTextField txtfieldoutput;
	JButton button;
	JPanel p1,p2,p3;
	public Framewindows(String title) {
		super(title);
		setSize(480,240);
		setLayout(new GridLayout(3,1,5,5));// rows,columns,horizontal gap, vertical gap.
		
		labelmessage = new JLabel("Windows GUI");//calling constructor created for object above.
		txtfieldoutput= new JTextField(20);
		button=new JButton("click");
		
		p1=new JPanel();//calling constructor created for object above.
		p2=new JPanel();
		p3=new JPanel();
		
		p1.add(labelmessage);//adding label to panel.
		p2.add(txtfieldoutput);
		p3.add(button);
		
		add(p1);//adding panel to window frame.
		add(p2);
		add(p3);
		
		button.addActionListener(new ButtonHandler());// adding the below function to the panel for action.
	}
	//outside constructor.
	class ButtonHandler implements ActionListener{

		@Override//overriding the below method which is inherited from Action listener. Only for compiler.
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button) {
				JOptionPane.showMessageDialog(null,"Hello "+txtfieldoutput.getText());
				labelmessage.setText("Hello "+txtfieldoutput.getText());//changes main window name as text is entered and clicked.
			}
			
		}
		
	}
}

public class Swingwindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Framewindows fw=new Framewindows("Windows GUI");
		fw.setVisible(true);//show GUI window.

	}

}
