package visual;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import logical.ControladorDB;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Album extends JDialog{
	private JPanel panel = new JPanel();
	private JTextField titulo_album;
	private JTextField lanzamiento_album;
	private JTextField precio_album;
	private JTextField txt_genero;
	
	public static void main(String[] args) {
		try {
			Album dialog = new Album();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			ControladorDB.getInstance();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public Album() {
		setTitle("Registrar Album");
		setBounds(100, 100, 404, 401);
		setLocationRelativeTo(null);
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 376, 362);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Registrar nuevo Album");
		panel_1.setBorder(new TitledBorder(null, "Create new album", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 355, 339);
		panel.add(panel_1);
		
		titulo_album = new JTextField();
		titulo_album.setColumns(10);
		titulo_album.setBounds(124, 30, 147, 20);
		panel_1.add(titulo_album);
		
		JLabel label = new JLabel("T\u00EDtulo album:");
		label.setBounds(46, 33, 68, 14);
		panel_1.add(label);
		
		lanzamiento_album = new JTextField();
		lanzamiento_album.setColumns(10);
		lanzamiento_album.setBounds(164, 61, 147, 20);
		panel_1.add(lanzamiento_album);
		
		JLabel label_1 = new JLabel("Fecha de lanzamiento:");
		label_1.setBounds(46, 64, 108, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Precio:");
		label_2.setBounds(46, 95, 46, 14);
		panel_1.add(label_2);
		
		precio_album = new JTextField();
		precio_album.setColumns(10);
		precio_album.setBounds(95, 92, 86, 20);
		panel_1.add(precio_album);
		
		JLabel label_3 = new JLabel("G\u00E9nero:");
		label_3.setBounds(46, 132, 46, 14);
		panel_1.add(label_3);
		
		txt_genero = new JTextField();
		txt_genero.setColumns(10);
		txt_genero.setBounds(105, 129, 86, 20);
		panel_1.add(txt_genero);
		
		JLabel label_4 = new JLabel("$");
		label_4.setBounds(191, 95, 46, 14);
		panel_1.add(label_4);
		
		Button btn_registrar = new Button("Registrar");
		btn_registrar.setBounds(74, 296, 70, 22);
		panel_1.add(btn_registrar);
		
		Button btn_cancelar = new Button("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancelar.setBounds(225, 296, 70, 22);
		panel_1.add(btn_cancelar);
	}
}
