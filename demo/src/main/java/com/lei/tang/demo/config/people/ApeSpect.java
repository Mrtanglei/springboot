package com.lei.tang.demo.config.people;

import com.lei.tang.demo.service.people.ApeService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2020/1/9
 *
 * 例：程序猿A下班时被同事约饭，到达饭店时想起了家有母老虎必须通知啊，也是拿起手机拿起电话一顿解释。接下来就是愉快的喝酒吃饭时间了，饭吃完的他为了等下到家不跪键盘，于是问候下母老虎是否需要带啥吃的给她，（此处有惊喜），到家后通知朋友安全到家。
 */
@Slf4j
@Aspect
@Component
public class ApeSpect {

    @Autowired
    private ApeService apeService;

    /**
     * 定义切入点
     */
    @Pointcut(value = "execution(* com.lei.tang.demo.service.people.ApeServiceImpl.haveMeal(..))")
    public void logPointcut() {

    }

//    @Before(value = "logPointcut()")
//    public void before(JoinPoint joinPoint) {
//        //获取request
//        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//        // .getRequest();
//        //后去请求ip request.getRemoteAddr()
//        apeService.call("打电话告知家里今天不回去吃饭了");
//    }
//
//    @After(value = "logPointcut()")
//    public void after(JoinPoint joinPoint) {
//        apeService.call("告知饭已吃完");
//    }
//
//    /**
//     * 发生异常不进入
//     *
//     * @param joinPoint
//     * @param result
//     */
//    @AfterReturning(value = "logPointcut()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        apeService.call("告知朋友顺利到家");
//    }

    @AfterThrowing(value = "logPointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        apeService.call("通知同事他老婆来医院");
    }

    /**
     * @Around是@Before与@After的组合
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around(value = "logPointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        apeService.call("打电话告知家里今天不回去吃饭了");
        //执行方法
        proceedingJoinPoint.proceed();
        apeService.call("告知饭已吃完");
    }
}