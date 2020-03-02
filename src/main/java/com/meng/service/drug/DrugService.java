package com.meng.service.drug;

import com.meng.pojo.Drug;

import java.util.List;

public interface DrugService {

    public List<Drug> queryDrugList();

    public Drug queryDrugById(int id);

    public int addDrug(Drug drug);

    public int deleteDrug(int id);

    public int updateDrug(Drug drug);
}
