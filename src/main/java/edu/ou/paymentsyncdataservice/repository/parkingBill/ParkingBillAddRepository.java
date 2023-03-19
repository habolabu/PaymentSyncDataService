package edu.ou.paymentsyncdataservice.repository.parkingBill;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.paymentsyncdataservice.data.entity.ParkingBillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingBillAddRepository extends BaseRepository<ParkingBillDocument, ParkingBillDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingBillDocument input) {
        // do nothing
    }

    /**
     * Save new parking bill
     *
     * @param parkingBillDocument parking bill
     * @return parking bill
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingBillDocument doExecute(ParkingBillDocument parkingBillDocument) {
        return mongoTemplate.save(parkingBillDocument);
    }

    @Override
    protected void postExecute(ParkingBillDocument input) {
        // do nothing
    }
}
