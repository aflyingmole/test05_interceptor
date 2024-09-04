package com.example.demo.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod)handler;
            log.info("preHandle-->[{}][{}]",requestURI,handler);
            MethodParameter[] params = method.getMethodParameters();
            for(MethodParameter param : params) {
                log.info("parameter : {}", param);
            }
            log.info("preHandle end.......");
        }
        return true; // 다음 인터셉터 또는 컨트롤러 호출
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle....[{}],[{}]",handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion-->[{}]",handler);
        if(ex!=null) log.info("afterCompletion-exception",ex);
    }
}