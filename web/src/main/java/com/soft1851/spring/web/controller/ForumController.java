package com.soft1851.spring.web.controller;
import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.util.ResponseObject;
import com.soft1851.spring.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ForumController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/20
 **/
@RestController
@RequestMapping(value = "forum")
public class ForumController {
    @Autowired
    private ForumService forumService;
    @RequestMapping(value = "/list" ,produces = "application/json;charset=utf-8")
    public String getForum(){
        ResponseObject ro=new ResponseObject(1,"成功",forumService.selectAll());
        return JSON.toJSONString(ro);
    }
    @PostMapping(value = "/listbyid", produces = "application/json;charset=utf-8")
    public String getForum(@RequestParam Integer forumId) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.get(forumId));
        return JSON.toJSONString(ro);
    }
    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    public String deleteForum(@RequestParam Integer forumId) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.delete(forumId));
        return JSON.toJSONString(ro);
    }

}