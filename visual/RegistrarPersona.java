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

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		panelPersona.setBounds(71, 47, 737, 239);
		contentPanel.add(panelPersona);
		panelPersona.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(54, 28, 56, 16);
		panelPersona.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(54, 51, 116, 22);
		panelPersona.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Segundo Nombre:");
		lblNewLabel.setBounds(224, 28, 116, 16);
		panelPersona.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 51, 116, 22);
		panelPersona.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(383, 28, 56, 16);
		panelPersona.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(383, 51, 116, 22);
		panelPersona.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setBounds(552, 28, 104, 16);
		panelPersona.add(lblSegundoApellido);
		
		textField_3 = new JTextField();
		textField_3.setBounds(552, 51, 116, 22);
		panelPersona.add(textField_3);
		textField_3.setColumns(10);
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
