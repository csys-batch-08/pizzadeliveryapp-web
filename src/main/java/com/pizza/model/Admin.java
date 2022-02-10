package com.pizza.model;

import java.util.Objects;

public class Admin {
	private String adminEmail;
	private String adminName;
	private String password;

	public String getadminEmail() {
		return adminEmail;
	}

	public void setadminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getadminName() {
		return adminName;
	}

	public void setadminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}



	public Admin() {
		super();
	}

	public Admin(String adminEmail, String adminName, String password) {
		super();
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminEmail=" + adminEmail + ", adminName=" + adminName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminEmail, adminName, password);
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
		return Objects.equals(adminEmail, other.adminEmail) && Objects.equals(adminName, other.adminName)
				&& Objects.equals(password, other.password);
	}

}