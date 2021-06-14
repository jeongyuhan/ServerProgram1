package controller;

import Service.DeleteService;
import Service.JoinPageService;
import Service.JoinService;
import Service.ListService;
import Service.LoginService;
import Service.LogoutService;
import Service.MemberService;
import Service.UpdateService;
import Service.deletePageService;

public class ServiceMapper {
	
	private static ServiceMapper instance = new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if(instance == null) {
			instance = new ServiceMapper();
		}
		return instance;
	}
	
	public MemberService getCommand(String cmd) {
		MemberService command = null;
		switch(cmd) {
		case "list.do":
			command = new ListService();
			break;
		case "login.do":
			command = new LoginService();
			break;
		case "logout.do":
			command = new LogoutService();
			break;
		case "joinPage.do":
			command = new JoinPageService();
			break;
		case "join.do":
			command = new JoinService();
			break;
		case "deleteMember.do":
			command = new DeleteService();
			break;
		case "delete.do":
			command = new deletePageService();
			break;
		case "updateMember.do":
			command = new UpdateService();
			break;
		}
		return command;
	}
	
}
