package com.mehmetyilmaz.issuemanagement.service.impl;

import com.mehmetyilmaz.issuemanagement.dto.ProjectDTO;
import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.repostory.ProjectRepostory;
import com.mehmetyilmaz.issuemanagement.service.ProjectService;
import com.mehmetyilmaz.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service // bu class ın bir servis oldugu anlamina geliyor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepostory projectRepostory;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepostory projectRepostory, ModelMapper modelMapper) {
        this.projectRepostory = projectRepostory;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {

        Project checkProject = projectRepostory.getByProjectCode(projectDTO.getProjectCode());
        if (checkProject != null)
            throw new IllegalArgumentException("Duplicade project code!!! ");

        Project project = modelMapper.map(projectDTO, Project.class);
        project = projectRepostory.save(project);
        projectDTO.setId(project.getId());

        return projectDTO;
    }

    @Override
    public ProjectDTO getById(Long id) {
        Project project = projectRepostory.getOne(id);
        ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);

        return projectDTO;
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return projectRepostory.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepostory.getByProjectCodeContains(projectCode);
    }

    @Override
    public TPage<ProjectDTO> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepostory.findAll(pageable);
        TPage<ProjectDTO> response = new TPage<>();
        ProjectDTO[] convert2DTO  = modelMapper.map(data.getContent(), ProjectDTO[].class);
        response.setStat(data, Arrays.asList(convert2DTO));
        return response;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepostory.deleteById(id);
        return true;
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO projectDTO) {
        Project projectDB = projectRepostory.getOne(id);
        if (projectDB == null)
            throw new IllegalArgumentException("This Project Not Found in DB. ID : " + id);

        Project checkProject = projectRepostory.getByProjectCode(projectDTO.getProjectCode());
        if (checkProject != null && projectDB.getId().compareTo(id) != 0)
            throw new IllegalArgumentException("Duplicade project code!!! ");

        projectDB.setId(id);
        projectDB.setProjectCode(projectDTO.getProjectCode());
        projectDB.setProjectName(projectDTO.getProjectName());

        projectRepostory.save(projectDB);
        return modelMapper.map(projectDB, ProjectDTO.class);
    }
}
