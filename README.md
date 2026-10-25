# Shelter Starter

## Purpose

This project is a simple sample application for learning basic UI development with Java and Spring Boot. It is intended for coursework, experimentation, and local practice.

## Disclaimer

This repository contains a sample homework project created for an educational course on basic UI development. It is shared for learning purposes, does not represent an official employer product or service, and does not contain proprietary or confidential materials.

## What is already provided

- sample animal data in memory
- service/repository logic for loading and saving animals
- image fallback handling by animal type
- static HTML drafts for the home page, list page, and add-animal page
- an API controller, DTOs and adoption-related support logic

## What you must build

- move the static pages into Thymeleaf templates
- create a page controller for '/', '/animals', and 'animals/new'
- connect the list page to live data with 'th:each'
- bind the form to 'AnimalForm' with 'th:object' and 'th:field'
- submit the form and redirect back to the list

## What to notice

- the repo is starter code, not finished solution
- the in-memory repository resets when the app restarts
- image values can be either a filename or a full URL
- if no image is provided, a fallback image is chosen by animal type

## Bonuses completed

- Inline validation messages below the form inputs (including a blank name)
- Link from the list page to Swagger UI
- Own login page replacing the default Spring Security one
- `@Parameter` for path variables and `@Schema` descriptions on the DTO fields

## Animal Images

The project supports local image files from static resources.

- Add custom animal photos to `src/main/resources/static/images/animals/`
- Store only the filename in the animal field, for example `Luna.jpeg`
- The app resolves that value to `/images/animals/Luna.jpeg`
- A full `http://` or `https://` image URL is also accepted and used as-is (see the seeded Rabbit/Pepper entry for a working example).

If image filename/url is missing, a fallback is selected by animal type:

- CAT -> `/images/fallback/fallback-cat.jpg`
- DOG -> `/images/fallback/fallback-dog.jpg`
- OTHER -> `/images/fallback/fallback-other.jpg`

## Running the app and logging in

1. Run `ShelterApplication` in IntelliJ (or `mvn spring-boot:run`).
2. Open http://localhost:8080. The whole app needs a login, so you are sent to the login page first.
   **Demo login: `hikmat` / `hikmat123`** (set in `application.properties`).
3. Pages: `/`, `/animals`, `/animals/new`.
4. API documentation (Swagger UI): http://localhost:8080/swagger-ui/index.html
   (log in first, in the same browser, so "Try it out" works).
5. The data is kept in memory, so it resets when the app restarts.

## Additional features (beyond Practical Tasks A and B)

- Shared stylesheet and a card-based design for all pages
- Extra form validation (age 0–40, length limits), an error summary box and a success message
- Log out button in the navigation
- Edit and delete pages for animals, with a confirmation step before deleting
- REST `PUT` and `DELETE` endpoints, documented in Swagger UI
- Examples and descriptions on the API parameters and DTO fields

## Notes

- Swagger UI opens at `/swagger-ui/index.html`. The task text mentions `/swaggerui/index.html`, which is a typo and returns 404.