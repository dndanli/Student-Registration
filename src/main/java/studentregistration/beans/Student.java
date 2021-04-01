/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 31, 2021
 */
package studentregistration.beans;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data @NoArgsConstructor
@Table(
		name = "student",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_email_unique", columnNames = "email")
		}
		
)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long studentId;

	@NotEmpty
	@Column(name = "first_name",nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty
	@Column(name = "email",nullable = false)
	private String email;
	
	@NotEmpty
	@Column(name = "major",nullable = false)
	private String major;
	
	
	@Column(name = "gpa")
	private double gpa;
	
	
	public Student(String firstName, String lastName, String email, String major, double gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.major = major;
		this.gpa = gpa;
	}


}
