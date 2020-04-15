package com.mehmetyilmaz.issuemanagement.service;

import com.mehmetyilmaz.issuemanagement.entity.Issue;
import com.mehmetyilmaz.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


// Entity -> ...DTO -> ...Service -> ...Repostory -> ...ServiceImpl
// uygulamama ozel validasyonlarin olacagi katman..
public interface UserService {

    User save (User user);

    User getById (Long id);

    Page<User> getAllPageable (Pageable pageable);

    Boolean delete (User user);

}
