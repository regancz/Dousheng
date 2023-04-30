package com.charles.dousheng.interceptor;

import com.alibaba.nacos.common.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author charles
 * @date 4/30/2023 10:38 PM
 */
@Slf4j
public class AuthInterceptor implements AsyncHandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (StpUtil.isLogin()) {
            List<Long> dataScopes = ExtraUtil.getDataScopes();
            if (!CollectionUtils.isEmpty(dataScopes)) {
                AppContextHolder.set(AuthConstant.Extra.DATA_SCOPES, dataScopes);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AppContextHolder.clear();
    }
}
