package com.example.Data_improvement_5.service;
import com.example.Data_improvement_5.dao.IUserDao;
import com.example.Data_improvement_5.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理接口")
@RequestMapping("/api/user")

public class UserApi {
    @Autowired
    private IUserDao userDao;


    @GetMapping("/login/{Id}/{password}")
    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户号", defaultValue = "23424", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "234234", required = true)
    })
    @RequestMapping(value ="/login/{Id}/{password}",method = RequestMethod.GET)
    public String login(@PathVariable String Id,@PathVariable String password)
    {
        User u =userDao.findUserByIdAndPassword(Id,password);
        if(u==null) {
            return "Please try again";
        }
        return "Welcome "+u.getName() ;
    }

    @PostMapping("/login")
    @ApiOperation("用户登录的接口_POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户号", defaultValue = "23424", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "234234", required = true)
    })

    public String loginByIdAndPassword(@RequestParam String Id,@RequestParam String password){
        {
            User u =userDao.findUserByIdAndPassword(Id,password);
            if(u==null) {
                return "Please try again";
            }
            return "Welcome "+u.getName() ;
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册的接口_POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户号", defaultValue = "23454", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", defaultValue = "18", required = true),
            @ApiImplicitParam(name = "sex", value = "性别", defaultValue = "true", required = true),
            @ApiImplicitParam(name = "name", value = "名字", defaultValue = "true", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "234234", required = true)
    })
    public String registerUser(@RequestParam String id,@RequestParam String name,@RequestParam String password,@RequestParam int age,@RequestParam boolean sex){
        if(id==null){
            return "Error";
        }
        User u = new User();
        u.setId(id);
        u.setPassword(password);
        u.setSex(sex);
        u.setName(name);
        u.setAge(age);
        try {
            userDao.save(u);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Yeeeeees";
    }

    @PostMapping("/register2")
    @ApiOperation("用户注册的接口_POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "u", value = "用户注册的接口", required = true),
    })
    public String registerUser(@RequestBody User u){
        try {
            userDao.save(u);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Yeeeeees";
    }

    @PostMapping("/Update")
    public String updateUser(@RequestBody User u){
        try {
            userDao.save(u);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Yeeeeees";
    }
    @DeleteMapping("/Delete")
    public String DeleteUser(@RequestParam String id){
        if(id==null){
            return "Error";
        }
        try {
            userDao.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return "success";

    }
}


