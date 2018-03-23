package com.digital.dao;

import com.digital.entity.UserEntity;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by mj on 2017/7/17.
 */

//@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
//@CachePut，指定key，将更新的结果同步到redis中
//@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
@Mapper
public interface UserDao {
    @Select("select user from userTest where user=#{user}")
    @Cacheable(value ="result") 
    List<UserEntity> query(@Param("user")String user);
    
   
}
