package com.jose.park_ok_colaborador.commom;

import java.io.Serializable;

public class Tutorial implements Serializable {

    private int idImage;
    private String information;


    public Tutorial(int idImage, String information) {
        this.idImage = idImage;
        this.information = information;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
