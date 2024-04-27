package com.hibernate.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@Column(name = "course_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "course_name", nullable = false)
	private String name;
	
	@Column(name = "describtion")
	private String describtion;
	
	@OneToMany(mappedBy = "course")
	private Set<Student> students;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(long id, String name, String describtion, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.describtion = describtion;
		this.students = students;
	}

	public Course(String name, String describtion, Set<Student> students) {
		super();
		this.name = name;
		this.describtion = describtion;
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", describtion=" + describtion + ", students=" + students + "]";
	}
	
	

}
