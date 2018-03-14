package cn.liupeng.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api(value = "hahahhah",description = "testtest")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("{userId}")
    @ApiOperation(value = "用户登陆")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String login(@PathVariable("userId") String userId){

        logger.info(userId);
        return userId;
    }

    @PutMapping
    public String aaa(){

        return "put";
    }

    @DeleteMapping
    public String bbb(){
        return "delete";
    }

    @GetMapping
    public String ccc(){
        return "get";
    }
}
