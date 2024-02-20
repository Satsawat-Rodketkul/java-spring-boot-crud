# Basic CRUD with java spring boot
This project was created to get started on How to create read update and delete data from database Postgres.

## How to start
1. Create database in docker following this step [**PostgreSQL in docker**].
2. Create table person with
```
create table public.person (
	id SERIAL PRIMARY KEY,
	firstname VARCHAR (100) UNIQUE NOT NULL,
	lastname VARCHAR (100) UNIQUE NOT NULL,
	create_date TIMESTAMP NOT null,
	update_date TIMESTAMP
);
```
3. Start this project.

## Reference
**PostgreSQL in docker:** `https://www.commandprompt.com/education/how-to-create-a-postgresql-database-in-docker/`
