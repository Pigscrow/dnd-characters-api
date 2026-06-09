# D&D Characters API

A REST API for managing Dungeons & Dragons characters, built with Spring Boot.

## Features

- Full CRUD for D&D characters
- Skill roll system with D&D modifier calculation (1d20 + modifier)
- Input validation (stats between 1-20, required fields)
- Interactive API documentation with Swagger UI
- Paginated character listing
- CORS enabled for frontend integration

## Tech Stack

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- OpenFeign (external dice API integration)
- Swagger / OpenAPI 3

## Getting Started

### Prerequisites

- Java 21
- PostgreSQL 16

### Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE dnd_characters;
```

### Configuration

Set the following environment variables with your PostgreSQL credentials:

| Variable | Description |
|----------|-------------|
| `DB_USERNAME` | PostgreSQL username |
| `DB_PASSWORD` | PostgreSQL password |

On Windows (Command Prompt):
```cmd
set DB_USERNAME=your_username
set DB_PASSWORD=your_password
```

On Mac/Linux:
```bash
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

### Run

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Documentation

Once running, explore all endpoints at:

`http://localhost:8080/swagger-ui.html`

## Endpoints

### Characters

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/characters?page=0&size=20` | Get all characters (paginated) |
| GET | `/characters/{id}` | Get character by ID |
| POST | `/characters` | Create a new character |
| PUT | `/characters/{id}` | Update a character |
| DELETE | `/characters/{id}` | Delete a character |

> **Pagination parameters:** `page` (default: 0), `size` (default: 20), `sort` (default: `name,asc`)

### Dice

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/characters/{id}/roll?skill={skill}` | Roll a d20 skill check |

Valid skills: `strength`, `dexterity`, `constitution`, `intelligence`, `wisdom`, `charisma`

### Example Request

```json
POST /characters
{
  "name": "Aragorn",
  "race": "Human",
  "characterClass": "Warrior",
  "strength": 18,
  "dexterity": 14,
  "constitution": 16,
  "intelligence": 12,
  "wisdom": 13,
  "charisma": 15
}
```

### Example Skill Roll Response

```json
GET /characters/1/roll?skill=strength

{
  "character": "Aragorn",
  "skill": "strength",
  "roll": 17,
  "modifier": 4,
  "total": 21,
  "details": "1d20[17] + modifier(4) = 21"
}
```

## Roadmap

- [x] Character CRUD
- [x] Input validation and error handling
- [x] Swagger / OpenAPI documentation
- [x] PostgreSQL
- [x] Skill roll system with Feign
- [x] Pagination and CORS support
- [ ] Inventory system
- [ ] Backstory for characters
- [ ] Combat with AI narration (epic / dramatic / comic)

## License

MIT
