package com.hgz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
         // 登录校验逻辑。        
         // 1）获取Zuul提供的请求上下文对象        
        RequestContext ctx = RequestContext.getCurrentContext();
         // RequestContext：用于在过滤器之间传递消息。它的数据保存在每个请求的ThreadLocal中。它 用于存储请求路由到哪里、错误、HttpServletRequest、HttpServletResponse都存储在 RequestContext中。RequestContext扩展了ConcurrentHashMap，所以，任何数据都可以存储 在上下文中 2.5 服务网关Zuul的核心源码解析
         //在Zuul中， 整个请求的过程是这样的，首先将请求给zuulservlet处理，zuulservlet中有一个 zuulRunner对象，该对象中初始化了RequestContext：作为存储整个请求的一些数据，并被所有的 zuulﬁlter共享。zuulRunner中还有 FilterProcessor，FilterProcessor作为执行所有的zuulﬁlter的管理 器。FilterProcessor从ﬁlterloader 中获取zuulﬁlter，而zuulﬁlter是被ﬁlterFileManager所加载，并支 持groovy热加载，采用了轮询的方式热加载。有了这些ﬁlter之后，zuulservelet首先执行的Pre类型的
         // 2) 从上下文中获取request对象        
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token      
        String token = req.getParameter("access-token");
        // 4) 判断        
        if(token == null || "".equals(token.trim())){
            // 没有token，登录校验失败，拦截          
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。          
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行      
        return null;
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }
}
