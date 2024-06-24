package com.codegym.computerapp.form;

import com.codegym.computerapp.model.Type;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class ComputerForm {

    private Long id;

    public String code;

    private String name;

    private MultipartFile image;

    private BigDecimal price;

    private String producer;

    private int quantity;

    private Type typeComputer;

    public ComputerForm() {

    }

    public ComputerForm(Long id, String code, String name,
                        MultipartFile image, BigDecimal price,
                        String producer, int quantity, Type typeComputer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
        this.producer = producer;
        this.quantity = quantity;
        this.typeComputer = typeComputer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getTypeComputer() {
        return typeComputer;
    }

    public void setTypeComputer(Type typeComputer) {
        this.typeComputer = typeComputer;
    }
}
