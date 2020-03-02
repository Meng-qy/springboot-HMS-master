package com.meng.mapper;

import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper {

    @Select(value ="select a.*,b.drug_name,b.price,b.add_time,b.id AS drug_id\n" +
            "FROM store a \n" +
            "LEFT JOIN drug b\n" +
            "ON a.drug_code = b.drug_code")
    List<StoreDrug> queryStoreList();

    @Insert(value ="INSERT INTO store (store_id,drug_code,drug_count,last_time)\n" +
            "VALUES(NULL,#{store.drug_code},#{store.drug_count},#{store.last_time})")
    int addStore(@Param("store") Store store);
}
