package cn.ccut.order.service;

import cn.ccut.model.TbOrder;
import com.github.pagehelper.Page;

import java.util.Map;

public interface OrderService {

    /**
     * 提交订单
     */
    public void add(TbOrder order);

    /**
     * 根据条件分页查询订单列表
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
     Page search(Map<String,String> searchMap, Integer page , Integer size);

}
