package com.primepro.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseCode;
    private String description;
        
    //Many-to-Many relationship: A profile can be associated with multiple courses, and a course can be associated with multiple profiles (faculty teaching and students taking the course).
        
    @ManyToMany(mappedBy = "courses")
    private List<Profile> profiles;
    
    public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, String courseCode, String description, List<Profile> profiles) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.description = description;
		this.profiles = profiles;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
    
}


