import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StudentRecords {

	private JFrame frame;
	private JTextField jtxtStudentID;
	private JTextField jtxtFirstName;
	private JTextField jtxtLastName;
	private JTextField jtxtTotall;
	private JTextField jtxtExamno;
	private JTextField jtxtRankk;
	private JTextField jtxtAvgg;
	private JTextField jtxtMath;
	private JTextField jtxtEng;
	private JTextField jtxtBio;
	private JTextField jtxtcompute;
	private JTextField jtxtchem;
	private JTextField jtxtphy;
	private JTextField jtxtAddMathss;
	private JTextField jtxtBuisness;
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	DefaultTableModel model=new DefaultTableModel();
	private JTable table_sale=new JTable();

	/**
	 * Launch the application.
	 */
	
	//to display the data into the table.....following code is required this fun is not going to run unless we call in it constructor
	public void updateTable() {
		
		conn=SqliteConnection.ConnectionDb();
		if(conn!=null)
		{
			String sql="Select StudentID,CourseCode,Maths,English,Biology,Computing,Chemistry,Physics,AddMaths,Buisness,"
					+ "TotalScore,Average,Ranking from Student"; 
			try {
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				Object[] columnData=new Object[13];
				table_sale.setModel(model);
				while(rs.next())
				{
					columnData[0]=rs.getString("StudentID");
					columnData[1]=rs.getString("CourseCode");
					columnData[2]=rs.getString("Maths");
					columnData[3]=rs.getString("English");
					columnData[4]=rs.getString("Biology");
					columnData[5]=rs.getString("Computing");
					columnData[6]=rs.getString("Chemistry");
					columnData[7]=rs.getString("Physics");
					columnData[8]=rs.getString("AddMaths");
					columnData[9]=rs.getString("Buisness");
					columnData[10]=rs.getString("TotalScore");
					columnData[11]=rs.getString("Average");
					columnData[12]=rs.getString("Ranking");
					
					model.addRow(columnData);
					model.setColumnIdentifiers(columnData);
					

				}
				}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRecords window = new StudentRecords();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void tableColumnSize()
	{
		table_sale.getColumnModel().getColumn(0).setPreferredWidth(25);
		
		table_sale.getColumnModel().getColumn(1).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(2).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(3).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(4).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(5).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(6).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(7).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(8).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(9).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(10).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(11).setPreferredWidth(45);
		table_sale.getColumnModel().getColumn(12).setPreferredWidth(45);
	}
	/**
	 * Create the application.
	 */
	public StudentRecords() {
		initialize();
		conn=SqliteConnection.ConnectionDb();
		
		Object col[]= {"StudentID","CourseCode","Maths","English","Biology","Computing","Chemistry","Physics","AddMaths","Buisness", "TotalScore","Average","Ranking"};
		model.setColumnIdentifiers(col);
		
		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 12));
		panel.setBounds(12, 13, 859, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(429, 17, 0, 0);
		panel.add(label);
		
		JLabel label_5 = new JLabel("Student Id");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_5.setBounds(22, 32, 120, 38);
		panel.add(label_5);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFirstName.setBounds(24, 76, 120, 31);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLastName.setBounds(23, 113, 120, 31);
		panel.add(lblLastName);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCourseCode.setBounds(22, 151, 139, 31);
		panel.add(lblCourseCode);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblRanking.setBounds(22, 304, 120, 31);
		panel.add(lblRanking);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblAverage.setBounds(23, 266, 120, 31);
		panel.add(lblAverage);
		
		JLabel lblTotalScore = new JLabel("Total Score");
		lblTotalScore.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTotalScore.setBounds(24, 229, 120, 31);
		panel.add(lblTotalScore);
		
		JLabel lblExamNo = new JLabel("Exam no");
		lblExamNo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblExamNo.setBounds(22, 185, 120, 38);
		panel.add(lblExamNo);
		
		JLabel lblMaths = new JLabel("Maths");
		lblMaths.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMaths.setBounds(437, 31, 120, 38);
		panel.add(lblMaths);
		
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblEnglish.setBounds(439, 75, 120, 31);
		panel.add(lblEnglish);
		
		JLabel lblBiology = new JLabel("Biology");
		lblBiology.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblBiology.setBounds(438, 112, 120, 31);
		panel.add(lblBiology);
		
		JLabel lblComputing = new JLabel("Computing");
		lblComputing.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblComputing.setBounds(437, 150, 120, 31);
		panel.add(lblComputing);
		
		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblChemistry.setBounds(437, 184, 120, 38);
		panel.add(lblChemistry);
		
		JLabel lblAddMaths = new JLabel("Physics");
		lblAddMaths.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblAddMaths.setBounds(439, 228, 120, 31);
		panel.add(lblAddMaths);
		
		JLabel lblBuisness = new JLabel("Add Maths");
		lblBuisness.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblBuisness.setBounds(438, 265, 120, 31);
		panel.add(lblBuisness);
		
		JLabel lblBuisness_1 = new JLabel("Buisness");
		lblBuisness_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblBuisness_1.setBounds(437, 303, 120, 31);
		panel.add(lblBuisness_1);
		
		jtxtStudentID = new JTextField();
		jtxtStudentID.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtStudentID.setBounds(201, 40, 217, 22);
		panel.add(jtxtStudentID);
		jtxtStudentID.setColumns(10);
		
		jtxtFirstName = new JTextField();
		jtxtFirstName.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtFirstName.setColumns(10);
		jtxtFirstName.setBounds(200, 79, 215, 22);
		panel.add(jtxtFirstName);
		
		jtxtLastName = new JTextField();
		jtxtLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtLastName.setColumns(10);
		jtxtLastName.setBounds(200, 117, 215, 22);
		panel.add(jtxtLastName);
		
		jtxtTotall = new JTextField();
		jtxtTotall.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtTotall.setEditable(false);
		jtxtTotall.setColumns(10);
		jtxtTotall.setBounds(197, 232, 218, 22);
		panel.add(jtxtTotall);
		
		jtxtExamno = new JTextField();
		jtxtExamno.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtExamno.setColumns(10);
		jtxtExamno.setBounds(198, 193, 217, 22);
		panel.add(jtxtExamno);
		
		jtxtRankk = new JTextField();
		jtxtRankk.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtRankk.setEditable(false);
		jtxtRankk.setColumns(10);
		jtxtRankk.setBounds(197, 309, 218, 22);
		panel.add(jtxtRankk);
		
		jtxtAvgg = new JTextField();
		jtxtAvgg.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtAvgg.setEditable(false);
		jtxtAvgg.setColumns(10);
		jtxtAvgg.setBounds(198, 270, 217, 22);
		panel.add(jtxtAvgg);
		
		jtxtMath = new JTextField();
		jtxtMath.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtMath.setColumns(10);
		jtxtMath.setBounds(615, 40, 217, 22);
		panel.add(jtxtMath);
		
		jtxtEng = new JTextField();
		jtxtEng.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtEng.setColumns(10);
		jtxtEng.setBounds(614, 79, 215, 22);
		panel.add(jtxtEng);
		
		jtxtBio = new JTextField();
		jtxtBio.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtBio.setColumns(10);
		jtxtBio.setBounds(614, 117, 215, 22);
		panel.add(jtxtBio);
		
		jtxtcompute = new JTextField();
		jtxtcompute.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtcompute.setColumns(10);
		jtxtcompute.setBounds(613, 156, 216, 22);
		panel.add(jtxtcompute);
		
		jtxtchem = new JTextField();
		jtxtchem.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtchem.setColumns(10);
		jtxtchem.setBounds(612, 193, 217, 22);
		panel.add(jtxtchem);
		
		jtxtphy = new JTextField();
		jtxtphy.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtphy.setColumns(10);
		jtxtphy.setBounds(611, 232, 218, 22);
		panel.add(jtxtphy);
		
		jtxtAddMathss = new JTextField();
		jtxtAddMathss.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtAddMathss.setColumns(10);
		jtxtAddMathss.setBounds(612, 270, 217, 22);
		panel.add(jtxtAddMathss);
		
		jtxtBuisness = new JTextField();
		jtxtBuisness.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtxtBuisness.setColumns(10);
		jtxtBuisness.setBounds(611, 309, 218, 22);
		panel.add(jtxtBuisness);
		
		JComboBox jcmbCourseCode = new JComboBox();
		jcmbCourseCode.setFont(new Font("Tahoma", Font.BOLD, 20));
		jcmbCourseCode.setModel(new DefaultComboBoxModel(new String[] {"", "OHS01", "OHS02", "OHS03", "OHS04", "OHS05", "OHS06", "OHS07", "OHS08"}));
		jcmbCourseCode.setBounds(201, 158, 214, 22);
		panel.add(jcmbCourseCode);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139), 12));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(883, 13, 533, 361);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea jtxtTranscript = new JTextArea();
		jtxtTranscript.setBounds(12, 13, 509, 335);
		panel_1.add(jtxtTranscript);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 139, 139), 12));
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(12, 387, 1402, 285);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 24, 1357, 237);
		panel_2.add(scrollPane_1);
		scrollPane_1.setViewportView(table_sale);
		scrollPane_1.getPreferredSize();
		
		/*table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
			new String[] {
				"StudentID", "CourseCode", "Maths", "English", "Biology", "Computing", "Chemistry", "Physics", "Add Maths", "Buisness", "Average", "Ranking", "Total Score"
				
			}
			
		));*/
		
		table_sale.setModel(model);
		Object Column_names[]= {"Student_id","Course Code","Maths","English","Biology","Computing","Chemistry","Physics","AddMaths","Buisness","Total Score","Average","Ranking"};
		model.setColumnIdentifiers(Column_names);
		tableColumnSize();
	
		JButton btnStudentResult = new JButton("Student Result");
		btnStudentResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double[] R=new double[14];
				R[0]=Double.parseDouble(jtxtMath.getText());
				R[1]=Double.parseDouble(jtxtEng.getText());
				R[2]=Double.parseDouble(jtxtBio.getText());
				R[3]=Double.parseDouble(jtxtcompute.getText());
				R[4]=Double.parseDouble(jtxtchem.getText());
				R[5]=Double.parseDouble(jtxtphy.getText());
				R[6]=Double.parseDouble(jtxtAddMathss.getText());
				R[7]=Double.parseDouble(jtxtBuisness.getText());
				
				R[8]=(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7])/8;
				R[9]=(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7]);
				
				String average=String.format("%.0f",R[8]);
				jtxtAvgg.setText(average);
				

				String Totalscr=String.format("%.0f",R[9]);
				jtxtTotall.setText(Totalscr);
				
				if(R[9]>=700)
				{
					jtxtRankk.setText("A+");
				}
				else if(R[9]>=600)
				{
					jtxtRankk.setText("A");
				}
				else if(R[9]>=500)
				{
					jtxtRankk.setText("B+");
				}
				else if(R[9]>=400)
				{
					jtxtRankk.setText("B");
				}
				else if(R[9]>=300)
				{
					jtxtRankk.setText("C");
				}
				else if(R[9]<600)
				{
					jtxtRankk.setText("Failed");
				}
				
				//to store into the database
				String sql="INSERT INTO Student(StudentID,CourseCode,Maths,English,Biology,Computing,Chemistry, Physics,AddMaths,"
						+ "Buisness,Total Score,Average,Ranking)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, jtxtStudentID.getText());
					pst.setString(2, (String) jcmbCourseCode.getSelectedItem());
					pst.setString(3, jtxtMath.getText());
					pst.setString(4, jtxtEng.getText());
					pst.setString(5, jtxtBio.getText());
					pst.setString(6, jtxtcompute.getText());
					pst.setString(7, jtxtchem.getText());
					pst.setString(8, jtxtphy.getText());
					pst.setString(9, jtxtAddMathss.getText());
					pst.setString(10, jtxtBuisness.getText());
					pst.setString(11, jtxtTotall.getText());
					pst.setString(12, jtxtAvgg.getText());
					pst.setString(13, jtxtRankk.getText());


					pst.execute();
					rs.close();
					pst.close();
				
				}
				catch(Exception ar)
				{
					JOptionPane.showMessageDialog(null,"system update completed");
				}
				
				//to display  on screen datbase
				DefaultTableModel model=(DefaultTableModel) table_sale.getModel();
				model.addRow(new Object[] {
						jtxtStudentID.getText(),
						jcmbCourseCode.getSelectedItem(),
						jtxtMath.getText(),
						jtxtEng.getText(),
						jtxtBio.getText(),
						jtxtcompute.getText(),
						jtxtchem.getText(),
						jtxtphy.getText(),
						jtxtAddMathss.getText(),
						jtxtBuisness.getText(),
						jtxtTotall.getText(),
						jtxtAvgg.getText(),
						jtxtRankk.getText()
				});
				if(table_sale.getSelectedRow()==-1)
				{
					if(table_sale.getRowCount()==0)
					{
						JOptionPane.showMessageDialog(null,"membership update confirmed","student database system",JOptionPane.OK_OPTION);
						
					}
				}
				
			}
		});
		btnStudentResult.setBackground(new Color(0, 139, 139));
		btnStudentResult.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnStudentResult.setBounds(12, 685, 221, 51);
		frame.getContentPane().add(btnStudentResult);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtTranscript.setText("");
				jtxtTranscript.setText("Student Information System\n"+
						"=====================================\n"+
						"Student ID:\t\t"+jtxtStudentID.getText()+
						"\nFirst Name:\t\t"+jtxtFirstName.getText()+
						"\nLast Name:\t\t"+jtxtLastName.getText()+
						"\nMaths:\t\t"+jtxtMath.getText()+
						"\nEnglish:\t\t"+jtxtEng.getText()+
						"\nBiology:\t\t"+jtxtBio.getText()+
						"\nComputing:\t\t"+jtxtcompute.getText()+
						"\nChemistry:\t\t"+jtxtchem.getText()+
						"\nPhysics:\t\t"+jtxtphy.getText()+
						"\nAdd Maths:\t\t"+jtxtAddMathss.getText()+
						"\nBuisness:\t\t"+jtxtBuisness.getText()+
						"\n=====================================\n"+
						"\nTotal score:\t\t"+jtxtTotall.getText()+
						"\nAverage:\t\t"+jtxtAvgg.getText()+
						"\nRanking:\t\t"+jtxtRankk.getText()+"\n"
						);
				}
		});
		btnTranscript.setBackground(new Color(0, 139, 139));
		btnTranscript.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTranscript.setBounds(245, 685, 221, 51);
		frame.getContentPane().add(btnTranscript);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_sale.getModel();
				if(table_sale.getSelectedRow()==-1)
				{
					if(table_sale.getRowCount()==0)
					{
						JOptionPane.showMessageDialog(null,"no data to delete","Student Information System",JOptionPane.OK_OPTION);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Select a row to delete","Student Information System",JOptionPane.OK_OPTION);

					}
					
				}
				else
				{
					model.removeRow(table_sale.getSelectedRow());
				}
			}
		});
		btnDelete.setBackground(new Color(0, 139, 139));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDelete.setBounds(711, 685, 221, 51);
		frame.getContentPane().add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header=new MessageFormat("Printing In Progress");
				MessageFormat footer=new MessageFormat("page(0,number,integer)");
				try {
						table_sale.print();
					}
				catch(java.awt.print.PrinterException ae) {
					System.err.format("No printer found", ae.getMessage());
				}
				}
		});
		btnPrint.setBackground(new Color(0, 139, 139));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPrint.setBounds(478, 685, 221, 51);
		frame.getContentPane().add(btnPrint);
		
		JButton button_4 = new JButton("Exit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Do you want to exit?","Student Information System",
				JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		button_4.setBackground(new Color(0, 139, 139));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_4.setBounds(1177, 685, 221, 51);
		frame.getContentPane().add(button_4);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JTextField temp=null;
			for(Component c:panel_1.getComponents()) {
				if(c.getClass().toString().contains("javax.swing.JTextField")) {
					temp=(JTextField)c;
					temp.setText(null);
					
					
				}
			}
			jtxtTranscript.setText(null);
			jcmbCourseCode.setSelectedIndex(0);
			jtxtFirstName.setText(null);
			jtxtLastName.setText(null);
			jtxtStudentID.setText(null);
			jtxtMath.setText(null);
			jtxtEng.setText(null);
			jtxtBio.setText(null);
			jtxtBuisness.setText(null);
			jtxtphy.setText(null);
			jtxtchem.setText(null);
			jtxtcompute.setText(null);
			jtxtAddMathss.setText(null);
			jtxtTotall.setText(null);
			jtxtAvgg.setText(null);
			jtxtExamno.setText(null);
			jtxtRankk.setText(null);

			
			
			}
		});
		btnReset.setBackground(new Color(0, 139, 139));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReset.setBounds(944, 685, 221, 51);
		frame.getContentPane().add(btnReset);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
