package card_order.mapper;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.dto.UpdateCardDto;
import card_order.entity.CardEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface CardMapper {

    CardEntity toCardEntity(CreateCardDto createCardDto);

    CardDto toCardDto(CardEntity cardEntity);

    CardEntity toCardEntity(UpdateCardDto updateCardDto, @MappingTarget CardEntity cardEntity);

}
