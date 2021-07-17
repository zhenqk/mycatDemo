package cn.ccut.goods.mapper;


import cn.ccut.model.TbSku;

public interface SkuMapper {

    /**
     * 根据ID查询SKU信息
     * @param skuid
     * @return
     */
    public TbSku findById(String skuid);

}
