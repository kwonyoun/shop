package com.example.coffe.shop.sms;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check")
@RequiredArgsConstructor
@Slf4j
public class SmsController {

    private final SmsService smsService;

    @PostMapping("sendSMS")
    public ResponseEntity<?> SendSMS(@Valid SmsRequestDto smsRequestDto){
        String certificationCode = Integer.toString((int)(Math.random() * (999999 - 100000 + 1)) + 100000); // 6자리 인증 코드를 랜덤으로 생성
        SingleMessageSentResponse b= smsService.SendSms(smsRequestDto, certificationCode);
        log.info("SendSMS = {}", b);
        return ResponseEntity.ok(certificationCode);
    }
}
