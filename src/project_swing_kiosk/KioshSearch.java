package project_swing_kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KioshSearch {
	private KioshDAO dao = new KioshDAO();
	private KioshVO vo = null;
	private int res = 0;
	
	private JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtCount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public KioshSearch(KioshVO vo) {
		this.vo = vo;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("재활용기 등록 처리");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);    
		frame.setResizable(false);					
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 55);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("재활용기 등록 수정하기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 0, 760, 55);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 182, 193));
		pn2.setBounds(0, 54, 784, 72);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("1개당 10포인트");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 760, 52);
		pn2.add(lblNewLabel_2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 125, 784, 341);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(128, 96, 161, 38);
		pn3.add(lblName);
		
		JLabel lblAddr = new JLabel("사는곳");
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddr.setFont(new Font("굴림", Font.PLAIN, 15));
		lblAddr.setBounds(128, 154, 161, 38);
		pn3.add(lblAddr);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.PLAIN, 15));
		lblId.setBounds(128, 38, 161, 38);
		pn3.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 15));
		txtId.setEditable(false);
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setBounds(325, 38, 354, 38);
		pn3.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 15));
		txtName.setEditable(false);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setColumns(10);
		txtName.setBounds(325, 96, 354, 38);
		pn3.add(txtName);
		
		JRadioButton rdaddr1 = new JRadioButton("청원구");
		rdaddr1.setEnabled(false);
		buttonGroup.add(rdaddr1);
		rdaddr1.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr1.setBounds(325, 153, 69, 38);
		pn3.add(rdaddr1);
		
		JRadioButton rdaddr2 = new JRadioButton("상당구");
		rdaddr2.setEnabled(false);
		buttonGroup.add(rdaddr2);
		rdaddr2.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr2.setBounds(423, 153, 69, 38);
		pn3.add(rdaddr2);
		
		JRadioButton rdaddr3 = new JRadioButton("흥덕구");
		rdaddr3.setEnabled(false);
		buttonGroup.add(rdaddr3);
		rdaddr3.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr3.setBounds(516, 153, 69, 38);
		pn3.add(rdaddr3);
		
		JRadioButton rdaddr4 = new JRadioButton("서원구");
		rdaddr4.setEnabled(false);
		buttonGroup.add(rdaddr4);
		rdaddr4.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr4.setBounds(610, 153, 69, 38);
		pn3.add(rdaddr4);
		
		JLabel lblCount = new JLabel("수거수량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("굴림", Font.PLAIN, 15));
		lblCount.setBounds(128, 270, 161, 38);
		pn3.add(lblCount);
		
		txtCount = new JTextField();
		txtCount.setFont(new Font("굴림", Font.PLAIN, 15));
		txtCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCount.setColumns(10);
		txtCount.setBounds(324, 269, 242, 38);
		pn3.add(txtCount);
		
		JLabel lblType = new JLabel("수거종류");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("굴림", Font.PLAIN, 15));
		lblType.setBounds(128, 212, 161, 38);
		pn3.add(lblType);
		
		JComboBox cbType = new JComboBox();
		cbType.setFont(new Font("굴림", Font.PLAIN, 15));
		cbType.setModel(new DefaultComboBoxModel(new String[] {"투명페트병", "캔류", "유리병", "종이팩", "폐건전지"}));
		cbType.setBounds(322, 212, 357, 37);
		pn3.add(cbType);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 465, 784, 96);
		frame.getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JButton btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 16));
		btnUpdate.setBounds(97, 26, 150, 43);
		pn4.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 16));
		btnDelete.setBounds(334, 26, 150, 43);
		pn4.add(btnDelete);
		
		JButton btnClose = new JButton("종료");
		btnClose.setFont(new Font("굴림", Font.BOLD, 16));
		btnClose.setBounds(567, 26, 150, 43);
		pn4.add(btnClose);
		
		// vo에서 담겨서 넘어온 회원의 정보를 검색창에 뿌려줄수 있도록 처리한다.
		txtId.setText(vo.getUserID());
		txtName.setText(vo.getName());
		if(vo.getAddress().equals("청원구")) rdaddr1.setSelected(true);
		if(vo.getAddress().equals("상당구")) rdaddr2.setSelected(true);
		if(vo.getAddress().equals("흥덕구")) rdaddr3.setSelected(true);
		if(vo.getAddress().equals("서원구")) rdaddr4.setSelected(true);
		cbType.setSelectedItem(vo.getAddress());
		txtCount.setText(String.valueOf(vo.getCount()));
		
		JLabel lblNewLabel_1 = new JLabel("개");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(578, 276, 30, 26);
		pn3.add(lblNewLabel_1);
		
		frame.setVisible(true);
	//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
		
		// 회원 수정
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userID = txtId.getText().trim();
				String name = txtName.getText().trim();
				String address = "";
				String product = (String) cbType.getSelectedItem();
				int count = Integer.parseInt(txtCount.getText().trim());
				int pointToAdd = count * 10;
				
				//유효성검사
				if(rdaddr1.isSelected()) address = "청원구";
				else if(rdaddr2.isSelected()) address = "상당구";
				else if(rdaddr3.isSelected()) address = "흥덕구";
				else address = "서원구";
					
				//기록한 내용을 vo에 담아서 DB에 저장
				vo = new KioshVO();
				vo.setUserID(userID);
				vo.setName(name);
				vo.setAddress(address);
				vo.setProduct(product);
				vo.setCount(count);
				vo.setPoints(pointToAdd);
				
				res = dao.setKioshUpdata(vo);
				
				if(res !=0) {
					JOptionPane.showMessageDialog(frame, "수정 등록 완료");
//					frame.dispose();
//					new KioshMain();
				} else {
					JOptionPane.showMessageDialog(frame, "수정 등록 실패");
					txtId.requestFocus();
				}
			}
		});
		
		//삭제하기
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = txtId.getText();
				
				int ans = JOptionPane.showConfirmDialog(frame, "등록정보를 삭제하시겠습니까?", "정보삭제창", JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					int res = dao.setKioshDelete(userID);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(frame, "등록정보가 삭제되었습니다.");
						frame.dispose();
						new KioshMain();
					} else {
						JOptionPane.showMessageDialog(frame, "등록정보 삭제 취소되었습니다.");
					}
				}
			}
		});
				
		// 종료버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioshMain();
			}
		});
	}
}
