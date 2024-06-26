package card_order.service.impl;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.entity.CardEntity;
import card_order.mapper.CardMapper;
import card_order.repository.CardRepository;
import card_order.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private  final CardRepository cardRepository;
    private  final CardMapper cardMapper;


    @Override
    public CardDto createCard(CreateCardDto createCardDto) {

        CardEntity cardEntity =cardMapper.toCardEntity(createCardDto);

        CardEntity cardEntityDb=cardRepository.save(cardEntity);

        CardDto  cardDto= cardMapper.toCardDto(cardEntityDb);

        return  cardDto;
    }
}
