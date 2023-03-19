package edu.ou.paymentsyncdataservice.listener.parkingBill;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.payment.internal.parkingBill.ParkingBillAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.paymentsyncdataservice.common.mapper.ParkingBillDocumentMapper;
import edu.ou.paymentsyncdataservice.data.entity.ParkingBillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ParkingBillAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingBillDocument, ParkingBillDocument> parkingBillAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new parking bill
     *
     * @param parkingBill parkingBill of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingBillAddQueueI.QUEUE})
    public Object execute(Object parkingBill) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) parkingBill);
        final ParkingBillDocument parkingBillDocument = ParkingBillDocumentMapper.INSTANCE.fromMap(dataMap);

        return parkingBillAddRepository.execute(parkingBillDocument);
    }

}
