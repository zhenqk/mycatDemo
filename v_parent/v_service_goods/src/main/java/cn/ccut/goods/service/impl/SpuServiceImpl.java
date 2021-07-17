package cn.ccut.goods.service.impl;


import cn.ccut.goods.mapper.SpuMapper;
import cn.ccut.goods.service.SpuService;
import cn.ccut.model.TbSpu;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public TbSpu findById(String id) {
        return spuMapper.findById(id);
    }

    @Override
    public Page search(Map<String, String> searchMap, Integer page, Integer size) {

        //设置分页查询参数
        PageHelper.startPage(page,size);
        List<TbSpu> spuList = spuMapper.search(searchMap);

        return (Page)spuList;
    }
}
