package nymgoAutomation.data.entity;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class AdminEntity {

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

	public AdminEntity(){
		
		this.username = "";
		this.password = "";
	}
}
