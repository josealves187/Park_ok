package com.jose.park_ok_colaborador.commom;

import java.io.Serializable;
import java.math.BigDecimal;

public class FAQ implements Serializable {

    private String topic;
    private String information;



    public FAQ(String topic, String information) {
        this.topic = topic;
        this.information = information;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }



}
