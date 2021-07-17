package cn.ccut.fegin.client;

import cn.ccut.entity.Result;
import cn.ccut.model.TbOperatelog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("log")
public interface OperateLogFeign {

    @PostMapping("/operateLog/add")
    public Result add(@RequestBody TbOperatelog operatelog);

}
