package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;

public class LogoutService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return new ModelAndView("/ServerProgram1/login.jsp", true);
	}

}
