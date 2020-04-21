package com.mehmetyilmaz.issuemanagement.api;


import com.mehmetyilmaz.issuemanagement.dto.ProjectDTO;
import com.mehmetyilmaz.issuemanagement.service.impl.ProjectServiceImpl;
import com.mehmetyilmaz.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.ProjectVersioned.CTRL)
@Api(value = ApiPaths.ProjectVersioned.CTRL, description = "Project Versioned APIs")
public class ProjectVersionedApi {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @GetMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value = "Get By Id Operatation Version-1", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> getByIdV1 (@PathVariable("id") Long id) {
        ProjectDTO projectDTO = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDTO);
    }

    @GetMapping(value = "/{id}", params = "version=2")
    @ApiOperation(value = "Get By Id Operatation Version-2", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> getByIdV2 (@PathVariable("id") Long id) {
        ProjectDTO projectDTO = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDTO);
    }

}
