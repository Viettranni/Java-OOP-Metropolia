DROP DATABASE IF EXISTS currency_db;
CREATE DATABASE currency_db;
USE currency_db;

-- Create the table to store Currency objects
CREATE TABLE currencies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    currency_code VARCHAR(10) NOT NULL,
    currency_name VARCHAR(50) NOT NULL,
    exchange_rate DECIMAL(10, 4) NOT NULL
);

-- Populate the table with some example currencies and their exchange rates
INSERT INTO currencies (currency_code, currency_name, exchange_rate) VALUES
('USD', 'United States Dollar', 1.0000),
('EUR', 'Euro', 0.9312),
('GBP', 'British Pound', 0.8104),
('JPY', 'Japanese Yen', 146.80),
('AUD', 'Australian Dollar', 1.5202),
('CAD', 'Canadian Dollar', 1.3765),
('CHF', 'Swiss Franc', 0.9251),
('CNY', 'Chinese Yuan', 7.2718);

-- Drop the user account 'appuser' if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- Create the 'appuser' account with a secure password
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'moi';

-- Grant appropriate privileges to 'appuser'
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_db.currencies TO 'appuser'@'localhost';

-- Flush privileges to apply the changes
FLUSH PRIVILEGES;
