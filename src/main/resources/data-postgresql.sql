-- INSERT INTO public.roles(id, name)
-- VALUES (1, 'ROLE_USER'),
--        (2, 'ROLE_ADMIN')
-- ON CONFLICT DO NOTHING;

INSERT INTO performer_styles(style_name) VALUES
(N'Ľudová tvorba'),
(N'Moderná tvorba'),
(N'Klasická tvorba'),
(N'Vlastná tvorba'),
(N'Iné')
ON CONFLICT DO NOTHING;

INSERT INTO performer_types(type_name) VALUES
(N'Hudba'),
(N'Tanec'),
(N'Zabávač'),
(N'Moderátor')
ON CONFLICT DO NOTHING;

INSERT INTO performance_categories(category_name) VALUES
(N'Svadba'),
(N'Celovečerná akcia'),
(N'Pódiové vystúpenie')
ON CONFLICT DO NOTHING;

INSERT INTO performance_subcategories(subcategory_name, category_id) VALUES
(N'Čepčenie', 1),
(N'Redový tanec', 1),
(N'Hranie', 1),
(N'Celovečerná akcia', 2),
(N'Pódiové vystúpenie', 3)
ON CONFLICT DO NOTHING;

INSERT INTO users(performer_name, username, email, password, is_solo) VALUES
('Hollárovci', 'Hollárovci', 'Hollarovci@gmail.com', '4saksjagkassad43s', '0'),
('DJ Kladivo', 'ferihruska', 'djkladivo@gmail.com', '7slkhjluisssad', '1'),
('Klaun Krusty', 'krusty', 'klaunkrusty@simpsons.com', 'asdaw_??sluisssad', '0')
ON CONFLICT DO NOTHING;

INSERT INTO users_performer_type(user_id, performer_type_id) VALUES
(1, 2)
ON CONFLICT DO NOTHING;

INSERT INTO users_performer_style(user_id, performer_style_id) VALUES
(1, 3)
ON CONFLICT DO NOTHING;

INSERT INTO priced_performance_subcategory(informative_price, performance_subcategory, price_description, user_id) VALUES
(100, 3, 'hranie', 1)
ON CONFLICT DO NOTHING;