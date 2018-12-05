package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 656);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtistas = new JMenu("Artistas");
		menuBar.add(mnArtistas);
		
		JMenuItem mntmBuscarArtista = new JMenuItem("Buscar Artista");
		mnArtistas.add(mntmBuscarArtista);
		
		JMenuItem mntmAgregarArtista = new JMenuItem("Agregar Artista");
		mnArtistas.add(mntmAgregarArtista);
		
		JMenuItem mntmListarArtistas = new JMenuItem("Listar Artistas");
		mnArtistas.add(mntmListarArtistas);
		
		JMenu mnlbumes = new JMenu("\u00E1lbumes");
		menuBar.add(mnlbumes);
		
		JMenuItem mntmBuscarAlbum = new JMenuItem("Buscar Album");
		mnlbumes.add(mntmBuscarAlbum);
		
		JMenuItem mntmAgregarAlbum = new JMenuItem("Agregar Album");
		mnlbumes.add(mntmAgregarAlbum);
		
		JMenuItem mntmListarAlbumes = new JMenuItem("Listar Albumes");
		mnlbumes.add(mntmListarAlbumes);
		
		JMenu mnTemas = new JMenu("Temas");
		menuBar.add(mnTemas);
		
		JMenuItem mntmBuscarTema = new JMenuItem("Buscar Tema");
		mnTemas.add(mntmBuscarTema);
		
		JMenuItem mntmAgregarTema = new JMenuItem("Agregar Tema");
		mnTemas.add(mntmAgregarTema);
		
		JMenuItem mntmListarTemas = new JMenuItem("Listar Temas");
		mnTemas.add(mntmListarTemas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
