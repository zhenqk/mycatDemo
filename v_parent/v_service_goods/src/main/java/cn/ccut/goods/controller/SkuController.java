package cn.ccut.goods.controller;


import cn.ccut.entity.Result;
import cn.ccut.entity.StatusCode;
import cn.ccut.goods.aop.OperateLog;
import cn.ccut.goods.service.SkuService;
import cn.ccut.model.TbSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping("/{id}")
    @OperateLog
    public Result findById(@PathVariable("id") String id){
        TbSku sku = skuService.findById(id);
        return new Result(true, StatusCode.OK,"查询成功",sku);
    }

}
