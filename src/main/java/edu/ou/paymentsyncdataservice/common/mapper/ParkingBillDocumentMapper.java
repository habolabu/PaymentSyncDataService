package edu.ou.paymentsyncdataservice.common.mapper;

import edu.ou.paymentsyncdataservice.data.entity.ParkingBillDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ParkingBillDocumentMapper {
    ParkingBillDocumentMapper INSTANCE = Mappers.getMapper(ParkingBillDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to ParkingBillEntity object
     *
     * @param map represents for ParkingBillEntity object
     * @return ParkingBillDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "billId", source = "billId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingTypeId", source = "parkingTypeId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingId", source = "parkingId", qualifiedByName = "objectToInt")
    @Mapping(target = "dayAmount", source = "dayAmount", qualifiedByName = "objectToInt")
    @Mapping(target = "total", source = "total", qualifiedByName = "objectToDouble")
    ParkingBillDocument fromMap(Map<String, Object> map);

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
