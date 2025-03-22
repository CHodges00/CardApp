package backEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backEnd.Models.Brand;
import backEnd.Models.Card;
import backEnd.Models.Year;
import backEnd.Repos.BrandRepo;
import backEnd.Repos.CardRepo;
import backEnd.Repos.YearRepo;

@Controller
public class MappingController {

    @Autowired BrandRepo brandRepo;
    @Autowired CardRepo cardRepo;
    @Autowired YearRepo yearRepo;


    @GetMapping("/404")
    public String err404(Model model) {
        model.addAttribute("message", "Generic error, what did you do?????");
        model.addAttribute("homeReturn", true);
        return "error";
    }

    @GetMapping("/cardapp")
    public String home() {
        return "home";
    }

    @GetMapping("/y")
    public String year(Model model) {
        Year year = new Year();
        model.addAttribute("year", year);
        return "year";
    }

    @GetMapping("/b")
    public String brand(Model model) {
        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        return "brand";
    }


    @GetMapping("/s")
    public String search(Model model) {
        List<Brand> brands = brandRepo.findAll();
        model.addAttribute("brands", brands);
        List<Year> years = yearRepo.findAll();
        model.addAttribute("years", years);
        return "search";
    }

    @GetMapping("/a")
    public String add(Model model) {
        List<Brand> brands = brandRepo.findAll();
        model.addAttribute("brands", brands);

        List<Year> years = yearRepo.findAll();
        model.addAttribute("years", years);
        
        Card card = new Card();
        model.addAttribute("card", card);
        
        return "add";
    }

    @PostMapping("/addBrand")
    public String addCard(@ModelAttribute Brand brand, Model model) {
        try {
            brandRepo.save(brand);
            return "redirect:/b";
        } catch (Exception e) {
            model.addAttribute("brandReturn", true);
            model.addAttribute("message", "Brand already exists");
            return "error";
        }
    }

    @PostMapping("/addCard")
    public String addCard(@ModelAttribute Card card, Model model) {
        try {
            cardRepo.save(card);
            return "redirect:/a";
        } catch (Exception e) {
            model.addAttribute("cardReturn", true);
            model.addAttribute("message", "Card already exists");
            return "error";
        }
    }

    @PostMapping("/addYear")
    public String addYear(@ModelAttribute Year year, Model model) {
        try {
            yearRepo.save(year);
            return "redirect:/y";
        } catch (Exception e) {
            model.addAttribute("yearReturn", true);
            model.addAttribute("message", "Year already exists");
            return "error";
        }
    }

    @GetMapping("/searchCards")
    public String searchCards(
            @RequestParam(required = false) String playerName,
            @RequestParam(required = false) String team,
            @RequestParam(required = false) Long brand,
            @RequestParam(required = false) Long year,
            @RequestParam(defaultValue = "0") int page,
            Model model) {
    
        // Define pagination settings (default page size = 10)
        Pageable pageable = PageRequest.of(page, 10);
        Page<Card> cards;
    
        // Query logic for search with various filters
        if (playerName != null && !playerName.isEmpty() &&
            team != null && !team.isEmpty() &&
            brand != null && year != null) {
            cards = cardRepo.findByPlayerNameContainingIgnoreCaseAndTeamContainingIgnoreCaseAndBrandIdAndYearId(
                    playerName, team, brand, year, pageable);
        } else if (playerName != null && !playerName.isEmpty()) {
            cards = cardRepo.findByPlayerNameContainingIgnoreCase(playerName, pageable);
        } else if (team != null && !team.isEmpty()) {
            cards = cardRepo.findByTeamContainingIgnoreCase(team, pageable);
        } else if (brand != null) {
            cards = cardRepo.findByBrandId(brand, pageable);
        } else if (year != null) {
            cards = cardRepo.findByYearId(year, pageable);
        } else {
            cards = cardRepo.findAll(pageable);
        }
    
        // Get the list of all brands and years for the filter dropdowns
        List<Brand> brands = brandRepo.findAll();
        model.addAttribute("brands", brands);
        List<Year> years = yearRepo.findAll();
        model.addAttribute("years", years);
    
        // Pagination attributes
        int currentPage = cards.getNumber();
        int totalPages = cards.getTotalPages();
        boolean hasPrev = currentPage > 0;
        boolean hasNext = currentPage < totalPages - 1;
    
        // Add the cards and pagination details to the model
        model.addAttribute("cards", cards.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("hasNext", hasNext);
    
        // Return the search page
        return "search";
    }
}