package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.BookService;
import com.soft1851.spring.web.service.RankService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
@Controller
@RequestMapping(value = "/")
public class BookController {
    @Resource
    private BookService bookService;
    @GetMapping(value = "books",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBook(){
        ResponseObject rs =new ResponseObject(1,"success",bookService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/book")
    public String rank(Model model){
        model.addAttribute("books",bookService.queryAll());
        return "book";
    }
}