package com.xz.controller;

import com.xz.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 *
 * @author 小马哥
 * @since 2018/5/27
 */
@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user")
    public User user(@RequestBody User user) {
        return user;
    }

}
