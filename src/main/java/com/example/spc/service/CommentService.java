package com.example.spc.service;



import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;


//注解方式实现redis缓存
/**
 * @Author: HardyYao
 * @Date: 2021/6/19
 */
@Service
public class CommentService {

    @Autowired
    private WchaMapper commentRepository;

    /**
     * 根据评论id查询评论
     * @Cacheable：将该方法的查询结果comment存放在SpringBoot默认缓存中
     * cacheNames：起一个缓存命名空间，对应缓存唯一标识
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "comment", unless = "#result==null")
    public Wcha findCommentById(Integer id){
        Wcha wcha = commentRepository.selectById(id);
        Optional<Wcha> comment = Optional.ofNullable(wcha);
        if(comment.isPresent()){
            Wcha comment1 = comment.get();
            return comment1;
        }
        return null;
    }

    /**
     * 更新评论
     * @param comment
     * @return
     */
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Wcha updateComment(Wcha comment) {
        commentRepository.updateById(comment);
        return comment;
    }

    /**
     * 删除评论
     * @param comment_id
     */
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id) {
        commentRepository.deleteById(comment_id);
    }

}
