package com.example.xl.demo.controller;


import com.example.xl.demo.entity.po.User;
import com.example.xl.demo.entity.vo.ResponseVo;
import com.example.xl.demo.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public ResponseVo insert(@RequestBody User user) {
        Assert.isTrue(user!=null && StringUtils.isNotBlank(user.getMobile())
                && StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())
                ,"请求参数缺失!");
        return ResponseVo.success(userService.insert(user));
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseVo selectByMobileAndPassword(String mobile,String password) {
        Assert.isTrue(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)
                ,"请求参数缺失!");
        return ResponseVo.success(userService.selectByMobileAndPassword(mobile,password));
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    public ResponseVo selectAll() {
        return ResponseVo.success(userService.selectAll());
    }

    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public ResponseVo updateById(User user) {
        Assert.isTrue(user!=null && user.getId()!=null && StringUtils.isNotBlank(user.getMobile())
                        && StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())
                ,"请求参数缺失!");
        return ResponseVo.success(userService.insert(user));
    }

    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public ResponseVo delete(Long id) {
        Assert.notNull(id,"请求参数缺失!");
        userService.delete(id);
        return ResponseVo.success();
    }
}
