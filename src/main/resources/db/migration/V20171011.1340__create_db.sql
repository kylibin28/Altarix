drop table if exists departments;

CREATE TABLE departments
(
  id_department integer NOT NULL,
  name_main_department character varying(255),
  creation_date date NOT NULL,
  departament_name character varying(100) NOT NULL,
  employee integer,
  CONSTRAINT departments_pkey PRIMARY KEY (id_department),
  CONSTRAINT fkmno2o63yg7v9swvbx4fhuj1 FOREIGN KEY (employee)
      REFERENCES employees (id_employee) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_fhu4bbjxhhs96ju7hprdpbsxr UNIQUE (departament_name)
)

CREATE TABLE employees
(
  id_employee integer NOT NULL,
  admition_date timestamp without time zone NOT NULL,
  birthday timestamp without time zone NOT NULL,
  chief boolean NOT NULL,
  dismissal_date timestamp without time zone,
  name character varying(50) NOT NULL,
  patronymic character varying(50),
  post character varying(50) NOT NULL,
  salary integer NOT NULL,
  sex character varying(10) NOT NULL,
  surname character varying(50) NOT NULL,
  departament_name integer,
  CONSTRAINT employees_pkey PRIMARY KEY (id_employee),
  CONSTRAINT fk48a3xuns4tlu9hxkd0yxvbetr FOREIGN KEY (departament_name)
      REFERENCES departments (id_department) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)