package cn.ccut.goods.controller;


import cn.ccut.entity.PageResult;
import cn.ccut.entity.Result;
import cn.ccut.entity.StatusCode;
import cn.ccut.goods.service.SpuService;
import cn.ccut.model.TbSpu;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/{id}")
    //@OperateLog
    public Result<TbSpu> findById(@PathVariable("id") String id){
        TbSpu tbSpu = spuService.findById(id);
        return new Result<TbSpu>(true, StatusCode.OK,"查询成功",tbSpu);
    }


    @PostMapping("/search/{page}/{size}")
    public Result findPage(@RequestBody Map<String,String> searchMap, @PathVariable("page") Integer page  , @PathVariable("size") Integer size){
        Page pageResult = spuService.search(searchMap, page, size);

        long total = pageResult.getTotal();
        List result = pageResult.getResult();

        PageResult pageResult1 = new PageResult(total, result);
        return new Result(true,StatusCode.OK,"查询成功",pageResult1);
    }

}
