package card_order.service.impl;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.dto.UpdateCardDto;
import card_order.entity.CardEntity;
import card_order.exception.CardNotFoundException;
import card_order.mapper.CardMapper;
import card_order.repository.CardRepository;
import card_order.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;


    @Override
    public CardDto createCard(CreateCardDto createCardDto) {

        CardEntity cardEntity = cardMapper.toCardEntity(createCardDto);

        CardEntity cardEntityDb = cardRepository.save(cardEntity);

        CardDto cardDto = cardMapper.toCardDto(cardEntityDb);

        return cardDto;
    }

    @Override
    public CardDto updateCard(Long id, UpdateCardDto updateCardDto) {

        CardEntity cardEntity = cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException("Card not found" + id));

        CardEntity updateCardEntity = cardMapper.toCardEntity(updateCardDto, cardEntity);
        CardEntity updateEntity = cardRepository.save(updateCardEntity);
        return cardMapper.toCardDto(updateEntity);
    }

    @Override
    public List<CardDto> getCardList() {
        return cardRepository.findAll()
                .stream()
                .map(cardMapper::toCardDto)
                .toList();
    }

    @Override
    public CardDto getCardById(Long id) {
        CardEntity cardEntity = cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException("Card not found"));
        return cardMapper.toCardDto(cardEntity);
    }


}
