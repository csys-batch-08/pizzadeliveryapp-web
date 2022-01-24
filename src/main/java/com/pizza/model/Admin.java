package com.pizza.model;

import java.util.Objects;

public class Admin {
	private String adminemail;
	private String adminname;
	private String password;

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminemail, String adminname, String password) {
		super();
		this.adminemail = adminemail;
		this.adminname = adminname;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminemail=" + adminemail + ", adminname=" + adminname + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminemail, adminname, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminemail, other.adminemail) && Objects.equals(adminname, other.adminname)
				&& Objects.equals(password, other.password);
	}

}