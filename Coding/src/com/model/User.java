/**
 * 
 */
package com.model;

import java.io.Serializable;

/**
 * @author BRAJENDRA SINGH
 * @Date Sep 17, 2016
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1611722224000630473L;
	private String username;
	private String password;

	//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

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
}
