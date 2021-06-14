package Service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		long point = Long.parseLong(request.getParameter("point"));
		
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		
		String grade = loginDTO.getGrade();
		if(point >= 5000) {
			grade = "vip";
		} else if(point >= 4000) {
			grade = "gold";
		} else if(point >= 3000) {
			grade = "silver";
		} else {
			grade = "bronze";
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPoint(point);
		dto.setGrade(grade);
		dto.setNo(loginDTO.getNo());
		
		int result = MemberDAO.getInstance().updateMember(dto);
		
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				// session의 loginDTO 업데이트
				loginDTO.setName(name);
				loginDTO.setPoint(point);
				
				// 응답 및 이동
				out.println("<script>");
				out.println("alert('회원정보가 수정되었습니다.')");
				out.println("location.href = '/ServerProgram1/login.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원정보가 수정되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
