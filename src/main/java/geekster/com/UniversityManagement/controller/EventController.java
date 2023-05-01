package geekster.com.UniversityManagement.controller;

import geekster.com.UniversityManagement.Department;
import geekster.com.UniversityManagement.Student;
import geekster.com.UniversityManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getStudentList")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/insertStudentList")
    public String addStudent(@Valid @RequestBody List<Student> students){
        studentService.addStudentList(students);
        return "Added Successfully";
    }

    @PutMapping("/id/{studentId}/dept/{department}")
    public String updateDept(@PathVariable int studentId, @PathVariable Department department){
        return studentService.updateDepartment(studentId,department);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        return studentService.deleteStudentById(studentId);
    }
}

