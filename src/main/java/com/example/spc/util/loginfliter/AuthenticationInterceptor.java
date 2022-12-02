package com.example.spc.util.loginfliter;

import com.example.spc.service.WchaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationInterceptor implements HandlerInterceptor {

//    @Autowired
//    private WchaService wchaService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if (token != null){
            String username = TokenUtil.getUserNameByToken(request);
            // 这边拿到的 用户名 应该去数据库查询获得密码，简略，步骤在service直接获取密码

            WchaService wchaService=new WchaService();

            String password = wchaService.getpassword(username);
            boolean result = TokenUtil.verify(token,username,password);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
