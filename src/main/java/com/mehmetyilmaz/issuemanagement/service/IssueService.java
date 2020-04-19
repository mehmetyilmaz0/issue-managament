package com.mehmetyilmaz.issuemanagement.service;

import com.mehmetyilmaz.issuemanagement.dto.IssueDTO;
import com.mehmetyilmaz.issuemanagement.entity.Issue;
import com.mehmetyilmaz.issuemanagement.entity.IssueHistory;
import com.mehmetyilmaz.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


// Entity -> ...DTO -> ...Service -> ...Repostory -> ...ServiceImpl
// uygulamama ozel validasyonlarin olacagi katman..
public interface IssueService {

    IssueDTO save(IssueDTO issue); // disariya direk Issue entity i acmadan ara katman olan IssueDTO gecici entity i acmak istiyorum..

    IssueDTO getById(Long id);

    TPage<IssueDTO> getAllPageable (Pageable pageable); // Spring 'in Page class ini kullanmadan kendi yarattigim TPage class i ile pagining yapmak istiyorum..

    Boolean delete (Long id);

    IssueDTO update(Long id, IssueDTO issueDTO);
}

