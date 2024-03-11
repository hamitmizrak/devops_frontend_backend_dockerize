package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.dto.EmailDto;
import com.hamitmizrak.business.services.IEmailServices;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.entity.EmailEntity;
import com.hamitmizrak.data.repository.IEmailRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class EmailServicesImpl implements IEmailServices<EmailDto, EmailEntity> {

    // Injection (Lombok Constructor Field) => 3.YOL
    private final IEmailRepository iEmailRepository;
    private final ModelMapperBean modelMapperBean;
    private final JavaMailSender javaMailSender; //Email Göndersin

    // MODEL MAPPER
    @Override
    public EmailDto entityToDto(EmailEntity emailEntity) {
        return modelMapperBean.modelMapperMethod().map(emailEntity,EmailDto.class);
    }

    @Override
    public EmailEntity dtoToEntity(EmailDto emailDto) {
        return  modelMapperBean.modelMapperMethod().map(emailDto,EmailEntity.class);
    }

    // LIST
    @Override
    public List<EmailDto>  emailServiceList() {
        Iterable<EmailEntity> entityIterable=  iEmailRepository.findAll();
        // Dto To entityb List
        List<EmailDto> emailDtoArrayList=new ArrayList<>();
        for (EmailEntity entity:  entityIterable) {
            EmailDto emailDto=entityToDto(entity);
            emailDtoArrayList.add(emailDto);
        }
        log.info("Liste Sayısı: "+emailDtoArrayList.size());
        return emailDtoArrayList;
    }

    ///////////////////////////////////////////////////
    // EMAIL BASIC SEND
    @Override
    //@Transactional
    @SneakyThrows // Throws
    public EmailDto basicSendEmail(EmailDto emailDto) {
        // Model Mapper
        EmailEntity emailEntity=dtoToEntity(emailDto);
        iEmailRepository.save(emailEntity);
        emailDto.setId(emailEntity.getId());

        // Mail Send
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(emailDto.getEmailFrom());//kimden
        simpleMailMessage.setTo(emailDto.getEmailTo());//kime
        simpleMailMessage.setSubject(emailDto.getEmailSubject());//konu
        simpleMailMessage.setText(emailDto.getEmailText());// mesaj
        simpleMailMessage.setSentDate(emailDto.getSystemDate()); //gönderilme tarihi

        // MAil Gönder
        javaMailSender.send(simpleMailMessage);
        return emailDto;
    }

    //  EMAIL INTERMEDIA PICTURE, PDF SEND
    @Override
    //@Transactional
    @SneakyThrows // Throws
    public EmailDto intermediaSendEmail(EmailDto emailDto) {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        return null;
    }

} //end class
