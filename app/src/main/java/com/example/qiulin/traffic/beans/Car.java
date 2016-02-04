package com.example.qiulin.traffic.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class Car implements Parcelable {
    private String id;
    private String carNo;
    private String carType;
    private String carOwner;
    private String kilometers;
    private String bearerNumber;
    private String annualInspectionTime;

    protected Car(Parcel in) {
        id = in.readString();
        carNo = in.readString();
        carType = in.readString();
        carOwner = in.readString();
        kilometers = in.readString();
        bearerNumber = in.readString();
        annualInspectionTime = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getBearerNumber() {
        return bearerNumber;
    }

    public void setBearerNumber(String bearerNumber) {
        this.bearerNumber = bearerNumber;
    }

    public String getAnnualInspectionTime() {
        return annualInspectionTime;
    }

    public void setAnnualInspectionTime(String annualInspectionTime) {
        this.annualInspectionTime = annualInspectionTime;
    }
    public Car(String id, String carNo, String carType, String carOwner, String kilometers, String bearerNumber, String annualInspectionTime) {
        this.id = id;
        this.carNo = carNo;
        this.carType = carType;
        this.carOwner = carOwner;
        this.kilometers = kilometers;
        this.bearerNumber = bearerNumber;
        this.annualInspectionTime = annualInspectionTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(carNo);
        dest.writeString(carType);
        dest.writeString(carOwner);
        dest.writeString(kilometers);
        dest.writeString(bearerNumber);
        dest.writeString(annualInspectionTime);
    }
}
