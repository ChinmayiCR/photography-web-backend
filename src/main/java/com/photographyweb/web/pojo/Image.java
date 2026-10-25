package com.photographyweb.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String id;
    private String title;
    private String content;
    private String link;
    private String path;
    private int price;
    private int quantity;
}
