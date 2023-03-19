package edu.ou.paymentsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("PaymentType")
public class PaymentTypeDocument implements Serializable {
    @Id
    private String id;
    private String name;
    private int oId;
    private String slug;
}
