BEGIN;
    CREATE TABLE associates (
        id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        display_name VARCHAR(255) NOT NULL,
        tax_id VARCHAR(20) UNIQUE,
        email VARCHAR(255),
        phone VARCHAR(50),
        address TEXT,
        city VARCHAR(100),
        state VARCHAR(100),
        postal_code VARCHAR(20),
        country VARCHAR(100),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    CREATE INDEX idx_associates_name ON associates(display_name);
    CREATE INDEX idx_associates_email ON associates(email);
    CREATE INDEX idx_associates_city ON associates(city);
COMMIT;