package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Statement;

import logical.Artista;
import logical.ControladorDB;
import logical.Grupo;
import logical.Temas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class RegistrarTema extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitulo;
	private JTextField txtDuracion;
	private JComboBox cbxGenero;
	private JComboBox cbxAlbum;
	private JRadioButton rdbtnArtista;
	private JRadioButton rdbtnAgrupacin;
	private JComboBox cbxArtista;
	private JComboBox cbxAgrupacion;
	private JSpinner spnOrden;
	private JTextField txtBuscarArtistaReg;
	private JTextField txtBuscarArtistaSeleccionado;
	private JTextField txtBuscarGrupReg;
	private JTextField txtBuscarGrupSelect;
	private DefaultListModel<String> modelArtistaReg = new DefaultListModel<>();
	private DefaultListModel<String> modelArtistaSelect = new DefaultListModel<>();
	private DefaultListModel<String> modelGrupReg = new DefaultListModel<>();
	private DefaultListModel<String> modelGrupSelect= new DefaultListModel<>();
	private JList listArtistasBuscados;
	private JList listArtistasSeleccionados;
	private JList listGrupReg;
	private JList listGrupSelect;
	private String datos;
	private JButton btnBuscarArtReg;
	private JButton btnBuscarArtSelect;
	private JButton btnGrupReg;
	private JButton btnGrupSelect;
	private JButton btnArtIzq;
	private JButton btnArtDer;
	private JButton btnGrupIzq;
	private JButton btnGrupDer;
	private Statement st = null;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public RegistrarTema() throws SQLException {
		setTitle("Registrar Tema");
		setBounds(100, 100, 1566, 959);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setBorder(new TitledBorder(null, "Registro de Tema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			
			JPanel panelArtistaoGrupo = new JPanel();
			panelArtistaoGrupo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Procedencia del Tema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelArtistaoGrupo.setBounds(55, 482, 692, 223);
			panel.add(panelArtistaoGrupo);
			panelArtistaoGrupo.setLayout(null);
			
			rdbtnArtista = new JRadioButton("Artista");
			rdbtnArtista.setBounds(90, 65, 149, 41);
			panelArtistaoGrupo.add(rdbtnArtista);
			
			rdbtnAgrupacin = new JRadioButton("Agrupaci\u00F3n");
			rdbtnAgrupacin.setBounds(356, 65, 251, 41);
			panelArtistaoGrupo.add(rdbtnAgrupacin);
			
			cbxArtista = new JComboBox();
			cbxArtista.setModel(new DefaultComboBoxModel(ControladorDB.artistasToLista(ControladorDB.obtenerArtistas())));
			cbxArtista.setBounds(100, 121, 170, 39);
			panelArtistaoGrupo.add(cbxArtista);
			
			cbxAgrupacion = new JComboBox();
			cbxAgrupacion.setModel(new DefaultComboBoxModel(ControladorDB.gruposToLista(ControladorDB.obtenerGrupos())));
			cbxAgrupacion.setBounds(366, 121, 194, 39);
			panelArtistaoGrupo.add(cbxAgrupacion);
			
			JPanel panelContribuciones = new JPanel();
			panelContribuciones.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Contribuciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelContribuciones.setBounds(795, 54, 703, 739);
			panel.add(panelContribuciones);
			panelContribuciones.setLayout(null);
			
			listArtistasBuscados = new JList();
			listArtistasBuscados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listArtistasBuscados.getSelectedIndex()>=0)
					{
						datos = (String)listArtistasBuscados.getModel().getElementAt(listArtistasBuscados.getSelectedIndex());
						btnArtIzq.setEnabled(true);
					}
				}
			});
			listArtistasBuscados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listArtistasBuscados.setBounds(26, 130, 282, 244);
			panelContribuciones.add(listArtistasBuscados);
			
			JLabel lblArtistasRegistrados = new JLabel("Artistas Registrados:");
			lblArtistasRegistrados.setBounds(26, 38, 255, 33);
			panelContribuciones.add(lblArtistasRegistrados);
			
			JLabel lblArtistasSeleccionados = new JLabel("Artistas Seleccionados:");
			lblArtistasSeleccionados.setBounds(406, 38, 271, 33);
			panelContribuciones.add(lblArtistasSeleccionados);
			
			listArtistasSeleccionados = new JList();
			listArtistasSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listArtistasSeleccionados.getSelectedIndex()>=0)
					{
						datos = (String)listArtistasSeleccionados.getModel().getElementAt(listArtistasSeleccionados.getSelectedIndex());
						btnArtDer.setEnabled(true);
					}
				}
			});
			listArtistasSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listArtistasSeleccionados.setBounds(406, 130, 282, 244);
			panelContribuciones.add(listArtistasSeleccionados);
			
			txtBuscarArtistaReg = new JTextField();
			txtBuscarArtistaReg.setBounds(26, 79, 236, 39);
			panelContribuciones.add(txtBuscarArtistaReg);
			txtBuscarArtistaReg.setColumns(10);
			
			btnBuscarArtReg = new JButton("");
			btnBuscarArtReg.setBounds(268, 78, 40, 40);
			panelContribuciones.add(btnBuscarArtReg);
			
			txtBuscarArtistaSeleccionado = new JTextField();
			txtBuscarArtistaSeleccionado.setColumns(10);
			txtBuscarArtistaSeleccionado.setBounds(406, 79, 236, 39);
			panelContribuciones.add(txtBuscarArtistaSeleccionado);
			
			btnBuscarArtSelect = new JButton("");
			btnBuscarArtSelect.setBounds(648, 78, 40, 40);
			panelContribuciones.add(btnBuscarArtSelect);
			
			JLabel lblAgrupacionesRegistrados = new JLabel("Grupos Registrados:");
			lblAgrupacionesRegistrados.setBounds(26, 389, 255, 33);
			panelContribuciones.add(lblAgrupacionesRegistrados);
			
			txtBuscarGrupReg = new JTextField();
			txtBuscarGrupReg.setColumns(10);
			txtBuscarGrupReg.setBounds(26, 430, 236, 39);
			panelContribuciones.add(txtBuscarGrupReg);
			
			btnGrupReg = new JButton("");
			btnGrupReg.setBounds(268, 429, 40, 40);
			panelContribuciones.add(btnGrupReg);
			
			listGrupReg = new JList();
			listGrupReg.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listGrupReg.getSelectedIndex()>=0)
					{
						datos = (String)listGrupReg.getModel().getElementAt(listGrupReg.getSelectedIndex());
						btnGrupIzq.setEnabled(true);
					}
				}
			});
			listGrupReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listGrupReg.setBounds(26, 481, 282, 244);
			panelContribuciones.add(listGrupReg);
			
			JLabel lblGruposSeleccionados = new JLabel("Grupos Seleccionados:");
			lblGruposSeleccionados.setBounds(406, 389, 271, 33);
			panelContribuciones.add(lblGruposSeleccionados);
			
			txtBuscarGrupSelect = new JTextField();
			txtBuscarGrupSelect.setColumns(10);
			txtBuscarGrupSelect.setBounds(406, 430, 236, 39);
			panelContribuciones.add(txtBuscarGrupSelect);
			
			btnGrupSelect = new JButton("");
			btnGrupSelect.setBounds(648, 429, 40, 40);
			panelContribuciones.add(btnGrupSelect);
			
			listGrupSelect = new JList();
			listGrupSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listGrupSelect.getSelectedIndex()>=0)
					{
						datos = (String)listGrupSelect.getModel().getElementAt(listGrupSelect.getSelectedIndex());
						btnGrupDer.setEnabled(true);
					}
				}
			});
			listGrupSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listGrupSelect.setBounds(406, 481, 282, 244);
			panelContribuciones.add(listGrupSelect);
			
			btnArtIzq = new JButton(">");
			btnArtIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelArtistaSelect.addElement(modelArtistaReg.getElementAt(listArtistasBuscados.getSelectedIndex()));
						listArtistasSeleccionados.setModel(modelArtistaSelect);
						modelArtistaReg.removeElementAt(listArtistasBuscados.getSelectedIndex());
						listArtistasBuscados.setModel(modelArtistaReg);
						btnArtDer.setEnabled(false);
						btnArtIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnArtIzq.setBounds(316, 179, 80, 39);
			panelContribuciones.add(btnArtIzq);
			
			btnArtDer = new JButton("<");
			btnArtDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelArtistaReg.addElement(modelArtistaSelect.getElementAt(listArtistasSeleccionados.getSelectedIndex()));
						listArtistasBuscados.setModel(modelArtistaReg);
						modelArtistaSelect.removeElementAt(listArtistasSeleccionados.getSelectedIndex());
						listArtistasSeleccionados.setModel(modelArtistaSelect);
						btnArtDer.setEnabled(false);
						btnArtIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnArtDer.setBounds(316, 265, 80, 39);
			panelContribuciones.add(btnArtDer);
			
			btnGrupIzq = new JButton(">");
			btnGrupIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelGrupSelect.addElement(modelGrupReg.getElementAt(listGrupReg.getSelectedIndex()));
						listGrupSelect.setModel(modelGrupSelect);
						modelGrupReg.removeElementAt(listGrupReg.getSelectedIndex());
						listGrupReg.setModel(modelGrupReg);
						btnGrupDer.setEnabled(false);
						btnGrupIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnGrupIzq.setBounds(316, 542, 80, 39);
			panelContribuciones.add(btnGrupIzq);
			
			btnGrupDer = new JButton("<");
			btnGrupDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelGrupReg.addElement(modelGrupSelect.getElementAt(listGrupSelect.getSelectedIndex()));
						listGrupReg.setModel(modelGrupReg);
						modelGrupSelect.removeElementAt(listGrupSelect.getSelectedIndex());
						listGrupSelect.setModel(modelGrupSelect);
						btnGrupDer.setEnabled(false);
						btnGrupIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnGrupDer.setBounds(316, 627, 80, 39);
			panelContribuciones.add(btnGrupDer);
			
			JPanel panelDatosTema = new JPanel();
			panelDatosTema.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Datos Tema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelDatosTema.setBounds(55, 66, 692, 388);
			panel.add(panelDatosTema);
			panelDatosTema.setLayout(null);
			
			JLabel lblTitulo = new JLabel("T\u00EDtulo:");
			lblTitulo.setBounds(26, 58, 115, 33);
			panelDatosTema.add(lblTitulo);
			
			txtTitulo = new JTextField();
			txtTitulo.setBounds(26, 100, 236, 39);
			panelDatosTema.add(txtTitulo);
			txtTitulo.setColumns(10);
			
			JLabel lblGenero = new JLabel("G\u00E9nero:");
			lblGenero.setBounds(324, 61, 115, 33);
			panelDatosTema.add(lblGenero);
			
			cbxGenero = new JComboBox<>();
			cbxGenero.setBounds(323, 100, 236, 39);
			panelDatosTema.add(cbxGenero);
			cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"Blues", "Corrido", "Country", "Cumbia", "Disco", "Electr\u00F3nica", "Flamenco", "Folk", "Funk", "Gospel", "Heavy Metal", "Hip Hop", "Indie\u200B", "Jazz\u200B", "Merengue", "Pop", "Punk", "Ranchera", "Rap", "Reggae", "Reggaeton", "Rumba", "Rhythm and Blues", "Rock", "Rock and Roll", "Salsa", "Son", "Soul", "Tango", "Vallenato"}));
			
			JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
			lblDuracin.setBounds(26, 204, 115, 33);
			panelDatosTema.add(lblDuracin);
			
			txtDuracion = new JTextField();
			txtDuracion.setBounds(26, 251, 135, 39);
			panelDatosTema.add(txtDuracion);
			txtDuracion.setColumns(10);
			
			JLabel lblAlbum = new JLabel("Album:");
			lblAlbum.setBounds(202, 204, 115, 33);
			panelDatosTema.add(lblAlbum);
			
			cbxAlbum = new JComboBox();
			cbxAlbum.setModel(new DefaultComboBoxModel(ControladorDB.obtenerAlbumes()));
			cbxAlbum.setBounds(202, 251, 236, 39);
			panelDatosTema.add(cbxAlbum);
			
			JLabel lblOrdenDelTema = new JLabel("Orden del Tema:");
			lblOrdenDelTema.setBounds(463, 204, 203, 33);
			panelDatosTema.add(lblOrdenDelTema);
			
			spnOrden = new JSpinner();
			spnOrden.setBounds(470, 250, 89, 40);
			panelDatosTema.add(spnOrden);
			
			ButtonGroup bgroup = new ButtonGroup();
			bgroup.add(rdbtnAgrupacin);
			bgroup.add(rdbtnArtista);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(parametersCheck())
						{
							Temas nuevoTema = null;
							try {
								nuevoTema = new Temas("T-"+1, txtTitulo.getText(), cbxGenero.getSelectedItem().toString(), txtDuracion.getText(), (int) spnOrden.getValue(), arregloDeArtistInvitados(st), arregloDeGruposInvitados(st), null, null, ControladorDB.obtenerAlbum(cbxAlbum.getSelectedItem().toString()));
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							ArrayList<Temas> music = new ArrayList<Temas>();
							music.add(nuevoTema);
							try {
								ControladorDB.insertMusic(music);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
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
		
		loadArtistas();
		loadGrupos();
	}
	
	private ArrayList<Grupo> arregloDeGruposInvitados(Statement st2) {
		
		ArrayList<String> datos = new ArrayList<>();
		ArrayList<Grupo> gru = new ArrayList<>();
		
		if(modelGrupSelect.isEmpty())
		{
			gru = null;
		}
		
		else
		{
			for(int i=0; i < modelGrupSelect.size(); i++)
			{
//				gru.add(i, st.execute("Select * from Persona where "));
			}
		}
		System.out.println(gru);
		return gru;
	}
	private ArrayList<Artista> arregloDeArtistInvitados(Statement st) {
		
		ArrayList<String> datos = new ArrayList<>();
		ArrayList<Artista> art = new ArrayList<>();
		
		if(modelArtistaSelect.isEmpty())
		{
			art = null;
		}
		
		else
		{
			for(int i=0; i < modelArtistaSelect.size(); i++)
			{
				//datos.add(i, st.execute("Select * from Persona where "))
			}
		}
		System.out.println(art);
		return art;
	}

	private void clean()
	{
		txtBuscarArtistaReg.setText("");
		txtBuscarArtistaSeleccionado.setText("");
		txtBuscarGrupReg.setText("");
		txtBuscarGrupSelect.setText("");
		txtDuracion.setText("");
		txtTitulo.setText("");
		modelArtistaSelect.removeAllElements();
		modelGrupSelect.removeAllElements();
	}

	private void loadGrupos() throws SQLException {
		for(Grupo grupo: ControladorDB.obtenerGrupos()) {
			modelGrupSelect.addElement(grupo.getNombre_grupo());
		}
		listGrupReg.setModel(modelGrupSelect);
	}

	private void loadArtistas() throws SQLException {
		for(String artista: ControladorDB.obtenerArtistas()) {
			modelArtistaSelect.addElement(artista);
		}
		listArtistasBuscados.setModel(modelArtistaSelect);		
	}

	private boolean parametersCheck() {
		
		boolean bandera = true;
		
		if(txtTitulo == null || txtDuracion == null)
		{
			bandera = false;
		}
		
		return bandera;
	}
}
