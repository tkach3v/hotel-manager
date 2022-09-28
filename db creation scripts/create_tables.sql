DROP TABLE IF EXISTS public.client CASCADE;
DROP TABLE IF EXISTS public.hotel_user CASCADE;
CREATE TABLE public.hotel_user
(
    id serial NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(25) NOT NULL DEFAULT 'USER',
    status character varying(25) NOT NULL DEFAULT 'ACTIVE',
    PRIMARY KEY (id),
    UNIQUE (email)
);

DROP TABLE IF EXISTS public.room CASCADE;
CREATE TABLE public.room
(
    id serial NOT NULL,
    room_number smallint NOT NULL,
    price double precision NOT NULL DEFAULT 0,
    status character varying(20) NOT NULL DEFAULT 'ACTIVE',
    capacity smallint NOT NULL DEFAULT 0,
    rating smallint NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.service CASCADE;
CREATE TABLE public.service
(
    id serial NOT NULL,
    name character varying(100) NOT NULL,
    price double precision NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.reservation CASCADE;
CREATE TABLE public.reservation
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    room_id integer NOT NULL,
    date_start date NOT NULL,
    date_end date NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES public.hotel_user (id)
			ON DELETE CASCADE,
    FOREIGN KEY (room_id)
        REFERENCES public.room (id)
			ON DELETE CASCADE
);

DROP TABLE IF EXISTS public.service_order CASCADE;
CREATE TABLE public.service_order
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    service_id integer NOT NULL,
    date date NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES public.hotel_user (id)
			ON DELETE CASCADE,
    FOREIGN KEY (service_id)
        REFERENCES public.service (id)			
			ON DELETE CASCADE
);