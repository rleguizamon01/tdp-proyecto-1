package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private final JTextField txtId = new JTextField();
	private final JTextField txtLastName = new JTextField();
	private final JTextField txtFirstName = new JTextField();
	private final JTextField txtMail = new JTextField();
	private final JTextField txtGithubURL = new JTextField();
	private final JLabel lblId = new JLabel("LU");
	private final JLabel lblLastName = new JLabel("Apellido");
	private final JLabel lblFirstName = new JLabel("Nombre");
	private final JLabel lblMail = new JLabel("E-mail");
	private final JLabel lblGithubURL = new JLabel("Github URL");
	private final JLabel lblCurrentDate = new JLabel("");
	private final JLabel lblPhoto = new JLabel("");

	public SimplePresentationScreen(Student studentData) {
		lblGithubURL.setLabelFor(txtGithubURL);
		lblMail.setLabelFor(txtMail);
		lblFirstName.setLabelFor(txtFirstName);
		lblLastName.setLabelFor(txtLastName);
		lblId.setLabelFor(txtId);
		txtGithubURL.setColumns(10);
		txtMail.setColumns(10);
		txtFirstName.setColumns(10);
		txtLastName.setColumns(10);
		txtId.setColumns(10);
		this.studentData = studentData;
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/tdp.png"));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setIconImage(icon.getImage());
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(638, 278));
		setResizable(false);
		setContentPane(contentPane);
		setVisible(true);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 375));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");

		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId)
						.addComponent(lblLastName)
						.addComponent(lblFirstName)
						.addComponent(lblMail)
						.addComponent(lblGithubURL))
					.addGap(58)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(txtLastName, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(txtMail, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(txtGithubURL, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(11)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtGithubURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGithubURL))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		contentPane.add(lblCurrentDate, BorderLayout.SOUTH);
		contentPane.add(lblPhoto, BorderLayout.EAST);
		
		// Initializes input texts with student personal data
		this.txtId.setText(String.valueOf(this.studentData.getId()));
		this.txtLastName.setText(this.studentData.getLastName());
		this.txtFirstName.setText(this.studentData.getFirstName());
		this.txtMail.setText(this.studentData.getMail());
		this.txtGithubURL.setText(this.studentData.getGithubURL());
			
		// Shows formatted current date and time 
		Date currentDateTime = new Date();
		String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(currentDateTime);
		String currentTime = new SimpleDateFormat("HH:mm:ss").format(currentDateTime);
		
		this.lblCurrentDate.setText("Esta ventana fue generada el " + currentDate + " a las " + currentTime);
		
		// Shows personal photo
		Image personalPhoto = new ImageIcon(this.getClass().getResource(this.studentData.getPathPhoto())).getImage();
		lblPhoto.setIcon(new ImageIcon(personalPhoto.getScaledInstance(177, 224, Image.SCALE_DEFAULT)));
		lblPhoto.setBounds(10,10,10,10);	
	}
}
