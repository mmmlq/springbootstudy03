package com.lq.springboot.action;


import com.lq.springboot.model.User;
import com.lq.springboot.service.impl.UserServiceImpl;
import com.lq.springboot.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luoqi
 * @since 2018-08-13
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/find/{id}")
    @ResponseBody
    public UserVo findUserById(@PathVariable(value = "id") Integer id){
        User user = new User();
        user.setId(id);
        User user1 =  userService.findById(user);
        UserVo uv = new UserVo();
        BeanUtils.copyProperties(user1,uv);
        return uv;
    }

}

