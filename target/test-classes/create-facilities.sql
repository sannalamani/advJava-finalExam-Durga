DROP TABLE IF EXISTS facilities;
CREATE TABLE facilities (
                            facid integer NOT NULL,
                            name varchar(100) NOT NULL,
                            membercost numeric NOT NULL,
                            guestcost numeric NOT NULL,
                            initialoutlay numeric NOT NULL,
                            monthlymaintenance numeric NOT NULL
);