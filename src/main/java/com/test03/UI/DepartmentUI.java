package com.test03.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.test03.dto.Department;
import com.test03.service.DepartmentService;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class DepartmentUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum;
	private JTextField tfDept;
	private JTextField tfFloor;
	
	private JTable jTable ;
	private DefaultTableModel tableModel ;
	private JScrollPane scpane;
	
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem modifyMenu = new JMenuItem("수정");
	private JMenuItem deleteMenu = new JMenuItem("삭제");
	
	private static DepartmentService departmentService;
	private List<Department> deptList;


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
		
		departmentService = DepartmentService.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setTitle("부서관리");
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
		
		//부서번호 설정
		Department lastDept = departmentService.findLastDepartment();
		int nextDcode = lastDept.getDcode()+1;
		tfNum.setText(String.valueOf(nextDcode));
		
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
		
		//부서 추가 이벤트
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText() == "추가"){
					//추가 이벤트
					Department newDept = new Department();
					newDept.setDcode(Integer.parseInt(tfNum.getText()));
					newDept.setDname(tfDept.getText());
					newDept.setFloor(Integer.parseInt(tfFloor.getText()));
					
					int res = departmentService.insertDepartment(newDept);
					
					DefaultTableModel m = new DefaultTableModel(row(),col());
					jTable.setModel(m);
					
					//부서 추가후 입력필드 초기화
					clearField();
					
				}else if(btnAdd.getText() == "수정"){
					//수정 이벤트
					//부서정보 update
					
					Department updDept = new Department();
					updDept.setDcode(Integer.parseInt(tfNum.getText()));
					updDept.setDname(tfDept.getText());
					updDept.setFloor(Integer.parseInt(tfFloor.getText()));
					
					int res = departmentService.updateDepartment(updDept);
					
					DefaultTableModel m = new DefaultTableModel(row(),col());
					jTable.setModel(m);
					
					//부서 수정 후 입력필드 초기화
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
				
			}
		});
		btnAdd.setBounds(89, 141, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(198, 141, 97, 23);
		contentPane.add(btnCancel);
		
		//테이블 생성
		
		scpane = new JScrollPane();
		contentPane.add(scpane);
		
		jTable = new JTable(tableModel);
		tableModel = new DefaultTableModel(row(), col());
		scpane.setViewportView(jTable);
		jTable.setModel(tableModel);
		
		scpane.setLocation(12, 174);
		scpane.setSize(360, 177);
		
		//수정, 삭제 팝업메뉴
		popupMenu.add(modifyMenu);
		popupMenu.add(deleteMenu);
		jTable.setComponentPopupMenu(popupMenu);
		
		modifyMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//추가버튼 수정으로 바꾸기
				btnAdd.setText("수정");
				
				//선택한 부서로  필드 갱신
				int row = jTable.getSelectedRow();
				Department findDept = deptList.get(row);
				
				tfNum.setText(String.valueOf(findDept.getDcode()));
				tfDept.setText(findDept.getDname());
				tfFloor.setText(String.valueOf(findDept.getFloor()));
				
			}
		});// end of modifyMenu.addActionListener
		
		deleteMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jTable.getSelectedRow();
				
				Department selDept = deptList.get(row);
				
				departmentService.deleteDepartment(selDept.getDcode());
				
				DefaultTableModel m = new DefaultTableModel(row(),col());
				jTable.setModel(m);
				JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				
			}
		});
		

	}
	
	private String[][] row(){
		deptList = departmentService.findAllDepartment();
		String[][] rowDatas = new String[deptList.size()][];
		for(int i=0;i<rowDatas.length;i++){
			rowDatas[i] = deptList.get(i).toArray();
		}
		return rowDatas;
	}
	
	private String[] col(){
		String columnNames[] = {"번호","부서명","위치"};
		return columnNames;
	}
	
	public void clearField(){
		Department lastDept = departmentService.findLastDepartment();
		int nextDcode = lastDept.getDcode()+1;
		tfNum.setText(String.valueOf(nextDcode));
		tfDept.setText("");
		tfFloor.setText("");
	}
}

