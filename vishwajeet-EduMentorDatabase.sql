create database EduMentorDatabase;
use EduMentorDatabase;

create table student(
student_id int auto_increment primary key,
name varchar(100) not null,
email varchar(100) unique not null,
password varchar(100),
grade_level varchar(50),
registration_date timestamp default current_timestamp
);
 create table subjects(
 subject_id int auto_increment primary key,
 subject_name varchar(100) not null
 );

create table grades (
grade_id int auto_increment primary key,
subject_id int,
student_id int,
score decimal(5,2),
assessment_date date,
foreign key(student_id) references student(student_id),
foreign key(subject_id) references subjects(subject_id)
);
 
 create table mentorship_requests(
 request_id int auto_increment primary key,
 student_id int,
 mentor_name varchar(100),
 topic varchar(100),
 status enum('Pending','Approved','Resolved') default 'Pending',
 request_date timestamp default current_timestamp,
 foreign key(student_id)references student(student_id)
 );
 
 create table feedback (
 feedback_id int auto_increment primary key,
 student_id int,
 feedback_text text,
 suggestion_link varchar(255),
 create_at timestamp default current_timestamp,
 foreign key(student_id)references student(student_id)
 );
 
 create table badges(
 badge_id int auto_increment primary key,
  badge_name varchar(100),
  description text
 );
 
  create table student_badges(
 student_id int,
 badge_id int,
 awarded_on timestamp default current_timestamp,
 primary key (student_id, badge_id),
 foreign key(student_id)references student(student_id),
  foreign key(badge_id)references badges(badge_id)
 );


