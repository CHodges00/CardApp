package backEnd.Repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backEnd.Models.Card;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
    
    // Find cards by player name and team, brand, and year
    Page<Card> findByPlayerNameContainingIgnoreCaseAndTeamContainingIgnoreCaseAndBrandIdAndYearId(
            String playerName, String team, Long brandId, Long yearId, Pageable pageable);

    // Find cards by player name and team and brand
    Page<Card> findByPlayerNameContainingIgnoreCaseAndTeamContainingIgnoreCaseAndBrandId(
            String playerName, String team, Long brandId, Pageable pageable);

    // Find cards by player name and team and year
    Page<Card> findByPlayerNameContainingIgnoreCaseAndTeamContainingIgnoreCaseAndYearId(
            String playerName, String team, Long yearId, Pageable pageable);

    // Find cards by player name and brand and year
    Page<Card> findByPlayerNameContainingIgnoreCaseAndBrandIdAndYearId(
            String playerName, Long brandId, Long yearId, Pageable pageable);

    // Find cards by team, brand, and year
    Page<Card> findByTeamContainingIgnoreCaseAndBrandIdAndYearId(
            String team, Long brandId, Long yearId, Pageable pageable);

    // Find cards by player name and team
    Page<Card> findByPlayerNameContainingIgnoreCaseAndTeamContainingIgnoreCase(
            String playerName, String team, Pageable pageable);

    // Find cards by player name and brand
    Page<Card> findByPlayerNameContainingIgnoreCaseAndBrandId(
            String playerName, Long brandId, Pageable pageable);

    // Find cards by player name and year
    Page<Card> findByPlayerNameContainingIgnoreCaseAndYearId(
            String playerName, Long yearId, Pageable pageable);

    // Find cards by team and brand
    Page<Card> findByTeamContainingIgnoreCaseAndBrandId(
            String team, Long brandId, Pageable pageable);

    // Find cards by team and year
    Page<Card> findByTeamContainingIgnoreCaseAndYearId(
            String team, Long yearId, Pageable pageable);

    // Find cards by brand and year
    Page<Card> findByBrandIdAndYearId(
            Long brandId, Long yearId, Pageable pageable);

    // Find cards by player name
    Page<Card> findByPlayerNameContainingIgnoreCase(String playerName, Pageable pageable);

    // Find cards by team
    Page<Card> findByTeamContainingIgnoreCase(String team, Pageable pageable);

    // Find cards by brand
    Page<Card> findByBrandId(Long brandId, Pageable pageable);

    // Find cards by year
    Page<Card> findByYearId(Long yearId, Pageable pageable);

    // Find all cards
    Page<Card> findAll(Pageable pageable);
}
