package edu.ou.paymentsyncdataservice;

import edu.ou.coreservice.annotation.BaseSyncDataAnnotation;
import org.springframework.boot.SpringApplication;

@BaseSyncDataAnnotation
public class PaymentSyncDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSyncDataServiceApplication.class, args);
    }
}
