# copilot-training

## Description

This mono repository resembles a simple full stack application to demonstrate the use of GitHub Copilot while developing.

The Application stores and displays profiles of cats.

## Tech Stack

- Frontend - Angular
- Persistence - Postgre SQL
- Backend - JAVA (Spring)

## Frontend Setup

The frontend of the application is built using Angular. It includes components for displaying cat profiles and a navigation bar.

### Directory Structure

- `src/app`: Contains the main application components.
  - `components/cat-profile`: Contains the CatProfileComponent for displaying individual cat profiles.
  - `components/navbar`: Contains the NavbarComponent for navigation.
- `src/assets`: Directory for static assets like images and fonts.
- `src/environments`: Contains environment-specific settings for development and production.

### Running the Frontend

To run the frontend application, navigate to the `frontend` directory and use the following command:

```bash
ng serve
```

This will start the development server and you can access the application at `http://localhost:4200`.