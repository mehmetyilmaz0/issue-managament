package com.mehmetyilmaz.issuemanagement.service.impl;

import com.mehmetyilmaz.issuemanagement.entity.User;
import com.mehmetyilmaz.issuemanagement.repostory.UserRepostory;
import com.mehmetyilmaz.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // bu class ın bir servis oldugu anlamina geliyor
public class UserServiceImpl implements UserService {

    private final UserRepostory userRepostory;

    public UserServiceImpl (UserRepostory userRepostory) {
        this.userRepostory = userRepostory;
    }

    @Override
    public User save(User user) {

        if (user.getEmail() == null) {
            throw new IllegalArgumentException("User email connot be null!!");
        }

        return userRepostory.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepostory.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepostory.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        userRepostory.delete(user);
        return true;
    }
}
