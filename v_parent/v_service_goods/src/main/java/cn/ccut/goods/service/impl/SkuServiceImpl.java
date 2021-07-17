package cn.ccut.goods.service.impl;

import cn.ccut.goods.mapper.SkuMapper;
import cn.ccut.goods.service.SkuService;
import cn.ccut.model.TbSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public TbSku findById(String id) {
        return skuMapper.findById(id);
    }
}
