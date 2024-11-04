package com.example.coffe.shop.sms;

import jakarta.annotation.PostConstruct;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsCertificationUtil {

    @Value("${coolsms.api.key}")
    private String apiKey;
    @Value("${coolsms.api.secret}")
    private String apiSecretKey;

    private DefaultMessageService messageService;

    @PostConstruct
    private void init(){
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecretKey, "https://api.coolsms.co.kr");
    }

    // 단일 메시지 발송
    public SingleMessageSentResponse sendSMS(String to, String certificationCode){
        Message message = new Message(); // 새 메시지 객체 생성
        message.setFrom(""); // 발신자 번호 설정
        message.setTo(to); // 수신자 번호 설정
        message.setText("[test]본인확인 인증번호는 " + certificationCode + "입니다."); // 메시지 내용 설정

        return this.messageService.sendOne(new SingleMessageSendingRequest(message));
    }

}