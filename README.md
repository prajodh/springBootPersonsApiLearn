# Legacy API Modernization with Spring Boot

This project modernizes a legacy system by converting outdated CRUD APIs into modern, maintainable Spring Boot RESTful services. It implements the MVC architecture pattern and includes interactive API documentation using Swagger UI. The backend originally relied on a relational database (SQL), and was later migrated to a NoSQL model using Azure Cosmos DB, guided through AI-assisted prompt engineering.

---

## ✨ Features

- ✅ Modern Spring Boot RESTful API implementation  
- 🔄 Full CRUD operations for `Person` entities  
- 🗂️ Follows MVC (Model-View-Controller) architecture  
- 🌐 Interactive API documentation via Swagger UI  
- 🔁 Database layer migration:  
  - From: Traditional SQL (e.g., MySQL/PostgreSQL)  
  - To: Azure Cosmos DB (NoSQL)  
- 🤖 AI-generated migration prompts for SQL to NoSQL transformation  
- 🚀 **Automated CI/CD pipeline using GitHub Actions to build Docker images**, push them to **Azure Container Registry (ACR)**, and deploy to **Azure Kubernetes Service (AKS)** for scalable cloud-native deployment  

---

## 📦 Tech Stack

- **Framework:** Spring Boot 3.x  
- **Architecture:** MVC  
- **API Documentation:** Swagger UI (Springfox/OpenAPI)  
- **Database (Initial):** SQL (MySQL/PostgreSQL)  
- **Database (Final):** Azure Cosmos DB (NoSQL)  
- **CI/CD:** GitHub Actions, Azure Container Registry (ACR), Azure Kubernetes Service (AKS)  
- **Build Tool:** Maven/Gradle  
- **Language:** Java 17+  

---

