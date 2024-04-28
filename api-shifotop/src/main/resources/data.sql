--insert into doctor table
INSERT INTO doctor (career_start_year, date_of_birth, price, bio, email, first_name, last_name, password, phone_number) VALUES
                                                                                                                            ('2020', '1998-02-18', 287000, 'Ichki kasalliklar va diabet bo‘yicha tajribali.', 'zafar99@example.com', 'Zafar', 'Abdullaev', 'password1234', '+998712345678'),
                                                                                                                            ('2002', '1959-12-08', 154000, 'Bolalar sog‘liqni saqlash va emlash dasturlari bo‘yicha mutaxassis.', 'gulbahor02@example.com', 'Gulbahor', 'Karimova', 'securepass02', '+998761234567'),
                                                                                                                            ('2019', '1956-07-02', 234000, 'Yurak-qon tomir salomatligi va jarrohlik amaliyotlari bo‘yicha mutaxassis.', 'nurillo19@example.com', 'Nurillo', 'Tursunov', 'mypassword19', '+998711223344'),
                                                                                                                            ('2006', '1980-08-29', 119000, 'Teri sharoitlari bo‘yicha keng tajribaga ega dermatolog.', 'feruza06@example.com', 'Feruza', 'Ismoilova', 'feruza1234', '+998721234598'),
                                                                                                                            ('2011', '1978-07-25', 198000, 'Sport jarohatlari bo‘yicha ortopedik jarroh.', 'shavkat11@example.com', 'Shavkat', 'Mirziyoyev', 'shavkat2011', '+998701234567'),
                                                                                                                            ('2002', '1952-05-31', 207000, 'Kattalar va keksa yoshdagi bemorlar bo‘yicha nevrolog.', 'sitora02@example.com', 'Sitora', 'Nazarova', 'sitora0202', '+998731234567'),
                                                                                                                            ('2008', '1974-01-23', 143000, 'Retina va kornea jarrohliklari bo‘yicha oftalmolog.', 'aziza08@example.com', 'Aziza', 'Akramova', 'aziza2008', '+998741234567'),
                                                                                                                            ('2016', '1991-09-04', 125000, 'Oldini olish va salomatlikni saqlashga e''tibor qaratgan umumiy amaliyot shifokori.', 'bahrom16@example.com', 'Bahrom', 'Saidov', 'bahrom2016', '+998701234888'),
                                                                                                                            ('2015', '1951-12-29', 175000, 'Artrit va autoimmun kasalliklar bo‘yicha revmatolog.', 'dilnoza15@example.com', 'Dilnoza', 'Kamilova', 'dilnoza2015', '+998712345999'),
                                                                                                                            ('2015', '1977-10-23', 258000, 'Og‘riq boshqaruv va jarrohlik anesteziyasi bo‘yicha anesteziolog.', 'kamol15@example.com', 'Kamol', 'Juraev', 'kamol2015', '+998711235678'),
                                                                                                                            ('2020', '1998-02-18', 287000, 'Ichki kasalliklar va diabet bo‘yicha tajribali.', 'zafar992@example.com', 'Zafar', 'Abdullaev', 'password1234', '+998712345678'),
                                                                                                                            ('2002', '1959-12-08', 154000, 'Bolalar sog‘liqni saqlash va emlash dasturlari bo‘yicha mutaxassis.', 'gulbahor022@example.com', 'Gulbahor', 'Karimova', 'securepass02', '+998761234567'),
                                                                                                                            ('2019', '1956-07-02', 234000, 'Yurak-qon tomir salomatligi va jarrohlik amaliyotlari bo‘yicha mutaxassis.', 'nurillo192@example.com', 'Nurillo', 'Tursunov', 'mypassword19', '+998711223344'),
                                                                                                                            ('2006', '1980-08-29', 119000, 'Teri sharoitlari bo‘yicha keng tajribaga ega dermatolog.', 'feruza062@example.com', 'Feruza', 'Ismoilova', 'feruza1234', '+998721234598'),
                                                                                                                            ('2011', '1978-07-25', 198000, 'Sport jarohatlari bo‘yicha ortopedik jarroh.', 'shavkat112@example.com', 'Shavkat', 'Mirziyoyev', 'shavkat2011', '+998701234567'),
                                                                                                                            ('2002', '1952-05-31', 207000, 'Kattalar va keksa yoshdagi bemorlar bo‘yicha nevrolog.', 'sitora022@example.com', 'Sitora', 'Nazarova', 'sitora0202', '+998731234567'),
                                                                                                                            ('2008', '1974-01-23', 143000, 'Retina va kornea jarrohliklari bo‘yicha oftalmolog.', 'aziza082@example.com', 'Aziza', 'Akramova', 'aziza2008', '+998741234567'),
                                                                                                                            ('2016', '1991-09-04', 125000, 'Oldini olish va salomatlikni saqlashga e''tibor qaratgan umumiy amaliyot shifokori.', 'bahrom162@example.com', 'Bahrom', 'Saidov', 'bahrom2016', '+998701234888'),
                                                                                                                            ('2015', '1951-12-29', 175000, 'Artrit va autoimmun kasalliklar bo‘yicha revmatolog.', 'dilnoza152@example.com', 'Dilnoza', 'Kamilova', 'dilnoza2015', '+998712345999'),
                                                                                                                            ('2015', '1977-10-23', 258000, 'Og‘riq boshqaruv va jarrohlik anesteziyasi bo‘yicha anesteziolog.', 'kamol152@example.com', 'Kamol', 'Juraev', 'kamol2015', '+998711235678');

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
                                            (1, 'Kardiologiya'),
                                            (2, 'Nevrologiya'),
                                            (3, 'Ortopediya'),
                                            (4, 'Pediatriya'),
                                            (5, 'Dermatologiya'),
                                            (6, 'Onkologiya');




INSERT INTO address (id, address_name, city_name, region_name) VALUES
                                                                   (1, 'Guliston 8 Apartments', 'Tashkent', 'Yakkasaroy District'),
                                                                   (2, 'Navroz 14 Residences', 'Tashkent', 'Mirzo-Ulugbek District'),
                                                                   (3, 'Zarafshan 22 Homes', 'Tashkent', 'Shaykhontohur District'),
                                                                   (4, 'Bogishamol 5 Towers', 'Tashkent', 'Yunusabad District'),
                                                                   (5, 'Sitora 11 Complex', 'Tashkent', 'Chilanzar District'),
                                                                   (6, 'Bahor 33 Villas', 'Tashkent', 'Olmazor District'),
                                                                   (7, 'Navbahor 48 Apartments', 'Tashkent', 'Yunusabad District'),
                                                                   (8, 'Zumrad 36 Residences', 'Tashkent', 'Mirzo-Ulugbek District'),
                                                                   (9, 'Gulnara 9 Homes', 'Tashkent', 'Olmazor District'),
                                                                   (10, 'Safar 26 Towers', 'Tashkent', 'Chilanzar District'),
                                                                   (11, 'Oltin Vodiy 13 Complex', 'Tashkent', 'Yakkasaroy District'),
                                                                   (12, 'Maftun 19 Villas', 'Tashkent', 'Shaykhontohur District'),
                                                                   (13, 'Nurafshon 7 Apartments', 'Tashkent', 'Sergeli District'),
                                                                   (14, 'Bahodir 25 Residences', 'Tashkent', 'Uchtepa District'),
                                                                   (15, 'Rayhon 45 Homes', 'Tashkent', 'Bektemir District'),
                                                                   (16, 'Shodlik 55 Towers', 'Tashkent', 'Zangiota District');





INSERT INTO clinic (address_id, id, name, official_name, phone_number, supervisor_name) VALUES
                                                                                            (1, 1, 'Sogliqni Saqlash Markazi', 'Sogliqni Saqlash Wellness Markazi', '+998-71-100-1001', 'Anvar Rasulov'),
                                                                                            (2, 2, 'Shahar Tibbiyot Klinikasi', 'CityMed Tibbiyot Markazi', '+998-71-100-1002', 'Dilnoza Akramova'),
                                                                                            (3, 3, 'Markaziy Salomatlik Xizmatlari', 'Downtown Salomatlik Markazi', '+998-71-100-1003', 'Otabek Karimov'),
                                                                                            (4, 4, 'Chet El Tibbiyot Klinikasi', 'Suburban Tibbiyot Klinikasi', '+998-71-100-1004', 'Gulbahor Yusupova'),
                                                                                            (5, 5, 'Sharqiy Tibbiyot Markazi', 'Eastside Tibbiyot Markazi', '+998-71-100-1005', 'Jamshid Bekmurodov'),
                                                                                            (6, 6, 'Garbiy Klinik Xizmatlari', 'Westend Klinik Xizmatlari', '+998-71-100-1006', 'Shuhrat Mirziyoyev'),
                                                                                            (7, 7, 'Yunusabad Salomatlik Markazi', 'Yunusabad Health Center', '+998-71-100-1007', 'Dr. Sarvar Juraev'),
                                                                                            (8, 8, 'Mirzo Ulugbek Tibbiyot Klinikasi', 'Mirzo Ulugbek Medical Clinic', '+998-71-100-1008', 'Dr. Nargiza Hamidova'),
                                                                                            (9, 9, 'Olmazor Klinik Xizmatlari', 'Olmazor Clinical Services', '+998-71-100-1009', 'Dr. Behzod Salimov'),
                                                                                            (10, 10, 'Chilanzar Tibbiyot Markazi', 'Chilanzar Medical Center', '+998-71-100-1010', 'Dr. Aziza Niyazova'),
                                                                                            (11, 11, 'Yakkasaroy Salomatlik Klinikasi', 'Yakkasaroy Health Clinic', '+998-71-100-1011', 'Dr. Ibrohim Abdullaev'),
                                                                                            (12, 12, 'Shayxontohur Salomatlik Xizmatlari', 'Shaykhontohur Health Services', '+998-71-100-1012', 'Dr. Elvira Rasulova'),
                                                                                            (13, 13, 'Sergeli Salomatlik Markazi', 'Sergeli Health Center', '+998-71-100-1013', 'Dr. Farhod Alimov'),
                                                                                            (14, 14, 'Uchtepa Klinik Xizmatlari', 'Uchtepa Clinical Services', '+998-71-100-1014', 'Dr. Malika Tursunova'),
                                                                                            (15, 15, 'Bektemir Tibbiyot Markazi', 'Bektemir Medical Center', '+998-71-100-1015', 'Dr. Rustam Jabbarov'),
                                                                                            (16, 16, 'Zangiota Salomatlik Markazi', 'Zangiota Health Center', '+998-71-100-1016', 'Dr. Saida Mirziyoyeva');

INSERT INTO clinic_doctor (clinic_id, doctor_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (1, 3),
                                                     (2, 1),
                                                     (2, 2),
                                                     (2, 3),
                                                     (3, 1),
                                                     (3, 3),
                                                     (4, 2),
                                                     (4, 3),
                                                     (4, 4),
                                                     (2, 4),
                                                     (2, 5),
                                                     (3, 4),
                                                     (3, 5),
                                                     (3, 6),
                                                     (4, 5),
                                                     (5, 6),
                                                     (5, 7),
                                                     (6, 8),
                                                     (6, 5),
                                                     (7, 9),
                                                     (7, 8),
                                                     (8, 10),
                                                     (8, 9),
                                                     (9, 8),
                                                     (10, 9),
                                                     (11, 1),
                                                     (11, 2),
                                                     (11, 3),
                                                     (12, 1),
                                                     (12, 2),
                                                     (12, 3),
                                                     (13, 1),
                                                     (13, 2),
                                                     (13, 3),
                                                     (14, 2),
                                                     (14, 3),
                                                     (14, 4);



INSERT INTO specialities (id, name) VALUES
                                        (1, 'Kardiolog'),  -- Cardiology updated to the Uzbek language
                                        (2, 'Nevrolog'),  -- Neurology updated to the Uzbek language
                                        (3, 'Ortopedik'),   -- Orthopedics updated to the Uzbek language
                                        (4, 'Bolalar shifokori'),  -- Pediatrics, more colloquially "Children's Doctor"
                                        (5, 'Dermatolog'),  -- Dermatology updated to the Uzbek language
                                        (6, 'Onkolog');  -- Oncology updated to the Uzbek language


INSERT INTO doctor_specialities (doctor_id, speciality_id) VALUES
                                                               (1, 1),
                                                               (1, 3),
                                                               (1, 6),
                                                               (2, 2),
                                                               (2, 5),
                                                               (2, 4),
                                                               (3, 1),
                                                               (3, 3),
                                                               (3, 6),
                                                               (4, 4),
                                                               (4, 5),
                                                               (5, 5),
                                                               (5, 2),
                                                               (6, 6),
                                                               (6, 1),
                                                               (7, 3),
                                                               (7, 4),
                                                               (8, 2),
                                                               (8, 1),
                                                               (9, 1),
                                                               (9, 6),
                                                               (10, 4),
                                                               (10, 2),
                                                               (10, 3),
                                                               (10, 5),
                                                               (10, 1),
                                                               (9, 2),
                                                               (9, 4),
                                                               (9, 5),
                                                               (9, 3),
                                                               (8, 6);


INSERT INTO medical_service (id, cost, name) VALUES
                                                 (1, 100000, 'Umumiy Maslahat'),
                                                 (2, 120000, 'Tish Tozalash'),
                                                 (3, 110000, 'Koz Tekshiruvi'),
                                                 (4, 180000, 'Ortopedik Maslahat'),
                                                 (5, 150000, 'Kardiologiya Tekshiruvi'),
                                                 (6, 200000, 'MRI Skanirovka'),
                                                 (7, 130000, 'Bolalar Tekshiruvi'),
                                                 (8, 160000, 'Nevrologik Maslahat'),
                                                 (9, 140000, 'Ovqatlanish Boyicha Maslahat'),
                                                 (10, 190000, 'Murakkab Dermatologik Protsedura'),
                                                 (11, 115000, 'Oddiy Qon Sinovlari'),
                                                 (12, 175000, 'Saratonni Skrining Qilish');


INSERT INTO clinic_medical_service(clinic_id, medical_service_id) VALUES
                                                                        -- Clinic 1
                                                                        (1,1), (1,2), (1,3), (1,4), (1,5),
                                                                        -- Clinic 2
                                                                        (2,1), (2,2), (2,3), (2,6), (2,7),
                                                                        -- Clinic 3
                                                                        (3,1), (3,2), (3,5), (3,7), (3,8),
                                                                        -- Clinic 4
                                                                        (4,3), (4,4), (4,8), (4,9), (4,10),
                                                                        -- Clinic 5
                                                                        (5,2), (5,4), (5,6), (5,8), (5,10),
                                                                        -- Clinic 6
                                                                        (6,1), (6,5), (6,7), (6,11), (6,12),
                                                                        -- Clinic 7
                                                                        (7,3), (7,5), (7,6), (7,9), (7,11),
                                                                        -- Clinic 8
                                                                        (8,1), (8,4), (8,7), (8,10), (8,12),
                                                                        -- Clinic 9
                                                                        (9,2), (9,5), (9,8), (9,11), (9,12),
                                                                        -- Clinic 10
                                                                        (10,3), (10,6), (10,9), (10,10), (10,12),
                                                                        -- Clinic 11
                                                                        (11,1), (11,4), (11,7), (11,8), (11,11),
                                                                        -- Clinic 12
                                                                        (12,2), (12,3), (12,5), (12,9), (12,10),
                                                                        -- Clinic 13
                                                                        (13,1), (13,6), (13,8), (13,10), (13,12),
                                                                        -- Clinic 14
                                                                        (14,3), (14,4), (14,7), (14,9), (14,11),
                                                                        -- Clinic 15
                                                                        (15,2), (15,5), (15,6), (15,8), (15,12),
                                                                        -- Clinic 16
                                                                        (16,1), (16,3), (16,4), (16,10), (16,11);





INSERT INTO clinic_spec_aux (clinic_id, spec_id) VALUES
                                                    -- Clinic 1
                                                    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),
                                                    -- Clinic 2
                                                    (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6),
                                                    -- Clinic 3
                                                    (3, 1), (3, 2), (3, 3),
                                                    -- Clinic 4
                                                    (4, 2), (4, 3), (4, 5),
                                                    -- Clinic 5
                                                    (5, 1), (5, 4), (5, 6),
                                                    -- Clinic 6
                                                    (6, 2), (6, 3), (6, 6),
                                                    -- Clinic 7
                                                    (7, 1), (7, 5),
                                                    -- Clinic 8
                                                    (8, 2), (8, 4), (8, 6),
                                                    -- Clinic 9
                                                    (9, 3), (9, 5),
                                                    -- Clinic 10
                                                    (10, 1), (10, 6),
                                                    -- Clinic 11
                                                    (11, 1), (11, 3), (11, 5),
                                                    -- Clinic 12
                                                    (12, 2), (12, 4),
                                                    -- Clinic 13
                                                    (13, 3), (13, 5), (13, 6),
                                                    -- Clinic 14
                                                    (14, 1), (14, 4),
                                                    -- Clinic 15
                                                    (15, 2), (15, 5), (15, 6),
                                                    -- Clinic 16
                                                    (16, 1), (16, 3), (16, 4);


INSERT INTO reviews (rating, clinic_id, doctor_id, patient_id, review_date, content) VALUES
                                                                                         (5, 1, NULL, 1, '2023-04-01 14:30:00', 'Ajoyib xizmat va do''stona xodimlar.'),
                                                                                         (4, NULL, 1, 2, '2023-04-02 10:15:00', 'Juda bilimdon va yordamchi.'),
                                                                                         (3, 2, NULL, 1, '2023-04-03 16:45:00', 'Yaxshi tajriba, lekin kutish vaqti uzoq.'),
                                                                                         (5, NULL, 2, 2, '2023-04-04 09:00:00', 'Maslahat chuqur va ma''lumotli edi.'),
                                                                                         (2, 3, NULL, 2, '2023-04-05 12:30:00', 'Mijozlarga g''amxo''rlik sohasida yaxshilanish zarur.'),
                                                                                         (4, NULL, 3, 1, '2023-04-06 15:20:00', 'Foydali maslahat va samarali davolash.'),
                                                                                         (5, 4, NULL, 2, '2023-04-07 11:10:00', 'Ajoyib g''amxo''rlik va zamonaviy sharoitlar.'),
                                                                                         (3, NULL, 4, 1, '2023-04-08 13:50:00', 'O''rtacha xizmat, ko''proq kutgan edim.'),
                                                                                         (4, 5, NULL, 1, '2023-04-09 08:25:00', 'Juda professional va do''stona.'),
                                                                                         (1, NULL, 5, 2, '2023-04-10 14:10:00', 'Qoniqarsiz va notanish.'),
                                                                                         (5, 6, NULL, 1, '2023-04-11 10:40:00', 'Ajoyib xizmat, yuqori baholayman.'),
                                                                                         (4, NULL, 6, 1, '2023-04-12 12:50:00', 'Tibbiy ko''rik chuqur va foydali edi.'),
                                                                                         (3, 7, NULL, 2, '2023-04-13 15:30:00', 'Xizmat yaxshi, biroq tezroq bo''lishi mumkin.'),
                                                                                         (5, NULL, 7, 2, '2023-04-14 09:45:00', 'Shifokor va xodimlar bilan ajoyib tajriba.'),
                                                                                         (2, 8, NULL, 1, '2023-04-15 11:30:00', 'Bemorlarga muomala yomon.'),
                                                                                         (4, NULL, 8, 1, '2023-04-16 16:15:00', 'Samarali davolash va yaxshi maslahat.'),
                                                                                         (3, 9, NULL, 2, '2023-04-17 14:05:00', 'Umumiy tajriba yaxshi, lekin yaxshilanish kerak.'),
                                                                                         (5, NULL, 9, 2, '2023-04-18 10:20:00', 'Eng yaxshi sharoit va ajoyib xizmat.'),
                                                                                         (4, 10, NULL, 2, '2023-04-19 12:45:00', 'Juda yaxshi tibbiy ko''rik va davolash.'),
                                                                                         (1, NULL, 10, 1, '2023-04-20 11:55:00', 'Umuman olganda qoniqarsiz.');
