package visual;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.ControladorDB;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import java.awt.Button;

public class Cancion extends JDialog{
	private JPanel panel = new JPanel();
	private JTextField titulo_cancion;
	private JTextField nombre_artista;
	private JTextField txt_genero;
	private JSpinner spn_duracion;
	private JComboBox cbx_album_cancion;
	private Button btn_cancelar;
	private Button btn_registrar;
	
	public static void main(String[] args) {
		try {
			Cancion dialog = new Cancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			ControladorDB.getInstance();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public Cancion() {
		setTitle("Registrar Cancion");
		setBounds(100, 100, 656, 401);
		setLocationRelativeTo(null);
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 394, 347);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Create new Cancion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(33, 49, 343, 250);
		panel_1.add(panel_2);
		
		titulo_cancion = new JTextField();
		titulo_cancion.setColumns(10);
		titulo_cancion.setBounds(141, 30, 147, 20);
		panel_2.add(titulo_cancion);
		
		JLabel label = new JLabel("T\u00EDtulo cancion:");
		label.setBounds(46, 33, 85, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Duraci\u00F3n:");
		label_1.setBounds(46, 64, 57, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre artista:");
		label_2.setBounds(46, 95, 85, 14);
		panel_2.add(label_2);
		
		nombre_artista = new JTextField();
		nombre_artista.setColumns(10);
		nombre_artista.setBounds(129, 92, 86, 20);
		panel_2.add(nombre_artista);
		
		JLabel label_3 = new JLabel("Album:");
		label_3.setBounds(46, 132, 46, 14);
		panel_2.add(label_3);
		
		spn_duracion = new JSpinner();
		spn_duracion.setBounds(102, 61, 89, 20);
		panel_2.add(spn_duracion);
		
		cbx_album_cancion = new JComboBox();
		cbx_album_cancion.setBounds(112, 129, 117, 20);
		panel_2.add(cbx_album_cancion);
		
		JLabel label_4 = new JLabel("G\u00E9nero:");
		label_4.setBounds(46, 168, 46, 14);
		panel_2.add(label_4);
		
		btn_cancelar = new Button("Cancelar");
		btn_cancelar.setBounds(204, 207, 70, 22);
		panel_2.add(btn_cancelar);
		
		btn_registrar = new Button("Registrar");
		btn_registrar.setBounds(48, 207, 70, 22);
		panel_2.add(btn_registrar);
		
		txt_genero = new JTextField();
		txt_genero.setColumns(10);
		txt_genero.setBounds(102, 165, 86, 20);
		panel_2.add(txt_genero);
	}
}
