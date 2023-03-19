package edu.ou.paymentsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("RoomBill")
public class RoomBillDocument implements Serializable {
    @Id
    private String id;
    private int billId;
    private int dayAmount;
    private int oId;
    private int roomId;
    private int total;
}
