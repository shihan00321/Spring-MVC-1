package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    //배열로 여러 url 등록
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    //http request method 등록
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    //http request method 등록2
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    //PathVariable 사용, 변수명이 같으면 생략 가능
    //@PathVariable("userId") String data = @PathVariable String userId
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathV2(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    //parameter에 mode=debug가 있어야 실행 != 등 여러 표현식 가능
    @GetMapping(value = "/mapping-param", params = "mode!=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    //특정 header로 매핑
    @PostMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
