package com.mehmetyilmaz.issuemanagement.service;

import com.mehmetyilmaz.issuemanagement.dto.ProjectDTO;
import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.entity.User;
import com.mehmetyilmaz.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


// Entity -> ...DTO -> ...Service -> ...Repostory -> ...ServiceImpl
// uygulamama ozel validasyonlarin olacagi katman..
public interface ProjectService {

    ProjectDTO save(ProjectDTO projectDTO);

    ProjectDTO getById(Long id);

    Project getByProjectCode (String projectCode);

    List<Project> getByProjectCodeContains (String projectCode);

    TPage<ProjectDTO> getAllPageable (Pageable pageable);

    Boolean delete (Long id);

    ProjectDTO update(Long id, ProjectDTO projectDTO);
}
