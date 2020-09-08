package com.nowcoder.community.dao;


import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiscussPostMapper {
    //用于查詢用戶個人中心，“我发布过的帖子”这个功能的实现

    /**
     *
     * @param userId
     * @param offset 起始行号
     * @param limit 每页最多显示
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //查询这个用户一共发布过多少条帖子
    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用(动态sql),则必须加别名.
    int selectDiscussPostRows(int userId);
}
