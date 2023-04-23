package pl.sda.springrestapp1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
//@Primary
@Service
@Slf4j
public class SmsCommercialService implements CommercialService{
    @Override
    public void sendCommercial(String commercialContent) {
        log.info(String.format("Sent sms from SmsCommercialService: [%s]", commercialContent));
    }
}
