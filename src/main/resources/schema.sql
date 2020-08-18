-----------------WORKFORCE----------------
--public class Workforce {
--@Id
--@GeneratedValue
--private Long id;
--private String name;
--private String email;
--@OneToOne
--private UserProfile userProfile;



DROP TABLE IF EXISTS WORKFORCE;

CREATE TABLE WORKFORCE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  userProfile INT DEFAULT NULL
);
