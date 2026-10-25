package com.photographyweb.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientQuery {
    private String sender;
    private String senderName;
    private String senderPhone;
    private String message;
}
