package com.jose.park_ok_colaborador.commom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Attendence implements Parcelable {

    private long id;
    private String cpf;
    private String nameUser;
    private int typeAttendance;
    private String numberBoard;
    private Date dateHour;
    private Date exitAttendece;
    private double amountPayable;
    private double value;
    private double finalValue;
    private int typeVehicle;


    public Attendence(long id, String cpf, String nameUser, int typeAttendance, String numberBoard,
                      Date dateHour, Date exitAttendece, double amountPayable, double value, double
                              finalValue, int typeVehicle) {
        this.id = id;
        this.cpf = cpf;
        this.nameUser = nameUser;
        this.typeAttendance = typeAttendance;
        this.numberBoard = numberBoard;
        this.dateHour = dateHour;
        this.exitAttendece = exitAttendece;
        this.amountPayable = amountPayable;
        this.value = value;
        this.finalValue = finalValue;
        this.typeVehicle = typeVehicle;
    }


    protected Attendence(Parcel in) {
        id = in.readLong();
        cpf = in.readString();
        nameUser = in.readString();
        typeAttendance = in.readInt();
        dateHour = new Date(in.readLong());
        exitAttendece = new Date(in.readLong());
        numberBoard = in.readString();
        amountPayable = in.readDouble();
        value = in.readDouble();
        finalValue = in.readDouble();
        typeVehicle = in.readInt();



    }

    public static final Creator<Attendence> CREATOR = new Creator<Attendence>() {
        @Override
        public Attendence createFromParcel(Parcel in) {
            return new Attendence(in);
        }

        @Override
        public Attendence[] newArray(int size) {
            return new Attendence[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getNumberBoard() {
        return numberBoard;
    }

    public void setNumberBoard(String numberBoard) {
        this.numberBoard = numberBoard;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public Date getExitAttendece() {
        return exitAttendece;
    }

    public void setExitAttendece(Date exitAttendece) {
        this.exitAttendece = exitAttendece;
    }

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
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
        dest.writeLong(id);
        dest.writeString(cpf);
        dest.writeString(nameUser);
        dest.writeInt(typeAttendance);
        dest.writeString(numberBoard);
        dest.writeDouble(amountPayable);
        dest.writeDouble(value);
        dest.writeDouble(finalValue);
        dest.writeInt(typeVehicle);
        dest.writeLong(dateHour.getTime());
        dest.writeLong(exitAttendece.getTime());
    }
}

