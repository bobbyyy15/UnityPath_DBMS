# **UNITYPATH: Volunteer Matching System**

![image](https://github.com/user-attachments/assets/1c7cbf45-bc55-4022-b688-0615844d2f82)


## **📚 Title and Purpose**
**UNITYPATH** is a platform designed to connect volunteers with organizations working toward social good. The system facilitates the matching of volunteers to opportunities based on their skills, availability, and interests, allowing for more efficient collaboration and fostering unity in the community.

---
![Screenshot 2024-12-12 225528](https://github.com/user-attachments/assets/11f19d23-120d-4783-8670-6766e38e4982)

# Table of Contents
- [Project Title and Purpose](#project-title-and-purpose)
- [Objective and Key Features](#objective-and-key-features)
- [Core Classes](#core-classes)
  - [Opportunity](#opportunity)
  - [Organization](#organization)
  - [Volunteer](#volunteer)
  - [User](#user)
  - [TestConnection](#testconnection)
- [Core Principles of OOP](#core-principles-of-oop)
  - [Encapsulation](#encapsulation)
  - [Inheritance](#inheritance)
  - [Polymorphism](#polymorphism)
  - [Abstraction](#abstraction)
- [SDG Alignment](#sdg-alignment)
- [Benefits](#benefits)
- [How to Use](#how-to-use)
- [Feature Enhancements](#feature-enhancements)
- [Setup Instructions](#setup-instructions)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Tech Used](#tech-used)
- [About the Developer](#about-the-developer)

---
![image](https://github.com/user-attachments/assets/234bfb6d-7142-4076-ae49-2129c6258fbc)


## **🎯 Objective**
The objective of **UNITYPATH** is to create a seamless volunteer matching platform that:
- Bridges the gap between organizations in need of volunteers and individuals who want to contribute.
- Enables efficient management of opportunities and volunteers.
- Promotes social change by supporting humanitarian, environmental, and community-building initiatives.

---

![image](https://github.com/user-attachments/assets/42a7cbac-2bc7-40ec-80ff-2a86500c8982)

## **🛠 Key Features**
- **Volunteer Registration & Login:** Volunteers can register and create profiles with their skills and interests, allowing for easy application to suitable opportunities.
- **Organization Registration & Login:** Organizations can post opportunities, review applications, and manage volunteer participation.
- **Opportunity Management:** Volunteers can view, apply, and track opportunities based on their availability.
- **Clear, User-Friendly Interface:** The system is designed with an easy-to-navigate UI that simplifies the interaction between volunteers and organizations.
- **Exit Handling:** The system includes clear exit options that allow users to cancel actions easily.

---

![image](https://github.com/user-attachments/assets/1a1ef512-11c7-4391-8a1c-d8ca037a2619)

## **📦 Core Classes**
- **`Volunteer`:** This class represents a volunteer with attributes like `id`, `name`, `password`, and `skills`. It extends the abstract class `User` and provides the `viewOpportunities()` method for displaying available opportunities.
- **`Organization`:** Represents an organization that can post volunteer opportunities. Includes methods for managing organizations and interacting with the volunteer database.
- **`Opportunity`:** Represents a volunteer opportunity with fields like `title`, `requiredSkills`, `location`, and dates. This class manages the details of each opportunity.
- **`User (Abstract)`:** This base class holds common attributes like `id`, `name`, and `email` for both volunteers and organizations. It defines the abstract method `viewOpportunities()` to be implemented by subclasses.
- **`TestConnection`:** A utility class used to test the connection to a MySQL database, ensuring the system can interact with a database properly.
- **`DesignUtils`:** A utility class for formatting output, clearing the screen, and printing styled headers and messages, helping improve user interaction.

---

![image](https://github.com/user-attachments/assets/14751afd-4857-41d4-a5d9-152f2b3ecbbc)

## **🧑‍💻 Core Principles of OOP**
The system follows key **Object-Oriented Programming** principles, such as:

1. **Encapsulation:** 
   - Each class has its own attributes and methods, ensuring the internal workings of each object are hidden and only relevant data is exposed.
   - Example: The `Volunteer` class encapsulates details like `name` and `skills`, while the `Opportunity` class encapsulates opportunity-specific details.

2. **Inheritance:**
   - The `User` class is an abstract base class that defines common properties like `id`, `name`, and `email`. Both `Volunteer` and `Organization` classes inherit from `User`, making the system extensible for future types of users.

3. **Polymorphism:**
   - The abstract method `viewOpportunities()` in the `User` class allows different subclasses (e.g., `Volunteer`, `Organization`) to provide their specific implementations of how opportunities are viewed.

4. **Abstraction:**
   - Complex logic, such as database connections or console clearing, is abstracted into utility methods like those in the `DesignUtils` and `TestConnection` classes, simplifying the user-facing functionality.

---

![image](https://github.com/user-attachments/assets/a7339ca8-0626-4189-a55b-388772881282)


## **🌍 SDG Alignment**
**UNITYPATH** aligns with the following **Sustainable Development Goals (SDGs):**

- **SDG 10: Reduced Inequality**  
   By connecting volunteers to community organizations, the platform helps in reducing inequality by fostering inclusion and support for marginalized groups.

- **SDG 17: Partnerships for the Goals**  
   The platform serves as a catalyst for partnerships by linking volunteers to organizations, fostering cooperation to achieve common goals.

---

![image](https://github.com/user-attachments/assets/088ad1bf-da45-40fe-b2f5-d3487eb268de)

## **🌟 Benefits**
### **For Volunteers:**
- Find opportunities that match their skills and interests.
- Contribute meaningfully to causes they care about.
- Track and manage volunteer activities with ease.

### **For Organizations:**
- Manage volunteer applications efficiently.
- Access a pool of skilled volunteers who can contribute to various projects.
- Simplify the process of posting and managing opportunities.

### **For Communities:**
- Communities benefit from efficient matching of volunteers, helping organizations meet their needs and deliver services faster.

---

![image](https://github.com/user-attachments/assets/85c7d9ac-3120-4e59-8bda-7b571e623656)


## **💻 How to Use**
1. **Clone the repository:**
   - Download or clone this repository to your local machine.

2. **Set up your database:**
   - Ensure that you have MySQL set up on your local or remote server.
   - Create a database and configure the connection in the `TestConnection` class to ensure the system can interact with it.

3. **Run the application:**
   - Execute the `Main` class in your IDE or from the command line. This will start the application, and you can navigate through the menu to create organizations, view opportunities, and register as a volunteer.

4. **Interact with the menu:**
   - Follow the prompts in the terminal to create and manage organizations, sign up as a volunteer, and apply for opportunities.
  
5. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/volunteer-matching-system.git

6. **Install Dependencies:**

   ```bash
   mvn install

7. **Run the Application:**

    ```bash
    mvn exec:java

8. **Follow The Prompts**

---

![image](https://github.com/user-attachments/assets/86e26e2a-e94f-479c-b359-d532e752924e)

## **⚙ Feature Enhancements**

- **Social Media Integration:**  
   Allow volunteers to share opportunities and their experiences on social media, increasing engagement.

- **Advanced Search Filters:**  
   Improve the search functionality to allow filtering by multiple criteria (e.g., date range, specific skills, etc.).

- **Notification System:**  
   Implement notifications to alert volunteers about new opportunities, upcoming events, or status updates.

- **Rating System for Volunteers:**  
   Add a rating system for volunteers, where organizations can rate their performance and provide feedback.

- **Mobile App Version:**  
   Develop a mobile version of the platform for increased accessibility and reach.
---
![image](https://github.com/user-attachments/assets/1e9b2e47-08c1-4b27-bc81-8629d92b8c67)

## **Tech Used**

- **Java:**
  The core programming language for the project.
  
- **MySQL:**
   A relational database management system for storing user and opportunity data.

- **JDBC (Java Database Connectivity:**
   For connecting to the MySQL database.

---
![image](https://github.com/user-attachments/assets/5db1da3d-903a-4d0d-9399-65a2afb9be04)

## **About the Devoloper**
 Hey there! I’m Ken Patrick Joshua N. Gaa, the sole developer behind UNITYPATH. UNITYPATH was created as part of my Object-Oriented Programming (OOP) final project, where I was tasked with building a console application that follows OOP principles and aligns with Sustainable Development Goals (SDGs). This project has been both a rewarding and challenging experience, as it not only helped me with my academic goals but also has the potential to make a positive impact on the community.

I designed UNITYPATH to facilitate volunteer matching, making it easier for individuals to connect with organizations in need of help. Although the system currently contains the basic features I envisioned, I’m excited about continuing to develop and expand it. Reaching this point in the project reflects my commitment to seeing it through to completion.

Developing UNITYPATH has taught me many valuable lessons, from managing databases to working through complex logic. Every step has been a learning experience, and at times, it has tested my patience. But through it all, it has helped me refine my skills and think critically about creating a platform that truly serves its users.

Thank you for taking the time to explore my project! This is more than just an academic requirement—it represents a step forward in my journey as a developer, and I look forward to building upon it. I’m excited to see where my growth in software development and community service will take me in the future.

Best regards,
Ken Patrick Joshua N. Gaa
---

- *Name*: [Ken Patrick Joshua N, Gaa]
- *Github*: [github.com/bobbyyy15](https://github.com/bobbyyy15)
- *Email*: 23-08002@g.bastate-u.edu.ph
