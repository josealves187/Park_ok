package com.jose.park_ok_colaborador.commom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Attendence implements Parcelable {

    private long id;
    private int cpf;
    private String nameUser;
    private int typeAttendance;
    private int numberBoard;
    private Date dateHour;
    private double value;
    private int typeVehicle;


    public Attendence(long id, int cpf, String nameUser, int typeAttendance,
                      int numberBoard, Date dateHour, double value, int typeVehicle) {
        this.id = id;
        this.cpf = cpf;
        this.nameUser = nameUser;
        this.typeAttendance = typeAttendance;
        this.numberBoard = numberBoard;
        this.dateHour = dateHour;
        this.value = value;
        this.typeVehicle = typeVehicle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getTypeAttendance() {
        return typeAttendance;
    }

    public void setTypeAttendance(int typeAttendance) {
        this.typeAttendance = typeAttendance;
    }

    public int getNumberBoard() {
        return numberBoard;
    }

    public void setNumberBoard(int numberBoard) {
        this.numberBoard = numberBoard;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(int typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
