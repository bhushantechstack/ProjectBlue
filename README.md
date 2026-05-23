# ProjectBlue
Testing Spring Boot Knowledge 

## 📋 API Endpoints

### 🏠 Home Endpoints

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `GET` | `/` | Welcome message | `200` |

---

### 👥 Customer Management Endpoints

#### 1️⃣ Get All Customers
```http
GET /customers
```
- **Description**: Retrieve all customers from database
- **Status Code**: `200 OK`
- **Response**: List of customers
- **Caching**: Enabled (customerCache)
- **Example**:
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "description": "Customer 1"
    }
  ]
  ```

---

#### 2️⃣ Create New Customer
```http
POST /customer
Content-Type: application/json

{
  "name": "Customer Name",
  "description": "Customer Description"
}
```
- **Description**: Create a new customer record
- **Status Code**: `201 Created`
- **Request Body**: ProjectBlue object
- **Response**: Created customer object

---

#### 3️⃣ Update Customer
```http
PUT /customer/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "description": "Updated Description"
}
```
- **Description**: Update existing customer by ID
- **Path Parameter**: `id` (Long) - Customer ID
- **Status Code**: `200 OK`
- **Caching**: CachePut (updates customerCache)
- **Response**: Success message

---

#### 4️⃣ Delete Customer
```http
DELETE /customer/{id}
```
- **Description**: Delete customer by ID
- **Path Parameter**: `id` (Long) - Customer ID
- **Status Code**: `200 OK`
- **Caching**: CacheEvict (removes from customerCache)
- **Response**: Success message

---

### ⚠️ Exception Handling

#### Test Exception Endpoint
```http
GET /test-exception
```
- **Description**: Triggers a test RuntimeException for testing global exception handling
- **Status Code**: `500 Internal Server Error`
- **Response**: Generic error message
- **Global Exception Handlers**: 
  - `ArithmeticException` - Handled globally
  - `RuntimeException` - Handled globally

---

## � Spring Boot Actuator

### Overview
Spring Boot Actuator provides production-ready features to monitor and manage your application. It exposes operational endpoints over HTTP/JMX to inspect and interact with running applications.

### Configuration
```properties
management.server.port=8081
spring.application.name=projectblue
```
- **Management Port**: `8081` (separate from application port)
- **Isolation**: Health checks and metrics are isolated from main application endpoints

### 📊 Available Actuator Endpoints

| Endpoint | Method | Description | Purpose |
|----------|--------|-------------|---------|
| `/actuator/health` | `GET` | Application health status | Monitor app availability |
| `/actuator/metrics` | `GET` | Metrics information | Performance monitoring |
| `/actuator/env` | `GET` | Environment properties | Configuration review |
| `/actuator/info` | `GET` | Application info | Version and metadata |
| `/actuator/loggers` | `GET` | Logger configuration | Logging management |

### Example Actuator Requests
```http
GET http://localhost:8081/actuator/health
```
**Response**:
```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "H2"
      }
    }
  }
}
```

```http
GET http://localhost:8081/actuator/metrics
```
**Response**:
```json
{
  "names": [
    "jvm.memory.used",
    "jvm.threads.live",
    "http.server.requests",
    "system.cpu.usage"
  ]
}
```

### Benefits
- ✅ **Real-time Monitoring**: Track application health and performance
- ✅ **Diagnostic Insights**: Inspect application state and configuration
- ✅ **Metrics Collection**: Gather performance metrics for analysis
- ✅ **Production Support**: Essential for operational visibility

---

## ⚙️ Profiling Concept

### What is Profiling?
Profiling is the process of analyzing application runtime behavior to identify performance bottlenecks, memory leaks, and CPU usage patterns.

### Types of Profiling

#### 1️⃣ CPU Profiling
```
Purpose: Track which methods consume most CPU time
Focus: Method execution time and frequency
Usage: Identify slow methods and optimization opportunities
```
- **Example Metrics**:
  - Method call count
  - Total execution time
  - Average time per call
  - Call stack analysis

#### 2️⃣ Memory Profiling
```
Purpose: Monitor heap usage and garbage collection
Focus: Object allocation and memory leaks
Usage: Detect memory inefficiencies
```
- **Example Metrics**:
  - Heap memory usage
  - Garbage collection events
  - Object allocation patterns
  - Memory leak detection

#### 3️⃣ Thread Profiling
```
Purpose: Analyze multi-threaded execution
Focus: Thread interactions and deadlocks
Usage: Optimize concurrency
```
- **Example Metrics**:
  - Thread count and state
  - Lock contention
  - Deadlock detection
  - Thread communication patterns

### Profiling Tools for Spring Boot

#### Using Spring Boot Actuator Metrics
```http
GET http://localhost:8081/actuator/metrics/jvm.memory.used
GET http://localhost:8081/actuator/metrics/jvm.threads.live
GET http://localhost:8081/actuator/metrics/http.server.requests
```

#### JVM Profiling Tools
| Tool | Type | Purpose |
|------|------|---------|
| **JProfiler** | GUI | Comprehensive CPU, memory, thread profiling |
| **YourKit** | GUI | Real-time monitoring and profiling |
| **JFR (Java Flight Recorder)** | CLI | Low-overhead profiling |
| **Async Profiler** | CLI | High-performance CPU/memory profiling |

### Profiling Best Practices

✅ **Do's**:
- Profile in production-like environments
- Identify bottlenecks before optimization
- Monitor memory trends over time
- Use low-overhead profilers in production

❌ **Don'ts**:
- Don't profile in development without real data
- Don't ignore garbage collection patterns
- Don't profile without baseline metrics
- Don't use high-overhead profilers in production

### Performance Metrics to Monitor
```
📈 Key Metrics:
├── Response Time (latency)
├── Throughput (requests/sec)
├── Error Rate
├── CPU Usage (%)
├── Memory Usage (heap)
├── Thread Count
├── Database Query Time
└── Cache Hit Ratio
```

### Cache Profiling Example
In this project, caching is implemented for customers:
```
Endpoint: GET /customers
Cache: customerCache (enabled)
Impact: Reduces database queries and improves response time
Monitoring: Use actuator metrics to track cache performance
```

---

## 🛠️ Technologies Used
- Spring Boot (v4.0.6)
- Spring Data JPA
- Spring Actuator (Monitoring & Management)
- Caching (Spring Cache)
- Global Exception Handling
- REST API
- H2 Database
- Java 17

--- 
