# RegalEquineOasis

A microservices-based system for managing horse riding sessions, rider profiles, and horse-related data.

## 🚀 Features
- Rider and horse management
- Session scheduling with conflict prevention
- Role-based authentication (Admin, Rider)
- Popularity tracking for session types

## 🛠 Tech Stack
### Backend:
- Java, Spring Boot
- Spring Security & JWT Authentication
- Spring Data JPA & MySQL
- API Gateway (Spring Cloud Gateway)

### Frontend:
- Angular with Tailwind

## 🏗 Setup Instructions
### Prerequisites:
- Java 17+
- Node.js & Angular CLI
- MySQL

### Backend Setup:
```sh
# Clone the repository
git clone https://github.com/MarinaBajic/RegalEquineOasis.git
cd RegalEquineOasis

# Configure database in application.yml

# Start services
mvn clean install
mvn spring-boot:run
```

### Frontend Setup:
```sh
cd frontend
npm install
ng serve
```

## 📌 Roadmap
- [ ] Improve route optimization for riding paths
- [ ] Add real-time session availability updates
- [ ] Implement full admin dashboard
