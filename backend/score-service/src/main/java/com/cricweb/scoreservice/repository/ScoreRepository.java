package com.cricweb.scoreservice.repository;

import com.cricweb.scoreservice.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByMatchId(Long matchId);
    List<Score> findByPlayerId(Long playerId);
    List<Score> findByMatchIdAndInnings(Long matchId, Integer innings);
}
