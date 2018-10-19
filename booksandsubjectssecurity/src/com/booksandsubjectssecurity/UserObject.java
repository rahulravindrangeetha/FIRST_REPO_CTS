package com.booksandsubjectssecurity;

public class UserObject 
{
	private String username;
	
    private String password;
    
    private boolean enabled;
    
    private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "UserObject [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority="
				+ authority + "]";
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
