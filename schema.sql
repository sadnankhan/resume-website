CREATE DATABASE IF NOT EXISTS resume_db;
USE resume_db;

-- Users table
CREATE TABLE IF NOT EXISTS users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  phone VARCHAR(30),
  location VARCHAR(100)
);

-- Resumes table
CREATE TABLE IF NOT EXISTS resumes (
  resume_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  resume_title VARCHAR(255),
  resume_data TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
