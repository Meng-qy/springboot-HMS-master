package com.meng.service.drug;


import com.meng.mapper.DrugMapper;
import com.meng.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> queryDrugList() {
        return drugMapper.queryDrugList();
    }

    @Override
    public Drug queryDrugById(int id) {
        return drugMapper.queryDrugById(id);
    }

    @Override
    public int addDrug(Drug drug) {
        return drugMapper.addDrug(drug);
    }

    @Override
    public int deleteDrug(int id) {
        return drugMapper.deleteDrug(id);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }
}
