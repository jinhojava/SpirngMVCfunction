package Springmvc.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller  --------- 반환 값이 String이면 뷰이름으로 인식됨
@RestController
@Slf4j
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //log.trace("trace my log="+name);//이렇게하면 안됨 연산일어남
        log.trace("trace log={}", name);     //가장 낮은 로그레벨
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);     //가장 높은 로그레벨

        return "ok";
    }
}
