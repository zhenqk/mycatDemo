package cn.ccut.goods.service;


import cn.ccut.model.TbSku;

public interface SkuService {

    /**
     * 根据ID查询SKU信息
     * @param id
     * @return
     */
    public TbSku findById(String id);

}
