package cn.ccut.order.controller;

import cn.ccut.entity.PageResult;
import cn.ccut.entity.Result;
import cn.ccut.entity.StatusCode;
import cn.ccut.model.TbOrder;
import cn.ccut.order.service.OrderService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
   // @OperateLog
    public Result add(@RequestBody TbOrder order){
        orderService.add(order);
        return new Result(true, StatusCode.OK,"提交成功");
    }

    //127.0.0.1:9002/order/search/1/10   {}  body
    @PostMapping("/search/{page}/{size}")
    //@OperateLog
    public Result findPage(@RequestBody Map<String,String> searchMap , @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page page1 = orderService.search(searchMap, page, size);

        long total = page1.getTotal();
        List result = page1.getResult();

        PageResult pageResult = new PageResult(total, result);

        return new Result(true, StatusCode.OK,"查询成功", pageResult);
    }

}
