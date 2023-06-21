# Hotel and Management

## Domain Description
A hotel is an establishment that provides temporary accommodation for visitors. Hotel management includes information about rooms, bookings, clients, and services.

## Object Composition
1. **Hotel**
    - Properties:
        - Hotel name
        - Hotel address
        - Number of rooms
        - Hotel rating
        - Phone number

2. **Room**
    - Properties:
        - Room number
        - Bed count
        - Room type (single, double, etc.)
        - Room price
        - Availability (occupied or vacant)

3. **Client**
    - Properties:
        - Client's first name
        - Client's last name
        - Client's phone number
        - Client's email
        - Client's country of residence

4. **Booking**
    - Properties:
        - Start date of the booking
        - End date of the booking
        - Booking status (active, completed, etc.)
        - Number of guests
        - Additional requirements

5. **Service**
    - Properties:
        - Service name
        - Service price
        - Availability of the service
        - Service description
        - Service category (e.g., food, transportation)

6. **Hotel Service** (additional entity for maintaining one-to-many relationships)
    - Properties:
        - Hotel (reference to a hotel)
        - Service (reference to a service)

## Relationships between Objects
- A hotel contains multiple rooms.
- Each room belongs to a specific hotel.
- Each booking is associated with one client and one room.
- Each client can have multiple bookings.
- A hotel can have multiple services, and each service can be offered in multiple hotels. To establish a one-to-many relationship, an additional entity called Hotel Service is used.

## Dependencies

To build and run this application, you need to have the following dependencies installed:

- Java Development Kit (JDK) 17 or higher
- Apache Maven
- MySQL 8
- Postman

## Database Setup

1. Create a new database in MySQL named `hotel_management`.

2. Import the database schema by executing the SQL script `src/main/resources/db/database.sql` using a tool like MySQL Workbench.

3. Update the database connection configuration in the `application.properties` file located in the `src/main/resources` directory. Use the following settings:
    ```
   spring.datasource.url=jdbc:mysql://localhost:3306/hotel_management
   spring.datasource.username=root
   spring.datasource.password=root`
   ```
4. Modify the username and password if necessary.

## Postman Collection

The Postman collection for this application is available in JSON format at `src/main/resources/postman/hotel_management.postman_collection.json`. You can import this collection into Postman to access and test the API endpoints.

## Building and Running the Application

Follow the steps below to set up and run the application:

1. Clone the repository:

```shell
git clone https://github.com/your-username/hotel-management.git
```

2. Navigate to the project directory:
```shell
cd hotel-management
```
3. Build the application using Maven:
```shell
mvn clean install
```
4. Run the application:
```shell
mvn spring-boot:run
```

The application will start running on http://localhost:8080.


