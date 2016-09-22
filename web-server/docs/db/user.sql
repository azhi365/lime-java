CREATE USER 'testcase'@'%' IDENTIFIED BY 'testcase';
GRANT ALL ON `testcase_db1`.* TO 'testcase'@'%';
GRANT GRANT OPTION ON `testcase_db1`.* TO 'testcase'@'%';
GRANT ALL ON `testcase_db2`.* TO 'testcase'@'%';
GRANT GRANT OPTION ON `testcase_db2`.* TO 'testcase'@'%';
flush privileges;