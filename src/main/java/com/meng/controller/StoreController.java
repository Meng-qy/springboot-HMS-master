package com.meng.controller;

import com.meng.pojo.Store;
import com.meng.pojo.StoreDrug;
import com.meng.pojo.StoreOutput;
import com.meng.service.store.StoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = sdf.format(new Date());
        storeOutput.setId(null);
        storeOutput.setOutput_time(dt);
        storeService.storeOutput(storeOutput);



        HashMap<String, String> map = new HashMap<>();
        map.put("msg","出库成功");
        return map;
    }
}
