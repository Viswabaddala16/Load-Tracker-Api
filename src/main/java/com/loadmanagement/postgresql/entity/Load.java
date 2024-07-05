package com.loadmanagement.postgresql.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "loads")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private String details;

    private UUID shipperId;

    @JsonFormat(pattern = "dd-MM-yyyy") // Ensure date format matches your input
    private Date date;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(int noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public double getWeight() {
        return weight;
    }
    
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UUID getShipperId() {
        return shipperId;
    }

    public void setShipperId(UUID shipperId) {
        this.shipperId = shipperId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}





//package com.loadmanagement.postgresql.entity;
//
//import jakarta.persistence.*;
//import java.util.Date;
//import java.util.UUID;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//@Entity
//@Table(name = "loads")
//public class Load {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String loadingPoint;
//    private String unloadingPoint;
//    private String productType;
//    private String truckType;
//    private int noOfTrucks;
//    private double weight;
//    private String comment;
//    private String details;
//
//    private UUID shipperId;
//
//
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date date;
//
//    // Getters and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLoadingPoint() {
//        return loadingPoint;
//    }
//
//    public void setLoadingPoint(String loadingPoint) {
//        this.loadingPoint = loadingPoint;
//    }
//
//    public String getUnloadingPoint() {
//        return unloadingPoint;
//    }
//
//    public void setUnloadingPoint(String unloadingPoint) {
//        this.unloadingPoint = unloadingPoint;
//    }
//
//    public String getProductType() {
//        return productType;
//    }
//
//    public void setProductType(String productType) {
//        this.productType = productType;
//    }
//
//    public String getTruckType() {
//        return truckType;
//    }
//
//    public void setTruckType(String truckType) {
//        this.truckType = truckType;
//    }
//
//    public int getNoOfTrucks() {
//        return noOfTrucks;
//    }
//
//    public void setNoOfTrucks(int noOfTrucks) {
//        this.noOfTrucks = noOfTrucks;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//    public String getDetails() {
//        return this.details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public UUID getShipperId() {
//        return shipperId;
//    }
//
//    public void setShipperId(UUID shipperId) {
//        this.shipperId = shipperId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
