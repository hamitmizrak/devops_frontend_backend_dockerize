package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.EmailDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmailApi<D> {

    // LIST
    public ResponseEntity<List<D>>  emailServiceList();

    // BASIC (text)
     ResponseEntity<?> basicApiSendEmail (EmailDto emailDto);

    // INTERMEDIA (pdf , picture)
     ResponseEntity<EmailDto> intermediaApiSendEmail (EmailDto emailDto);
}
