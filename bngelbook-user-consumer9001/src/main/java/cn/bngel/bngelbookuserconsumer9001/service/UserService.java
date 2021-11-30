package cn.bngel.bngelbookuserconsumer9001.service;

import cn.bngel.bngelbookcommonapi.bean.CommonResult;
import cn.bngel.bngelbookcommonapi.bean.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@FeignClient("bngelbook-user-provider")
@Service
public interface UserService {

    @PostMapping("/user")
    CommonResult<Boolean> saveUser(@RequestBody User user);

    @DeleteMapping("/user")
    CommonResult<Boolean> deleteUserById(@RequestParam("id") Long id);

    @PutMapping("/user")
    CommonResult<Boolean> updateUserById(@RequestBody User user);

    @GetMapping("/user")
    CommonResult<User> getUserById(@RequestParam("id") Long id);

    @PostMapping("/user/login")
    CommonResult<User> login(@RequestParam("account") String account,
                       @RequestParam("password") String password);

    @GetMapping("/user/registerDays")
    CommonResult<Integer> getUserRegisterDays(@RequestParam("id") Long id);

    @GetMapping("/user/friends")
    CommonResult<List<User>> getFriendsById(@RequestParam("id") Long id);
}
