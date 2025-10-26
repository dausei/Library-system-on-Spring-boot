
# Smart Library API

The project is a minimal backend for library management, implemented on Spring Boot. It allows you to register users, add books, and process book checkouts (loans) to users. All data is stored in memory (in-memory repositories) for simplicity.
## Running the Application

This project is built with Spring Boot. To run it, you can use the Maven wrapper:

```bash
./mvnw spring-boot:run
````

If you don't have the Maven wrapper, you can use a local Maven installation:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

-----

## Testing the Endpoints

You can use `curl` or any API client (like Postman) to interact with the endpoints.

### 1\. Create a User

Creates a new user.

**Request:**

```bash
curl -X POST http://localhost:8080/users \
 -H "Content-Type: application/json" \
 -d '{"name":"Alice"}'
```

**Response:**

```json
{"id":1,"name":"Alice"}
```

### 2\. List All Users

Retrieves a list of all registered users.

**Request:**

```bash
curl http://localhost:8080/users
```

**Response:**

```json
[{"id":1,"name":"Alice"}]
```

### 3\. Add a New Book

Adds a new book to the library.

**Request:**

```bash
curl -X POST http://localhost:8080/books \
 -H "Content-Type: application/json" \
 -d '{"title":"Clean Architecture"}'
```

**Response:**

```json
{"id":1,"title":"Clean Architecture","available":true,"borrowerId":null}
```

### 4\. List All Books

Retrieves a list of all books in the library.

**Request:**

```bash
curl http://localhost:8080/books
```

**Response:**

```json
[{"id":1,"title":"Clean Architecture","available":true,"borrowerId":null}]
```

### 5\. Borrow a Book

Marks a specific book as borrowed by a specific user.

**Request:**
(This assumes a book with ID `1` and a user with ID `1` already exist).

```bash
curl -X POST http://localhost:8080/books/1/borrow \
 -H "Content-Type: application/json" \
 -d '{"userId":1}'
```

**Response:**

```json
{"id":1,"title":"Clean Architecture","available":false,"borrowerId":1}
```
