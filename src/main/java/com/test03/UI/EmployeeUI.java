package com.test03.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.junit.Assert;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.test03.dto.Employee;
import com.test03.service.EmployeeService;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class EmployeeUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfDate; 
	
	private JTable jTable = null;
	private DefaultTableModel tableModel = null;
	private JScrollPane scpane;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox comboBoxPosition;
	private JComboBox comboBoxDept;
	
	private String gender;
	private int genderCode;

	private static EmployeeService employeeService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUI frame = new EmployeeUI();
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
	public EmployeeUI() {
		
		employeeService = EmployeeService.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 659);
		setTitle("사원 관리");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setFont(new Font("굴림", Font.BOLD, 12));
		lblNum.setBounds(217, 57, 57, 15);
		contentPane.add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setEditable(false);
		tfNum.setBounds(286, 54, 200, 21);
		tfNum.setText("E0000002");
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		//사원번호 설정
		Employee lastEmp = employeeService.findLastEmployee();
		int nextEno =  lastEmp.getEno()+1;
		tfNum.setText(String.valueOf(nextEno));
		
		JLabel lblName = new JLabel("사원명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("굴림", Font.BOLD, 12));
		lblName.setBounds(217, 85, 57, 15);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(286, 82, 200, 21);
		contentPane.add(tfName);
		
		JLabel lblPostion = new JLabel("직책");
		lblPostion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostion.setFont(new Font("굴림", Font.BOLD, 12));
		lblPostion.setBounds(217, 110, 57, 15);
		contentPane.add(lblPostion);
		
		JLabel lblPay = new JLabel("급여");
		lblPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPay.setFont(new Font("굴림", Font.BOLD, 12));
		lblPay.setBounds(217, 135, 57, 15);
		contentPane.add(lblPay);
		
		JSpinner spinnerPay = new JSpinner();
		spinnerPay.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		spinnerPay.setBounds(286, 132, 200, 22);
		contentPane.add(spinnerPay);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("굴림", Font.BOLD, 12));
		lblGender.setBounds(217, 160, 57, 15);
		contentPane.add(lblGender);
		
		JRadioButton radioMale = new JRadioButton("남");
		radioMale.setHorizontalAlignment(SwingConstants.RIGHT);
		radioMale.setSelected(true);
		radioMale.setBounds(282, 155, 43, 24);
		
		contentPane.add(radioMale);
		
		JRadioButton radioFemale = new JRadioButton("여");
		radioFemale.setHorizontalAlignment(SwingConstants.RIGHT);
		radioFemale.setBounds(329, 155, 43, 24);
		contentPane.add(radioFemale);
		
		ButtonGroup groupGender = new ButtonGroup();
		groupGender.add(radioMale);
		groupGender.add(radioFemale);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDept.setFont(new Font("굴림", Font.BOLD, 12));
		lblDept.setBounds(217, 185, 57, 15);
		contentPane.add(lblDept);
		
		JLabel lblDate = new JLabel("입사일");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("굴림", Font.BOLD, 12));
		lblDate.setBounds(217, 210, 57, 15);
		contentPane.add(lblDate);
		
		//오늘 날짜
		Calendar cal = Calendar.getInstance();
		
		String nowDate = String.format("%04d-%02d-%02d",
                cal.get(Calendar.YEAR),
                (cal.get(Calendar.MONTH) + 1),
                cal.get(Calendar.DAY_OF_MONTH)
            );

		tfDate = new JTextField();
		tfDate.setBounds(286, 207, 200, 21);
		tfDate.setText(nowDate);
		contentPane.add(tfDate);
		tfDate.setColumns(10);
		
		btnAdd = new JButton("추가");
		
		//사원 추가 이벤트
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee newEmp = new Employee();
				newEmp.setEno(Integer.parseInt(tfNum.getText()));
				newEmp.setEname(tfName.getText());
				
				switch (comboBoxPosition.getSelectedIndex()) {
				case 0:
					newEmp.setTitle(1);
					break;
					
				case 1:
					newEmp.setTitle(2);
					break;
					
				case 2:
					newEmp.setTitle(3);
					break;
					
				case 3:
					newEmp.setTitle(4);
					break;	
				
				case 4:
					newEmp.setTitle(5);
					break;	

				default:
					break;
				}// end of switch
				
				newEmp.setSalary(Integer.parseInt(spinnerPay.getValue().toString()));
				
				Enumeration<AbstractButton> enums = groupGender.getElements();
				
				while(enums.hasMoreElements()) {           
				    AbstractButton ab = enums.nextElement();    
				    JRadioButton jb = (JRadioButton)ab; 				 
				    if(jb.isSelected())
				    	gender = jb.getText().trim(); //getText() 메소드로 문자열 받아낸다.
				}// end of while
				
				if(gender.equals("남")){
					genderCode =1;
				}else if(gender.equals("여")){
					genderCode=2;
				}
				
				newEmp.setGender(genderCode);
				
				switch (comboBoxDept.getSelectedIndex()) {
				case 0:
					newEmp.setDno(1);
					break;
				
				case 1:
					newEmp.setDno(2);
					break;
				
				case 2:
					newEmp.setDno(3);
					break;
				
				case 3:
					newEmp.setDno(4);
					break;
					
				case 4:
					newEmp.setDno(5);

				default:
					break;
				}// end of switch
				
				String inputDate = tfDate.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date userDate;
				try {
					userDate = dateFormat.parse(inputDate);
					newEmp.setJoindate(userDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				int res = employeeService.insertEmployee(newEmp);
				
				
				
			}
		});
		btnAdd.setBounds(226, 270, 97, 23);
		contentPane.add(btnAdd);
		
		
		btnCancel = new JButton(" 취소");
		
		//취소버튼 초기화
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfName.setText("");
				spinnerPay.setValue(1500000);
				radioMale.setSelected(true);
				tfDate.setText(nowDate);
				comboBoxPosition.setSelectedIndex(0);
				comboBoxDept.setSelectedIndex(0);
			}
		});
		
		btnCancel.setBounds(327, 270, 97, 23);
		contentPane.add(btnCancel);
		
		comboBoxPosition = new JComboBox();
		comboBoxPosition.setModel(new DefaultComboBoxModel(new String[] {"사장", "부장", "과장", "대리", "사원"}));
		comboBoxPosition.setBounds(286, 107, 200, 21);
		contentPane.add(comboBoxPosition);
		
		comboBoxDept = new JComboBox();
		comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"마케팅(10층)" ,"개발(9층)", "인사(6층)", "총무(7층)", "경영(4층)"}));
		comboBoxDept.setBounds(286, 182, 200, 21);
		contentPane.add(comboBoxDept);
		
		
		String columnNames[] = {"번호","사원명","직책","급여","성별","부서","입사일"};
		Object data[][] = {{"E0000001","사장1","사장","5,000,000","남","경영(4층)","2002-05-05"},
				{"E0000001","사장2","사장","5,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","사장3","사장","5,000,000","남","마케팅(10층)","2003-05-06"},
				{"E0000001","사장4","사장","5,000,000","남","개발(9층)","2004-05-06"},
				{"E0000001","사장5","사장","5,000,000","남","경영(4층)","2005-05-06"},
				{"E0000001","부장1","부장","4,000,000","남","경영(4층)","2006-05-06"},
				{"E0000001","부장2","부장","4,000,000","남","마케팅(10층)","2002-05-06"},
				{"E0000001","부장3","부장","4,000,000","남","개발(9층)","2012-05-06"},
				{"E0000001","부장4","부장","4,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","부장5","부장","4,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","과장1","과장","3,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","과장2","과장","3,000,000","남","마케팅(10층)","2002-05-06"},
				{"E0000001","과장3","과장","3,000,000","남","개발(9층)","2002-05-06"},
				{"E0000001","과장4","과장","3,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","과장5","과장","3,000,000","남","경영(4층)","2002-05-06"},
				{"E0000001","대리1","대리","2,500,000","남","경영(4층)","2002-05-06"},
				{"E0000001","대리2","대리","2,500,000","남","마케팅(10층)","2002-05-06"},
				{"E0000001","대리3","대리","2,500,000","남","개발(9층)","2002-05-06"},
				{"E0000001","대리4","대리","2,500,000","남","경영(4층)","2002-05-06"},
				{"E0000001","대리5","대리","2,500,000","남","경영(4층)","2002-05-06"}};
		
		
		tableModel = new DefaultTableModel(data, columnNames);
		jTable = new JTable(tableModel);
		scpane = new JScrollPane(jTable);
		scpane.setLocation(12, 325);
		scpane.setSize(683, 269);
		contentPane.add(scpane);
		
	}
}
