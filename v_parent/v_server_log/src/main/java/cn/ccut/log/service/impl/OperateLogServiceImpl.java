package cn.ccut.log.service.impl;

import cn.ccut.log.mapper.OperateLogMapper;
import cn.ccut.log.service.OperateLogService;
import cn.ccut.model.TbOperatelog;
import cn.ccut.util.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private IdWorker idWorker;


    @Override
    @Transactional
    public void insert(TbOperatelog operatelog) {
        //1. 获取分布式ID
        long id = idWorker.nextId();
        operatelog.setId(id);

        operateLogMapper.insert(operatelog);
    }

    @Override
    public Page search(Map searchMap, Integer page, Integer size) {
        //设置分页参数
        PageHelper.startPage(page,size);

        List<TbOperatelog> operatelogList = operateLogMapper.search(searchMap);

        return (Page) operatelogList;
    }

}
