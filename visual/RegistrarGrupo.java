package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class RegistrarGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreDelGrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarGrupo dialog = new RegistrarGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarGrupo() {
		setBounds(100, 100, 427, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Registrar grupo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				txtNombreDelGrupo = new JTextField();
				txtNombreDelGrupo.setBounds(46, 56, 131, 22);
				panel.add(txtNombreDelGrupo);
				txtNombreDelGrupo.setColumns(10);
			}
			{
				JLabel lblNombreDelGrupo = new JLabel("Nombre del grupo:");
				lblNombreDelGrupo.setBounds(47, 27, 130, 16);
				panel.add(lblNombreDelGrupo);
			}
			{
				JLabel lblCiudadDeProcedencia = new JLabel("Ciudad de procedencia:");
				lblCiudadDeProcedencia.setBounds(221, 27, 147, 16);
				panel.add(lblCiudadDeProcedencia);
			}
			{
				JComboBox cbxCiudad = new JComboBox();
				cbxCiudad.setBounds(231, 56, 113, 22);
				panel.add(cbxCiudad);
			}
			{
				JLabel lblFechaDeFormacin = new JLabel("Fecha de formaci\u00F3n:");
				lblFechaDeFormacin.setBounds(46, 114, 131, 16);
				panel.add(lblFechaDeFormacin);
			}
			{
				JComboBox cbxDia = new JComboBox();
				cbxDia.setBounds(46, 143, 31, 22);
				panel.add(cbxDia);
			}
			{
				JComboBox cbxMes = new JComboBox();
				cbxMes.setBounds(109, 143, 37, 22);
				panel.add(cbxMes);
			}
			{
				JComboBox cbxAnio = new JComboBox();
				cbxAnio.setBounds(185, 143, 88, 22);
				panel.add(cbxAnio);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 224, 100, 129);
			panel.add(scrollPane);
			
			JList listArtistas = new JList();
			scrollPane.setViewportView(listArtistas);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(244, 224, 100, 129);
			panel.add(scrollPane_1);
			
			JList listIntegrantes = new JList();
			scrollPane_1.setViewportView(listIntegrantes);
			
			JButton button = new JButton(">");
			button.setBounds(146, 261, 97, 25);
			panel.add(button);
			
			JButton button_1 = new JButton("<");
			button_1.setBounds(146, 295, 97, 25);
			panel.add(button_1);
			
			JLabel lblIntegrantes = new JLabel("Integrantes");
			lblIntegrantes.setBounds(165, 197, 88, 16);
			panel.add(lblIntegrantes);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
