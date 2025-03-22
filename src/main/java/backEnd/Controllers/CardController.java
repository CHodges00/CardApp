package backEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backEnd.Models.Card;
import backEnd.Repos.CardRepo;

@RestController
@RequestMapping("/cards")
public class CardController {
    
    @Autowired
    private CardRepo cardRepo;
    
    @GetMapping("/allCards")
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteCard(Long id) {
        cardRepo.deleteById(id);
    }
}