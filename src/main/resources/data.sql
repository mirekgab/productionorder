insert into measure_unit(id, name) values
(1, 'kg'),
(2, 'm2'),
(3, 'sheet');
alter table measure_unit alter column id restart with 4;

insert into product (id, name) values
(1, 'product 1'),
(2, 'product 2'),
(3, 'product 3'),
(4, 'product 4');
alter table product alter column id restart with 5;

insert into material(id, name, base_measure_unit_id) values
(1, 'arkusz 100x200', 3),
(2, 'rura fi 10', 2),
(3, 'płaskownik', 1);
alter table material alter column id restart with 4;

insert into material_unit(id, material_id, measure_unit_id, factor) values
(1, 1, 2, 0.1),
(2, 1, 1, 0.2);
alter table material_unit alter column id restart with 3;

insert into production_order(id, number) values
(1, 'P/001/2024'),
(2, 'P/002/2024'),
(3, 'P/003/2024');
alter table production_order alter column id restart with 4;

insert into input_resource (id, production_order_id, material_id, quantity, measure_unit_id) values
(1, 1, 1, 10, 3),
(2, 1, 2, 2, 1),
(3, 2, 1, 20, 1),
(4, 1, 3, 20, 1);
alter table input_resource alter column id restart with 5;

insert into output_resource(id, production_order_id, product_id, quantity, measure_unit_id) values
(1, 1, 1, 5, 1),
(2, 1, 2, 3, 1);
alter table output_resource alter column id restart with 3;
