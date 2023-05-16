package edu.ou.paymentsyncdataservice.common.mapper;

import edu.ou.paymentsyncdataservice.data.entity.BillDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface BillDocumentMapper {
    BillDocumentMapper INSTANCE = Mappers.getMapper(BillDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to BillEntity object
     *
     * @param map represents for BillEntity object
     * @return BillDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "billStatusId", source = "billStatusId", qualifiedByName = "objectToInt")
    @Mapping(target = "paymentTypeId", source = "paymentTypeId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "total", source = "total", qualifiedByName = "objectToDouble")
    @Mapping(target = "paidDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    BillDocument fromMap(Map<String, Object> map);

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
