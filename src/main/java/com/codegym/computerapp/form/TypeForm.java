package com.codegym.computerapp.form;

import org.springframework.web.multipart.MultipartFile;

public class TypeForm {

    private Long id;

    private String name;

    private MultipartFile image;

    public TypeForm() {
    }

    public TypeForm(String name, MultipartFile image) {
        this.name = name;
        this.image = image;
    }

    public TypeForm(Long id, String name, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
