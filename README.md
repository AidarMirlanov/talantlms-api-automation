# talantlms-api-automation

API test automation project for [TalantLMS](https://www.talentlms.com) — a cloud-based learning management system.

## 🛠 Tech Stack

| Tool | Purpose |
|------|---------|
| Java 17 | Programming language |
| REST Assured | API testing |
| TestNG | Test framework |
| Jackson | JSON serialization |
| Gson | JSON parsing |
| WireMock | Mock server |
| Maven | Build tool |

## 📋 Test Coverage

- User management (create, delete)
- Course management
- Category management
- System settings
- Add user to course

## 🚀 How to Run

```bash
mvn test
```

## ⚙️ Configuration

Edit `src/main/resources/api.properties`:
```properties
base_url=https://kurmanaliev.talentlms.com
api_key=jh61APYYKtd6pbNCNteY7SL3C7TMe1
```
