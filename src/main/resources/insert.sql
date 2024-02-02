insert into role_hierarchy (id, child_name, parent_name) values (1,'ROLE_ADMIN',null);
insert into role_hierarchy (id, child_name, parent_name) values (2,'ROLE_MANAGER','ROLE_ADMIN');
insert into role_hierarchy (id, child_name, parent_name) values (3,'ROLE_USER','ROLE_MANAGER');