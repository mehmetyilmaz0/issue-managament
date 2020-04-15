package com.mehmetyilmaz.issuemanagement.repostory;

import com.mehmetyilmaz.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepostory extends JpaRepository<User, Long> {

    User findByUsername (String username);

}
