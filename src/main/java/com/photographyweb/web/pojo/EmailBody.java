package com.photographyweb.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailBody {
    private String sender;
    private String senderName;
    private String senderPhone;
    private List<Order> senderOrder;
}
