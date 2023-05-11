package com.example.pageserver.controller;

import com.example.pageserver.entity.Student;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/select/{username}/{password}")
    public Student selectByInfo(@PathVariable String username,@PathVariable String password){
        Student student = studentService.selectByInfo(username,password);
        return  student;
    }

    @GetMapping("/checkInfo/{username}/{password}")
    public Boolean checkInfo(@PathVariable String username,@PathVariable String password){
        studentService.checkInfo(username, password);
        return true;
    }

    @PutMapping("/updateInfo/{sid}/{name}/{gender}/{age}/{address}/{telephone}/{company}/{state}")
    public Boolean updateInfo(Student student){
        studentService.updateInfo(student);
        return true;
    }

    @PostMapping("uploadResume/{sid}")
    public Boolean uploadResume(MultipartFile file, @PathVariable Integer sid) throws IOException {
        byte[] content = file.getBytes();
        Student student = new Student();
        student.setInformation(content);
        student.setSid(sid);
        studentService.uploadResume(student);
        return true;
    }
    @GetMapping("/downloadResume/{sid}")
    public ResponseEntity<byte[]> downloadInfo(@PathVariable Integer sid){
        byte[] data = studentService.downloadInfo(sid).getInformation();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("data.pdf").build());
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
    @PostMapping("removeResume/{sid}")
    public Boolean removeResume(@PathVariable Integer sid) {
        Student student = new Student();
        student.setSid(sid);
        studentService.removeResume(student);
        return true;
    }
    @GetMapping("/selectNotice/{sid}")
    public String selectNotice(@PathVariable Integer sid){
        return studentService.selectNotice(sid);
    }
    @GetMapping("selectAll")
    public List<Student> selectAll(){
        return studentService.selectAll();
    }
    @GetMapping("/selectUnderemployed")
    public Integer selectUnderemployed(){
        return studentService.selectUnderemployed();
    }
    @GetMapping("/selectEmployment")
    public Integer selectEmployment(){
        return studentService.selectEmployment();
    }
}
