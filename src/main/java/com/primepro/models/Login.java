package com.primepro.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "login_id")
    private long id;
    private String username;
    private String password;
    private String role;

    private LocalDateTime loginTime;

    private LocalDateTime logoutTime;
    
   //One-to-One relationship: A user has one profile.
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;
    
    

    public Login() {
		// TODO Auto-generated constructor stub
	}
    

    public Login(String username, String password, String role, LocalDateTime loginTime, LocalDateTime logoutTime,
			Profile profile) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.profile = profile;
	}


	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }
}