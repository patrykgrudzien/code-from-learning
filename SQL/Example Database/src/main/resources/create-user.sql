# --- SCRIPT THAT CREATES USER --- #
# user-for-examples   -> ID
# examples            -> PASSWORD
CREATE USER 'user-for-examples'@'localhost' IDENTIFIED BY 'examples';

# --- TO ALLOW USER ADD MORE TABLES etc. --- #
GRANT ALL PRIVILEGES ON * . * TO 'user-for-examples'@'localhost';