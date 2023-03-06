drop owned by manager;

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50) NOT NULL,
    contact  VARCHAR(16) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    password VARCHAR(40) NOT NULL
);

create table users_token
(
    token           varchar(40) primary key,
    expiration_date timestamp not null,
    validity        boolean   not null default true,
    user_id         integer   not null references users (id)
);

CREATE TABLE project
(
    owner_id      integer     NOT NULL references users (id) on delete cascade,
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
    role_id    INTEGER             NOT NULL references role (id),
    status     integer default 0
);
CREATE TABLE task
(
    id          serial PRIMARY KEY,
    user_id     integer references users (id),
    project_id  integer      NOT NULL references project (id) on delete cascade,
    description VARCHAR(255) NOT NULL,
    start_date  TIMESTAMP    NOT NULL,
    end_date    TIMESTAMP    NOT NULL,
    supere_id    INTEGER references task (id),
    status      INTEGER      NOT NULL DEFAULT 0,
    task_order  INTEGER      NOT NULL
);