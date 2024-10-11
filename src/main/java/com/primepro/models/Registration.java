package com.primepro.models;

import jakarta.persistence.*;

@Entity
@Table
public class Registration {
    @Id
    @GeneratedValue
    @Column(name = "registration_id")
    private long id;
    private String username;
    private String password;
    private String mobileNo;
    private String fullName;
    private String role;
    public Registration() {
		// TODO Auto-generated constructor stub
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
    
}