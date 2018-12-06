package visual;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logical.ControladorDB;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel label;
	private JTextField txt_usuario;
	private JLabel label_1;
	private JButton btn_ingresar;
	private JButton btn_cancelar;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			ControladorDB.getInstance();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public Login() {
		setTitle("Log in");
		setBounds(100, 100, 656, 401);
		setLocationRelativeTo(null);
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		label = new JLabel("Usuario:");
		label.setBounds(105, 120, 68, 14);
		getContentPane().add(label);
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setBounds(183, 117, 147, 20);
		getContentPane().add(txt_usuario);
		
		label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setBounds(105, 151, 108, 14);
		getContentPane().add(label_1);
		//
		btn_ingresar = new JButton("Ingresar");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {/*
				boolean acceso = Main.getInstance().login(txt_usuario.getText(), txt_contrasena.getText());
				String tipo ="";
				if(acceso)
				{
					tipo = Consultorio.getInstance().getTipousuario(txtCedula.getText());
					//Principal principal = new Principal(tipo);
					Principal.main(null, tipo);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrectos");
					txtClave.setText("");
					txtCedula.requestFocus();
				}
			}*/
			}
		});
		btn_ingresar.setBounds(105, 212, 89, 23);
		getContentPane().add(btn_ingresar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancelar.setBounds(256, 212, 89, 23);
		getContentPane().add(btn_cancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 148, 137, 20);
		getContentPane().add(passwordField);
	}
}
