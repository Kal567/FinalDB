package visual;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buscador extends JDialog{
	private JTextField txtBusqueda;
	private JTable tablaTema;
	private JTable tablaArtista;
	private JTable tablaGrupo;
	private JTable tablaAlbum;
	private static DefaultTableModel tablaModeloGrupo;
	private static DefaultTableModel tablaModeloArtista;
	private static DefaultTableModel tablaModeloAlbum;
	private static DefaultTableModel tablaModeloTema;
	
	public Buscador() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelBusqueda, BorderLayout.CENTER);
		panelBusqueda.setLayout(null);
		
		JPanel panelTablaTema = new JPanel();
		panelTablaTema.setBounds(44, 98, 634, 306);
		panelBusqueda.add(panelTablaTema);
		panelTablaTema.setLayout(new BorderLayout(0, 0));
		
		tablaTema = new JTable();
		tablaTema.setBackground(Color.LIGHT_GRAY);
		tablaModeloTema = new DefaultTableModel();
		String ColumnaTitulosTema[] = {"ID Tema", "T\u00EDtulo", "G\u00E9nero", "Duraci\u00F3n", "Orden Tema"};
		tablaModeloTema.setColumnIdentifiers(ColumnaTitulosTema);
		tablaTema.setModel(tablaModeloTema);
		tablaTema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTablaTema.add(tablaTema, BorderLayout.CENTER);
		
		JPanel panelTablaAlbum = new JPanel();
		panelTablaAlbum.setBounds(44, 98, 634, 306);
		panelBusqueda.add(panelTablaAlbum);
		panelTablaAlbum.setLayout(new BorderLayout(0, 0));
		
		tablaAlbum = new JTable();
		tablaAlbum.setBackground(Color.LIGHT_GRAY);
		tablaModeloAlbum = new DefaultTableModel();
		String ColumnaTitulosAlbum[] = {"ID Album", "T\u00EDtulo", "G\u00E9nero", "Precio", "Fecha de Lanzamiento"};
		tablaModeloTema.setColumnIdentifiers(ColumnaTitulosAlbum);
		tablaAlbum.setModel(tablaModeloAlbum);
		tablaAlbum.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTablaAlbum.add(tablaAlbum, BorderLayout.CENTER);
		
		JPanel panelTablaGrupo = new JPanel();
		panelTablaGrupo.setBounds(44, 98, 634, 306);
		panelBusqueda.add(panelTablaGrupo);
		panelTablaGrupo.setLayout(new BorderLayout(0, 0));
		
		tablaGrupo = new JTable();
		tablaGrupo.setBackground(Color.LIGHT_GRAY);
		tablaModeloGrupo = new DefaultTableModel();
		String ColumnaTitulosGrupo[] = {"ID Grupo", "Nombre", "Fecha de Formaci\u00F3n", "Lugar de Procedencia"};
		tablaModeloGrupo.setColumnIdentifiers(ColumnaTitulosGrupo);
		tablaGrupo.setModel(tablaModeloAlbum);
		tablaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTablaGrupo.add(tablaGrupo, BorderLayout.CENTER);
		
		JPanel panelTablaArtista = new JPanel();
		panelTablaArtista.setBounds(44, 98, 634, 306);
		panelBusqueda.add(panelTablaArtista);
		panelTablaArtista.setLayout(new BorderLayout(0, 0));
		
		tablaArtista = new JTable();
		tablaArtista.setBackground(Color.LIGHT_GRAY);
		tablaModeloArtista = new DefaultTableModel();
		String ColumnaTitulosArtista[] = {"ID Grupo", "Nombre", "Fecha de Formaci\u00F3n", "Lugar de Procedencia"};
		tablaModeloArtista.setColumnIdentifiers(ColumnaTitulosArtista);
		tablaArtista.setModel(tablaModeloAlbum);
		tablaArtista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTablaArtista.add(tablaArtista, BorderLayout.CENTER);
		
		JComboBox cbxFiltro = new JComboBox();
		cbxFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxFiltro.getSelectedIndex() == 0)
				{
					panelTablaTema.setVisible(true);
					panelTablaAlbum.setVisible(false);
					panelTablaArtista.setVisible(false);
					panelTablaGrupo.setVisible(false);
				}
				
				if(cbxFiltro.getSelectedIndex() == 1)
				{
					panelTablaTema.setVisible(false);
					panelTablaAlbum.setVisible(false);
					panelTablaArtista.setVisible(true);
					panelTablaGrupo.setVisible(false);
				}
				
				if(cbxFiltro.getSelectedIndex() == 2)
				{
					panelTablaTema.setVisible(false);
					panelTablaAlbum.setVisible(false);
					panelTablaArtista.setVisible(false);
					panelTablaGrupo.setVisible(true);
				}
				
				if(cbxFiltro.getSelectedIndex() == 3)
				{
					panelTablaTema.setVisible(false);
					panelTablaAlbum.setVisible(true);
					panelTablaArtista.setVisible(false);
					panelTablaGrupo.setVisible(false);
				}
			}
		});
		cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Tema", "Artista", "Agrupaci\u00F3n", "Album"}));
		cbxFiltro.setBounds(44, 39, 79, 22);
		panelBusqueda.add(cbxFiltro);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setText("Buscar...");
		txtBusqueda.setBounds(135, 39, 116, 22);
		panelBusqueda.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Buscador.class.getResource("/images/LupaNegra21x21.png")));
		btnBuscar.setBounds(252, 38, 35, 24);
		panelBusqueda.add(btnBuscar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(44, 445, 634, 195);
		panelBusqueda.add(textPane);
	}
}
