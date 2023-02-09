--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-02-09 12:25:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16463)
-- Name: customer; Type: TABLE; Schema: public; Owner: lgalindop
--

CREATE TABLE public.customer (
    customer_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    second_first_name character varying(25),
    third_first_name character varying(25),
    last_name character varying(25) NOT NULL,
    second_last_name character varying(25),
    customer_phone character varying(10) NOT NULL,
    customer_phone_country_code character varying(3),
    customer_secondary_phone character varying(10),
    customer_secondary_phone_country_code character varying(3),
    street character varying(200),
    address_number character varying(10),
    address_number_interior character varying(10),
    neighborhood character varying(100),
    city character varying(25),
    zip_code character varying(10),
    email_address character varying(50) NOT NULL,
    personal_id_code character varying(25),
    personal_id character varying(25)
);


ALTER TABLE public.customer OWNER TO lgalindop;

--
-- TOC entry 216 (class 1259 OID 16468)
-- Name: customer_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: lgalindop
--

CREATE SEQUENCE public.customer_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_customer_id_seq OWNER TO lgalindop;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 216
-- Name: customer_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lgalindop
--

ALTER SEQUENCE public.customer_customer_id_seq OWNED BY public.customer.customer_id;


--
-- TOC entry 220 (class 1259 OID 16482)
-- Name: customer_order; Type: TABLE; Schema: public; Owner: lgalindop
--

CREATE TABLE public.customer_order (
    order_id integer NOT NULL,
    check_in_date date NOT NULL,
    check_out_date date NOT NULL,
    number_of_adults_in_quote integer NOT NULL,
    number_of_minors_in_quote integer,
    minor_one_age integer,
    minor_two_age integer,
    minor_three_age integer,
    number_of_days integer,
    number_of_nights integer,
    hotel_name character varying(100),
    hotel_price numeric,
    hotel_type character varying(100),
    transport_type character varying(100),
    transport_carrier character varying(100),
    transport_price numeric,
    transport_checkin_date date,
    transport_checout_date date,
    shuttle_service_name character varying(100),
    order_status character varying(25) NOT NULL,
    customer_phone character varying(10) NOT NULL
);


ALTER TABLE public.customer_order OWNER TO lgalindop;

--
-- TOC entry 219 (class 1259 OID 16481)
-- Name: customer_order_order_id_seq; Type: SEQUENCE; Schema: public; Owner: lgalindop
--

CREATE SEQUENCE public.customer_order_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_order_order_id_seq OWNER TO lgalindop;

--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 219
-- Name: customer_order_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lgalindop
--

ALTER SEQUENCE public.customer_order_order_id_seq OWNED BY public.customer_order.order_id;


--
-- TOC entry 217 (class 1259 OID 16469)
-- Name: employee; Type: TABLE; Schema: public; Owner: lgalindop
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    second_first_name character varying(25),
    second_last_name character varying(25),
    employee_phone character varying(10),
    employee_email_address character varying(50)
);


ALTER TABLE public.employee OWNER TO lgalindop;

--
-- TOC entry 218 (class 1259 OID 16472)
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: lgalindop
--

CREATE SEQUENCE public.employee_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_employee_id_seq OWNER TO lgalindop;

--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 218
-- Name: employee_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lgalindop
--

ALTER SEQUENCE public.employee_employee_id_seq OWNED BY public.employee.employee_id;


--
-- TOC entry 222 (class 1259 OID 16508)
-- Name: party; Type: TABLE; Schema: public; Owner: lgalindop
--

CREATE TABLE public.party (
    party_id integer NOT NULL,
    owner_first_name character varying(25),
    owner_last_name character varying(25),
    customer_phone character varying(10) NOT NULL,
    member_first_name character varying(25) NOT NULL,
    member_last_name character varying(25) NOT NULL,
    member_age integer
);


ALTER TABLE public.party OWNER TO lgalindop;

--
-- TOC entry 221 (class 1259 OID 16507)
-- Name: party_party_id_seq; Type: SEQUENCE; Schema: public; Owner: lgalindop
--

CREATE SEQUENCE public.party_party_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.party_party_id_seq OWNER TO lgalindop;

--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 221
-- Name: party_party_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lgalindop
--

ALTER SEQUENCE public.party_party_id_seq OWNED BY public.party.party_id;


--
-- TOC entry 3192 (class 2604 OID 16473)
-- Name: customer customer_id; Type: DEFAULT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer ALTER COLUMN customer_id SET DEFAULT nextval('public.customer_customer_id_seq'::regclass);


--
-- TOC entry 3194 (class 2604 OID 16485)
-- Name: customer_order order_id; Type: DEFAULT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer_order ALTER COLUMN order_id SET DEFAULT nextval('public.customer_order_order_id_seq'::regclass);


--
-- TOC entry 3193 (class 2604 OID 16474)
-- Name: employee employee_id; Type: DEFAULT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.employee ALTER COLUMN employee_id SET DEFAULT nextval('public.employee_employee_id_seq'::regclass);


--
-- TOC entry 3195 (class 2604 OID 16511)
-- Name: party party_id; Type: DEFAULT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.party ALTER COLUMN party_id SET DEFAULT nextval('public.party_party_id_seq'::regclass);


--
-- TOC entry 3197 (class 2606 OID 16476)
-- Name: customer customer_customer_id_key; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_customer_id_key UNIQUE (customer_id);


--
-- TOC entry 3199 (class 2606 OID 16491)
-- Name: customer customer_customer_phone_key; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_customer_phone_key UNIQUE (customer_phone);


--
-- TOC entry 3207 (class 2606 OID 16495)
-- Name: customer_order customer_order_order_id_key; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer_order
    ADD CONSTRAINT customer_order_order_id_key UNIQUE (order_id);


--
-- TOC entry 3209 (class 2606 OID 16489)
-- Name: customer_order customer_order_pkey; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer_order
    ADD CONSTRAINT customer_order_pkey PRIMARY KEY (order_id);


--
-- TOC entry 3201 (class 2606 OID 16478)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_phone);


--
-- TOC entry 3203 (class 2606 OID 16493)
-- Name: employee employee_employee_id_key; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_employee_id_key UNIQUE (employee_id);


--
-- TOC entry 3205 (class 2606 OID 16480)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3211 (class 2606 OID 16513)
-- Name: party party_id; Type: CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.party
    ADD CONSTRAINT party_id PRIMARY KEY (party_id);


--
-- TOC entry 3212 (class 2606 OID 16502)
-- Name: customer_order customer_phone; Type: FK CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.customer_order
    ADD CONSTRAINT customer_phone FOREIGN KEY (customer_phone) REFERENCES public.customer(customer_phone);


--
-- TOC entry 3213 (class 2606 OID 16514)
-- Name: party customer_phone; Type: FK CONSTRAINT; Schema: public; Owner: lgalindop
--

ALTER TABLE ONLY public.party
    ADD CONSTRAINT customer_phone FOREIGN KEY (customer_phone) REFERENCES public.customer(customer_phone);