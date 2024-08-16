package com.example.coffe.shop.sms;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsCertificationUtil smsCertificationUtil;

    public SingleMessageSentResponse SendSms(SmsRequestDto smsRequestDto) {
        String phoneNum = smsRequestDto.getPhoneNum(); // SmsrequestDto에서 전화번호를 가져온다.
        String certificationCode = Integer.toString((int)(Math.random() * (999999 - 100000 + 1)) + 100000); // 6자리 인증 코드를 랜덤으로 생성

        return smsCertificationUtil.sendSMS(phoneNum, certificationCode);
    }
}