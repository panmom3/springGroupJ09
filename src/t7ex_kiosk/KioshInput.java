package t7ex_kiosk;

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

public class KioshInput {
	private KioshDAO dao = new KioshDAO();
	private KioshVO vo = null;
	private int res = 0;
	
	private JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtCount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public KioshInput() {
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
		
		JLabel lblNewLabel = new JLabel("재활용기 등록 화면");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(67, 0, 705, 55);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(204, 255, 204));
		pn2.setBounds(0, 54, 784, 72);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("１개당 １０포인트 적립");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(182, 10, 472, 52);
		pn2.add(lblNewLabel_2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 125, 784, 341);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(134, 95, 161, 38);
		pn3.add(lblName);
		
		JLabel lblAddr = new JLabel("사는곳");
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddr.setFont(new Font("굴림", Font.PLAIN, 15));
		lblAddr.setBounds(134, 153, 161, 38);
		pn3.add(lblAddr);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.PLAIN, 15));
		lblId.setBounds(134, 37, 161, 38);
		pn3.add(lblId);
		
		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setBounds(331, 37, 354, 38);
		pn3.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setColumns(10);
		txtName.setBounds(331, 95, 354, 38);
		pn3.add(txtName);
		
		JRadioButton rdaddr1 = new JRadioButton("청원구");
		buttonGroup.add(rdaddr1);
		rdaddr1.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr1.setBounds(331, 152, 69, 38);
		pn3.add(rdaddr1);
		
		JRadioButton rdaddr2 = new JRadioButton("상당구");
		buttonGroup.add(rdaddr2);
		rdaddr2.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr2.setBounds(429, 152, 69, 38);
		pn3.add(rdaddr2);
		
		JRadioButton rdaddr3 = new JRadioButton("흥덕구");
		buttonGroup.add(rdaddr3);
		rdaddr3.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr3.setBounds(522, 152, 69, 38);
		pn3.add(rdaddr3);
		
		JRadioButton rdaddr4 = new JRadioButton("서원구");
		buttonGroup.add(rdaddr4);
		rdaddr4.setFont(new Font("굴림", Font.PLAIN, 15));
		rdaddr4.setBounds(616, 152, 69, 38);
		pn3.add(rdaddr4);
		
		JLabel lblCount = new JLabel("수거수량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("굴림", Font.PLAIN, 15));
		lblCount.setBounds(134, 269, 161, 38);
		pn3.add(lblCount);
		
		txtCount = new JTextField();
		txtCount.setFont(new Font("굴림", Font.PLAIN, 15));
		txtCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCount.setColumns(10);
		txtCount.setBounds(330, 268, 242, 38);
		pn3.add(txtCount);
		
		JLabel lblType = new JLabel("수거종류");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("굴림", Font.PLAIN, 15));
		lblType.setBounds(134, 211, 161, 38);
		pn3.add(lblType);
		
		JComboBox cbType = new JComboBox();
		cbType.setFont(new Font("굴림", Font.PLAIN, 15));
		cbType.setModel(new DefaultComboBoxModel(new String[] {"투명페트병", "캔류", "유리병", "종이팩", "폐건전지"}));
		cbType.setBounds(328, 211, 357, 37);
		pn3.add(cbType);
		
		JButton btnPointIn = new JButton("적립");
		btnPointIn.setFont(new Font("굴림", Font.PLAIN, 15));
		btnPointIn.setBounds(584, 269, 101, 38);
		pn3.add(btnPointIn);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 465, 784, 96);
		frame.getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JButton btnInput = new JButton("등록하기");
		btnInput.setFont(new Font("굴림", Font.BOLD, 16));
		btnInput.setBounds(248, 25, 150, 43);
		pn4.add(btnInput);
		
		JButton btnClose = new JButton("종료하기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 16));
		btnClose.setBounds(410, 25, 150, 43);
		pn4.add(btnClose);
		
		frame.setVisible(true);
	//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
		
		// 등록버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = txtId.getText().trim();
				String name = txtName.getText().trim();
				String address = "";
				String product = (String) cbType.getSelectedItem();
				int count = Integer.parseInt(txtCount.getText().trim());
				
				//유효성검사
				if(userID.equals("")) {
					JOptionPane.showMessageDialog(frame, "아이디를 입력하세요");
					txtId.requestFocus();
				} else if(name.equals("")) {
					JOptionPane.showMessageDialog(frame, "이름을 입력하세요");
				} else {
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
					
					res = dao.setKioshInput(vo);
					
					if(res !=0) {
						JOptionPane.showMessageDialog(frame, "수거 등록 완료");
						frame.dispose();
						new KioshMain();
					} else {
						JOptionPane.showMessageDialog(frame, "수거 등록 실패");
						txtId.requestFocus();
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
