package edu.ou.paymentsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("BillStatus")
public class BillStatusDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String name;
    private String slug;
}
