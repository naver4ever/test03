package com.test03.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ERP_Application extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
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
	public ERP_Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 144);
		setTitle("대구아이티ERP");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnEmpManager = new JButton("사원관리");
		btnEmpManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmployeeUI employeeUI = new EmployeeUI();
				employeeUI.setVisible(true);
			}
		});
		contentPane.add(btnEmpManager);
		
		JButton btnDeptManager = new JButton("부서관리");
		btnDeptManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DepartmentUI departmentUI = new DepartmentUI();
				departmentUI.setVisible(true);
			}
		});
		contentPane.add(btnDeptManager);
		
		JButton btnPosManager = new JButton("직책관리");
		btnPosManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PositionUI positionUI = new PositionUI();
				positionUI.setVisible(true);
			}
		});
		contentPane.add(btnPosManager);
	}

}
