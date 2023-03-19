package edu.ou.paymentsyncdataservice.repository.bill;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BillAddRepository extends BaseRepository<BillDocument, BillDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(BillDocument input) {
        // do nothing
    }

    /**
     * Save new bill
     *
     * @param billDocument bill
     * @return bill
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected BillDocument doExecute(BillDocument billDocument) {
        return mongoTemplate.save(billDocument);
    }

    @Override
    protected void postExecute(BillDocument input) {
        // do nothing
    }
}
