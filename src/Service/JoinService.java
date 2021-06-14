package Service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		
		int result = MemberDAO.getInstance().join(dto);
		
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('회원가입에 성공하였습니다!')");
				out.println("location.href = '/ServerProgram1/login.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원가입에 실패하였습니다.')");
				out.println("location.href = '/ServerProgram1/joinPage.do'");
				out.println("</script>");
			}
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
