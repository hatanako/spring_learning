package com.atguigu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    //执行handler之前！调用的拦截方法！
    //编码格式设置，登录保护，权限处理！！

    /**
     * filter -> doFilter
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 要调用的方法对象
     * @return true 放行 false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        return true;
    }

    /**
     * 当handler执行完毕后，触发的方法！没有拦截机制了！
     * 此方法只有 preHandler return true
     *
     * 对结果处理！敏感词汇检查！！
     *
     * @param request 请求
     * @param response 响应
     * @param handler handler方法
     * @param modelAndView 返回的视图和共享域数据对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
    }

    /**
     * 整体处理完毕！！
     * @param request
     * @param response
     * @param handler
     * @param ex handler报错了 异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
