--@Id
--@GeneratedValue
--private Long id;
--private String employeeCode;
--private String name;
--private String email;
--@OneToOne
--private Role role;



DROP TABLE IF EXISTS WORKFORCE;

CREATE TABLE WORKFORCE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  employeeCode VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  role INT DEFAULT NULL
);
