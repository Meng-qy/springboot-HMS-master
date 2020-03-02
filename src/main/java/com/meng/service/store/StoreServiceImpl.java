package com.meng.service.store;

import com.meng.mapper.StoreMapper;
import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreInput;
import com.meng.pojo.StoreOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int storeOutput(StoreOutput storeOutput) {
        return storeMapper.storeOutput(storeOutput);
    }
}
