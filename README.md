Shopping Cart Management Service

A simple and efficient shopping cart management service that uses modern technologies to deliver performance and scalability.

🔗 Table of Contents
About the Project
Technologies Used
Java 17
Lombok
Redis
MongoDB
OpenFeign
Docker
External API
Features
Screenshots
How to Run the Project
Contributions
License

📖 About the Project

 a service that manages a simple shopping cart, integrating data from an external API to provide available products. It uses an efficient architecture that combines caching (Redis), a NoSQL database (MongoDB), and containers (Docker), ensuring high performance and scalability.

Main Objectives:
Provide a seamless user experience.
Minimize unnecessary calls to the external API through caching.
Facilitate deployment in containerized environments.
🛠 Technologies Used

The project was developed using the following technologies:

Java 17

The latest version of the Java language, focused on performance and enhanced features.

Learn more: Official Java documentation
Lombok

Reduces code verbosity by automating the creation of getters, setters, and constructors.

Learn more: Official Lombok documentation
Redis

An in-memory database used as a cache to improve performance in interactions with the API.

Learn more: Introduction to Redis
MongoDB

A NoSQL database used to store shopping cart information in a flexible way.

Learn more: Official MongoDB documentation
OpenFeign

A library that simplifies integration with external APIs, making communication more intuitive and reducing code verbosity.

Learn more: Official OpenFeign documentation
Docker

A containerization tool for creating consistent and simplified environments for deployment.

Learn more: Official Docker documentation
External API

Integration with an API that provides the list of products available for the shopping cart.

Learn more about API integration: Guide to Working with APIs

✨ Features
List Products: Easily manage the products in the shopping cart.
Create, Edit, Checkout, and Delete: Manage the shopping cart.
Smart Cache: Reduces response time with data stored in Redis.
Persistence with MongoDB: Store cart data securely and flexibly.
External API Integration: Products are loaded directly from a trusted API.
Docker Support: Deploy the project quickly in any environment.
