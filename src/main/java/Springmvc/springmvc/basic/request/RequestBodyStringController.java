package Springmvc.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
//메세지바디 직접조회
@Slf4j
@Controller
public class RequestBodyStringController {

        @PostMapping("/request-body-string-v1")
        public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
            ServletInputStream inputStream = request.getInputStream();
            String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

            log.info("messageBody={}", messageBody);

            response.getWriter().write("ok");
        }
                /**위 아래 같음**/

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        responseWriter.write("ok");
    }
                /**위 아래 같음 셋 다 같은 거임**/

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);

        return new HttpEntity<>("ok");
//        return new ResponseEntity<String>("ok", HttpStatus.OK);
//        return ResponseEntity.ok("ok")
//       HttpEntity상속받는애인데 이렇게 사용하면 상태코드도 반환가능
    }

            /**위 아래 같음**/

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody){

        log.info("messageBody={}", messageBody);

        return "ok";
    }

    /**요청파라미터를 조회하는 기능 @RequestParam, @ModelAttribute
     * Http 메시지 바디를 직접 조회하는 기능 @RequestBody
     */

    }



