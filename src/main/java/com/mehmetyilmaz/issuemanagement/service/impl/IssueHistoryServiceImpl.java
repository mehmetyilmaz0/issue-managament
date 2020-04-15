package com.mehmetyilmaz.issuemanagement.service.impl;

import com.mehmetyilmaz.issuemanagement.entity.IssueHistory;
import com.mehmetyilmaz.issuemanagement.repostory.IssueHistoryRepostory;
import com.mehmetyilmaz.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // bu class ın bir servis oldugu anlamina geliyor
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepostory issueHistoryRepostory;

    public IssueHistoryServiceImpl (IssueHistoryRepostory issueHistoryRepostory) {
        this.issueHistoryRepostory = issueHistoryRepostory;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {

        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("IssueHistory Date can not be null");
        }

        return issueHistoryRepostory.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepostory.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepostory.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepostory.delete(issueHistory);
        return true;
    }
}
