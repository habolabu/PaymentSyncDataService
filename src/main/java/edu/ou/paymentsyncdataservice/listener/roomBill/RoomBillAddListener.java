package edu.ou.paymentsyncdataservice.listener.roomBill;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.payment.internal.roomBill.RoomBillAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.paymentsyncdataservice.common.mapper.RoomBillDocumentMapper;
import edu.ou.paymentsyncdataservice.data.entity.RoomBillDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoomBillAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoomBillDocument, RoomBillDocument> roomBillAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new room bill
     *
     * @param room room of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomBillAddQueueI.QUEUE})
    public Object execute(Object room) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) room);
        final RoomBillDocument roomBillBillDocument = RoomBillDocumentMapper.INSTANCE.fromMap(dataMap);

        return roomBillAddRepository.execute(roomBillBillDocument);
    }
}
