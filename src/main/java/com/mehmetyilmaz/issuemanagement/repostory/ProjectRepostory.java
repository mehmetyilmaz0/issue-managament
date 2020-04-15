package com.mehmetyilmaz.issuemanagement.repostory;

import com.mehmetyilmaz.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepostory extends JpaRepository<Project, Long> {

    List<Project> getByProjectCode (String projectCode);

    List<Project> getByProjectCodeContains (String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

}
