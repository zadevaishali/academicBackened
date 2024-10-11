package com.primepro.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class Achievement {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    
    public Achievement() {
		// TODO Auto-generated constructor stub
	}

	public Achievement(String title, String description, LocalDate date, Profile profile) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.profile = profile;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
    
}

