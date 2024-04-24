--insert into doctor table
INSERT INTO doctor (career_start_year, date_of_birth, price, bio, email, first_name, last_name, password, phone_number) VALUES
                                                                                                                            ('2020', '1998-02-18', 335.06, 'VryPYoqfzkPQJpGiXxzg', 'zYqsh@example.com', 'hpaOo', 'ehfKl', 'hSFdOykfuV', '+14716543071'),
                                                                                                                            ('2002', '1959-12-08', 79.33, 'sKQWirTeaeOPcbBVYjbf', 'ADPXS@example.com', 'iluPh', 'ZsflQ', 'ZvnYTmZYlc', '+17287283536'),
                                                                                                                            ('2019', '1956-07-02', 406.76, 'nXSoWMRTUJmmwITlUFnf', 'VBlrl@example.com', 'VhEsu', 'sOfDt', 'tXBNAEoTCf', '+19419125701'),
                                                                                                                            ('2006', '1980-08-29', 93.52, 'pWvCGSYKDlJJtrVeECIM', 'fzfUT@example.com', 'euAOe', 'rrARO', 'bSAOBYANCL', '+14943164285'),
                                                                                                                            ('2011', '1978-07-25', 193.81, 'QRLRkmcAFJlvxPdUWGyn', 'qikjp@example.com', 'Ffork', 'XTYXE', 'rWsZAnrMLU', '+12328050758'),
                                                                                                                            ('2002', '1952-05-31', 157.06, 'QImREHmZYUdNIZBiYWLF', 'nwvGi@example.com', 'VjSio', 'OmuCj', 'gkSlJWQchn', '+18469121516'),
                                                                                                                            ('2008', '1974-01-23', 112.21, 'oRjENrqJtrozbfjESvKa', 'JfViC@example.com', 'HSQJm', 'awjok', 'DJVwUtfzup', '+19471644007'),
                                                                                                                            ('2016', '1991-09-04', 99.42, 'rQWWVxBmrHQkFZLxVHKw', 'Mhcgn@example.com', 'vfUPF', 'uaJle', 'ulfuWFflBu', '+17446659884'),
                                                                                                                            ('2015', '1951-12-29', 395.03, 'TwIlGMDecmsZHVTLzILZ', 'apyBX@example.com', 'DEBkG', 'haUDO', 'WDEWZAUvYR', '+14126288434'),
                                                                                                                            ('2015', '1977-10-23', 163.67, 'rxlkGDkccrxdAjkNALGh', 'uuDPm@example.com', 'zZkPo', 'OHWLJ', 'IPWHAhlOMl', '+11317095078');


--insert users data, patient data
INSERT INTO users (id, date_of_birth, email, first_name, last_name, password, phone_number, role) VALUES
                                                                                                      (1, '1980-06-15', 'user1@example.com', 'John', 'Doe', 'hashedpassword1', '555-0100', 'ADMIN'),
                                                                                                      (2, '1985-07-20', 'user2@example.com', 'Jane', 'Smith', 'hashedpassword2', '555-0101', 'PATIENT'),
                                                                                                      (3, '1990-05-25', 'user3@example.com', 'Emily', 'Jones', 'hashedpassword3', '555-0102', 'PATIENT'),
                                                                                                      (4, '1995-08-30', 'user4@example.com', 'Michael', 'Brown', 'hashedpassword4', '555-0103', 'PATIENT'),
                                                                                                      (5, '2000-09-10', 'user5@example.com', 'Jessica', 'Davis', 'hashedpassword5', '555-0104', 'PATIENT'),
                                                                                                      (6, '1975-11-21', 'user6@example.com', 'William', 'Garcia', 'hashedpassword6', '555-0105', 'PATIENT'),
                                                                                                      (7, '1982-12-11', 'user7@example.com', 'Linda', 'Miller', 'hashedpassword7', '555-0106', 'PATIENT'),
                                                                                                      (8, '1978-10-05', 'user8@example.com', 'David', 'Wilson', 'hashedpassword8', '555-0107', 'PATIENT'),
                                                                                                      (9, '1993-03-14', 'user9@example.com', 'Angela', 'Moore', 'hashedpassword9', '555-0108', 'PATIENT'),
                                                                                                      (10, '1988-04-23', 'user10@example.com', 'Daniel', 'Taylor', 'hashedpassword10', '555-0109', 'PATIENT');



INSERT INTO clinic_spec (spec_id, name) VALUES
                                            (1, 'Cardiology'),
                                            (2, 'Neurology'),
                                            (3, 'Orthopedics'),
                                            (4, 'Pediatrics'),
                                            (5, 'Dermatology'),
                                            (6, 'Oncology');


INSERT INTO address (id, address_name, city_name, region_name) VALUES
                                                                   ( 1, 'Lotus Towers', 'Chinatown', 'Eastside'),
                                                                   ( 2, 'Bamboo Gardens', 'Chinatown', 'Westside'),
                                                                   ( 3, 'Ming Estates', 'Chinatown', 'Northside'),
                                                                   (4, 'Dragon Alley', 'Chinatown', 'Southside'),
                                                                   ( 5, 'Panda Plaza', 'Chinatown', 'Central'),
                                                                   ( 6, 'Jade Village', 'Chinatown', 'Uptown');


INSERT INTO clinic (address_id, id, name, official_name, phone_number, supervisor_name) VALUES
                                                                                            (1, 1, 'Health & Wellness Clinic', 'The Wellness Center', '555-1001', 'Dr. Emma Taylor'),
                                                                                            (2, 2, 'City Medical Clinic', 'CityMed', '555-1002', 'Dr. John Smith'),
                                                                                            (3, 3, 'Downtown Health Services', 'Downtown Health', '555-1003', 'Dr. Ava Brown'),
                                                                                            (4, 4, 'Suburban Health Clinic', 'Suburban Clinic', '555-1004', 'Dr. Michael Green'),
                                                                                            (5, 5, 'Eastside Medical Center', 'Eastside Center', '555-1005', 'Dr. Olivia Johnson'),
                                                                                            (6, 6, 'Westend Clinical Services', 'Westend Services', '555-1006', 'Dr. William Davis');
INSERT INTO clinic_doctor values
                              (1, 1),
                              (1, 2),
                              (2, 1),
                              (3, 1),
                              (4, 1);



INSERT INTO specialities (id, name) VALUES
                                        (1, 'Cardiology'),
                                        (2, 'Neurology'),
                                        (3, 'Orthopedics'),
                                        (4, 'Pediatrics'),
                                        (5, 'Dermatology'),
                                        (6, 'Oncology');

INSERT INTO doctor_specialities (doctor_id, speciality_id) VALUES
                                                              (1, 1),
                                                              (2, 2),
                                                              (1, 3),
                                                              (3, 1),
                                                              (4, 4),
                                                              (2, 5);

INSERT INTO medical_service (id, cost, name, clinic_id) VALUES
                                                            (1, 50.00, 'General Consultation', 1),
                                                            (2, 200.00, 'Dental Cleaning', 1),
                                                            (3, 150.00, 'Eye Examination', 2),
                                                            (4, 300.00, 'Orthopedic Consultation', 2),
                                                            (5, 250.00, 'Cardiology Checkup', 3),
                                                            (6, 400.00, 'MRI Scan', 3);




INSERT INTO clinic_spec_aux (clinic_id, spec_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (1, 3),
                                                     (1, 4),
                                                     (1, 5),
                                                     (1, 6),
                                                     (2, 1),
                                                     (2, 2),
                                                     (2, 3),
                                                     (2, 4),
                                                     (2, 5),
                                                     (2, 6),
-- Repeat this pattern for clinics 3 through 6
                                                     (3, 1),
-- ... etc.
                                                     (6, 6);