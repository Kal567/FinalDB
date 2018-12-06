package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.ControladorDB;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtSNombre;
	private JTextField txtApellido;
	private JTextField txtSApellido;
	private JTextField txtNombreUsuario;
	private JPasswordField pswContrasenia;
	private JPasswordField pswConfirmacion;
	private JTextField txtNombreArtistico;
	private JTextField txtRol;
	private JComboBox cbxCiudadNacimiento;
	private JComboBox cbxDia;
	private JComboBox cbxMes;
	private JComboBox cbxAnio;
	private JComboBox cbxSexo;
	private JRadioButton rdbtnArtista;
	private JRadioButton rdbtnUsuario;
	private JComboBox cbxGrupo;
	private JCheckBox chckbxGrupo;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txt_id_usuario;
	private JLabel lblId;
	private JTextField txt_email;
	private JLabel lblEmail;
	private JTextField txt_id_artista;
	private JLabel lblIdArtista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona() {
		setBounds(100, 100, 905, 656);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPersona.setBounds(71, 47, 737, 526);
		contentPanel.add(panelPersona);
		panelPersona.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(54, 28, 56, 16);
		panelPersona.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(54, 51, 116, 22);
		panelPersona.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Segundo Nombre:");
		lblNewLabel.setBounds(224, 28, 116, 16);
		panelPersona.add(lblNewLabel);
		
		txtSNombre = new JTextField();
		txtSNombre.setBounds(224, 51, 116, 22);
		panelPersona.add(txtSNombre);
		txtSNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(383, 28, 56, 16);
		panelPersona.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(383, 51, 116, 22);
		panelPersona.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setBounds(552, 28, 104, 16);
		panelPersona.add(lblSegundoApellido);
		
		txtSApellido = new JTextField();
		txtSApellido.setBounds(552, 51, 116, 22);
		panelPersona.add(txtSApellido);
		txtSApellido.setColumns(10);
		
		cbxCiudadNacimiento = new JComboBox();
		cbxCiudadNacimiento.setBounds(54, 129, 122, 22);
		panelPersona.add(cbxCiudadNacimiento);
		
		JLabel lblCiudad = new JLabel("Ciudad de nacimiento:");
		lblCiudad.setBounds(54, 100, 159, 16);
		panelPersona.add(lblCiudad);
		
		cbxDia = new JComboBox();
		cbxDia.setBounds(224, 129, 31, 22);
		panelPersona.add(cbxDia);
		
		cbxMes = new JComboBox();
		cbxMes.setBounds(267, 129, 31, 22);
		panelPersona.add(cbxMes);
		
		cbxAnio = new JComboBox();
		cbxAnio.setBounds(310, 129, 56, 22);
		panelPersona.add(cbxAnio);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(224, 100, 159, 16);
		panelPersona.add(lblFechaDeNacimiento);
		
		cbxSexo = new JComboBox();
		cbxSexo.setBounds(437, 129, 31, 22);
		panelPersona.add(cbxSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(431, 100, 56, 16);
		panelPersona.add(lblSexo);
		
		rdbtnArtista = new JRadioButton("Artista");
		rdbtnArtista.setBounds(383, 200, 127, 25);
		panelPersona.add(rdbtnArtista);
		
		rdbtnUsuario = new JRadioButton("Usuario");
		rdbtnUsuario.setBounds(54, 200, 127, 25);
		panelPersona.add(rdbtnUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(54, 275, 116, 22);
		panelPersona.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblIdDeUsuario = new JLabel("Nombre de usuario:");
		lblIdDeUsuario.setBounds(54, 253, 134, 16);
		panelPersona.add(lblIdDeUsuario);
		
		JLabel lblContrase = new JLabel("Contrase\u00F1a:");
		lblContrase.setBounds(54, 317, 134, 16);
		panelPersona.add(lblContrase);
		
		pswContrasenia = new JPasswordField();
		pswContrasenia.setBounds(54, 346, 116, 22);
		panelPersona.add(pswContrasenia);
		
		pswConfirmacion = new JPasswordField();
		pswConfirmacion.setBounds(54, 424, 116, 22);
		panelPersona.add(pswConfirmacion);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarContrasea.setBounds(54, 395, 134, 16);
		panelPersona.add(lblConfirmarContrasea);
		
		txtNombreArtistico = new JTextField();
		txtNombreArtistico.setBounds(383, 275, 116, 22);
		panelPersona.add(txtNombreArtistico);
		txtNombreArtistico.setColumns(10);
		
		JLabel lblNombreArtstico = new JLabel("Nombre art\u00EDstico:");
		lblNombreArtstico.setBounds(383, 253, 116, 16);
		panelPersona.add(lblNombreArtstico);
		
		txtRol = new JTextField();
		txtRol.setColumns(10);
		txtRol.setBounds(383, 417, 116, 22);
		panelPersona.add(txtRol);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(383, 395, 116, 16);
		panelPersona.add(lblRol);
		
		chckbxGrupo = new JCheckBox("Grupo");
		chckbxGrupo.setBounds(383, 313, 113, 25);
		panelPersona.add(chckbxGrupo);
		
		txt_email = new JTextField();
		txt_email.setBounds(54, 482, 170, 20);
		panelPersona.add(txt_email);
		txt_email.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(54, 455, 134, 16);
		panelPersona.add(lblEmail);
		
		txt_id_artista = new JTextField();
		txt_id_artista.setBounds(593, 215, 86, 20);
		panelPersona.add(txt_id_artista);
		txt_id_artista.setColumns(10);
		
		lblIdArtista = new JLabel("ID Artista:");
		lblIdArtista.setBounds(516, 218, 67, 14);
		panelPersona.add(lblIdArtista);
		
		txt_id_usuario = new JTextField();
		txt_id_usuario.setBounds(122, 16, 86, 20);
		contentPanel.add(txt_id_usuario);
		txt_id_usuario.setColumns(10);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(80, 22, 46, 14);
		contentPanel.add(lblId);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String id_persona="";
							String p_nombre="";
							String ciudad="";
							String fecha="";
							char sexo;
							String nombreUsuario;
							String contrasena;
							String confirmar;
							String id_usuario="";
							String fechaDeUltimoAcceso = new SimpleDateFormat("dd-MM-yyyy").format(new Date(getDefaultCloseOperation(), getDefaultCloseOperation(), getDefaultCloseOperation()));
							String fechaDeRegistro = new SimpleDateFormat("dd-MM-yyyy").format(new Date(getDefaultCloseOperation(), getDefaultCloseOperation(), getDefaultCloseOperation()));
							String email = "";
							String id_artista="";
							String nombreArtistico="";
	
							id_persona = txt_id_usuario.getText();
							p_nombre = txtNombre.getText() + " " + txtSNombre.getText() + " " + txtApellido.getText() + " " + txtSApellido.getText();
							ciudad = cbxCiudadNacimiento.getSelectedItem().toString();
							fecha = cbxDia.getSelectedItem().toString() + "-" + cbxMes.getSelectedItem().toString() + "-" + cbxAnio.getSelectedItem().toString();
							sexo = cbxSexo.getSelectedItem().toString().charAt(0);	
							id_usuario = txt_id_usuario.getText();
							email = txt_email.getText();
							nombreArtistico = txtNombreArtistico.getText();
							
							ControladorDB.getInstance().insertPersona(id_persona, p_nombre, ciudad, fecha, sexo);
							
							if (rdbtnUsuario.isSelected()) {
								boolean continueReg = true;
								do {
									continueReg = true;
									nombreUsuario = txtNombreUsuario.getText();
									contrasena = pswContrasenia.getText();
									confirmar = pswConfirmacion.getText();
									
									if(contrasena != confirmar) {
										pswConfirmacion.setText("");
										pswConfirmacion.requestFocus();
										continueReg = false;
									}									
								}while(!continueReg);
								
								ControladorDB.getInstance().insertUsuario(id_usuario, p_nombre, ciudad, fecha, sexo, 
										id_persona, contrasena, fechaDeUltimoAcceso, fechaDeRegistro, email);
							}
							if(rdbtnArtista.isSelected()) {
								ControladorDB.getInstance().insertArtista(id_artista, p_nombre, ciudad, fecha, sexo, id_artista, id_persona, nombreArtistico);
								String[] array = new String[ControladorDB.getInstance().getMisAgrupaciones().size()];
								for(int i = 0; i < array.length; i++) {
								    array[i] = ControladorDB.getInstance().getMisAgrupaciones().get(i).toString();
								}
								if (chckbxGrupo.isSelected()) {
									cbxGrupo = new JComboBox(array);
									cbxGrupo.setBounds(383, 346, 116, 22);
									panelPersona.add(cbxGrupo);
								}
							}
							
						}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}