package com.example.spc.service;

import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


//api方式实现redis缓存
/**
 * @Author: HardyYao
 * @Date: 2021/6/19
 */
@Service
public class ApiCommentService {

    @Autowired
    private WchaMapper commentRepository;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 根据评论id查询评论
     * @param id
     * @return
     */
    public Wcha findCommentById(Integer id){
        // 先查Redis缓存
        Object o = redisTemplate.opsForValue().get("comment_" + id);
        if (o != null) {
            return (Wcha) o;
        } else {
            // 如果缓存中没有，则从数据库查询
            Wcha wcha = commentRepository.selectById(id);
            Optional<Wcha> dbComment = Optional.ofNullable(wcha);
            if (dbComment.isPresent()) {
                Wcha redisComment = dbComment.get();
                // 将查询结果存储到缓存中，并设置有效期为1天
                redisTemplate.opsForValue().set("comment_"+id, redisComment,1, TimeUnit.DAYS);
                return redisComment;
            } else {
                return null;
            }
        }

    }

    /**
     * 更新评论
     * @param comment
     * @return
     */
    public Wcha updateComment(Wcha comment) {
        commentRepository.updateById(comment);
        // 更新数据库数据后进行缓存更新
        redisTemplate.opsForValue().set("comment_" + comment.getId(), comment);
        return comment;
    }

    /**
     * 删除评论
     * @param comment_id
     */
    public void deleteComment(int comment_id) {
        commentRepository.deleteById(comment_id);
        // 删除数据库数据后进行缓存删除
        redisTemplate.delete("comment_" + comment_id);
    }

}
