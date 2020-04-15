package com.mehmetyilmaz.issuemanagement.repostory;

import com.mehmetyilmaz.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepostory extends JpaRepository<Issue, Long> {


}
