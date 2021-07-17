package cn.ccut.log.controller;

import cn.ccut.entity.PageResult;
import cn.ccut.entity.Result;
import cn.ccut.entity.StatusCode;
import cn.ccut.log.service.OperateLogService;
import cn.ccut.model.TbOperatelog;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operateLog")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @PostMapping("/add")
    public Result add(@RequestBody TbOperatelog operatelog){
        operateLogService.insert(operatelog);
        return new Result(true, StatusCode.OK,"操作成功");
    }


    @PostMapping("/search/{page}/{size}")
    public Result findPage(@RequestBody Map searchMap, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page p = operateLogService.search(searchMap, page, size);
        long total = p.getTotal();
        List result = p.getResult();

        PageResult pageResult = new PageResult(total, result);

        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

}
