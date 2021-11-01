set foreign_key_checks=0;

truncate table learning_party;
truncate table authority;
truncate table instructor;

insert into learning_party(`id`, `email`,`password`, `enabled`)
values(123, 'tomi@mail.com', '123pass321', false),
      (124, 'bomi@mail.com', '123pass321', false),
      (125, 'tobi@mail.com', '123pass321', false),
      (126, 'alex@mail.com', '123pass321', false),
      (127, 'craig@mail.com', '123pass321', false);

set foreign_key_checks=1;


-- insert  into learning_party(`id`,`email`,`password`,`enable`)
-- value (123,'tomi@gmail.com','122pass321',false ),
--       (124,'ola@mail.com','162pass321',false ),
--       (125,'tom@gmail.com','132pass321',false ),
--       (125,'omi@gmail.com','152pass321',false )