package com.mehmetyilmaz.issuemanagement.service;

import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


// Entity -> ...DTO -> ...Service -> ...Repostory -> ...ServiceImpl
// uygulamama ozel validasyonlarin olacagi katman..
public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode (String projectCode);

    List<Project> getByProjectCodeContains (String projectCode);

    Page<Project> getAllPageable (Pageable pageable);

    Boolean delete (Project project);

}
