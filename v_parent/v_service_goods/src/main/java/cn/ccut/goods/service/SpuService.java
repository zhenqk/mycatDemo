package cn.ccut.goods.service;

import cn.ccut.model.TbSpu;
import com.github.pagehelper.Page;

import java.util.Map;

public interface SpuService {

    /**
     * 根据ID查询SPU信息
     * @param id
     * @return
     */
    public TbSpu findById(String id);

    /**
     * 根据条件分页查询SPU列表
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page search(Map<String,String> searchMap, Integer page , Integer size );

}
