package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

public class RegistrarTema extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitulo;
	private JTextField txtDuracion;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegistrarTema() {
		setTitle("Registrar Tema");
		setBounds(100, 100, 854, 710);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registro de Tema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblTitulo = new JLabel("T\u00EDtulo:");
			lblTitulo.setBounds(55, 54, 115, 33);
			panel.add(lblTitulo);
			
			txtTitulo = new JTextField();
			txtTitulo.setBounds(55, 99, 236, 39);
			panel.add(txtTitulo);
			txtTitulo.setColumns(10);
			
			JLabel lblGenero = new JLabel("G\u00E9nero:");
			lblGenero.setBounds(381, 54, 115, 33);
			panel.add(lblGenero);
			
			JComboBox cbxGenero = new JComboBox();
			cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"Blues", "Corrido", "Country", "Cumbia", "Disco", "Electr\u00F3nica", "Flamenco", "Folk", "Funk", "Gospel", "Heavy Metal", "Hip Hop", "Indie\u200B", "Jazz\u200B", "Merengue", "Pop", "Punk", "Ranchera", "Rap", "Reggae", "Reggaeton", "Rumba", "Rhythm and Blues", "Rock", "Rock and Roll", "Salsa", "Son", "Soul", "Tango", "Vallenato"}));
			cbxGenero.setBounds(381, 99, 236, 39);
			panel.add(cbxGenero);
			
			JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
			lblDuracin.setBounds(55, 191, 115, 33);
			panel.add(lblDuracin);
			
			txtDuracion = new JTextField();
			txtDuracion.setBounds(55, 243, 135, 39);
			panel.add(txtDuracion);
			txtDuracion.setColumns(10);
			
			JLabel lblAlbum = new JLabel("Album:");
			lblAlbum.setBounds(245, 191, 115, 33);
			panel.add(lblAlbum);
			
			JComboBox cbxAlbum = new JComboBox();
			cbxAlbum.setBounds(245, 243, 236, 39);
			panel.add(cbxAlbum);
			
			JLabel lblOrdenDelTema = new JLabel("Orden del Tema:");
			lblOrdenDelTema.setBounds(534, 191, 203, 33);
			panel.add(lblOrdenDelTema);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(544, 243, 89, 40);
			panel.add(spinner);
			
			JPanel panelArtistaoGrupo = new JPanel();
			panelArtistaoGrupo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Procedencia del Tema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelArtistaoGrupo.setBounds(55, 310, 692, 223);
			panel.add(panelArtistaoGrupo);
			panelArtistaoGrupo.setLayout(null);
			
			JRadioButton rdbtnArtista = new JRadioButton("Artista");
			rdbtnArtista.setBounds(90, 65, 149, 41);
			panelArtistaoGrupo.add(rdbtnArtista);
			
			JRadioButton rdbtnAgrupacin = new JRadioButton("Agrupaci\u00F3n");
			rdbtnAgrupacin.setBounds(356, 65, 251, 41);
			panelArtistaoGrupo.add(rdbtnAgrupacin);
			
			JComboBox cbxArtista = new JComboBox();
			cbxArtista.setBounds(100, 121, 170, 39);
			panelArtistaoGrupo.add(cbxArtista);
			
			JComboBox cbxAgrupacion = new JComboBox();
			cbxAgrupacion.setBounds(366, 121, 194, 39);
			panelArtistaoGrupo.add(cbxAgrupacion);
		}
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
				JButton btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}
