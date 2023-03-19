package edu.ou.paymentsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("Bill")
public class BillDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private int billStatusId;
    private int paymentTypeId;
    private int total;
    private int userId;
    private Date paidDate;
    private Date createdAt = new Date(System.currentTimeMillis());
}
