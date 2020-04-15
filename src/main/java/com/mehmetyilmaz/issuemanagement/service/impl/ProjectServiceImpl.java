package com.mehmetyilmaz.issuemanagement.service.impl;

import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.repostory.ProjectRepostory;
import com.mehmetyilmaz.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // bu class ın bir servis oldugu anlamina geliyor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepostory projectRepostory;

    public ProjectServiceImpl(ProjectRepostory projectRepostory) {
        this.projectRepostory = projectRepostory;
    }

    @Override
    public Project save(Project project) {

        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project Code Can Not Be Null !!");
        }

        return projectRepostory.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepostory.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepostory.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepostory.getByProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepostory.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepostory.delete(project);
        return true;
    }
}
