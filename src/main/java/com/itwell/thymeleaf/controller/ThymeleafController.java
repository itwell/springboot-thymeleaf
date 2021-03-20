package com.itwell.thymeleaf.controller;

import com.itwell.thymeleaf.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description", required = false, defaultValue = "springboot-thymeleaf") String description) {
        request.setAttribute("description", description);

        Book book = new Book();
        book.setTitle("三国演义");
        request.setAttribute("book", book);

        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setTitle("水浒传");
        Book book2 = new Book();
        book2.setTitle("西游记");
        Book book3 = new Book();
        book3.setTitle("红楼梦");
        Book book4 = new Book();
        book4.setTitle("三国演义");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        request.setAttribute("books", books);

        request.setAttribute("boolean", true);
        request.setAttribute("unless", false);


        request.setAttribute("switch", "a");

        request.setAttribute("msg", "<b>great!</b>");

        return "thymeleaf";
    }

    @GetMapping("/user")
    public String getNickname(@RequestParam(value = "nickname", required = false) String nickname) {
        System.out.println(nickname);
        return "success";
    }
}
