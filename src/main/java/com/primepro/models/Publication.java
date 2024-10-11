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
public class Publication {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String publisher;
    private LocalDate publicationDate;
    
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    
    public Publication() {
		// TODO Auto-generated constructor stub
	}

	public Publication(String title, String publisher, LocalDate publicationDate, Profile profile) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
    

}



