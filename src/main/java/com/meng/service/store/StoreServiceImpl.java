package com.meng.service.store;

import com.meng.mapper.StoreMapper;
import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
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
}
