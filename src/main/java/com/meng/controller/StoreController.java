package com.meng.controller;

import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreOutput;
import com.meng.service.store.StoreService;
import com.meng.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;


@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/store/list")
    public String storeList(Model model){
        List<StoreDrug> storeList = storeService.queryStoreList();
        model.addAttribute("storeList",storeList);
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

    @CrossOrigin
    @RequestMapping("/store/output/deal")
    @ResponseBody
    public HashMap storeOutputDeal(@RequestBody StoreOutput storeOutput){


        HashMap<String, String> map = new HashMap<>();
        //出库数量小于库存数量才能出库
        if(storeService.queryStoreByDrugCode(storeOutput.getDrug_code()).getDrug_count()>=storeOutput.getOutput_count())
        {
            storeOutput.setId(null);
            storeOutput.setOutput_time(MyUtils.getNowTime());
            storeService.storeOutput(storeOutput);
            map.put("msg","出库成功");
        }else{
            map.put("msg","出库失败");
        }
        return map;
    }
}
