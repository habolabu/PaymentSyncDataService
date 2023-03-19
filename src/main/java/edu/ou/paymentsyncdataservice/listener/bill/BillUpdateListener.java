package edu.ou.paymentsyncdataservice.listener.bill;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.payment.internal.bill.BillUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.paymentsyncdataservice.common.mapper.BillDocumentMapper;
import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BillUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<BillDocument, BillDocument> billUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new bill
     *
     * @param bill bill of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {BillUpdateQueueI.QUEUE})
    public Object execute(Object bill) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) bill);
        final BillDocument billDocument = BillDocumentMapper.INSTANCE.fromMap(dataMap);
        billDocument.setBillStatusId((Integer) dataMap.get("billStatusId"));

        if (Objects.nonNull(dataMap.get("paidDate"))) {
            billDocument.setPaidDate(new Date((long) dataMap.get("paidDate")));
        }

        return billUpdateRepository.execute(billDocument);
    }

}
