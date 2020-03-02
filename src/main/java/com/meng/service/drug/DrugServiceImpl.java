package com.meng.service.drug;


import com.meng.mapper.DrugMapper;
import com.meng.mapper.StoreMapper;
import com.meng.pojo.Drug;
import com.meng.pojo.Store;
import com.meng.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private StoreService storeService;

    @Override
    public List<Drug> queryDrugList() {
        return drugMapper.queryDrugList();
    }

    @Override
    public Drug queryDrugById(int id) {
        return drugMapper.queryDrugById(id);
    }

    @Override
    @Transactional
    public int addDrug(Drug drug) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = sdf.format(new Date());
        Store store = new Store();
        store.setStore_id(null);
        store.setDrug_code(drug.getDrug_code());
        store.setDrug_count(0);
        store.setLast_time(dt);

        int i = storeService.addStore(store);
        int i1 = drugMapper.addDrug(drug);
        if(i>=1 && i1>=1){
            return 1;
        }else{
            return 0;
        }
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
