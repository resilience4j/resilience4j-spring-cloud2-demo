package io.github.dlsrb6342;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.RetryRegistry;

@Service
public class CheckService {

    private static final Logger log = LoggerFactory.getLogger(CheckController.class);

    public CheckService(BulkheadRegistry bulkheadRegistry,
                           ThreadPoolBulkheadRegistry threadPoolBulkheadRegistry,
                           CircuitBreakerRegistry circuitBreakerRegistry,
                           RateLimiterRegistry rateLimiterRegistry,
                           RetryRegistry retryRegistry) {
        this.bulkheadRegistry = bulkheadRegistry;
        this.threadPoolBulkheadRegistry = threadPoolBulkheadRegistry;
        this.circuitBreakerRegistry = circuitBreakerRegistry;
        this.rateLimiterRegistry = rateLimiterRegistry;
        this.retryRegistry = retryRegistry;
    }

    private final BulkheadRegistry bulkheadRegistry;
    private final ThreadPoolBulkheadRegistry threadPoolBulkheadRegistry;
    private final CircuitBreakerRegistry circuitBreakerRegistry;
    private final RateLimiterRegistry rateLimiterRegistry;
    private final RetryRegistry retryRegistry;

    public Map<String, Number> check() {

        return Map.of(
                "Bulkhead maxConcurrentCalls", bulkheadRegistry.getDefaultConfig().getMaxConcurrentCalls(),
                "TheadPollBulkhead maxThreadPoolSize", threadPoolBulkheadRegistry.getDefaultConfig().getMaxThreadPoolSize(),
                "CircuitBreaker failureRateThreshold", circuitBreakerRegistry.getDefaultConfig().getFailureRateThreshold(),
                "RateLimiter limitForPeriod", rateLimiterRegistry.getDefaultConfig().getLimitForPeriod(),
                "Retry maxRetryAttempts", retryRegistry.getDefaultConfig().getMaxAttempts()
        );
    }
}
