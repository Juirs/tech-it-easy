INSERT INTO televisions (type, brand, name, price, available_size, refresh_rate, is_smart_tv, has_wi_fi, has_voice_control, hashdr, has_bluetooth, has_ambi_light, original_stock, sold, sold_date, stock_date, screen_type, screen_quality)
VALUES
('LED', 'Samsung', 'Galaxy TV', 499.99, 55.0, 60, true, true, false, true, true, false, 100, 20, '2025-06-01', '2025-05-01', 'LED', 'HD'),
('OLED', 'LG', 'C1 OLED', 1299.99, 65.0, 120, true, true, true, true, true, true, 50, 10, '2025-06-10', '2025-05-15', 'OLED', 'FOUR_K'),
('QLED', 'Sony', 'Bravia QLED', 899.99, 75.0, 120, true, true, true, true, true, false, 80, 30, '2025-06-12', '2025-05-20', 'LED', 'FOUR_K'),
('LCD', 'Panasonic', 'Viera LCD', 299.99, 40.0, 60, false, false, false, false, false, false, 200, 50, '2025-06-05', '2025-05-10', 'LCD', 'HD'),
('Plasma', 'Philips', 'Ambilight Plasma', 699.99, 50.0, 60, true, true, true, true, false, true, 60, 15, '2025-06-08', '2025-05-12', 'PLASMA', 'FULL_HD');

INSERT INTO users (username, password, enabled, apikey, email) VALUES ('henk', '$2a$12$tJ1OH9MNbJVoMn53ZeDXQeN1vNK/tN0zO530T0dExTY1y6guOoNni', true, '7847493', 'test@testy.tst');
INSERT INTO authorities (username, authority) VALUES ('henk', 'ROLE_ADMIN');