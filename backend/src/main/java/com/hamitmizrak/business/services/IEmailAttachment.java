package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.dto.EmailDto;

public interface IEmailAttachment  {

    public EmailDto basicSendEmail(EmailDto emailDto);
    public EmailDto intermediaSendEmail(EmailDto emailDto);
}
