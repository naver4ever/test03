package com.test03.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DepartmentUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JTextField tfDept;
	private JTextField tfFloor;
	
	private JTable jTable = null;
	private DefaultTableModel tableModel = null;
	private JScrollPane scpane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentUI frame = new DepartmentUI();
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
	public DepartmentUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNum = new JLabel("번호");
		lblNum.setFont(new Font("굴림", Font.BOLD, 12));
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(69, 27, 57, 15);
		contentPane.add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setEditable(false);
		tfNum.setBounds(141, 24, 178, 21);
		tfNum.setText("D001");
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblDept = new JLabel("부서명");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDept.setFont(new Font("굴림", Font.BOLD, 12));
		lblDept.setBounds(69, 55, 57, 15);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(141, 52, 178, 21);
		contentPane.add(tfDept);
		
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFloor.setFont(new Font("굴림", Font.BOLD, 12));
		lblFloor.setBounds(69, 83, 57, 15);
		contentPane.add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		tfFloor.setBounds(141, 80, 178, 21);
		contentPane.add(tfFloor);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(89, 141, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(198, 141, 97, 23);
		contentPane.add(btnCancel);
		
		//테이블
		String columnNames[] = {"번호","부서명","위치"};
		Object data[][] = {{"D001","마케팅","10"},
				{"D002","개발","9"},
				{"D003","인사","6"},
				{"D004","총무","7"},
				{"D005","경영","4"}};
	
		tableModel = new DefaultTableModel(data, columnNames);
		jTable = new JTable(tableModel);
		scpane = new JScrollPane(jTable);
		scpane.setLocation(12, 174);
		scpane.setSize(360, 166);
		
		contentPane.add(scpane);
		

	}
}

