package com.test03.UI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.junit.Assert;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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

public class EmployeeUI extends JFrame{

	private JPanel contentPane;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfDate;
	private JSpinner spinnerPay;
	private ButtonGroup groupGender;
	private JRadioButton radioMale;
	private JRadioButton radioFemale;
	
	private JTable jTable ;
	private DefaultTableModel tableModel ;
	private JScrollPane scpane;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox comboBoxPosition;
	private JComboBox comboBoxDept;
	
	private String gender;
	private int genderCode;
	private String nowDate;
	
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem modifyMenu = new JMenuItem("수정");
	private JMenuItem deleteMenu = new JMenuItem("삭제");

	private static EmployeeService employeeService;
	private List<Employee> empList;

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
		
		spinnerPay = new JSpinner();
		spinnerPay.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		spinnerPay.setBounds(286, 132, 200, 22);
		contentPane.add(spinnerPay);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("굴림", Font.BOLD, 12));
		lblGender.setBounds(217, 160, 57, 15);
		contentPane.add(lblGender);
		
		radioMale = new JRadioButton("남");
		radioMale.setHorizontalAlignment(SwingConstants.RIGHT);
		radioMale.setSelected(true);
		radioMale.setBounds(282, 155, 43, 24);
		
		contentPane.add(radioMale);
		
		radioFemale = new JRadioButton("여");
		radioFemale.setHorizontalAlignment(SwingConstants.RIGHT);
		radioFemale.setBounds(329, 155, 43, 24);
		contentPane.add(radioFemale);
		
		groupGender = new ButtonGroup();
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
		
		nowDate = String.format("%04d-%02d-%02d",
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
				if(btnAdd.getText() == "추가"){
					//추가 이벤트
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
					
					DefaultTableModel m = new DefaultTableModel(row(),col());
					jTable.setModel(m);
					
					//사원추가후 입력필드 초기화
					clearField();
					
				}else if(btnAdd.getText() == "수정"){
					//수정 이벤트
					//사원정보 update하기
					Employee updEmp = new Employee();
					updEmp.setEno(Integer.parseInt(tfNum.getText()));
					updEmp.setEname(tfName.getText());
					
					switch (comboBoxPosition.getSelectedIndex()) {
					case 0:
						updEmp.setTitle(1);
						break;
						
					case 1:
						updEmp.setTitle(2);
						break;
						
					case 2:
						updEmp.setTitle(3);
						break;
						
					case 3:
						updEmp.setTitle(4);
						break;	
					
					case 4:
						updEmp.setTitle(5);
						break;	

					default:
						break;
					}// end of switch
					
					updEmp.setSalary(Integer.parseInt(spinnerPay.getValue().toString()));
					
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
					
					updEmp.setGender(genderCode);
					
					switch (comboBoxDept.getSelectedIndex()) {
					case 0:
						updEmp.setDno(1);
						break;
					
					case 1:
						updEmp.setDno(2);
						break;
					
					case 2:
						updEmp.setDno(3);
						break;
					
					case 3:
						updEmp.setDno(4);
						break;
						
					case 4:
						updEmp.setDno(5);

					default:
						break;
					}// end of switch
					
					String inputDate = tfDate.getText();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date userDate;
					try {
						userDate = dateFormat.parse(inputDate);
						updEmp.setJoindate(userDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					int res = employeeService.updateEmployee(updEmp);
					DefaultTableModel m = new DefaultTableModel(row(),col());
					jTable.setModel(m);
					
					//사원 수정 후 입력필드 초기화
					clearField();
					
					//수정버튼 다시 추가로 바꾸기
					btnAdd.setText("추가");				
				}
					
				
				jTable.setComponentPopupMenu(popupMenu);
				
				jTable.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getButton() ==3) //마우스 오른쪽 버튼이면
				        {
							jTable.setComponentPopupMenu(popupMenu);
				        }
						
					}
				});
			}// end of btnAdd.addActionListener
		});
		
		btnAdd.setBounds(226, 270, 97, 23);
		contentPane.add(btnAdd);
		
		
		btnCancel = new JButton("취소");
		
		//취소버튼 초기화
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearField();
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
		
		scpane = new JScrollPane();
		contentPane.add(scpane);
		
		jTable = new JTable(tableModel);
		tableModel = new DefaultTableModel(row(), col());
		scpane.setViewportView(jTable);
		jTable.setModel(tableModel);
		
		
		scpane.setLocation(12, 325);
		scpane.setSize(683, 269);
		
		
		//수정, 삭제 팝업메뉴
		popupMenu.add(modifyMenu);
		popupMenu.add(deleteMenu);
		jTable.setComponentPopupMenu(popupMenu);
		
		modifyMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				//추가버튼 수정으로 바꾸기
				btnAdd.setText("수정");
				
				//선택한 사원으로 필드 갱신
				int row = jTable.getSelectedRow();
				Employee findEmp = empList.get(row);
				
				tfNum.setText(String.valueOf(findEmp.getEno()));
				tfName.setText(findEmp.getEname());
				spinnerPay.setValue(findEmp.getSalary());
				tfDate.setText(dateFormat.format(findEmp.getJoindate()));
				
				int genderCode = findEmp.getGender();
				if(genderCode==1){
					radioMale.setSelected(true);
				}else{
					radioFemale.setSelected(true);
				}
				
				switch (findEmp.getTitle()) {
				case 1:comboBoxPosition.setSelectedIndex(0);
					break;
				case 2:comboBoxPosition.setSelectedIndex(1);
					break;
				case 3:comboBoxPosition.setSelectedIndex(2);
					break;
				case 4:comboBoxPosition.setSelectedIndex(3);
					break;
				case 5:comboBoxPosition.setSelectedIndex(4);
					break;
				}
				
				switch (findEmp.getDno()) {
				case 1:comboBoxDept.setSelectedIndex(0);
					break;
				case 2:comboBoxDept.setSelectedIndex(1);
					break;
				case 3:comboBoxDept.setSelectedIndex(2);
					break;
				case 4:comboBoxDept.setSelectedIndex(3);
					break;
				case 5:comboBoxDept.setSelectedIndex(4);
					break;
				}
				
			}
		});
		
		deleteMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jTable.getSelectedRow();
				
				Employee selEmp = empList.get(row);
				
				employeeService.deleteEmployee(selEmp.getEno());
				
				DefaultTableModel m = new DefaultTableModel(row(),col());
				jTable.setModel(m);
				JOptionPane.showMessageDialog(null, "삭제되었습니다.");
			}
		});

		
	}
	
	public void clearField(){
		Employee lastEmp = employeeService.findLastEmployee();
		int nextEno = lastEmp.getEno()+1;
		tfNum.setText(String.valueOf(nextEno));
		tfName.setText("");
		spinnerPay.setValue(1500000);
		radioMale.setSelected(true);
		tfDate.setText(nowDate);
		comboBoxPosition.setSelectedIndex(0);
		comboBoxDept.setSelectedIndex(0);
	}
	
	
	private String[][] row(){
		empList = employeeService.findAllEmployee();
		String[][] rowDatas = new String[empList.size()][];
		for(int i=0;i<rowDatas.length;i++){
			rowDatas[i] = empList.get(i).toArray();
		}
		return rowDatas;
	}
	
	private String[] col(){
		String columnNames[] = {"번호","사원명","직책","급여","성별","부서","입사일"};
		return columnNames;
	}
}
