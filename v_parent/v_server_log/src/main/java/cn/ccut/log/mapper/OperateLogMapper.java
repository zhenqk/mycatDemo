package cn.ccut.log.mapper;

import cn.ccut.model.TbOperatelog;

import java.util.List;
import java.util.Map;

public interface OperateLogMapper {

    /**
     * 插入日志
     * @param operatelog
     */
    public void insert(TbOperatelog operatelog);

    /**
     * 根据条件查询日志
     * @param searchMap
     * @return
     */
    public List<TbOperatelog> search(Map searchMap);

}
