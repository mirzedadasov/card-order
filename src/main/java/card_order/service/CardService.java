package card_order.service;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.dto.UpdateCardDto;

import java.util.List;

public interface CardService {
    CardDto createCard(CreateCardDto createCardDto);

    CardDto updateCard(Long id, UpdateCardDto updateCardDto);

    List<CardDto> getCardList();


    CardDto getCardById(Long id);
}
