package com.meng.service.store;

import com.meng.mapper.StoreMapper;
import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreInput;
import com.meng.pojo.StoreOutput;
import com.meng.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public List<StoreDrug> queryStoreList() {
        return storeMapper.queryStoreList();
    }

    @Override
    public int addStore(Store store) {
        return storeMapper.addStore(store);
    }

    @Override
    public int storeInput(StoreInput storeInput) {
        return storeMapper.storeInput(storeInput);
    }

    @Override
    @Transactional
    public int storeOutput(StoreOutput storeOutput) {
        //没出库之前的数量
        int OldStoreCount = (storeMapper.queryStoreByDrugCode(storeOutput.getDrug_code())).getDrug_count();

        if (OldStoreCount>storeOutput.getOutput_count()){
            //更新库存
            int i = storeMapper.updateStore((OldStoreCount - storeOutput.getOutput_count()),storeOutput.getDrug_code(), MyUtils.getNowTime());
            //出库
            int i1 = storeMapper.storeOutput(storeOutput);

            return (i==i1)?1:0;
        }else {
            return 0;
        }
    }

    @Override
    public Store queryStoreByDrugCode(String drug_code) {
        return storeMapper.queryStoreByDrugCode(drug_code);
    }
}
