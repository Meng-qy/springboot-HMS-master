package com.meng.controller;

import com.meng.pojo.Drug;
import com.meng.service.drug.DrugService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class DrugController {

    @Autowired
    private DrugService drugService;

    /**
     * 查询所有药品
     * @param model
     * @return
     */
    @RequestMapping("/drug/list")
    public String drugList(Model model){
        List<Drug> drugs = drugService.queryDrugList();
        model.addAttribute("drugsList",drugs);
        return "drug/list";
    }

    /**
     * 单删
     * @param id
     * @return
     */
    @RequestMapping("/drug/delete/{id}")
    public String deleteDrug(@PathVariable("id") int id){
        System.out.println(id);
        drugService.deleteDrug(id);
        return "redirect:/drug/list";
    }

    /**
     * 进入更改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/drug/update")
    public String updateDrug(Integer id,Model model){
        Drug drug = drugService.queryDrugById(id);
        model.addAttribute("queryDrugById",drug);
        return "drug/update";
    }

    @RequestMapping("drug/update/deal")
    public String updateDrugDeal(Drug drug,Model model){
        drugService.updateDrug(drug);
        model.addAttribute("msg","添加成功");
        return "redirect:/drug/list";
    }



//    跳转到添加药品页面
    @RequestMapping("/drug/add")
    public String addDrug(){
        return "drug/add";
    }


    @PostMapping("/drug/add/deal")
    @ResponseBody
    public HashMap addDrugDeal(@RequestBody Drug drug){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = sdf.format(new Date());
        drug.setId(null);
        drug.setAdd_time(dt);
        System.out.println(drug);
        drugService.addDrug(drug);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg","添加成功");
        return map;
    }

}
