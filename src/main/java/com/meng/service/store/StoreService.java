package com.meng.service.store;

import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreInput;
import com.meng.pojo.StoreOutput;

import java.util.List;

public interface StoreService {

    List<StoreDrug> queryStoreList();

    int addStore(Store store);

    int storeInput(StoreInput storeInput);

    int storeOutput(StoreOutput storeOutput);

    Store queryStoreByDrugCode(String drug_code);

}
