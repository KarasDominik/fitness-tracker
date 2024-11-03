create table measurement
(
    id          uuid primary key,
    user_id     uuid not null,
    weight      numeric(5, 1),
    calf        numeric(5, 1),
    thigh       numeric(5, 1),
    hips        numeric(5, 1),
    belly       numeric(5, 1),
    waist       numeric(5, 1),
    chest       numeric(5, 1),
    arm         numeric(5, 1),
    forearm     numeric(5, 1)
);