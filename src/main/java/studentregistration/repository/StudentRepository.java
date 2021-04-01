/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 31, 2021
 */
package studentregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentregistration.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	
}
