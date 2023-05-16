package edu.ou.paymentsyncdataservice.common.mapper;

import edu.ou.paymentsyncdataservice.data.entity.RoomBillDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface RoomBillDocumentMapper {
    RoomBillDocumentMapper INSTANCE = Mappers.getMapper(RoomBillDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to RoomBillBillEntity object
     *
     * @param map represents for RoomBillEntity object
     * @return RoomBillDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "billId", source = "billId", qualifiedByName = "objectToInt")
    @Mapping(target = "roomId", source = "roomId", qualifiedByName = "objectToInt")
    @Mapping(target = "dayAmount", source = "dayAmount", qualifiedByName = "objectToInt")
    @Mapping(target = "total", source = "total", qualifiedByName = "objectToDouble")
    RoomBillDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to int
     *
     * @param object object will be converted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }

    /**
     * Convert object to double
     *
     * @param object object will be converted
     * @return double value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToDouble")
    static double objectToDouble(Object object) {
        return Double.parseDouble(String.valueOf(object));
    }
}
