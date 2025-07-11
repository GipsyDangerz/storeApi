# Java Store API

A simple Spring Boot application that simulates product creation events and processes them through a simulated Kafka pipeline. It uses an in-memory H2 database for storage and testing.
Our team of one tired person tried to implement Kafka without actually implementing it, it was easy at first to add the classic code of a consumer, producer etc. 
But the real work happened when our unpaid worker saw that we can`t have a broker, zookeeper or Docker. Since this is a test, or poc thing, it had to be as self-contained as possible.

---

## Features

- Create, retrieve, and update products, employees, clients
- Simulate Kafka event publishing on product creation
- Persist processed product events in the database, while the app is running since H2 as it is doesn`t store anything outside the session
- In-memory H2 database for testing and development
- Clean (hopefully), modular architecture using Spring Boot

---

## Technologies

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Simulated Kafka integration (can be uncommented for an actual integration)

---

## Setup & Run

### Prerequisites

- Java 17 or higher
- Maven

### Run Locally

1. **Clone the repository**
   ```bash
   git clone https://github.com/GipsyDangerz/storeApi.git
   cd storeApi
