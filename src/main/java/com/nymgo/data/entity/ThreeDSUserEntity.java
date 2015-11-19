package com.nymgo.data.entity;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ThreeDSUserEntity {

	String username;
    String password;

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

	public ThreeDSUserEntity(){
		
		this.username = "";
		this.password = "";
	}
}
