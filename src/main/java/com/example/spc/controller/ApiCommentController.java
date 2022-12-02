package com.example.spc.controller;




import com.example.spc.entity.Wcha;
import com.example.spc.service.ApiCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//api实现redis
/**
 * @Author: HardyYao
 * @Date: 2021/6/19
 */
@RestController
@RequestMapping("/apiredis")  // 改变请求路径
public class ApiCommentController {

    @Autowired
    private ApiCommentService apiCommentService;

    @RequestMapping(value = "/findCommentById")
    public Wcha findCommentById(Integer id){
        Wcha comment = apiCommentService.findCommentById(id);
        return comment;
    }

    @RequestMapping(value = "/updateComment")
    public Wcha updateComment(Wcha comment){
        Wcha oldComment = apiCommentService.findCommentById(comment.getId());
        Wcha comment1 = apiCommentService.updateComment(comment);
        return comment1;
    }

    @RequestMapping(value = "/deleteComment")
    public void deleteComment(Integer id){
        apiCommentService.deleteComment(id);
    }

}
