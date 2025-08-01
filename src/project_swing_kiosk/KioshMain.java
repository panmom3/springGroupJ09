package project_swing_kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class KioshMain {

	private JFrame frame;

	public static void main(String[] args) {
		new KioshMain();
	}

	public KioshMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("재활용품 수거 키오스크");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(102, 205, 170));
		pn1.setBounds(0, 0, 784, 76);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("재활용기 수거 등록하세요");
		lblTitle.setBackground(new Color(102, 205, 170));
		lblTitle.setFont(new Font("휴먼엑스포", Font.PLAIN, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 760, 56);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 74, 389, 487);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(KioshMain.class.getResource("/project_swing_kiosk/images/20250723_145003.png")));
		lblNewLabel.setBounds(0, 0, 389, 487);
		pn2.add(lblNewLabel);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(388, 74, 396, 487);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 18));
		btnInput.setBounds(110, 27, 185, 88);
		pn3.add(btnInput);
		
		JButton btnList = new JButton("등록리스트");
		btnList.setFont(new Font("굴림", Font.BOLD, 18));
		btnList.setBounds(110, 257, 185, 88);
		pn3.add(btnList);
		
		JButton btnSearch = new JButton("검색&수정");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 18));
		btnSearch.setBounds(110, 142, 185, 88);
		pn3.add(btnSearch);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(110, 372, 185, 88);
		pn3.add(btnExit);
		
		frame.setVisible(true);
	//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------
		
		// 등록버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioshInput();
			}
		});
		
		// 개별조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = JOptionPane.showInputDialog("검색할 아이디를 입력하세요");
				KioshDAO dao = new KioshDAO();
				KioshVO vo = dao.getIdSearch(userID);
				
				if(vo.getUserID() == null) JOptionPane.showMessageDialog(frame, "검색할 아이디가 없습니다.");
				else {
					frame.dispose();
					new KioshSearch(vo);
				}
			}
		});
		
		//등록리스트 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioshList();
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int ans = JOptionPane.showConfirmDialog(frame, "작업종료할까요??","작업종료", JOptionPane.YES_NO_OPTION);
			if(ans == 0) System.exit(0);		
			}
		});
	}

}
