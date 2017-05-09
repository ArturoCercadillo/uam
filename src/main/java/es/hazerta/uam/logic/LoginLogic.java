package es.hazerta.uam.logic;

import es.hazerta.uam.bbdd.BBDD;

public class LoginLogic {
	private BBDD bbdd;
	public LoginLogic() {
		this.bbdd = new BBDD();
	}
	public boolean login(String user, String pass){
		return bbdd.login(user, pass);
	}
}
