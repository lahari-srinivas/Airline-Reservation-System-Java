# ✈️ Airline Reservation System (Java Swing)

A desktop-based **Airline Reservation System** developed using **Java Swing** that allows users to search for flights using the **AviationStack API** and book flights through an intuitive graphical interface.

This project demonstrates Object-Oriented Programming (OOP), REST API integration, JSON parsing, and Java Swing GUI development.

---

## 📌 Features

- 🔍 Search flights using source and destination airport IATA codes
- 🌐 Fetch live flight data from the AviationStack API
- 📋 Display available flights in a table
- 🎫 Book a selected flight
- 👤 Enter passenger details during booking
- 🖥️ User-friendly Java Swing interface
- 📦 Modular object-oriented design

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Gson (JSON Parsing)
- AviationStack REST API
- HTTPURLConnection
- Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```
Airline-Reservation-System-Java/
│
├── AirlineSwing.java        # Main GUI
├── APIClient.java           # Handles API communication
├── BookingWindow.java       # Booking interface
├── BookingUI.java           # Additional booking UI
├── Flight.java              # Flight model
├── Passenger.java           # Passenger model
├── reservationsystem.java   # Reservation logic
├── gson-2.13.2.jar          # Gson library
└── README.md
```

---

## 🏗️ System Architecture

```
                +----------------------+
                |     Java Swing GUI   |
                |   (AirlineSwing)     |
                +----------+-----------+
                           |
                           |
                           ▼
                +----------------------+
                |     APIClient        |
                | HTTP + JSON Parsing  |
                +----------+-----------+
                           |
                           ▼
              AviationStack REST API
                           |
                           ▼
                +----------------------+
                |   Flight Objects     |
                +----------+-----------+
                           |
                           ▼
                +----------------------+
                |  Booking Window      |
                +----------+-----------+
                           |
                           ▼
                Reservation System
```

---

## 🚀 How It Works

1. Launch the application.
2. Enter the **Departure Airport IATA Code**.
3. Enter the **Arrival Airport IATA Code**.
4. Click **Search Flights**.
5. The application sends a request to the AviationStack API.
6. Available flights are displayed in a table.
7. Select a flight.
8. Enter passenger information.
9. Confirm the booking.

---

## 📸 Screenshots

> Add screenshots here after uploading them.

### Home Screen

```
Insert Screenshot Here
```

### Flight Search

```
Insert Screenshot Here
```

### Booking Window

```
Insert Screenshot Here
```

---

## ⚙️ Installation

### Clone the repository

```bash
git clone https://github.com/lahari-srinivas/Airline-Reservation-System-Java.git
```

### Open the project

Import the project into your preferred Java IDE:

- Eclipse
- IntelliJ IDEA
- VS Code

### Add Gson Library

Ensure `gson-2.13.2.jar` is added to the project's build path.

### Configure API Key

Open:

```
APIClient.java
```

Replace the API key with your own AviationStack API key.

---

## ▶️ Running the Project

Compile and run:

```
AirlineSwing.java
```

The application window will open, allowing you to search and book flights.

---

## 📖 Object-Oriented Design

### Classes

| Class | Responsibility |
|--------|----------------|
| AirlineSwing | Main graphical interface |
| APIClient | Retrieves flight data from AviationStack |
| Flight | Represents flight information |
| Passenger | Stores passenger details |
| BookingWindow | Flight booking interface |
| BookingUI | Booking management UI |
| reservationsystem | Handles reservation logic |

---

## 🔮 Future Enhancements

- Database integration (MySQL)
- User authentication
- Ticket cancellation
- Payment gateway integration
- Admin dashboard
- Seat selection
- Booking history
- PDF ticket generation
- Email confirmation
- Flight filtering and sorting

---

## 📚 Learning Outcomes

This project helped demonstrate:

- Java Swing GUI Development
- REST API Integration
- JSON Parsing using Gson
- HTTP Communication
- Object-Oriented Programming
- Modular Software Design
- Event Handling
- Exception Handling

---

## 👩‍💻 Author

**Lahari Srinivas**

GitHub:
https://github.com/lahari-srinivas

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!

---

## 📄 License

This project is intended for educational purposes.
