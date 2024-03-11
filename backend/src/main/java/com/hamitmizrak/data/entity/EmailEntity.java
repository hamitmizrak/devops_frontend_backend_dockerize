package com.hamitmizrak.data.entity;

import com.hamitmizrak.data.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ENTITY
@Entity
@Table(name = "emails")
// Category(1) Blog(N)
public class EmailEntity extends BaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // KIME
    @Column(name = "email_to")
    private String emailTo;

    // KIMDEN GELIYOR
    @Column(name = "email_from")
    private String emailFrom;

    // KONU
    @Column(name = "email_subject")
    private String emailSubject;

    // TEXT
    @Lob
    @Column(name = "email_text")
    private String emailText;

    // IMAGE
    private String image;

    // URL
    private String url;

    // CC
    @Column(name = "email_cc")
    private String emailCc;

    // EMAİL CC ARRAY
    @Column(name = "email_cc_array")
    private String emailCcArray;

    // BCC
    @Column(name = "email_bcc")
    private String emailBcc;

    // EMAİL BCC ARRAY
    @Column(name = "email_bcc_array")
    private String emailBccArray;

} //end class
