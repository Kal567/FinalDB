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
import java.sql.SQLException;
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
	private JTextField txtHost;
	
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
		setBounds(100, 100, 441, 320);
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
			public void actionPerformed(ActionEvent e) {
				
				boolean acceso = false;
				/*try {
					/*acceso = ControladorDB.login(txt_usuario.getText().toString(), passwordField.getText().toString(), txtHost.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				if(acceso)
				{
					Principal principal = new Principal(txt_usuario.getText().toString());
					principal.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrectos");
					passwordField.setText("");
					passwordField.requestFocus();
				}
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
		
		txtHost = new JTextField();
		txtHost.setColumns(10);
		txtHost.setBounds(183, 86, 147, 20);
		getContentPane().add(txtHost);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(105, 89, 68, 14);
		getContentPane().add(lblHost);
	}
}
