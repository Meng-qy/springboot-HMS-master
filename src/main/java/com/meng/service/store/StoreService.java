package com.meng.service.store;

import com.meng.pojo.Store;

import java.util.List;

public interface StoreService {

    List<Store> queryStoreList();

    int addStore(Store store);

}
