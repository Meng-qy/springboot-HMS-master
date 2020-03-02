package com.meng.service.store;

import com.meng.mapper.StoreMapper;
import com.meng.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public List<Store> queryStoreList() {
        return storeMapper.queryStoreList();
    }
}
