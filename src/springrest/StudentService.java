package springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: gsunderam
 * Date: Oct 8, 2013
 */
@Service
public class StudentService {
  private Student student;

	@Autowired
  public void setStudent(Student student) {
    this.student = student;
  }

  public Student getStudentData(long id) {
     student.setId(id);
     student.setCompany("WellsFargo");
     student.setName("Sitaraman");
     student.setSalary(4001);
     return student;
  }
}
