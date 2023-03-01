DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS collaborator;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS task;


CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50) NOT NULL,
    contact  VARCHAR(16) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    password VARCHAR(40) NOT NULL
);

CREATE TABLE project
(
    owner      integer     NOT NULL references users (id) on delete cascade,
    id         serial PRIMARY KEY,
    title      VARCHAR(40) NOT NULL,
    start_date TIMESTAMP   NOT NULL,
    end_date   TIMESTAMP   NOT NULL
);

CREATE TABLE role
(
    id   serial PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);


CREATE TABLE collaborator
(
    id         INTEGER PRIMARY KEY NOT NULL,
    project_id INTEGER             NOT NULL references project (id) on delete cascade,
    user_id    integer             NOT NULL references users (id) on delete cascade,
    role_id    INTEGER             NOT NULL references role (id)
);


CREATE TABLE task
(
    id          serial PRIMARY KEY,
    user_id     integer references users (id),
    project_id  integer      NOT NULL references project (id) on delete cascade,
    description VARCHAR(255) NOT NULL,
    start_date  TIMESTAMP    NOT NULL,
    end_date    TIMESTAMP    NOT NULL,
    super_id    INTEGER references task (id),
    status      INTEGER      NOT NULL DEFAULT 0,
    task_order  INTEGER      NOT NULL
);