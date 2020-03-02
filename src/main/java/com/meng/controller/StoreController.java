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
    @ResponseBody
    public String storeList(){
        List<Store> stores = storeService.queryStoreList();
        System.out.println(stores);
        return "药品库存";
    }

    @RequestMapping("/store/input")
    @ResponseBody
    public String storeInput(){
        return "药品入库";
    }

    @RequestMapping("/store/output")
    @ResponseBody
    public String storeOutput(){
        return "药品出库";
    }
}
