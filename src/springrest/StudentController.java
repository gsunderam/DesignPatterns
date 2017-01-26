package springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gsunderam
 * Date: Oct 8, 2013
 */
@Controller
@RequestMapping("/students")
public class StudentController {
  StudentService studentService;

//  private ArrayList<String> list;

//  @PostConstruct
//  public void afterInitialization() {
//    System.out.println(list.size());
//  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
  public ModelAndView getStudentData(@PathVariable("id") long id) {
    Student student = studentService.getStudentData(id);
    return new ModelAndView("student", "student", student);
  }

//  public void setList(ArrayList<String> list) {
//    this.list = list;
//  }
}