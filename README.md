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

## 🛠️ Technologies Used
- Spring Boot
- Spring Data JPA
- Caching (Spring Cache)
- Global Exception Handling
- REST API

--- 
