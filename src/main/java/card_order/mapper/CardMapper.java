package card_order.mapper;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.entity.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CardMapper {

    CardEntity toCardEntity(CreateCardDto createCardDto);

    CardDto toCardDto(CardEntity cardEntity);
}
