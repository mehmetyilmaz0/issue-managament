package com.mehmetyilmaz.issuemanagement.service.impl;

import com.mehmetyilmaz.issuemanagement.dto.IssueDTO;
import com.mehmetyilmaz.issuemanagement.entity.Issue;
import com.mehmetyilmaz.issuemanagement.repostory.IssueRepostory;
import com.mehmetyilmaz.issuemanagement.service.IssueService;
import com.mehmetyilmaz.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

public class IssueServiceImpl implements IssueService {

    private final IssueRepostory issueRepostory;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueServiceImpl(IssueRepostory issueRepostory, ModelMapper modelMapper) {
        this.issueRepostory = issueRepostory;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDTO save(IssueDTO issue) {

        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Issue Data can not be null!!!");
        }

        Issue issueDb = modelMapper.map(issue, Issue.class); // IssueDTO icindeki fieldleri Issue icindeki fieldlere setliyor ve geriye Issue nesnesini donduruyor...
        issueDb = issueRepostory.save(issueDb); // save islemi yaptiktan sonda issueDb (Issue) yi dondur
        return modelMapper.map(issueDb, IssueDTO.class); // sonrasinda issueDBb (Issue) yi, IssueDTO ya cevir ve return et..
    }

    @Override
    public IssueDTO getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDTO> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepostory.findAll(pageable);
        IssueDTO[] dataDTO = modelMapper.map(data.getContent(), IssueDTO[].class);

        TPage<IssueDTO> tPage = new TPage<IssueDTO>();
        tPage.setStat(data, Arrays.asList(dataDTO));

        return tPage;
    }

    @Override
    public Boolean delete(IssueDTO issue) {
        return null;
    }
}
