package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.assist.FrontendUrl;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.dto.EmailDto;
import com.hamitmizrak.business.services.IBlogServices;
import com.hamitmizrak.business.services.IEmailServices;
import com.hamitmizrak.business.services.impl.EmailServicesImpl;
import com.hamitmizrak.controller.api.IBlogApi;
import com.hamitmizrak.controller.api.IEmailApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = FrontendUrl.REACT_URL) // http://localhost:3000
@RequestMapping("/email/api/v1")
public class EmailApiImpl implements IEmailApi<BlogDto> {

    // Injection
     private final IEmailServices iEmailServices;

     // LIST
    // http://localhost:4444/email/api/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<BlogDto>> emailServiceList() {
        return ResponseEntity.ok(iEmailServices.emailServiceList());
    }

    // BASIC
    // http://localhost:4444/email/api/v1/basic
    @Override
    @PostMapping("/basic")
    public ResponseEntity<?> basicApiSendEmail(@Valid @RequestBody EmailDto emailDto) {
        return ResponseEntity.ok(iEmailServices.basicSendEmail(emailDto));
    }

    // EMAIL
    // http://localhost:4444/email/api/v1/intermedia
    @Override
    @PostMapping("/intermedia")
    public ResponseEntity<EmailDto> intermediaApiSendEmail(@Valid @RequestBody  EmailDto emailDto) {
        return ResponseEntity.ok(iEmailServices.intermediaSendEmail(emailDto));
    }

} //end class
