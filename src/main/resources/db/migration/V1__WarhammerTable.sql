CREATE TABLE faction (
    faction_id SERIAL NOT NULL PRIMARY KEY,
    faction_name VARCHAR(75) NOT NULL
);

CREATE TABLE army (
    army_id SERIAL NOT NULL PRIMARY KEY,
    faction_id INTEGER NOT NULL,
    army_name VARCHAR(100) NOT NULL,
    FOREIGN KEY(faction_id) REFERENCES faction(faction_id)
);

CREATE TABLE unit (
    unit_id SERIAL NOT NULL PRIMARY KEY,
    army_id INTEGER NOT NULL,
    unit_name VARCHAR(100),
    FOREIGN KEY (army_id) REFERENCES army(army_id)
);