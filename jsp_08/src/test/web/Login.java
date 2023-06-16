package test.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Login implements HttpSessionBindingListener {
	private String userName;
	private String userID;
	private String pass;
	private static int total;
	
	public Login(String userName, String userID, String pass) {
		this.userName = userName;
		this.userID = userID;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserID() {
		return userID;
	}

	public String getPass() {
		return pass;
	}

	public static int getTotal() {
		return total;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(">>>> valueBound ...");
		total++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(">>>> valueUnbound ...");
		total--;
	}
}