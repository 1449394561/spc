package com.example.spc.controller;


import com.example.spc.entity.Wcha;
import com.example.spc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//注解实现redis增删查改
//spring.cache.redis.time-to-live=60000  设置有效期
/**
 * @Author: HardyYao
 * @Date: 2021/6/19
 */
@RequestMapping("/redis")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/findCommentById")
    public Wcha findCommentById(Integer id){
        Wcha comment = commentService.findCommentById(id);
        return comment;
    }

    @RequestMapping(value = "/updateComment")
    public Wcha updateComment(Wcha comment){
        Wcha oldComment = commentService.findCommentById(comment.getId());

        Wcha comment1 = commentService.updateComment(comment);
        return comment1;
    }

    @RequestMapping(value = "/deleteComment")
    public void deleteComment(Integer id){
        commentService.deleteComment(id);
    }

}
