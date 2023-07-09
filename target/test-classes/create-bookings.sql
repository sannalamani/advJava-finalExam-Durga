DROP TABLE IF EXISTS bookings;
CREATE TABLE bookings (
                          bookid integer NOT NULL,
                          facid integer NOT NULL,
                          memid integer NOT NULL,
                          starttime timestamp NOT NULL,
                          slots integer NOT NULL
);
