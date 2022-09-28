insert into public.hotel_user(id, first_name, last_name, email, password) values (-1, 'Алексей', 'Петров', 'petrov@gmail.com', '$2a$12$BKDdLJGTrsA7L8NRNO4c7engP7zEFLh0jLCD/4V3lcihnCRlXEHuK');
insert into public.hotel_user(id, first_name, last_name, email, password) values (-2, 'Данил', 'Берёзов', 'berezov@gmail.com', '$2a$12$BKDdLJGTrsA7L8NRNO4c7engP7zEFLh0jLCD/4V3lcihnCRlXEHuK');
insert into public.hotel_user(id, first_name, last_name, email, password) values (-3, 'Сергей', 'Вишневский', 'vishnevskiy@gmail.com', '$2a$12$BKDdLJGTrsA7L8NRNO4c7engP7zEFLh0jLCD/4V3lcihnCRlXEHuK');
insert into public.hotel_user(id, first_name, last_name, email, password) values (-4, 'Ирина', 'Михеева', 'miheeva@gmail.com', '$2a$12$BKDdLJGTrsA7L8NRNO4c7engP7zEFLh0jLCD/4V3lcihnCRlXEHuK');
insert into public.hotel_user(id, first_name, last_name, email, password) values (-5, 'Татьяна', 'Яковлева', 'yakovleva@gmail.com', '$2a$12$BKDdLJGTrsA7L8NRNO4c7engP7zEFLh0jLCD/4V3lcihnCRlXEHuK');
insert into public.hotel_user(id, first_name, last_name, email, password) values (-6, 'Pavel', 'Tkachev', 'tkachev@gmail.com', '$2a$12$aW8Ljb.omPfChQz8kk10KO15tq8goJ6KdYgzd2SKXlMPAejYjA.a2');


insert into public.service(id, name, price) values (-1, 'cleaning', 200);
insert into public.service(id, name, price) values (-2, 'cooking', 500);
insert into public.service(id, name, price) values (-3, 'drinks', 1000);
insert into public.service(id, name, price) values (-4, 'haircut', 100);
insert into public.service(id, name, price) values (-5, 'dance', 234);
insert into public.service(id, name, price) values (-6, 'cook meat', 666);
insert into public.service(id, name, price) values (-7, 'drink juice', 888);


insert into public.room(id, room_number, price, status, capacity, rating) values (-1, 123, 100, 'OCCUPIED', 1, 3);
insert into public.room(id, room_number, price, status, capacity, rating) values (-2, 234, 200, 'ACTIVE', 2, 4);
insert into public.room(id, room_number, price, status, capacity, rating) values (-3, 345, 300, 'OCCUPIED', 3, 5);
insert into public.room(id, room_number, price, status, capacity, rating) values (-4, 456, 400, 'OCCUPIED', 4, 3);
insert into public.room(id, room_number, price, status, capacity, rating) values (-5, 567, 1000, 'OCCUPIED', 5, 4);
insert into public.room(id, room_number, price, status, capacity, rating) values (-6, 678, 2000, 'OCCUPIED', 2, 5);
insert into public.room(id, room_number, price, status, capacity, rating) values (-7, 789, 500, 'RENOVATION', 3, 4);
insert into public.room(id, room_number, price, status, capacity, rating) values (-8, 890, 600, 'RENOVATION', 4, 2);
insert into public.room(id, room_number, price, status, capacity, rating) values (-9, 987, 2000, 'ACTIVE', 1, 5);
insert into public.room(id, room_number, price, status, capacity, rating) values (-10, 666, 6666, 'ACTIVE', 1, 5);


insert into public.service_order(user_id, service_id, date) values (-3, -1, '01.02.2020');
insert into public.service_order(user_id, service_id, date) values (-3, -2, '02.04.2020');
insert into public.service_order(user_id, service_id, date) values (-4, -3, '11.06.2020');
insert into public.service_order(user_id, service_id, date) values (-4, -4, '20.08.2021');
insert into public.service_order(user_id, service_id, date) values (-1, -5, '25.09.2021');
insert into public.service_order(user_id, service_id, date) values (-3, -1, '30.10.2021');
insert into public.service_order(user_id, service_id, date) values (-3, -2, '01.01.2022');
insert into public.service_order(user_id, service_id, date) values (-4, -3, '15.03.2022');
insert into public.service_order(user_id, service_id, date) values (-4, -4, '18.07.2022');


insert into public.reservation(user_id, room_id, date_start, date_end) values (-1, -1, '01.02.2017', '10.02.2017');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-1, -2, '05.03.2018', '15.03.2018');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-1, -3, '20.04.2019', '25.04.2019');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-2, -4, '03.05.2020', '13.05.2020');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-2, -3, '04.06.2021', '14.06.2021');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-3, -5, '17.07.2022', '27.07.2022');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-4, -6, '29.08.2023', '30.08.2023');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-5, -1, '05.09.2025', '25.09.2025');
insert into public.reservation(user_id, room_id, date_start, date_end) values (-1, -1, '01.09.2022', '10.10.2022');
