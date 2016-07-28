package org.formation.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "staff_id", nullable = false)
	private String staffId;

	private String name;
	private Integer salary;

	// annotation et mapped by
	@OneToMany(mappedBy = "professor", cascade = { CascadeType.PERSIST })
	private Set<Student> students = new HashSet<Student>();

	public Professor() {
	}

	public Professor(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
