insert into role_hierarchy (id, role_name, parent_id) values (1,'ROLE_ADMIN',null);
insert into role_hierarchy (id, role_name, parent_id) values (2,'ROLE_MANAGER','1');
insert into role_hierarchy (id, role_name, parent_id) values (3,'ROLE_DBA','1');
insert into role_hierarchy (id, role_name, parent_id) values (4,'ROLE_USER','2');
insert into role_hierarchy (id, role_name, parent_id) values (5,'ROLE_USER','3');