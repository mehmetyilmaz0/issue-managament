package com.mehmetyilmaz.issuemanagement.api;


import com.mehmetyilmaz.issuemanagement.dto.ProjectDTO;
import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.service.impl.ProjectServiceImpl;
import com.mehmetyilmaz.issuemanagement.util.ApiPaths;
import com.mehmetyilmaz.issuemanagement.util.TPage;
import com.sun.javafx.tools.packager.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // bu class 'in bir rest contoller oldugunu etiketleyen bir anotation
@RequestMapping(ApiPaths.ProjectCtrl.CTRL) // localhost:8080/project ile bu classin metodlarina ulasilmasi saglandi
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs") // swagger ile dokumantasyonda gorulmesi icin kullanilan anotation. Controller'lari tanimlar.
@Slf4j // loglama icin kullanilan bir anotation
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController (ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    // ResponseEntity -> bizim api metodlarimizin ve  disarida ortak bir imzaya sahip olmasi icin ve
    // her entity imizin uzerinde belirli bilgileri bulundaracagimiz bir class

    @GetMapping("/{id}") // bu metodun webservis metoduna getirilmesi icin kullanilan anotatin
    @ApiOperation(value = "Get By Id Operatation", response = ProjectDTO.class) // swagger ile dokumantasyonda gorulmesi icin kullanilan anotation. metod'lari tanimlar.
    public ResponseEntity<ProjectDTO> getById (@PathVariable("id") Long id) {

        log.info("ProjectController -> getById metodu call edildi....");
        log.debug("ProjectController -> getById -> PARAM : " + id);

        ProjectDTO projectDTO = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDTO);
    }

    //RequestBody : create olacak data'lar request body uzerinden gidiyor
    //Valid : ProjectDTO uzerinde tanimladigimiz validatitonlari calistirmasina yariyor.
    @PostMapping()
    @ApiOperation(value = "Create Operatation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> createProejct (@Valid @RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDTO));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operatation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operatation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject (@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operatation", response = ProjectDTO.class)
    public ResponseEntity<TPage<ProjectDTO>> getAllProjectByPagination (Pageable pageable) {
        TPage<ProjectDTO> paginationData = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(paginationData);
    }

}
