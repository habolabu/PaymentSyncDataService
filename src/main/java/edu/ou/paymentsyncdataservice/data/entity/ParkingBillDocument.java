package edu.ou.paymentsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("ParkingBill")
public class ParkingBillDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private int billId;
    private int dayAmount;
    private int parkingId;
    private int total;
    private int parkingTypeId;
}
