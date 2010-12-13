package test;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;

public class ImagenImpl extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private BorderLayout bl;

	private JLabel jLabelImagen = null;
	
	public ImagenImpl() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(507, 233);
		this.setContentPane(getJContentPane());
		this.setTitle("Imagen");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			bl = new BorderLayout();
			jContentPane.setLayout(bl);
			jContentPane.add(getJPanel(), bl.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			
			jLabelImagen = new JLabel(new ImageIcon(System.getProperty("user.dir")+"/circustrain/data/Tablero.jpg"),
		    		JLabel.CENTER);
			jLabelImagen.setVisible(false);
			jLabelImagen.setBounds(new Rectangle(4, 2, 495, 183));
		}
		return jPanel;
	}
}
