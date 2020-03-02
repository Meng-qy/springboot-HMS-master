package com.meng.controller;

import com.meng.pojo.Store;
import com.meng.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/store/list")
    public String storeList(){
        List<Store> stores = storeService.queryStoreList();
        return "store/store";
    }

    @RequestMapping("/store/input")
    public String storeInput(){
        return "store/input";
    }

    @RequestMapping("/store/output")
    public String storeOutput(){
        return "store/output";
    }
}
