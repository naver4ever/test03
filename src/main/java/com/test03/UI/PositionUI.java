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

public class PositionUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JTextField tfPosition;
	
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
					PositionUI frame = new PositionUI();
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
	public PositionUI() {
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
		tfNum.setText("T001");
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblPosition = new JLabel("직책명");
		lblPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosition.setFont(new Font("굴림", Font.BOLD, 12));
		lblPosition.setBounds(69, 55, 57, 15);
		contentPane.add(lblPosition);
		
		tfPosition = new JTextField();
		tfPosition.setColumns(10);
		tfPosition.setBounds(141, 52, 178, 21);
		contentPane.add(tfPosition);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(89, 141, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(198, 141, 97, 23);
		contentPane.add(btnCancel);
		
		//테이블
		String columnNames[] = {"번호","직책"};
		Object data[][] = {{"T001","사장"},
				{"T002","부장"},
				{"T003","과장"},
				{"T004","대리"},
				{"T005","사원"}};
	
		tableModel = new DefaultTableModel(data, columnNames);
		jTable = new JTable(tableModel);
		scpane = new JScrollPane(jTable);
		scpane.setLocation(12, 174);
		scpane.setSize(360, 166);
		
		contentPane.add(scpane);
		

	}
}

