package Service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class DeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		
		int result = MemberDAO.getInstance().delete(loginDTO.getNo());
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				// session 초기화
				session.invalidate();
				out.println("<script>");
				out.println("location.href = '/ServerProgram1/delete.do'");
				out.println("</script>");
			} else {
				session.invalidate();
				out.println("<script>");
				out.println("alert('탈퇴되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 		
		return null;
	}

}
