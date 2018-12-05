package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

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
		panelPersona.setBounds(71, 47, 737, 477);
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
		
		JComboBox cbxCiudadNacimiento = new JComboBox();
		cbxCiudadNacimiento.setBounds(54, 129, 122, 22);
		panelPersona.add(cbxCiudadNacimiento);
		
		JLabel lblCiudad = new JLabel("Ciudad de nacimiento:");
		lblCiudad.setBounds(54, 100, 159, 16);
		panelPersona.add(lblCiudad);
		
		JComboBox cbxDia = new JComboBox();
		cbxDia.setBounds(224, 129, 31, 22);
		panelPersona.add(cbxDia);
		
		JComboBox cbxMes = new JComboBox();
		cbxMes.setBounds(267, 129, 31, 22);
		panelPersona.add(cbxMes);
		
		JComboBox cbxAnio = new JComboBox();
		cbxAnio.setBounds(310, 129, 56, 22);
		panelPersona.add(cbxAnio);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(224, 100, 159, 16);
		panelPersona.add(lblFechaDeNacimiento);
		
		JComboBox cbxSexo = new JComboBox();
		cbxSexo.setBounds(437, 129, 31, 22);
		panelPersona.add(cbxSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(431, 100, 56, 16);
		panelPersona.add(lblSexo);
		
		JRadioButton rdbtnArtista = new JRadioButton("Artista");
		rdbtnArtista.setBounds(383, 200, 127, 25);
		panelPersona.add(rdbtnArtista);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Usuario");
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
		txtRol.setBounds(383, 424, 116, 22);
		panelPersona.add(txtRol);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(383, 402, 116, 16);
		panelPersona.add(lblRol);
		
		JComboBox cbxGrupo = new JComboBox();
		cbxGrupo.setBounds(383, 346, 116, 22);
		panelPersona.add(cbxGrupo);
		
		JCheckBox chckbxGrupo = new JCheckBox("Grupo");
		chckbxGrupo.setBounds(383, 313, 113, 25);
		panelPersona.add(chckbxGrupo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
