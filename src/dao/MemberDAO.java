package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBC.DBConnector;
import dto.MemberDTO;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	
	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	/* 접속해제 */
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) {con.close();}
			if(ps != null) {ps.close();}
			if(rs != null) {rs.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 로그인 */
	public MemberDTO login(MemberDTO dto) {
		MemberDTO loginDTO = null;
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT FROM MEMBER_TABLE WHERE ID = ? AND NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			rs = ps.executeQuery();
			if(rs.next()) {
				loginDTO = new MemberDTO();
				loginDTO.setNo(rs.getLong(1));
				loginDTO.setId(rs.getString(2));
				loginDTO.setName(rs.getString(3));
				loginDTO.setGrade(rs.getString(4));
				loginDTO.setPoint(rs.getLong(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return loginDTO;
	}
	
	
	/* 회원가입 */
	public int join(MemberDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO MEMBER_TABLE VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, 'bronze', 1000)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 회원탈퇴 */
	public int delete(long no) {
		int result = 0;
		try {
			sql = "DELETE FROM MEMBER_TABLE WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 정보수정 */
	public int updateMember(MemberDTO dto) {
		int result = 0;
		try {
			sql = "UPDATE MEMBER_TABLE SET NAME = ?, GRADE = ?, POINT = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getGrade());
			ps.setLong(3, dto.getPoint());
			ps.setLong(4, dto.getNo());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
