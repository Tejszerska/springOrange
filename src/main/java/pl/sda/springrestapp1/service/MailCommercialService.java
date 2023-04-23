package pl.sda.springrestapp1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailCommercialService implements CommercialService{
    @Override
    public void sendCommercial(String commercialContent) {
        log.info(String.format("Sent mail from MailCommercialService: [%s]", commercialContent));
    }
}
