-- INSERT INTO roles(name) VALUES('ROLE_STUDENT');
-- INSERT INTO roles(name) VALUES('ROLE_TEACHER');
-- INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO courses (description, name, points) VALUES ('Fundamental laws and physics', 'Physics', '4');
INSERT INTO courses (description, name, points) VALUES ('Introduction into natural chemistry', 'Chemistry', '2');

-- INSERT INTO teachers (email, first_name, last_name, phone_number, course_id) VALUES ('rob@gmail.com', 'Robbie', 'Smith', '7344645', '1');
-- INSERT INTO teachers (email, first_name, last_name, phone_number, course_id) VALUES ('steven@gmail.com', 'Steven', 'Black', '12351235', '2');

-- insert into students (first_name, last_name, email, phone_number) values ('Bob', 'Blue', 'bob@gmail.com', '14584989');
-- insert into students (first_name, last_name, email, phone_number) values ('Will', 'Black', 'will@gmail.com', '694862977');


-- INSERT INTO studcourses (student_id, course_id) VALUES ('1', '1');
-- INSERT INTO studcourses (student_id, course_id) VALUES ('1', '2');

-- UPDATE courses SET teacher_id = '1' WHERE (course_id = '1');
-- UPDATE courses SET teacher_id = '2' WHERE (course_id = '2');

-- INSERT INTO dates (dow, end_time, start_time) VALUES ('0', '09:30:00', '08:00:00');
-- INSERT INTO dates (dow, end_time, start_time) VALUES ('0', '11:30:00', '10:00:00');


-- INSERT INTO events (venue, course_id, date_id) VALUES ('U-512', '1', '1');
-- INSERT INTO events (venue, course_id, date_id) VALUES ('U-613', '1', '8');
-- INSERT INTO events (venue, course_id, date_id) VALUES ('U-125', '1', '12');
-- INSERT INTO events (venue, course_id, date_id) VALUES ('U-612', '1', '19');

-- UPDATE students SET profile_pic = 'https://content.fakeface.rest/male_22_098d0b0cd98dcf772476e595ab38b4479943ca80.jpg' WHERE (student_id = '1');
-- UPDATE students SET profile_pic = 'https://content.fakeface.rest/male_29_fee11f02e3c508249f689125f684307b21c228de.jpg' WHERE (student_id = '2');

-- UPDATE teachers SET profile_pic = 'https://content.fakeface.rest/male_42_8ad47bcce24893e5120c0b932d68c8ec984749bc.jpg' WHERE (id = '1');
-- UPDATE teachers SET profile_pic = 'https://content.fakeface.rest/male_37_38c42d74e2413ca6f89f981dbac3e6f83afa45b0.jpg' WHERE (id = '2');


-- INSERT INTO users (password, username) VALUES ('$2a$10$.AYBxGl440LYL4.HuFycYO7XAUXRaJT7Fj0YHO5z0z0qUnmk4i5xi', 'admin');
-- INSERT INTO users (password, username) VALUES ('$2a$10$G8wyXmiZ6yvY6tSQaSqq3.lL9zUrLtZGFtkMzvbH085bjyrzM3QnS', 'rob@gmail.com');    --teacher;
-- INSERT INTO users (password, username) VALUES ('$2a$10$G8wyXmiZ6yvY6tSQaSqq3.lL9zUrLtZGFtkMzvbH085bjyrzM3QnS', 'steven@gmail.com'); --teacher;
-- INSERT INTO users (password, username) VALUES ('$2a$10$G8wyXmiZ6yvY6tSQaSqq3.lL9zUrLtZGFtkMzvbH085bjyrzM3QnS', 'bob@gmail.com');  --student;
-- INSERT INTO users (password, username) VALUES ('$2a$10$G8wyXmiZ6yvY6tSQaSqq3.lL9zUrLtZGFtkMzvbH085bjyrzM3QnS', 'will@gmail.com'); --student;

-- UPDATE teachers SET user_id = '2' WHERE (id = '1');
-- UPDATE teachers SET user_id = '3' WHERE (id = '2');

-- UPDATE students SET user_id = '4' WHERE (student_id = '1');
-- UPDATE students SET user_id = '5' WHERE (student_id = '2');

-- INSERT INTO user_roles (user_id, role_id) VALUES ('1', '3');
-- INSERT INTO user_roles (user_id, role_id) VALUES ('2', '2');
-- INSERT INTO user_roles (user_id, role_id) VALUES ('3', '2');
-- INSERT INTO user_roles (user_id, role_id) VALUES ('4', '1');
-- INSERT INTO user_roles (user_id, role_id) VALUES ('5', '1');