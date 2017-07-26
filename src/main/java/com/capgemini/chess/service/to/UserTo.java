package com.capgemini.chess.service.to;

public class UserTo {
	private Long id;
	private String email;
	private String password;
	private ProfileTo profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileTo getProfile() {
		return profile;
	}

	public void setProfile(ProfileTo profile) {
		this.profile = profile;
	}

}
