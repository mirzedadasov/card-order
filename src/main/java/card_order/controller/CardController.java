package card_order.controller;

import card_order.dto.CardDto;
import card_order.dto.CreateCardDto;
import card_order.dto.UpdateCardDto;
import card_order.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;


    @PostMapping
    public ResponseEntity<CardDto> createCard(@Valid @RequestBody CreateCardDto createCardDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body((cardService.createCard(createCardDto)));
    }

    @PatchMapping
    public ResponseEntity<CardDto> updateCard(@RequestParam Long id,
                                              @Valid @RequestBody UpdateCardDto updateCardDto) {
        return ResponseEntity.ok(cardService.updateCard(id, updateCardDto));
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getCardList() {
        return ResponseEntity.ok(cardService.getCardList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));

    }

}
