package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class FrmReportClienteConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblConsultaCliente;
	private JTextField txtNombreCliente;
	private JLabel lblNombreCliente;
	private JButton btnFiltrar;
	private JPanel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportClienteConsulta frame = new FrmReportClienteConsulta();
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
	public FrmReportClienteConsulta() {
		setTitle("Consulta Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaCliente = new JLabel("Consulta Cliente");
		lblConsultaCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setBounds(10, 11, 769, 49);
		contentPane.add(lblConsultaCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(236, 71, 122, 20);
		contentPane.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		lblNombreCliente = new JLabel("Nombre Cliente:");
		lblNombreCliente.setBounds(90, 71, 110, 17);
		contentPane.add(lblNombreCliente);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(498, 71, 166, 23);
		contentPane.add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(10, 106, 769, 337);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent arg0) {
		String nombre = txtNombreCliente.getText();
		
		ClienteModel model = new ClienteModel();
		List<Cliente> listaData = null;
		if(nombre.equals("")){
			listaData = model.listarCliente();
		}else{
			listaData = model.consultaCliente(nombre);
		}
		
		// 1 La data
		JRBeanCollectionDataSource dataSource 
				= new JRBeanCollectionDataSource(listaData);

		// 2 El dise?o del reporte (Dise?o)
		String file = "ReporteCliente.jasper";
				
		// 3 Se genera el reporte
		JasperPrint jasperPrint =
		GeneradorReporte.genera(file, dataSource, null);

		// 4 Se muestra en el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);
			
		// 5 Se a?ade el visor al panel
		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		
		
	}
}
