package com.meng.mapper;

import com.meng.pojo.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper {

    @Select(value ="select * from store")
    List<Store> queryStoreList();
}
