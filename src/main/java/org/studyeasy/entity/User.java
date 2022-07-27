package org.studyeasy.entity;

public class User {
	private int users_id;
	private String usersname;
	private String email;
	
	public User(int users_id, String usersname, String email) {
		
		this.users_id = users_id;
		this.usersname = usersname;
		this.email = email;
	}

	
	public User(String usersname, String email) {
		
		this.usersname = usersname;
		this.email = email;
	}


	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getUsersname() {
		return usersname;
	}

	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
