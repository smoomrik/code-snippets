package snippet.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceIdLoggingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(TraceIdLoggingAspect.class);

    @Pointcut(
            value = "args(traceId, ..)",
            argNames = "traceId"
    )
    public void firstParamTraceId(String traceId){
    }

    @Before(value = "firstParamTraceId(traceId)")
    public void logTraceId(String traceId){

        LOG.trace("Trace id : {}", traceId);
    }
}

