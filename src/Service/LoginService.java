package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		
		MemberDTO loginDTO = MemberDAO.getInstance().login(dto);
		
		if(loginDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginDTO", loginDTO);
		}
		
		return new ModelAndView("/ServerProgram1/member/manager.jsp", true);
	}

}
