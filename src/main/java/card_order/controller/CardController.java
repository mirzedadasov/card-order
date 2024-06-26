package card_order.controller;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private  final CardService cardService;


    @PostMapping
    public ResponseEntity<CardDto>createCard(@Valid  @RequestBody CreateCardDto createCardDto){
        return  ResponseEntity.ok(cardService.createCard(createCardDto));
    }



}
