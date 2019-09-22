package com.jose.park_ok_colaborador.commom;

import android.os.Parcel;
import android.os.Parcelable;

import java.security.PrivateKey;
import java.util.Date;

public class Historic implements Parcelable {

    private long id;
    private int typeService;
    private Date lenghtOfStay;
    private double amount;
    private double amountPaid;
    private Date serviceDate;
    private  int formOfPayment;
    private String nome;
    private Date input;
    private Date exit;
    private String boad;
    private long cpf;
    private double discountAmount;



    public Historic(long id, int typeService, Date lenghtOfStay, double amount, double amountPaid, Date serviceDate, int formOfPayment, String nome, Date input, Date exit, String boad, long cpf, double discountAmount) {
        this.id = id;
        this.typeService = typeService;
        this.lenghtOfStay = lenghtOfStay;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.serviceDate = serviceDate;
        this.formOfPayment = formOfPayment;
        this.nome = nome;
        this.input = input;
        this.exit = exit;
        this.boad = boad;
        this.cpf = cpf;
        this.discountAmount = discountAmount;
    }

    protected Historic(Parcel in) {
        id = in.readLong();
        typeService = in.readInt();
        amount = in.readDouble();
        amountPaid = in.readDouble();
        formOfPayment = in.readInt();
        nome = in.readString();
        boad = in.readString();
        cpf = in.readLong();
        input = new Date(in.readLong());
        exit = new Date(in.readLong());
        lenghtOfStay = new Date(in.readLong());
        discountAmount = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(typeService);
        dest.writeDouble(amount);
        dest.writeDouble(amountPaid);
        dest.writeInt(formOfPayment);
        dest.writeString(nome);
        dest.writeString(boad);
        dest.writeLong(cpf);
        dest.writeLong(input.getTime());
        dest.writeLong(lenghtOfStay.getTime());
        dest.writeLong(exit.getTime());
        dest.writeDouble(discountAmount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Historic> CREATOR = new Creator<Historic>() {
        @Override
        public Historic createFromParcel(Parcel in) {
            return new Historic(in);
        }

        @Override
        public Historic[] newArray(int size) {
            return new Historic[size];
        }
    };

    public long getId() {
        return id;
    }

    public int getTypeService() {
        return typeService;
    }

    public Date getLenghtOfStay() {
        return lenghtOfStay;
    }

    public double getAmount() {
        return amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public int getFormOfPayment() {
        return formOfPayment;
    }

    public String getNome() {
        return nome;
    }

    public Date getInput() {
        return input;
    }

    public Date getExit() {
        return exit;
    }

    public String getBoad() {
        return boad;
    }

    public long getCpf() {
        return cpf;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
}
