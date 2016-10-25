package fenetre;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import carte.Carte;

public class NetHackFrame extends JFrame{

	  private JPanel pan = new JPanel();
	  private JTextArea area = new JTextArea(24,80);
	  private JTextField field = new JTextField(80);
	  private Carte carte = new Carte();
	
	public NetHackFrame(){
	    this.setTitle("NetHack");
	    this.setSize(600, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    area.setText(carte.afficher());
	    area.setFont(new Font("monospaced", Font.PLAIN, 12));
	    field.setFont(new Font("monospaced", Font.PLAIN, 12));
	    pan.add(area);
	    pan.add(field);
	    this.setContentPane(pan);
	    this.setVisible(true);
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetHackFrame n = new NetHackFrame();
	}

}
