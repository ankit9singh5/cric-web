package com.cricweb.scoreservice.controller;

import com.cricweb.scoreservice.entity.Score;
import com.cricweb.scoreservice.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Optional<Score> score = scoreRepository.findById(id);
        return score.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/match/{matchId}")
    public List<Score> getScoresByMatch(@PathVariable Long matchId) {
        return scoreRepository.findByMatchId(matchId);
    }

    @GetMapping("/player/{playerId}")
    public List<Score> getScoresByPlayer(@PathVariable Long playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    public List<Score> getScoresByMatchAndInnings(@PathVariable Long matchId, @PathVariable Integer innings) {
        return scoreRepository.findByMatchIdAndInnings(matchId, innings);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Long id, @RequestBody Score scoreDetails) {
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        
        if (scoreOptional.isPresent()) {
            Score score = scoreOptional.get();
            if (scoreDetails.getRuns() != null) {
                score.setRuns(scoreDetails.getRuns());
            }
            if (scoreDetails.getWickets() != null) {
                score.setWickets(scoreDetails.getWickets());
            }
            if (scoreDetails.getOvers() != null) {
                score.setOvers(scoreDetails.getOvers());
            }
            if (scoreDetails.getInnings() != null) {
                score.setInnings(scoreDetails.getInnings());
            }
            if (scoreDetails.getStatus() != null) {
                score.setStatus(scoreDetails.getStatus());
            }
            
            Score updatedScore = scoreRepository.save(score);
            return ResponseEntity.ok(updatedScore);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        if (scoreRepository.existsById(id)) {
            scoreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
