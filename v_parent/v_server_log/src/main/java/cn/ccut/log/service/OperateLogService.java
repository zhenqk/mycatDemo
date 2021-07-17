package cn.ccut.log.service;

import cn.ccut.model.TbOperatelog;
import com.github.pagehelper.Page;

import java.util.Map;

public interface OperateLogService {

    /**
     * 插入日志
     * @param operatelog
     */
    public void insert(TbOperatelog operatelog);

    /**
     * 根据条件查询日志列表 (分页)
     * @param searchMap
     * @return
     */
    public Page search(Map searchMap , Integer page , Integer size);

}
