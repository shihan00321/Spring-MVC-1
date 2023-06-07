package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    /**
     *
     * @param paramMap - key(username, age) value request parameter
     * @param model - viewRender model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
