package com.meng.service.store;

import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;

import java.util.List;

public interface StoreService {

    List<StoreDrug> queryStoreList();

    int addStore(Store store);

}
