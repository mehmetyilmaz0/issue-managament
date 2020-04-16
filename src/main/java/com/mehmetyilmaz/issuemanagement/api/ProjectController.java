package com.mehmetyilmaz.issuemanagement.api;


import com.mehmetyilmaz.issuemanagement.dto.ProjectDTO;
import com.mehmetyilmaz.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // bu class 'in bir rest contoller oldugunu etiketleyen bir anotation
@RequestMapping("/project") // localhost:8080/project ile bu classin metodlarina ulasilmasi saglandi
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController (ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    // ResponseEntity -> bizim api metodlarimizin ve  disarida ortak bir imzaya sahip olmasi icin ve
    // her entity imizin uzerinde belirli bilgileri bulundaracagimiz bir class

    @GetMapping("/{id}") // bu metodun webservis metoduna getirilmesi icin kullanilan anotatin
    public ResponseEntity<ProjectDTO> getById (@PathVariable("id") Long id) {
        ProjectDTO projectDTO = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDTO);
    }


}
