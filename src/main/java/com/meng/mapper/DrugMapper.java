package com.meng.mapper;

import com.meng.pojo.Drug;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DrugMapper {


    @Select(value = "select * from drug ")
    public List<Drug> queryDrugList();

    @Select(value = "select * from drug where id = #{id} ")
    public Drug queryDrugById(int id);

    @Insert(value =
            "INSERT INTO drug\n" +
            "(id,drug_name,drug_code,price,add_time)\n" +
            "VALUES\n" +
            "(null,#{drug.drug_name},#{drug.drug_code},#{drug.price},#{drug.add_time})")
    public int addDrug(@Param("drug") Drug drug);

    @Update(value =
            "UPDATE  drug \n" +
            "       SET drug_code =#{drug.drug_code} ,drug_name=#{drug.drug_name},price=#{drug.price} \n" +
            "       WHERE id =#{drug.id}"
    )
    public  int updateDrug(@Param("drug") Drug drug);

    @Delete(value = "DELETE FROM drug WHERE id =#{id}")
    public int deleteDrug(int id);
}
