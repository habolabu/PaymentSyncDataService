package edu.ou.paymentsyncdataservice.repository.bill;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BillFindOneRepository extends BaseRepository<Integer, BillDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find bill by id
     *
     * @param billId bill id
     * @return bill
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected BillDocument doExecute(Integer billId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(billId)
                ),
                BillDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
