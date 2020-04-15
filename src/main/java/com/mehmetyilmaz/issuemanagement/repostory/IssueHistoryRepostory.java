package com.mehmetyilmaz.issuemanagement.repostory;

import com.mehmetyilmaz.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepostory extends JpaRepository<IssueHistory, Long> {


}
