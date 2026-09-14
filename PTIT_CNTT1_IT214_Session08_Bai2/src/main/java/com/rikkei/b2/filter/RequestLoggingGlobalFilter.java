package com.rikkei.b2.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestLoggingGlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingGlobalFilter.class);

    public void logPreFilter(String path, String method) {
        log.info("[GATEWAY PRE-FILTER] Incoming request: {} {}", method, path);
    }

    public void logPostFilter(String path, int statusCode, long durationMs) {
        log.info("[GATEWAY POST-FILTER] Response sent for {}: Status {} in {} ms", path, statusCode, durationMs);
    }
}
