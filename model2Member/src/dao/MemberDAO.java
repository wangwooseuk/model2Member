package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.MemberBean;

public class MemberDAO {
	Connection con;
	private static MemberDAO memberDAO;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(MemberBean member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String loginId = null;
		String sql = "select id from member where id=? and pw=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("id");
			}
		} catch(Exception e) {
			System.out.println("로그인 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public int insertMember(MemberBean member) {
		PreparedStatement pstmt = null;
		String sql = "insert into member values (?, ?, ?, ?, ?, ?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("joinMember 에러: " + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					mb = new MemberBean();
					mb.setId(rs.getString("id"));
					mb.setPw(rs.getString("pw"));
					mb.setName(rs.getString("name"));
					mb.setAge(rs.getInt("age"));
					mb.setGender(rs.getString("gender"));
					mb.setEmail(rs.getString("email"));
					memberList.add(mb);
				} while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("getDetailMember 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public MemberBean selectMember(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		MemberBean mb = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
			}
		} catch(Exception e) {
			System.out.println("getDetailMember 에러 " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return mb;
	}

	public int deleteMember(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("deleteMember 에러: " + e);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

}
