INSERT INTO roles (id, name, description)
VALUES
  (1, 'ROLE_ADMIN', 'admin'),
  (2, 'ROLE_USER', 'user');

INSERT INTO persons (id, first_name, last_name, short_name, email, password, phone, birth_date, city, gender, created)
VALUES
(1, 'Andy', 'Flintstone', 'Andrzeju', 'andy@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '792112567', '1991-01-29', 'Myslowice', 1, '2020-01-01'),
(2, 'Alex', 'Krzem', '', 'alex@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '765454465', '1956-10-19','Myslowice', 1, '2020-01-11'),
(3, 'Мarta', 'Falko', '', 'marta@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '754565465', '1991-07-16', 'Zabrze', 2, '2020-01-08'),
(4, 'Zbigniew', 'Falo', '', 'zibi@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '719999999', '1963-12-08','Zabrze', 1, '2020-01-12'),
(5, 'Daniel', 'Sroka', '', 'daniel@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '740465465', '1995-10-15','Zabrze', 1, '2020-01-02');

INSERT INTO user_roles (person_id, role_id) VALUES
  (1, 1), (1, 2), (2, 2), (3, 2), (5, 2);

INSERT INTO friends (person_id, friend_id) VALUES
  (2, 1), (1, 3), (1, 2), (5, 1), (1, 5),
  (3, 4), (4, 3), (2, 5);

INSERT INTO messages (id, posted, sender_id, recipient_id, body) VALUES
  (1, {ts '2021-07-20 00:00:00.0'}, 1, 5, 'Hello'),
  (2, {ts '2021-07-20 00:00:01.0'}, 5, 1, 'Hi'),
  (3, {ts '2021-07-20 12:02:43.0'}, 1, 5, 'Whats up?'),
  (4, {ts '2021-07-20 12:05:34.0'}, 5, 1, 'Everything ok, and u?'),
  (5, {ts '2021-07-20 12:06:11.0'}, 1, 5, 'Fine, thanks'),
  (6, {ts '2021-07-20 19:03:19.0'}, 5, 1, 'When we go do some sports?'),
  (7, {ts '2021-07-20 19:51:11.0'}, 1, 5, 'Maybe next week?'),
  (8, {ts '2021-07-26 16:49:58.0'}, 1, 5, 'Ok, we will spoke more here in PlayAndSeek'),
  (9, {ts '2021-07-26 15:34:12.0'}, 5, 1, 'This app is great!'),
  (10, {ts '2021-07-27 10:10:35.0'}, 1, 5, 'I agree, bye!'),
  (11, {ts '2021-07-21 15:01:13.0'}, 1, 4, 'Hello Zibi!\nHow''s your family?'),
  (12, {ts '2021-07-04 01:33:47.0'}, 4, 1, 'It''s all right...'),
  (13, {ts '2021-07-26 00:40:52.0'}, 3, 1, 'Hi geek!'),
  (14, {ts '2021-07-26 01:13:42.0'}, 1, 3, 'Hi!'),
  (15, {ts '2021-07-26 01:14:54.0'}, 3, 1, 'How you doin?'),
  (16, {ts '2021-07-26 01:15:19.0'}, 1, 3, 'I''m Ok, and you?\nHow are you getting on?'),
  (17, {ts '2021-07-26 01:15:45.0'}, 3, 1, 'Seems good enougth.\n Maybe we will met next week?'),
  (18, {ts '2021-07-14 14:07:43.0'}, 2, 1, 'Hi can we speak?'),
  (19, {ts '2021-07-14 14:09:30.0'}, 1, 2, 'Yes of course!'),
  (20, {ts '2021-07-14 14:20:08.0'}, 2, 1, 'Please add me for your friend list!');