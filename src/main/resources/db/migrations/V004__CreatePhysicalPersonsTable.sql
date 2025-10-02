BEGIN;
    CREATE TABLE IF NOT EXISTS physical_associates (
        associate_id BIGINT UNSIGNED UNIQUE,
        first_name VARCHAR(100),
        last_name VARCHAR(100),
        jmbg VARCHAR(20),
        date_of_birth DATE,
        created_at TIMESTAMP DEFAULT NOW(),
        updated_at TIMESTAMP DEFAULT NOW()
    );

    ALTER TABLE physical_associates ADD CONSTRAINT fk_associate_id FOREIGN KEY (associate_id) REFERENCES associates(id);
COMMIT;