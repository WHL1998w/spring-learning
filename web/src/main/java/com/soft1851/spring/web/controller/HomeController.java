package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/24
 **/
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    public String home(Model model){
        Book[] books = {
                new Book("撒哈拉的故事",26.3,"三毛作品中最膾炙人口的《撒哈拉的故事》﹐ 由１２篇精采動人的散文結合而成。","三毛","https://img3.doubanio.com/view/subject/s/public/s3563113.jpg"),
                new Book("我们仨",18.8,"《我们仨》是钱钟书夫人杨绛撰写的家庭生活回忆录。","杨绛","https://img3.doubanio.com/view/subject/s/public/s1015872.jpg"),
                new Book("目送",39.0,"龙应台","目送共由七十四篇散文组成，是为一本极具亲情、感人至深的文集。","https://img1.doubanio.com/view/subject/s/public/s3984108.jpg"),
                new Book("朝花夕拾",29.8,"鲁迅","中西的思想确乎有一点不同。听说中国的孝子们，一到将要“罪孽深重祸延父母”的时候，就买几斤人参","https://img3.doubanio.com/view/subject/s/public/s2875823.jpg"),
                new Book("城南旧事 ",30.8,"林海音","多少年来，《城南旧事》感动了一代又一代的读者，","https://img1.doubanio.com/view/subject/s/public/s2654869.jpg")
        };
        List<Book> bookList = Arrays.asList(books);
        model.addAttribute("bookList",bookList);
        return "home";
    }
}