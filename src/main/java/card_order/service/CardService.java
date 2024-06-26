package card_order.service;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;

public interface CardService {
    CardDto createCard(CreateCardDto createCardDto);
}
