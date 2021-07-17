package cn.ccut.goods.aop;

import cn.ccut.fegin.client.OperateLogFeign;
import cn.ccut.model.TbOperatelog;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class OperateAdvice {

	@Autowired
	private OperateLogFeign operateLogFeign;

	@Around("execution(* cn.ccut.goods.controller.*.*(..)) && @annotation(operateLog)")
	public Object insertLogAround(ProceedingJoinPoint pjp , OperateLog operateLog) throws Throwable{
		System.out.println(" *********************************** 记录日志 [start]  ****************************** ");

		TbOperatelog op = new TbOperatelog();

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		op.setOperateTime(sdf.format(new Date()));
		op.setOperateUser("10000");
		
		op.setOperateClass(pjp.getTarget().getClass().getName());
		op.setOperateMethod(pjp.getSignature().getName());

		String paramAndValue = "";
		Object[] args = pjp.getArgs();
		if(args != null){
			for (Object arg : args) {
				if(arg instanceof String || arg instanceof Integer || arg instanceof Long){
					paramAndValue += arg +",";
				}else{
					paramAndValue += JSON.toJSONString(arg)+",";
				}
			}
			op.setParamAndValue(paramAndValue);
		}

		long start_time = System.currentTimeMillis();

		//放行
		Object object = pjp.proceed();

		long end_time = System.currentTimeMillis();
		op.setCostTime(end_time - start_time);

		if(object != null){
			op.setReturnClass(object.getClass().getName());
			op.setReturnValue(object.toString());
		}else{
			op.setReturnClass("java.lang.Object");
			op.setParamAndValue("void");
		}

		operateLogFeign.add(op);//插入日志

		System.out.println(" *********************************** 记录日志 [end]  ****************************** ");

		return object;
	}
}