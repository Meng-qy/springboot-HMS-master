package com.meng.mapper;

import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreInput;
import com.meng.pojo.StoreOutput;
import org.apache.ibatis.annotations.*;
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

    @Update(value = "update store set drug_count = #{drug_count},last_time =#{last_time} where drug_code =#{drug_code}")
    int updateStore(Integer drug_count,String drug_code,String last_time);


    @Insert(value = "INSERT INTO store_input\n" +
            "(id,drug_code,input_count,input_time)\n" +
            "VALUES\n" +
            "(NULL,#{input.drug_code},#{input.input_count},#{input.input_time})")
    int storeInput(@Param("input")StoreInput storeInput);

    @Insert(value = "INSERT INTO store_output\n" +
            "(id,drug_code,output_count,output_time)\n" +
            "VALUES\n" +
            "(NULL,#{output.drug_code},#{output.output_count},#{output.output_time})")
    int storeOutput(@Param("output")StoreOutput storeOutput);

    @Select(value = "select * from store where drug_code =#{drug_code}")
    Store queryStoreByDrugCode(String drug_code);
}
