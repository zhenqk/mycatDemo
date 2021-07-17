package cn.ccut.modelgroup;


import cn.ccut.model.TbSku;
import cn.ccut.model.TbSpu;

import java.util.List;

public class Goods {

    //spu
    private TbSpu spu;

    //sku集合
    private List<TbSku> skuList;

    public TbSpu getSpu() {
        return spu;
    }

    public void setSpu(TbSpu spu) {
        this.spu = spu;
    }

    public List<TbSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<TbSku> skuList) {
        this.skuList = skuList;
    }
}
