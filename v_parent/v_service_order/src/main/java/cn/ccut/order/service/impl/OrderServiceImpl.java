package cn.ccut.order.service.impl;

import cn.ccut.model.TbOrder;
import cn.ccut.order.mapper.OrderMapper;
import cn.ccut.order.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void add(TbOrder order) {

        //1. 获取购物车中的商品数据信息

        //2. 统计计算 : 总商品数量 , 总金额

        //3. 组装订单数据信息, 并保存订单

        //4. 组装订单明细信息 , 并保存对应的订单明细

        //5. 保存订单日志信息

        //6. 调用商品微服务扣将库存 ; 用户模块增加积分 ;

        //7. 删除商品购物车中商品数据 ;

    }

    @Override
    public Page search(Map<String, String> searchMap, Integer page, Integer size) {

        //1. 设置分页参数
        PageHelper.startPage(page,size);
        //2. 执行分页查询
        List<TbOrder> orderList = orderMapper.search(searchMap);

        return (Page) orderList;
    }
}
