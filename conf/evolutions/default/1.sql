# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                        bigint not null,
  street_address1           varchar(255),
  street_address2           varchar(255),
  street_address3           varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  country                   varchar(255),
  pincode                   varchar(255),
  address_type              integer,
  user_id                   bigint,
  created                   timestamp,
  constraint ck_address_address_type check (address_type in (0,1)),
  constraint pk_address primary key (id))
;

create table allergy (
  id                        bigint not null,
  name                      varchar(255),
  reaction                  varchar(255),
  allergy_type              integer,
  first_observed            timestamp,
  provider_id               bigint,
  treatment                 varchar(255),
  effective                 integer,
  allergen_code             varchar(255),
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint ck_allergy_allergy_type check (allergy_type in (0,1,2,3,4)),
  constraint ck_allergy_effective check (effective in (0,1,2)),
  constraint pk_allergy primary key (id))
;

create table appointment (
  id                        bigint not null,
  start_date                timestamp,
  end_date                  timestamp,
  provider_id               bigint,
  speciality                varchar(255),
  purpose                   varchar(255),
  appointment_type          integer,
  appointment_status        integer,
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint ck_appointment_appointment_type check (appointment_type in (0,1,2,3,4)),
  constraint ck_appointment_appointment_status check (appointment_status in (0,1,2,3,4)),
  constraint pk_appointment primary key (id))
;

create table blood_glucose (
  id                        bigint not null,
  measurement_context       integer,
  measurement_type          integer,
  date_time                 timestamp,
  comparison_to_normal      integer,
  result_of_control_test    integer,
  range_of_device           integer,
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint ck_blood_glucose_measurement_context check (measurement_context in (0,1,2,3,4,5,6,7,8,9,10,11,12,13)),
  constraint ck_blood_glucose_measurement_type check (measurement_type in (0,1)),
  constraint ck_blood_glucose_comparison_to_normal check (comparison_to_normal in (0,1,2,3,4,5)),
  constraint ck_blood_glucose_result_of_control_test check (result_of_control_test in (0,1,2)),
  constraint ck_blood_glucose_range_of_device check (range_of_device in (0,1,2)),
  constraint pk_blood_glucose primary key (id))
;

create table blood_pressure (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_blood_pressure primary key (id))
;

create table ccd (
  id                        bigint not null,
  file_path                 varchar(255),
  description               varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_ccd primary key (id))
;

create table ccr (
  id                        bigint not null,
  file_path                 varchar(255),
  description               varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_ccr primary key (id))
;

create table cholesterol (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_cholesterol primary key (id))
;

create table condition (
  id                        bigint not null,
  name                      varchar(255),
  severity                  varchar(255),
  status                    varchar(255),
  start_date                timestamp,
  end_date                  timestamp,
  how_it_ended              varchar(255),
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_condition primary key (id))
;

create table dietary_intake (
  id                        bigint not null,
  name                      varchar(255),
  date                      timestamp,
  serving_size              varchar(255),
  number_of_servings        integer,
  calories                  float,
  nutrition_id              bigint,
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_dietary_intake primary key (id))
;

create table document (
  id                        bigint not null,
  file_path                 varchar(255),
  description               varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_document primary key (id))
;

create table email (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  email_type                integer,
  user_id                   bigint,
  created                   timestamp,
  constraint ck_email_email_type check (email_type in (0,1)),
  constraint pk_email primary key (id))
;

create table exercise (
  id                        bigint not null,
  user_id                   bigint,
  constraint pk_exercise primary key (id))
;

create table family_history (
  id                        bigint not null,
  relative_id               bigint,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_family_history primary key (id))
;

create table follow (
  id                        bigint not null,
  source_id                 bigint,
  destination_id            bigint,
  created                   timestamp,
  constraint pk_follow primary key (id))
;

create table height (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_height primary key (id))
;

create table lab_result (
  id                        bigint not null,
  created                   timestamp,
  constraint pk_lab_result primary key (id))
;

create table lab_test (
  id                        bigint not null,
  created                   timestamp,
  constraint pk_lab_test primary key (id))
;

create table medical_device (
  id                        bigint not null,
  start_date                timestamp,
  device_type               varchar(255),
  manufacturer_id           bigint,
  model                     varchar(255),
  serial_number             varchar(255),
  description               varchar(255),
  location_on_body          varchar(255),
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_medical_device primary key (id))
;

create table medical_image (
  id                        bigint not null,
  constraint pk_medical_image primary key (id))
;

create table medication (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_medication primary key (id))
;

create table nutrition (
  id                        bigint not null,
  carbohydrates             float,
  proteins                  float,
  total_fat                 float,
  saturated_fat             float,
  monounsaturated_fat       float,
  polyunsaturated_fat       float,
  trans_fat                 float,
  sugar                     float,
  dietary_fiber             float,
  cholesterol               float,
  sodium                    float,
  calcium                   float,
  iron                      float,
  magnesium                 float,
  phosphorus                float,
  potassium                 float,
  zinc                      float,
  vitamin_a_rae             float,
  vitamin_b6                float,
  vitamin_b12               float,
  vitamin_c                 float,
  vitamin_d                 float,
  vitamin_e                 float,
  vitamin_k                 float,
  niacin                    float,
  riboflavin                float,
  thiamin                   float,
  folate_dfe                float,
  created                   timestamp,
  constraint pk_nutrition primary key (id))
;

create table peak_flow (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_peak_flow primary key (id))
;

create table phone (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  phone_type                integer,
  user_id                   bigint,
  created                   timestamp,
  constraint ck_phone_phone_type check (phone_type in (0,1)),
  constraint pk_phone primary key (id))
;

create table procedure (
  id                        bigint not null,
  name                      varchar(255),
  date_time                 timestamp,
  location_on_body          varchar(255),
  provider_id               bigint,
  secondary_provider_id     bigint,
  note                      varchar(255),
  user_id                   bigint,
  created                   timestamp,
  constraint pk_procedure primary key (id))
;

create table o_user (
  id                        bigint not null,
  profile_image_url         varchar(255),
  full_name                 varchar(255),
  password                  varchar(255),
  relationship_to_primary   integer,
  date_of_birth             timestamp,
  gender                    integer,
  user_type                 integer,
  speciality                varchar(255),
  place_of_business         varchar(255),
  region_of_origin          integer,
  date_of_death             timestamp,
  blood_type                integer,
  ethnicity                 varchar(255),
  language                  varchar(255),
  created                   timestamp,
  constraint ck_o_user_relationship_to_primary check (relationship_to_primary in (0,1,2,3,4)),
  constraint ck_o_user_gender check (gender in (0,1,2)),
  constraint ck_o_user_user_type check (user_type in (0,1,2)),
  constraint ck_o_user_region_of_origin check (region_of_origin in (0,1,2,3,4,5,6,7,8)),
  constraint ck_o_user_blood_type check (blood_type in (0,1)),
  constraint pk_o_user primary key (id))
;

create table weight (
  id                        bigint not null,
  user_id                   bigint,
  created                   timestamp,
  constraint pk_weight primary key (id))
;

create sequence address_seq;

create sequence allergy_seq;

create sequence appointment_seq;

create sequence blood_glucose_seq;

create sequence blood_pressure_seq;

create sequence ccd_seq;

create sequence ccr_seq;

create sequence cholesterol_seq;

create sequence condition_seq;

create sequence dietary_intake_seq;

create sequence document_seq;

create sequence email_seq;

create sequence exercise_seq;

create sequence family_history_seq;

create sequence follow_seq;

create sequence height_seq;

create sequence lab_result_seq;

create sequence lab_test_seq;

create sequence medical_device_seq;

create sequence medical_image_seq;

create sequence medication_seq;

create sequence nutrition_seq;

create sequence peak_flow_seq;

create sequence phone_seq;

create sequence procedure_seq;

create sequence o_user_seq;

create sequence weight_seq;

alter table address add constraint fk_address_user_1 foreign key (user_id) references o_user (id);
create index ix_address_user_1 on address (user_id);
alter table allergy add constraint fk_allergy_provider_2 foreign key (provider_id) references o_user (id);
create index ix_allergy_provider_2 on allergy (provider_id);
alter table allergy add constraint fk_allergy_user_3 foreign key (user_id) references o_user (id);
create index ix_allergy_user_3 on allergy (user_id);
alter table appointment add constraint fk_appointment_provider_4 foreign key (provider_id) references o_user (id);
create index ix_appointment_provider_4 on appointment (provider_id);
alter table appointment add constraint fk_appointment_user_5 foreign key (user_id) references o_user (id);
create index ix_appointment_user_5 on appointment (user_id);
alter table blood_glucose add constraint fk_blood_glucose_user_6 foreign key (user_id) references o_user (id);
create index ix_blood_glucose_user_6 on blood_glucose (user_id);
alter table blood_pressure add constraint fk_blood_pressure_user_7 foreign key (user_id) references o_user (id);
create index ix_blood_pressure_user_7 on blood_pressure (user_id);
alter table ccd add constraint fk_ccd_user_8 foreign key (user_id) references o_user (id);
create index ix_ccd_user_8 on ccd (user_id);
alter table ccr add constraint fk_ccr_user_9 foreign key (user_id) references o_user (id);
create index ix_ccr_user_9 on ccr (user_id);
alter table cholesterol add constraint fk_cholesterol_user_10 foreign key (user_id) references o_user (id);
create index ix_cholesterol_user_10 on cholesterol (user_id);
alter table condition add constraint fk_condition_user_11 foreign key (user_id) references o_user (id);
create index ix_condition_user_11 on condition (user_id);
alter table dietary_intake add constraint fk_dietary_intake_nutrition_12 foreign key (nutrition_id) references nutrition (id);
create index ix_dietary_intake_nutrition_12 on dietary_intake (nutrition_id);
alter table dietary_intake add constraint fk_dietary_intake_user_13 foreign key (user_id) references o_user (id);
create index ix_dietary_intake_user_13 on dietary_intake (user_id);
alter table document add constraint fk_document_user_14 foreign key (user_id) references o_user (id);
create index ix_document_user_14 on document (user_id);
alter table email add constraint fk_email_user_15 foreign key (user_id) references o_user (id);
create index ix_email_user_15 on email (user_id);
alter table exercise add constraint fk_exercise_user_16 foreign key (user_id) references o_user (id);
create index ix_exercise_user_16 on exercise (user_id);
alter table family_history add constraint fk_family_history_relative_17 foreign key (relative_id) references o_user (id);
create index ix_family_history_relative_17 on family_history (relative_id);
alter table family_history add constraint fk_family_history_user_18 foreign key (user_id) references o_user (id);
create index ix_family_history_user_18 on family_history (user_id);
alter table follow add constraint fk_follow_source_19 foreign key (source_id) references o_user (id);
create index ix_follow_source_19 on follow (source_id);
alter table follow add constraint fk_follow_destination_20 foreign key (destination_id) references o_user (id);
create index ix_follow_destination_20 on follow (destination_id);
alter table height add constraint fk_height_user_21 foreign key (user_id) references o_user (id);
create index ix_height_user_21 on height (user_id);
alter table medical_device add constraint fk_medical_device_manufacture_22 foreign key (manufacturer_id) references o_user (id);
create index ix_medical_device_manufacture_22 on medical_device (manufacturer_id);
alter table medical_device add constraint fk_medical_device_user_23 foreign key (user_id) references o_user (id);
create index ix_medical_device_user_23 on medical_device (user_id);
alter table medication add constraint fk_medication_user_24 foreign key (user_id) references o_user (id);
create index ix_medication_user_24 on medication (user_id);
alter table peak_flow add constraint fk_peak_flow_user_25 foreign key (user_id) references o_user (id);
create index ix_peak_flow_user_25 on peak_flow (user_id);
alter table phone add constraint fk_phone_user_26 foreign key (user_id) references o_user (id);
create index ix_phone_user_26 on phone (user_id);
alter table procedure add constraint fk_procedure_provider_27 foreign key (provider_id) references o_user (id);
create index ix_procedure_provider_27 on procedure (provider_id);
alter table procedure add constraint fk_procedure_secondaryProvide_28 foreign key (secondary_provider_id) references o_user (id);
create index ix_procedure_secondaryProvide_28 on procedure (secondary_provider_id);
alter table procedure add constraint fk_procedure_user_29 foreign key (user_id) references o_user (id);
create index ix_procedure_user_29 on procedure (user_id);
alter table weight add constraint fk_weight_user_30 foreign key (user_id) references o_user (id);
create index ix_weight_user_30 on weight (user_id);



# --- !Downs

drop table if exists address cascade;

drop table if exists allergy cascade;

drop table if exists appointment cascade;

drop table if exists blood_glucose cascade;

drop table if exists blood_pressure cascade;

drop table if exists ccd cascade;

drop table if exists ccr cascade;

drop table if exists cholesterol cascade;

drop table if exists condition cascade;

drop table if exists dietary_intake cascade;

drop table if exists document cascade;

drop table if exists email cascade;

drop table if exists exercise cascade;

drop table if exists family_history cascade;

drop table if exists follow cascade;

drop table if exists height cascade;

drop table if exists lab_result cascade;

drop table if exists lab_test cascade;

drop table if exists medical_device cascade;

drop table if exists medical_image cascade;

drop table if exists medication cascade;

drop table if exists nutrition cascade;

drop table if exists peak_flow cascade;

drop table if exists phone cascade;

drop table if exists procedure cascade;

drop table if exists o_user cascade;

drop table if exists weight cascade;

drop sequence if exists address_seq;

drop sequence if exists allergy_seq;

drop sequence if exists appointment_seq;

drop sequence if exists blood_glucose_seq;

drop sequence if exists blood_pressure_seq;

drop sequence if exists ccd_seq;

drop sequence if exists ccr_seq;

drop sequence if exists cholesterol_seq;

drop sequence if exists condition_seq;

drop sequence if exists dietary_intake_seq;

drop sequence if exists document_seq;

drop sequence if exists email_seq;

drop sequence if exists exercise_seq;

drop sequence if exists family_history_seq;

drop sequence if exists follow_seq;

drop sequence if exists height_seq;

drop sequence if exists lab_result_seq;

drop sequence if exists lab_test_seq;

drop sequence if exists medical_device_seq;

drop sequence if exists medical_image_seq;

drop sequence if exists medication_seq;

drop sequence if exists nutrition_seq;

drop sequence if exists peak_flow_seq;

drop sequence if exists phone_seq;

drop sequence if exists procedure_seq;

drop sequence if exists o_user_seq;

drop sequence if exists weight_seq;

