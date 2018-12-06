package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	public Principal(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 662);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtistas = new JMenu("Personas");
		menuBar.add(mnArtistas);
		
		JMenuItem mntmBuscarArtista = new JMenuItem("Registrar persona");
		mntmBuscarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regPersona = new RegistrarPersona();
				regPersona.setVisible(true);
			}
		});
		mnArtistas.add(mntmBuscarArtista);
		
		JMenuItem mntmAgregarArtista = new JMenuItem("Listado de usuarios");
		mntmAgregarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoUsuarios listUsuarios = new ListadoUsuarios();
				listUsuarios.setVisible(true);
			}
		});
		mnArtistas.add(mntmAgregarArtista);
		
		JMenu mnlbumes = new JMenu("\u00E1lbumes");
		menuBar.add(mnlbumes);
		
		JMenuItem mntmBuscarAlbum = new JMenuItem("Buscar Album");
		mntmBuscarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador buscador = new Buscador();
				buscador.setVisible(true);
			}
		});
		mnlbumes.add(mntmBuscarAlbum);
		
		JMenuItem mntmAgregarAlbum = new JMenuItem("Agregar Album");
		mntmAgregarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Album regAlbum = new Album();
				regAlbum.setVisible(true);
			}
		});
		mnlbumes.add(mntmAgregarAlbum);
		
		JMenuItem mntmListarAlbumes = new JMenuItem("Listar Albumes");
		mnlbumes.add(mntmListarAlbumes);
		
		JMenu mnTemas = new JMenu("Temas");
		menuBar.add(mnTemas);
		
		JMenuItem mntmBuscarTema = new JMenuItem("Buscar Tema");
		mntmBuscarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador buscador = new Buscador();
				buscador.setVisible(true);
			}
		});
		mnTemas.add(mntmBuscarTema);
		
		JMenuItem mntmAgregarTema = new JMenuItem("Agregar Tema");
		mntmAgregarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarTema regTema = new RegistrarTema();
				regTema.setVisible(true);
			}
		});
		mnTemas.add(mntmAgregarTema);
		
		JMenuItem mntmListarTemas = new JMenuItem("Listar Temas");
		mnTemas.add(mntmListarTemas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 747, 111);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOrden = new JLabel("0");
		lblOrden.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblOrden.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOrden.setBounds(679, 13, 56, 28);
		panel_1.add(lblOrden);
		
		JLabel lblTituloTema = new JLabel("Cancion de Ejemplo");
		lblTituloTema.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTituloTema.setBounds(31, 13, 643, 57);
		panel_1.add(lblTituloTema);
		
		JLabel lblArtistaGrupo = new JLabel("Artista de Ejemplo ft. El otro Artista");
		lblArtistaGrupo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArtistaGrupo.setBounds(60, 67, 349, 31);
		panel_1.add(lblArtistaGrupo);
		
		JButton btnReproducir = new JButton("Reproducir");
		btnReproducir.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnReproducir.setBounds(267, 226, 209, 111);
		panel.add(btnReproducir);
		
		JLabel lblDuraciontxt = new JLabel("Duracion:");
		lblDuraciontxt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDuraciontxt.setBounds(278, 364, 108, 27);
		panel.add(lblDuraciontxt);
		
		JLabel lblDuracion = new JLabel("4:23");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDuracion.setBounds(394, 364, 67, 27);
		panel.add(lblDuracion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 447, 333, 119);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAlbumtxt = new JLabel("Album:");
		lblAlbumtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlbumtxt.setBounds(12, 13, 229, 34);
		panel_2.add(lblAlbumtxt);
		
		JLabel lblAlbum = new JLabel("Ejemplo de Album");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAlbum.setBounds(12, 47, 309, 46);
		panel_2.add(lblAlbum);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(426, 447, 333, 119);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblGenero = new JLabel("Ejemplo de Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblGenero.setBounds(12, 47, 309, 46);
		panel_3.add(lblGenero);
		
		JLabel lblGenerotxt = new JLabel("Genero:");
		lblGenerotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGenerotxt.setBounds(12, 13, 229, 34);
		panel_3.add(lblGenerotxt);
	}
}
