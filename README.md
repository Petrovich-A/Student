<div align="center">
  <h1>Student application</h1>
<!-- Badges -->
<p>
  <a>
<img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/Petrovich-A/Student/develop?style=for-the-badge">
  </a>
<a>
<img alt="GitHub commit activity (branch)" src="https://img.shields.io/github/commit-activity/m/Petrovich-A/Student/develop?style=for-the-badge">
</a>
<a>
<img alt="GitHub pull requests" src="https://img.shields.io/github/issues-pr/Petrovich-A/Student?style=for-the-badge">
</a>
</p>
</div>

<br />

<!-- Table of Contents -->

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
    * [Screenshots](#camera-screenshots)
    * [Tech Stack](#space_invader-tech-stack)
    * [Features](#dart-features)
    * [Run Locally](#running-run-locally)
    * [Database structure](#key-database-structure)
- [Have to fix](#compass-have-to-fix)
- [Contact](#handshake-contact)
- [Acknowledgements](#gem-acknowledgements)

<!-- About the Project -->

## :star2: About the Project

<!-- Screenshots -->

The main task of this project is to display on `JSP` a group data from database using plain `JDBC` and the `PostgreSQL`
database.
Was created two tables: cities and students with `1:M` relationship between two entities respectively. The application
allows
to generate a list of all students and cities. Moreover, can be displayed a resulting table using SQL queries to
database.

The application is able to provide all `CRUD` methods related to each entity in table. Thus, operations such as adding
new cities,
new students, deleting students, and deleting cities are available to the user. Some code coverded with unit tests.

The ultimate goal is to develop a fully functioning and reliable web application with the desired capabilities for both
the primary task and the secondary task.

### :camera: Screenshots

<div align="center"> 
<img src="https://github.com/Petrovich-A/Student/blob/develop/main_page.png" alt="Alt text" title="Optional title">
</div>

<!-- TechStack -->

### :space_invader: Tech Stack

<details>
  <summary>Show</summary>
  <ul>
    <li><a>Java 1.8.0_282</a></li>
    <li><a>Apache Tomcat 9.0.73 </a></li>
    <li><a>Maven 3.8.1</a></li>
    <li><a>PostgreSQL 15.1</a></li>
    <li><a>Project Lombok 1.18.24</a></li>
  </ul>
</details>

<!-- Features -->

### :dart: Features

- CRUD methods for student entity
- CRUD methods for city entity
- show resulting 1:M relationship table

<!-- Run Locally -->
### :running: Run Locally

Clone the project

```bash
  git clone https://github.com/Petrovich-A/Student.git
```

Go to the project directory and `run` this [script](https://github.com/Petrovich-A/Student/blob/develop/src/main/resources/scripts/create_and_populate_tables)
to populate the database tables.

<!-- Database struct -->
### :key: Database structure

cities:
```SQL
city_id SERIAL,
name    text NOT NULL,
PRIMARY KEY (city_id),
UNIQUE (name);
```
students:
```SQL
student_id SERIAL,
first_name VARCHAR(40) NOT NULL,
last_name  VARCHAR(40) NOT NULL,
city_id    int         NOT NULL,
PRIMARY KEY (student_id),
FOREIGN KEY (student_id) REFERENCES students (student_id),
FOREIGN KEY (city_id) REFERENCES cities (city_id);
```

<!-- Roadmap -->

## :compass: Have to fix:

* [x] to add the lombok
* [ ] to add an error page
* [ ] to add checking is entity exists
* [ ] opportunity to delete city which associated with student

## :handshake: Contact

Petrovich Alexandr - [@Petrovich Alexandr](https://www.linkedin.com/in/alexandr-petrovich/) - a.piatrovich@gmail.com

<!-- Acknowledgments -->

## :gem: Acknowledgements

Use this section to mention useful resources and libraries that you have used in your projects.

- [Shields.io](https://shields.io/)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md#travel--places)
- [Readme Template](https://github.com/othneildrew/Best-README-Template)