package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); <- @Slf4j 으로 대체 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "hyeon";

        //log.trace( "trace log="+ name) 출력은 똑같지만 + 연산이 해당 패키지 로그 레벨과 관계없이 일어나게 됨. -> 출력을 안해도 연산이 일어날 수 있음
        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);
        return "ok";
    }
}
