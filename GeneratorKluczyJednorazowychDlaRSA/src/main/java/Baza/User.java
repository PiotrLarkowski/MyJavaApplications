package Baza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class User 
{
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String Login;
	private String Has�o;
	private String N;
	
	public User()
	{}
	
	public User(int id, String login, String has�o, String iloczyn)
	{ 
		this.id = id;
		this.Has�o = has�o;
		this.Login = login;
		this.N = iloczyn;
	}
	
	public String getILOCZYN() {
		return N;
	}

	public void setILOCZYN(String iLOCZYN) {
		N = iLOCZYN;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getHas�o() {
		return Has�o;
	}
	public void setHas�o(String has�o) {
		Has�o = has�o;
	}
}
