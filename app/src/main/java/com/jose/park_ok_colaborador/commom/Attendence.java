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
    private Date exitAttendece;
    private double amountPayable;
    private double value;
    private double finalValue;
    private int typeVehicle;


    public Attendence(long id, int cpf, String nameUser, int typeAttendance,
                      int numberBoard, Date dateHour,Date exitAttendece,double amountPayable, double value,double finalValue, int typeVehicle) {
        this.id = id;
        this.cpf = cpf;
        this.nameUser = nameUser;
        this.typeAttendance = typeAttendance;
        this.numberBoard = numberBoard;
        this.dateHour = dateHour;
        this.exitAttendece = exitAttendece;
        this.amountPayable = amountPayable;
        this.finalValue = finalValue;
        this.value = value;
        this.typeVehicle = typeVehicle;
    }

    protected Attendence(Parcel in) {
        id = in.readLong();
        cpf = in.readInt();
        nameUser = in.readString();
        typeAttendance = in.readInt();
        dateHour = new Date(in.readLong());
        exitAttendece = new Date(in.readLong());
        numberBoard = in.readInt();
        value = in.readDouble();
        amountPayable = in.readDouble();
        finalValue = in.readDouble();
        typeVehicle = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(cpf);
        dest.writeString(nameUser);
        dest.writeInt(typeAttendance);
        dest.writeInt(numberBoard);
        dest.writeLong(dateHour.getTime());
        dest.writeLong(exitAttendece.getTime());
        dest.writeDouble(amountPayable);
        dest.writeDouble(finalValue);
        dest.writeDouble(value);
        dest.writeInt(typeVehicle);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
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

    public int getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(int typeVehicle) {
        this.typeVehicle = typeVehicle;
    }
}

