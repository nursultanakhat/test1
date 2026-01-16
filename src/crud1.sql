INSERT INTO vehicle (model, price, available)
VALUES ('Toyota Camry', 50.0, true);

UPDATE vehicle SET price = 60.0 WHERE id = 1;
DELETE FROM vehicle WHERE id = 2;
SELECT * FROM vehicle;
