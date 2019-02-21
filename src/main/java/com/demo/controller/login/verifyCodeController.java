package com.demo.controller.login;

import com.demo.entity.web.login.VerifyCode;
import com.demo.util.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
public class verifyCodeController {

    /**
     * 生成登录图表验证码
     */
    @GetMapping("/verificationCode")
    public void verify(String id, HttpServletRequest request, HttpServletResponse response) {
        verifyCode(request, response, "identifyingCode");
    }

    private void verifyCode(HttpServletRequest request, HttpServletResponse response, String attributeName) {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpg");
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            String code = VerifyCodeUtils.outputVerifyImage(260, 80, output, 1);
            request.getSession().setAttribute(attributeName, new VerifyCode(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (output != null) {
            try {
                output.close();
            } catch (Exception e) {
            }
        }
    }
}
