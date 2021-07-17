package cn.ccut.goods.mapper;


import cn.ccut.model.TbSpu;

import java.util.List;
import java.util.Map;

public interface SpuMapper {

    /**
     * 根据ID查询SPU信息
     * @param spuid
     * @return
     */
    public TbSpu findById(String spuid);

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<TbSpu> search(Map<String,String> searchMap);

}
