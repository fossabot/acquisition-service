set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_mcs_cm_cm_clientgeoinfo
select
`id`    as    id,
`extpropertys`    as    extpropertys,
`client`    as    client,
`latitude`    as    latitude,
`longitude`    as    longitude,
`remark`    as    remark,
`inserttime`    as    inserttime,
`insertuser`    as    insertuser,
`updatetime`    as    updatetime,
`updateuser`    as    updateuser
`row_id`    as src_sys_row_id,
'crm'    as src_sys_cd,
'crm_cm_clientgeoinfo'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.crm_cm_clientgeoinfo;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_mcs_cm_cm_contract
select
`id`    as    id,
`updatetime`    as    updatetime,
`updatestaff`    as    updatestaff,
`extpropertys`    as    extpropertys,
`client`    as    client,
`begindate`    as    begindate,
`enddate`    as    enddate,
`signman`    as    signman,
`signdate`    as    signdate,
`approveflag`    as    approveflag,
`inserttime`    as    inserttime,
`insertstaff`    as    insertstaff
`row_id`    as src_sys_row_id,
'crm'    as src_sys_cd,
'crm_cm_contract'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.crm_cm_contract;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_ap_ap_ae_lines_all
select
`ae_line_id`    as    ae_line_id,
`entered_dr`    as    entered_dr,
`entered_cr`    as    entered_cr,
`accounted_dr`    as    accounted_dr,
`accounted_cr`    as    accounted_cr,
`source_table`    as    source_table,
`source_id`    as    source_id,
`account_overlay_source_id`    as    account_overlay_source_id,
`gl_sl_link_id`    as    gl_sl_link_id,
`description`    as    description,
`accounting_error_code`    as    accounting_error_code,
`ae_header_id`    as    ae_header_id,
`gl_transfer_error_code`    as    gl_transfer_error_code,
`third_party_id`    as    third_party_id,
`third_party_sub_id`    as    third_party_sub_id,
`stat_amount`    as    stat_amount,
`subledger_doc_sequence_id`    as    subledger_doc_sequence_id,
`subledger_doc_sequence_value`    as    subledger_doc_sequence_value,
`org_id`    as    org_id,
`creation_date`    as    creation_date,
`ussgl_transaction_code`    as    ussgl_transaction_code,
`created_by`    as    created_by,
`ae_line_number`    as    ae_line_number,
`last_update_date`    as    last_update_date,
`last_updated_by`    as    last_updated_by,
`last_update_login`    as    last_update_login,
`program_update_date`    as    program_update_date,
`program_application_id`    as    program_application_id,
`program_id`    as    program_id,
`request_id`    as    request_id,
`reference1`    as    reference1,
`reference2`    as    reference2,
`reference3`    as    reference3,
`ae_line_type_code`    as    ae_line_type_code,
`reference4`    as    reference4,
`reference5`    as    reference5,
`reference6`    as    reference6,
`reference7`    as    reference7,
`reference8`    as    reference8,
`reference9`    as    reference9,
`reference10`    as    reference10,
`applied_from_trx_hdr_table`    as    applied_from_trx_hdr_table,
`applied_from_trx_hdr_id`    as    applied_from_trx_hdr_id,
`applied_to_trx_hdr_table`    as    applied_to_trx_hdr_table,
`code_combination_id`    as    code_combination_id,
`applied_to_trx_hdr_id`    as    applied_to_trx_hdr_id,
`tax_code_id`    as    tax_code_id,
`taxable_entered_dr`    as    taxable_entered_dr,
`taxable_entered_cr`    as    taxable_entered_cr,
`taxable_accounted_dr`    as    taxable_accounted_dr,
`taxable_accounted_cr`    as    taxable_accounted_cr,
`tax_link_id`    as    tax_link_id,
`currency_code`    as    currency_code,
`currency_conversion_type`    as    currency_conversion_type,
`currency_conversion_date`    as    currency_conversion_date,
`currency_conversion_rate`    as    currency_conversion_rate
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_ap_ae_lines_all'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_ap_ae_lines_all;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_ap_ap_aging_periods
select
`aging_period_id`    as    aging_period_id,
`aging_type`    as    aging_type,
`amounts_to_show`    as    amounts_to_show,
`attribute_category`    as    attribute_category,
`attribute1`    as    attribute1,
`attribute2`    as    attribute2,
`attribute3`    as    attribute3,
`attribute4`    as    attribute4,
`attribute5`    as    attribute5,
`attribute6`    as    attribute6,
`attribute7`    as    attribute7,
`last_updated_by`    as    last_updated_by,
`attribute8`    as    attribute8,
`attribute9`    as    attribute9,
`attribute10`    as    attribute10,
`attribute11`    as    attribute11,
`attribute12`    as    attribute12,
`attribute13`    as    attribute13,
`attribute14`    as    attribute14,
`attribute15`    as    attribute15,
`last_update_login`    as    last_update_login,
`last_update_date`    as    last_update_date,
`created_by`    as    created_by,
`creation_date`    as    creation_date,
`period_name`    as    period_name,
`description`    as    description,
`status`    as    status,
`base_date`    as    base_date
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_ap_aging_periods'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_ap_aging_periods;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_ap_ap_test
select
`id`    as    id,
`name`    as    name
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_ap_test'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_ap_test;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_dms_cx_adjust
select
`row_id`    as    row_id,
`remark`    as    remark,
`storage_id`    as    storage_id,
`file_name`    as    file_name,
`file_path`    as    file_path,
`create_dt`    as    create_dt,
`lastupdate_dt`    as    lastupdate_dt,
`adjust_number`    as    adjust_number,
`adjust_type`    as    adjust_type,
`creator_id`    as    creator_id,
`invoices_flag`    as    invoices_flag,
`lastupdator_id`    as    lastupdator_id,
`org_id`    as    org_id
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_cx_adjust'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_cx_adjust;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_erp_ap_accounting_events_all
select
`accounting_event_id`    as    accounting_event_id,
`last_update_date`    as    last_update_date,
`last_updated_by`    as    last_updated_by,
`last_update_login`    as    last_update_login,
`program_update_date`    as    program_update_date,
`program_id`    as    program_id,
`program_application_id`    as    program_application_id,
`request_id`    as    request_id,
`org_id`    as    org_id,
`cannot_account_flag`    as    cannot_account_flag,
`ax_accounted_flag`    as    ax_accounted_flag,
`event_type_code`    as    event_type_code,
`accounting_date`    as    accounting_date,
`event_number`    as    event_number,
`event_status_code`    as    event_status_code,
`source_table`    as    source_table,
`source_id`    as    source_id,
`creation_date`    as    creation_date,
`created_by`    as    created_by
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_ap_accounting_events_all'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_ap_accounting_events_all;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_ftm_requdtl
select
`findex`    as    findex,
`ftype3`    as    ftype3,
`fpm`    as    fpm,
`fdate1`    as    fdate1,
`fdate2`    as    fdate2,
`stockqty`    as    stockqty,
`stockqua`    as    stockqua,
`fpoprice`    as    fpoprice,
`ctid`    as    ctid,
`fzdw`    as    fzdw,
`pkgut`    as    pkgut,
`fno`    as    fno,
`fzdrq`    as    fzdrq,
`fitemnoa`    as    fitemnoa,
`fitemno`    as    fitemno,
`ftype4`    as    ftype4,
`perpkg`    as    perpkg,
`dbqty`    as    dbqty,
`dbqua`    as    dbqua,
`ftype3bak`    as    ftype3bak,
`cangchufy`    as    cangchufy,
`rkdays`    as    rkdays,
`fromno`    as    fromno,
`ctname`    as    ctname,
`fshck`    as    fshck,
`finvno`    as    finvno,
`fpono`    as    fpono,
`fpehao`    as    fpehao,
`ftype2`    as    ftype2
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_requdtl'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_requdtl;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_ftm_requisition
select
`fno`    as    fno,
`gp`    as    gp,
`mp`    as    mp,
`dp`    as    dp,
`tp`    as    tp,
`opid`    as    opid,
`gpid`    as    gpid,
`gpidtg`    as    gpidtg,
`fsigndate`    as    fsigndate,
`memo1`    as    memo1,
`memo2`    as    memo2,
`fdate`    as    fdate,
`fsaved`    as    fsaved,
`placed`    as    placed,
`stocktype`    as    stocktype,
`tostocktype`    as    tostocktype,
`ctid`    as    ctid,
`ctname`    as    ctname,
`fstockno`    as    fstockno,
`fstockname`    as    fstockname,
`ftostockno`    as    ftostockno,
`ftostockname`    as    ftostockname,
`rp`    as    rp
`row_id`    as src_sys_row_id,
'dms'    as src_sys_cd,
'dms_requisition'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.dms_requisition;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_administrator
select
`id`    as    id,
`name`    as    name,
`role`    as    role,
`username`    as    username,
`password`    as    password,
`token`    as    token
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_administrator'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_administrator;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_develop_info
select
`id`    as    id,
`last_update_content`    as    last_update_content,
`comment`    as    comment,
`unique_name`    as    unique_name,
`create_dt`    as    create_dt,
`create_by`    as    create_by,
`pic`    as    pic,
`develop_status`    as    develop_status,
`last_update_dt`    as    last_update_dt,
`last_update_by`    as    last_update_by,
`last_update_reason`    as    last_update_reason
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_develop_info'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_develop_info;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_ods_job_info
select
`job_pk`    as    job_pk,
`import_rows`    as    import_rows,
`elapsed_time`    as    elapsed_time,
`dt`    as    dt,
`job_status`    as    job_status,
`import_log`    as    import_log,
`workflow_name`    as    workflow_name,
`source_system`    as    source_system,
`source_table`    as    source_table,
`extract_type`    as    extract_type,
`target_database`    as    target_database,
`target_table`    as    target_table,
`start_time`    as    start_time,
`end_time`    as    end_time
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_ods_job_info'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_ods_job_info;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_pro_object_structure
select
`database_name`    as    database_name,
`sys_abbreviation`    as    sys_abbreviation,
`object_name`    as    object_name,
`unique_name`    as    unique_name,
`col_name`    as    col_name,
`col_type`    as    col_type,
`partition_key`    as    partition_key
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_pro_object_structure'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_pro_object_structure;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_pro_ods_object_metadata
select
`id`    as    id,
`extract_type`    as    extract_type,
`increment_column`    as    increment_column,
`query`    as    query,
`hive_ddl`    as    hive_ddl,
`increment_script`    as    increment_script,
`extract_days`    as    extract_days,
`database_name`    as    database_name,
`unique_name`    as    unique_name,
`object_type`    as    object_type,
`partitions`    as    partitions,
`field_terminate`    as    field_terminate,
`line_terminate`    as    line_terminate,
`comment`    as    comment,
`split_by`    as    split_by
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_pro_ods_object_metadata'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_pro_ods_object_metadata;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_blob_triggers
select
`sched_name`    as    sched_name,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`blob_data`    as    blob_data
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_blob_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_blob_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_calendars
select
`sched_name`    as    sched_name,
`calendar_name`    as    calendar_name,
`calendar`    as    calendar
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_calendars'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_calendars;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_cron_triggers
select
`sched_name`    as    sched_name,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`cron_expression`    as    cron_expression,
`time_zone_id`    as    time_zone_id
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_cron_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_cron_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_fired_triggers
select
`sched_name`    as    sched_name,
`job_name`    as    job_name,
`job_group`    as    job_group,
`is_nonconcurrent`    as    is_nonconcurrent,
`requests_recovery`    as    requests_recovery,
`entry_id`    as    entry_id,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`instance_name`    as    instance_name,
`fired_time`    as    fired_time,
`sched_time`    as    sched_time,
`priority`    as    priority,
`state`    as    state
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_fired_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_fired_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_job_details
select
`sched_name`    as    sched_name,
`job_data`    as    job_data,
`job_name`    as    job_name,
`job_group`    as    job_group,
`description`    as    description,
`job_class_name`    as    job_class_name,
`is_durable`    as    is_durable,
`is_nonconcurrent`    as    is_nonconcurrent,
`is_update_data`    as    is_update_data,
`requests_recovery`    as    requests_recovery
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_job_details'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_job_details;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_locks
select
`sched_name`    as    sched_name,
`lock_name`    as    lock_name
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_locks'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_locks;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_paused_trigger_grps
select
`sched_name`    as    sched_name,
`trigger_group`    as    trigger_group
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_paused_trigger_grps'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_paused_trigger_grps;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_scheduler_state
select
`sched_name`    as    sched_name,
`instance_name`    as    instance_name,
`last_checkin_time`    as    last_checkin_time,
`checkin_interval`    as    checkin_interval
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_scheduler_state'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_scheduler_state;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_simple_triggers
select
`sched_name`    as    sched_name,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`repeat_count`    as    repeat_count,
`repeat_interval`    as    repeat_interval,
`times_triggered`    as    times_triggered
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_simple_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_simple_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_simprop_triggers
select
`sched_name`    as    sched_name,
`long_prop_2`    as    long_prop_2,
`dec_prop_1`    as    dec_prop_1,
`dec_prop_2`    as    dec_prop_2,
`bool_prop_1`    as    bool_prop_1,
`bool_prop_2`    as    bool_prop_2,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`str_prop_1`    as    str_prop_1,
`str_prop_2`    as    str_prop_2,
`str_prop_3`    as    str_prop_3,
`int_prop_1`    as    int_prop_1,
`int_prop_2`    as    int_prop_2,
`long_prop_1`    as    long_prop_1
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_simprop_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_simprop_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_qrtz_triggers
select
`sched_name`    as    sched_name,
`trigger_state`    as    trigger_state,
`trigger_type`    as    trigger_type,
`start_time`    as    start_time,
`end_time`    as    end_time,
`calendar_name`    as    calendar_name,
`misfire_instr`    as    misfire_instr,
`job_data`    as    job_data,
`trigger_name`    as    trigger_name,
`trigger_group`    as    trigger_group,
`job_name`    as    job_name,
`job_group`    as    job_group,
`description`    as    description,
`next_fire_time`    as    next_fire_time,
`prev_fire_time`    as    prev_fire_time,
`priority`    as    priority
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_qrtz_triggers'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_qrtz_triggers;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_script_store
select
`id`    as    id,
`unique_name`    as    unique_name,
`hive_ddl`    as    hive_ddl,
`increment_script`    as    increment_script,
`db_env`    as    db_env
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_script_store'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_script_store;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_source_object_info
select
`id`    as    id,
`meta_data_status`    as    meta_data_status,
`db_env`    as    db_env,
`create_dt`    as    create_dt,
`create_by`    as    create_by,
`pic`    as    pic,
`develop_status`    as    develop_status,
`level`    as    level,
`object_name`    as    object_name,
`database_type`    as    database_type,
`sys_abbreviation`    as    sys_abbreviation,
`unique_name`    as    unique_name,
`owner`    as    owner,
`object_type`    as    object_type,
`data_volume`    as    data_volume
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_source_object_info'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_source_object_info;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_source_object_list
select
`source_object_id`    as    source_object_id,
`level`    as    level,
`database_type`    as    database_type,
`sys_abbreviation`    as    sys_abbreviation,
`object_name`    as    object_name,
`unique_name`    as    unique_name,
`owner`    as    owner,
`object_type`    as    object_type,
`create_dt`    as    create_dt
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_source_object_list'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_source_object_list;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_source_object_metadata
select
`id`    as    id,
`meta_data_status`    as    meta_data_status,
`db_env`    as    db_env,
`create_dt`    as    create_dt,
`create_by`    as    create_by,
`pic`    as    pic,
`develop_status`    as    develop_status,
`object_id`    as    object_id,
`object_name`    as    object_name,
`database_type`    as    database_type,
`sys_abbreviation`    as    sys_abbreviation,
`unique_name`    as    unique_name,
`owner`    as    owner,
`object_type`    as    object_type,
`data_volume`    as    data_volume
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_source_object_metadata'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_source_object_metadata;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_source_structure
select
`unique_name`    as    unique_name,
`ordinal_position`    as    ordinal_position,
`level`    as    level,
`column_name`    as    column_name,
`column_type`    as    column_type,
`data_length`    as    data_length,
`data_precision`    as    data_precision,
`data_scale`    as    data_scale,
`is_nullable`    as    is_nullable,
`comment`    as    comment,
`constraint_name`    as    constraint_name
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_source_structure'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_source_structure;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_sys_info
select
`id`    as    id,
`jdbc_url`    as    jdbc_url,
`db_username`    as    db_username,
`db_password`    as    db_password,
`etl_time`    as    etl_time,
`sys_type`    as    sys_type,
`sys_abbreviation`    as    sys_abbreviation,
`sys_name`    as    sys_name,
`sid`    as    sid,
`queue`    as    queue,
`database_version`    as    database_version,
`database_type`    as    database_type,
`ip`    as    ip,
`port`    as    port
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_sys_info'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_sys_info;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_task_monitor
select
`id`    as    id,
`check_time`    as    check_time,
`job_status`    as    job_status,
`count`    as    count
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_task_monitor'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_task_monitor;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_test_object_structure
select
`database`    as    database,
`sys_abbreviation`    as    sys_abbreviation,
`object_name`    as    object_name,
`unique_name`    as    unique_name,
`col_name`    as    col_name,
`col_type`    as    col_type,
`partition_key`    as    partition_key
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_test_object_structure'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_test_object_structure;


set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
set hive.exec.max.dynamic.partitions.pernode = 10000;
insert overwrite table acquisition_dw.d_nct_surgingdb_work_list
select
`id`    as    id,
`increment_column`    as    increment_column,
`split_column`    as    split_column,
`extract_type`    as    extract_type,
`init_script`    as    init_script,
`init_big_script`    as    init_big_script,
`full_script`    as    full_script,
`increment_script`    as    increment_script,
`table_ddl`    as    table_ddl,
`last_update_date`    as    last_update_date,
`object_name`    as    object_name,
`sys_info_id`    as    sys_info_id,
`developer_id`    as    developer_id,
`develop_status`    as    develop_status,
`plan_develop_time`    as    plan_develop_time,
`object_type`    as    object_type,
`schema`    as    schema,
`big_table`    as    big_table
`row_id`    as src_sys_row_id,
'mlgx'    as src_sys_cd,
'mlgx_work_list'    as src_table_name,
cast( current_timestamp() as string)    as etl_dt,
cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,
`data_dt`    as partition_key
from acquisition_ods.mlgx_work_list;


