package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    //嗯，这里查询到的DiscussPost里面只有userId，但是我们页面上要显示username
    //解决办法一：写sql的时候关联查询用户，把用户的数据一起查到
    //解决办法二：查DiscussPost，再查user(再在UserService写一个查询方法)。这样比较好以后使用redis的时候缓存一些数据比较方便
    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
