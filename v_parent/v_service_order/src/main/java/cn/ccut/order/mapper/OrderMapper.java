package cn.ccut.order.mapper;

import cn.ccut.model.TbOrder;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    /**
     * 根据条件查询订单数据
     * @param searchMap
     * @return
     */
    public List<TbOrder> search(Map<String,String> searchMap);

}
