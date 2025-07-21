package t7ex_kiosk;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings({ "rawtypes", "unused"})
public class KioshList {
	private KioshDAO dao = new KioshDAO();
	private KioshVO vo = null;
	private int res = 0;

	private JFrame frame;
	private JTable table;
	
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JTable table_1;
	private JTextField txtCondition;

//	public static void main(String[] args) {
//		new KioshList();
//	}

	public KioshList() {
		initialize();
	}

	@SuppressWarnings({ "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("재활용품 수거 키오스크");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 786, 80);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(12, 22, 178, 48);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		JButton btnCondition = new JButton("아이디검색");
		btnCondition.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCondition.setBounds(208, 22, 124, 48);
		pn1.add(btnCondition);
		
		JButton btnClose = new JButton("종료");
		btnClose.setBounds(683, 21, 91, 49);
		pn1.add(btnClose);
		btnClose.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 79, 786, 394);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 472, 786, 91);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		//JTable
		title = new Vector();
		title.add("아이디");
		title.add("성명");
		title.add("주소");
		title.add("종류");
		title.add("개수");
		title.add("포인트");
		title.add("등록일");
		
		vData = dao.getKioshList();
		
		dtm = new DefaultTableModel(vData, title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 762, 370);
		pn2.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);

		
		frame.setVisible(true);
	//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------
	
		//종료
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioshMain();
			}
		});
		
		// 조건검색버튼을 마우스로 클릭시 수행
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textCondition = txtCondition.getText();
				
				if(textCondition.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "검색할 내용을 입력하세요.");
					txtCondition.requestFocus();
					return;
				}
				vData = dao.getConditionSearch("userID", textCondition);
				
				dtm.setDataVector(vData, title);
			}
		});
	
	}
}
