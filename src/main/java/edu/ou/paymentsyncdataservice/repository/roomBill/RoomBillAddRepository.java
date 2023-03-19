package edu.ou.paymentsyncdataservice.repository.roomBill;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.paymentsyncdataservice.data.entity.RoomBillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomBillAddRepository extends BaseRepository<RoomBillDocument, RoomBillDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoomBillDocument input) {
        // do nothing
    }

    /**
     * Save new room bill
     *
     * @param roomBillDocument room bill
     * @return room bill
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoomBillDocument doExecute(RoomBillDocument roomBillDocument) {
        return mongoTemplate.save(roomBillDocument);
    }

    @Override
    protected void postExecute(RoomBillDocument input) {
        // do nothing
    }
}
