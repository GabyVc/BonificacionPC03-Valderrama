package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;
import util.Validaciones;

public class FrmReporteNombreConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblConsulta;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnFiltrar;
	private JPanel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteNombreConsulta frame = new FrmReporteNombreConsulta();
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
	public FrmReporteNombreConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsulta = new JLabel("Consulta por Nombre");
		lblConsulta.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblConsulta.setBounds(197, 11, 182, 23);
		contentPane.add(lblConsulta);
		
		lblNombre = new JLabel("Nombre ");
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNombre.setBounds(35, 48, 96, 18);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 49, 182, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnFiltrar.setBounds(420, 46, 109, 23);
		contentPane.add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(10, 99, 560, 370);
		contentPane.add(panelReporte);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	List<Cliente> data = new ArrayList<Cliente>();
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		String nombres=txtNombre.getText().trim();
		ClienteModel model = new ClienteModel();
		
		data = model.consultaCliente(nombres);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

		// 2 El diseño del reporte
		String file = "reportCliente.jasper";

		// 3 Se genera el reporte
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);

		// 4 Se muestra en el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);

		// 5 Se añade el visor al panel
		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		
		
	}
	 void mensaje(String mgs) {
		 JOptionPane.showMessageDialog(this, mgs);
	 }
	
}
