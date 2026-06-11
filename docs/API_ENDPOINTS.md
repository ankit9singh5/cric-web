# Cricket Score Web App - Backend API Endpoints

## Base URL
- **API Gateway**: `http://localhost:8080`
- **Match Service**: `http://localhost:8081`
- **Player Service**: `http://localhost:8082`
- **Score Service**: `http://localhost:8083`

## Match Service Endpoints

### Get All Matches
```
GET /api/matches
```

### Get Match by ID
```
GET /api/matches/{id}
```

### Create Match
```
POST /api/matches
Content-Type: application/json

{
  "team1": "India",
  "team2": "Australia",
  "venue": "MCG",
  "matchDate": "2024-06-15T19:30:00",
  "status": "SCHEDULED"
}
```

### Update Match
```
PUT /api/matches/{id}
Content-Type: application/json

{
  "status": "ONGOING"
}
```

### Delete Match
```
DELETE /api/matches/{id}
```

---

## Player Service Endpoints

### Get All Players
```
GET /api/players
```

### Get Player by ID
```
GET /api/players/{id}
```

### Get Players by Team
```
GET /api/players/team/{team}
Example: GET /api/players/team/India
```

### Get Players by Role
```
GET /api/players/role/{role}
Example: GET /api/players/role/Batsman
```

### Create Player
```
POST /api/players
Content-Type: application/json

{
  "name": "Virat Kohli",
  "role": "Batsman",
  "team": "India",
  "jerseyNumber": 18,
  "runsScored": 0,
  "wicketsTaken": 0
}
```

### Update Player
```
PUT /api/players/{id}
Content-Type: application/json

{
  "runsScored": 85
}
```

### Delete Player
```
DELETE /api/players/{id}
```

---

## Score Service Endpoints

### Get All Scores
```
GET /api/scores
```

### Get Score by ID
```
GET /api/scores/{id}
```

### Get Scores by Match
```
GET /api/scores/match/{matchId}
```

### Get Scores by Player
```
GET /api/scores/player/{playerId}
```

### Get Scores by Match and Innings
```
GET /api/scores/match/{matchId}/innings/{innings}
Example: GET /api/scores/match/1/innings/1
```

### Create Score
```
POST /api/scores
Content-Type: application/json

{
  "matchId": 1,
  "playerId": 1,
  "runs": 85,
  "wickets": 0,
  "overs": 20.0,
  "innings": 1,
  "status": "ACTIVE"
}
```

### Update Score
```
PUT /api/scores/{id}
Content-Type: application/json

{
  "runs": 95,
  "status": "COMPLETED"
}
```

### Delete Score
```
DELETE /api/scores/{id}
```

---

## Error Responses

All endpoints return appropriate HTTP status codes:
- `200 OK` - Successful GET/PUT request
- `201 Created` - Successful POST request
- `204 No Content` - Successful DELETE request
- `404 Not Found` - Resource not found
- `400 Bad Request` - Invalid request data
- `500 Internal Server Error` - Server error

### Error Response Format
```json
{
  "timestamp": "2024-06-11T12:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Resource not found",
  "path": "/api/matches/999"
}
```

---

## Swagger Documentation

Access interactive API documentation at:
- Match Service: http://localhost:8081/swagger-ui.html
- Player Service: http://localhost:8082/swagger-ui.html
- Score Service: http://localhost:8083/swagger-ui.html

---

## Example Usage with cURL

### Create a Match
```bash
curl -X POST http://localhost:8080/api/matches \
  -H "Content-Type: application/json" \
  -d '{
    "team1": "India",
    "team2": "Pakistan",
    "venue": "Lords",
    "matchDate": "2024-06-15T19:30:00",
    "status": "SCHEDULED"
  }'
```

### Get All Players
```bash
curl http://localhost:8080/api/players
```

### Create a Player
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Rohit Sharma",
    "role": "Batsman",
    "team": "India",
    "jerseyNumber": 45
  }'
```

### Create a Score
```bash
curl -X POST http://localhost:8080/api/scores \
  -H "Content-Type: application/json" \
  -d '{
    "matchId": 1,
    "playerId": 1,
    "runs": 120,
    "wickets": 0,
    "overs": 20.0,
    "innings": 1,
    "status": "ACTIVE"
  }'
```

---

## Notes

- All timestamps are in ISO 8601 format (UTC)
- Jersey numbers must be unique within a team
- Match status: SCHEDULED, ONGOING, COMPLETED, CANCELLED
- Player role: Batsman, Bowler, All-rounder, Wicket-keeper
- Score status: ACTIVE, COMPLETED, CANCELLED
