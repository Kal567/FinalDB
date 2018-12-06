package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Statement;

import logical.Grupo;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreDelGrupo;
	private JComboBox cbxCiudad;
	private JComboBox cbxDia;
	private JComboBox cbxMes;
	private JComboBox cbxAnio;
	private JButton btnDer;
	private JButton btnIzq;
	private String datos;
	private JList listArtistas;
	private JList listIntegrantes;
	private DefaultListModel<String> modelArtistas;
	private DefaultListModel<String> modelIntegrantes;
	
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
				cbxCiudad = new JComboBox();
				cbxCiudad.setBounds(231, 56, 113, 22);
				panel.add(cbxCiudad);
			}
			{
				JLabel lblFechaDeFormacin = new JLabel("Fecha de formaci\u00F3n:");
				lblFechaDeFormacin.setBounds(46, 114, 131, 16);
				panel.add(lblFechaDeFormacin);
			}
			{
				cbxDia = new JComboBox();
				cbxDia.setBounds(46, 143, 31, 22);
				panel.add(cbxDia);
			}
			{
				cbxMes = new JComboBox();
				cbxMes.setBounds(109, 143, 37, 22);
				panel.add(cbxMes);
			}
			{
				cbxAnio = new JComboBox();
				cbxAnio.setBounds(185, 143, 88, 22);
				panel.add(cbxAnio);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 224, 100, 129);
			panel.add(scrollPane);
			
			listArtistas = new JList();
			listArtistas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listArtistas.getSelectedIndex()>=0)
					{
						datos = (String)listArtistas.getModel().getElementAt(listArtistas.getSelectedIndex());
						btnDer.setEnabled(true);
					}
				}
			});
			scrollPane.setViewportView(listArtistas);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(244, 224, 100, 129);
			panel.add(scrollPane_1);
			
			listIntegrantes = new JList();
			listIntegrantes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listIntegrantes.getSelectedIndex()>=0)
					{
						datos = (String)listIntegrantes.getModel().getElementAt(listIntegrantes.getSelectedIndex());
						btnIzq.setEnabled(true);
					}
				}
			});
			scrollPane_1.setViewportView(listIntegrantes);
			
			btnDer = new JButton(">");
			btnDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelIntegrantes.addElement(modelArtistas.getElementAt(listArtistas.getSelectedIndex()));
						listIntegrantes.setModel(modelIntegrantes);
						modelArtistas.removeElementAt(listArtistas.getSelectedIndex());
						listArtistas.setModel(modelArtistas);
						btnDer.setEnabled(false);
						btnIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnDer.setBounds(146, 261, 97, 25);
			panel.add(btnDer);
			
			btnIzq = new JButton("<");
			btnIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!datos.equalsIgnoreCase(""))
					{
						modelArtistas.addElement(modelIntegrantes.getElementAt(listIntegrantes.getSelectedIndex()));
						listArtistas.setModel(modelArtistas);
						modelIntegrantes.removeElementAt(listIntegrantes.getSelectedIndex());
						listIntegrantes.setModel(modelIntegrantes);
						btnDer.setEnabled(false);
						btnIzq.setEnabled(false);
						datos = "";
					}
				}
			});
			btnIzq.setBounds(146, 295, 97, 25);
			panel.add(btnIzq);
			
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
	
	/*private ArrayList<Grupo> arregloDeIntegrantes(Statement st2) {
		
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
	}*/
}
