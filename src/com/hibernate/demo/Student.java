package com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "student_id",nullable = false)
	private String stuId;
	
	@Column(name = "student_name", nullable = false)
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "address",nullable = false)
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "course_id",nullable = false)
	private Course course;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String stuId, String name, int age, String address, Course course) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.course = course;
	}
	public Student(String stuId, String name, int age, String address, Course course) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.course = course;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuId=" + stuId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", course=" + course + "]";
	}
	
	

}
