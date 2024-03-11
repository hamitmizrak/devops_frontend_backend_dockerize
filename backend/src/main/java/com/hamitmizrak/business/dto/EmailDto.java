package com.hamitmizrak.business.dto;

import com.hamitmizrak.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

// EMAIL
public class EmailDto  extends AuditingAwareBaseDto implements Serializable {

    // serileştirme
    public static final Long serialVersionUID=1L;

    // KIME
    @NotEmpty(message = "{email.to.validation.constraints.NotNull.message}")
    private String emailTo;

    // KIMDEN GELIYOR
    @Value("${spring.mail.username}")
    private String emailFrom;

    // KONU
    @NotEmpty(message = "{email.subject.validation.constraints.NotNull.message}")
    private String emailSubject;

    // TEXT
    @NotEmpty(message = "{email.text.validation.constraints.NotNull.message}")
    private String emailText;

    // IMAGE
    @Builder.Default
    private String image="image.png";

    // URL
    @Builder.Default
    private String url="http://localhost:4444";

    // CC
    private String emailCc;
    private String emailCcArray;

    // BCC
    private String emailBcc;
    private String emailBccArray;

    // Date
    @Builder.Default
    private Date sentDate=new Date(System.currentTimeMillis());
}
