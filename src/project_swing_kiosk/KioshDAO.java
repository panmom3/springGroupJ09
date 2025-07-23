package project_swing_kiosk;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class KioshDAO extends DBConn{
	KioshVO vo = null;
	
	// 등록
	public int setKioshInput(KioshVO vo) {
		int res = 0;
		try {
			sql = "insert into recycling values (?,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getProduct());
			pstmt.setInt(5, vo.getCount());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setKioshInput) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	// 등록 개별 조회
	public KioshVO getIdSearch(String userID) {
		vo = new KioshVO();
		try {
			sql = "select * from recycling where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setUserID(rs.getString("userID"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setProduct(rs.getString("product"));
				vo.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getIdSearch) : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}
	// 등록 정보 수정하기
	public int setKioshUpdata(KioshVO vo) {
		int res = 0;
		try {
			sql = "update recycling set address=? , product=? , count=? where userID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAddress());
			pstmt.setString(2, vo.getProduct());
			pstmt.setInt(3, vo.getCount());
			pstmt.setString(4, vo.getUserID());
			res = pstmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("sql오류(setKioshUpdata) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	// 등록 정보 삭제하기
	public int setKioshDelete(String userID) {
		int res = 0;
		try {
			sql = "delete from recycling where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setKioshDelete) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	// 리스트
	public Vector getKioshList() {
		Vector vData = new Vector();
		try {
			sql = "select userID from recycling order by createdAt";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getString("userID"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("address"));
				vo.add(rs.getString("product"));
				vo.add(rs.getInt("count"));
				vo.add(rs.getInt("points"));
				vo.add(rs.getString("createdAt"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getKioshList) : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}

	public Vector getConditionSearch(String fieldName, String textCondition) {
		Vector vData = new Vector();
		try {
			sql = "select * from recycling where "+fieldName+" like ? order by createdAt";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, textCondition);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getString("userID"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("address"));
				vo.add(rs.getString("product"));
				vo.add(rs.getInt("count"));
				vo.add(rs.getInt("points"));
				vo.add(rs.getString("createdAt"));
				vData.add(vo);
			}
			
		}	catch (SQLException e) {
			System.out.println("sql오류(getConditionSearch) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
	//포인트적립
	public int setKioshPointIn(KioshVO vo) {
		int res = 0;
		//int point = 0;
//		try {
//			sql = "select points from recycling where userID = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getUserID());
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				point = rs.getInt("points");
//			}
//			
//			//
//			
//			rs.close();
//			pstmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return point;
		
		
		try {
			sql = "update recycling set points = ? where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPoints());
			pstmt.setString(2, vo.getUserID());
			res = pstmt.executeUpdate();	
	
		} catch (SQLException e) {
			System.out.println("sql오류(setKioshPointIn) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	

	
}
