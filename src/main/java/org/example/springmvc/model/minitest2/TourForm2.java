package org.example.springmvc.model.minitest2;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;


public class TourForm2 {
    private int id;
    private String code;
    private String destination;
    private Date start;
    private MultipartFile img;
    private Province province;
    public TourForm2() {
    }

    public TourForm2(int id, String code, String destination, Date start, MultipartFile img) {
        this.id = id;
        this.code = code;
        this.destination = destination;
        this.start = start;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}