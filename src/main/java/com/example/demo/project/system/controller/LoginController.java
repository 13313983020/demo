package com.example.demo.project.system.controller;

import com.example.demo.project.common.AjaxResult;
import com.example.demo.project.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("login")
    @ResponseBody
    public AjaxResult login(User user, Boolean rememberMe){
        System.out.println("user:"+user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPass());
        //获取Subject 对象
        Subject subject = SecurityUtils.getSubject();
        try{
            if(rememberMe)
                token.setRememberMe(true);
            subject.login(token);
            return AjaxResult.success("/index");
        } catch (UnknownAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @GetMapping("/403")
    public String forbid(){
        return "403";
    }

}
