package edu.ou.paymentsyncdataservice.repository.bill;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BillUpdateRepository extends BaseRepository<BillDocument, BillDocument> {
    private final IBaseRepository<Integer, BillDocument> billFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(BillDocument input) {
        // do nothing
    }

    /**
     * Update exist bill document
     *
     * @param billDocument bill
     * @return updated bill
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected BillDocument doExecute(BillDocument billDocument) {
        final BillDocument existBillDocument = billFindOneRepository.execute(billDocument.getOId());

        assert existBillDocument != null;
        billDocument.setId(existBillDocument.getId());

        return mongoTemplate.save(billDocument);
    }

    @Override
    protected void postExecute(BillDocument input) {
        // do nothing
    }
}
