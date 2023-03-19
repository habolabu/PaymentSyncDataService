package edu.ou.paymentsyncdataservice.listener.bill;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.payment.internal.bill.BillAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.paymentsyncdataservice.common.mapper.BillDocumentMapper;
import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BillAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<BillDocument, BillDocument> billAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new bill
     *
     * @param bill bill of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {BillAddQueueI.QUEUE})
    public Object execute(Object bill) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) bill);
        final BillDocument billDocument = BillDocumentMapper.INSTANCE.fromMap(dataMap);

        return billAddRepository.execute(billDocument);
    }
}
