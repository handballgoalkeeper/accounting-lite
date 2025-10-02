BEGIN;
    ALTER TABLE associates
    ADD CONSTRAINT fk_associate_type
    FOREIGN KEY (associate_type_id)
    REFERENCES associate_types(id);
COMMIT;