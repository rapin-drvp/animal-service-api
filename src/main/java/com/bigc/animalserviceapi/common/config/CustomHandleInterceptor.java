
package com.bigc.animalserviceapi.common.config;

import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class CustomHandleInterceptor implements HandlerInterceptor {
    private static final String CORRELATION_ID = "X-Correlation-Id";
    @Value("${app.name}")
    private String appName;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) {
        String xCorrelationId = httpServletRequest.getHeader(CORRELATION_ID);

        if (StringUtils.isEmpty(xCorrelationId)) {
            xCorrelationId = this.generateCorrelationId();
        }
        MDC.put(CORRELATION_ID, xCorrelationId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object object, Exception e) {
        MDC.remove(CORRELATION_ID);
        MDC.clear();
    }

    private String generateCorrelationId() {
        String rawUuid = UUID.randomUUID().toString();
        return String.format(appName+"-%s", rawUuid.replaceAll("-", ""));
    }
}
