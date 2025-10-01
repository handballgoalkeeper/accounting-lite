BEGIN;
    CREATE TABLE IF NOT EXISTS associate_types (
        id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(64) UNIQUE NOT NULL,
        description VARCHAR(254),
        created_at TIMESTAMP NOT NULL DEFAULT NOW(),
        updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

    INSERT INTO associate_types (
        name
    )
    VALUES
    ('Physical person'),
    ('Legal entity');
COMMIT;