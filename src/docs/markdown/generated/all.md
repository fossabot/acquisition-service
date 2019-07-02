# 采集系统的API文档


<a name="overview"></a>
## 概览
描述：伊利采集系统官方API


### 版本信息
*版本* : 1.0


### URI scheme
*域名* : localhost:6269  
*基础路径* : /


### 标签

* datalake-table-status-contrller : Datalake Table Status Contrller
* enterHuOverview : 入湖总览
* export-script-controller : 初始化ODS/DW脚本导出
* generate-script-controller : ods/dw脚本生成页面
* getSourceMetaData : 初始化业务元数据
* hiveCreateTable : hive建表
* kafka-test-controller : Kafka Test Controller




<a name="paths"></a>
## 资源

<a name="datalake-table-status-contrller_resource"></a>
### Datalake-table-status-contrller
Datalake Table Status Contrller


<a name="exportexcleusingpost"></a>
#### exportExcle
```
POST /tableStatus/exportExcle
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**dataList**  <br>*必填*|dataList|< [ExclePropertyModel](#exclepropertymodel) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/tableStatus/exportExcle
```


###### 请求 body
```
json :
[ {
  "businessSystemNameShortName" : "string",
  "dataSourceSchema" : "string",
  "date" : "string",
  "dwCount" : "string",
  "odsCount" : "string",
  "tableCount" : "string"
} ]
```


<a name="getstatusbysysusingpost"></a>
#### getStatusBySys
```
POST /tableStatus/getStatusBySys
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[PageGeorge<T>«CjDataSourceTabInfo»](#4a9fcd93d7736708c93e006f933f578c)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/tableStatus/getStatusBySys
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : {
    "businessSystemId" : "string",
    "businessSystemNameShortName" : "string",
    "dataFlagForCrtDwDll" : "string",
    "dataFlagForCrtDwHive" : "string",
    "dataFlagForCrtDwScript" : "string",
    "dataFlagForCrtOdsDll" : "string",
    "dataFlagForCrtOdsHive" : "string",
    "dataFlagForCrtOdsScript" : "string",
    "dataFlagForGetCols" : "string",
    "dataFlagForGetRows" : "string",
    "dataSourceSchema" : "string",
    "dataSourceTable" : "string",
    "dataSourceTableComment" : "string",
    "date" : "string",
    "dwCount" : "string",
    "lastModifyBy" : "string",
    "lastModifyDt" : "string",
    "odsCount" : "string",
    "tableCount" : "string"
  }
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getstatuslistusingget"></a>
#### getStatusList
```
GET /tableStatus/getStatusList
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**pagenum**  <br>*可选*|integer (int32)|
|**Query**|**pagesize**  <br>*可选*|integer (int32)|
|**Query**|**query**  <br>*可选*|< string > array(multi)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/tableStatus/getStatusList
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getsyslistusingget"></a>
#### getSysList
```
GET /tableStatus/getSysList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/tableStatus/getSysList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="enterhuoverview_resource"></a>
### EnterHuOverview
入湖总览


<a name="selectbytableusingget"></a>
#### 根据表名获取表的详细信息
```
GET /enterHuOverview/getByTableInfo
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**schema**  <br>*必填*|schema|[String](#string)|
|**Body**|**systemname**  <br>*必填*|系统名|[String](#string)|
|**Body**|**tablename**  <br>*必填*|表名|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/enterHuOverview/getByTableInfo
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getschemausingget"></a>
####  获取去重的Schema
```
GET /enterHuOverview/getSchema
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**systemname**  <br>*必填*|系统名|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/enterHuOverview/getSchema
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getsysnameandschemaandtablenameusingget"></a>
#### 获取表信息列表
```
GET /enterHuOverview/getSysNameAndSchemaAndTableName
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**pagenum**  <br>*必填*|当前页数|integer (int32)|
|**Query**|**pagesize**  <br>*必填*|页面大小|integer (int32)|
|**Query**|**query**  <br>*必填*|数据|object|
|**Body**|**schema**  <br>*可选*|schema|[String](#string)|
|**Body**|**systemname**  <br>*可选*|系统名|[String](#string)|
|**Body**|**tablename**  <br>*可选*|表明|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/enterHuOverview/getSysNameAndSchemaAndTableName
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "object"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getsystemnameusingget"></a>
####  获取去重的SystemName
```
GET /enterHuOverview/getSystemName
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/enterHuOverview/getSystemName
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="export-script-controller_resource"></a>
### Export-script-controller
初始化ODS/DW脚本导出


<a name="exportdwscriptusingget"></a>
#### 导出dw脚本
```
GET /exportScript/exportDwScript
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/exportDwScript
```


###### 请求 body
```
json :
{ }
```


<a name="exportodsscriptusingget"></a>
#### 导出ODS脚本
```
GET /exportScript/exportOdsScript
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/exportOdsScript
```


###### 请求 body
```
json :
{ }
```


<a name="getdwtablistusingget"></a>
#### 获取DW脚本导出清单
```
GET /exportScript/getDwTabList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**schema**  <br>*必填*|schema|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getDwTabList
```


###### 请求 query
```
json :
{
  "schema" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterlistusingget"></a>
#### getFilterList
```
GET /exportScript/getFilterList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**flag**  <br>*必填*|flag|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterList
```


###### 请求 query
```
json :
{
  "flag" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingpost"></a>
#### getFilterResults
```
POST /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingget"></a>
#### getFilterResults
```
GET /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingput"></a>
#### getFilterResults
```
PUT /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingdelete"></a>
#### getFilterResults
```
DELETE /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingpatch"></a>
#### getFilterResults
```
PATCH /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusinghead"></a>
#### getFilterResults
```
HEAD /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfilterresultsusingoptions"></a>
#### getFilterResults
```
OPTIONS /exportScript/getFilterResults
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getFilterResults
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodstablistusingget"></a>
#### 获取ODS脚本导出清单
```
GET /exportScript/getOdsTabList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**schema**  <br>*必填*|schema|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/exportScript/getOdsTabList
```


###### 请求 query
```
json :
{
  "schema" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="generate-script-controller_resource"></a>
### Generate-script-controller
ods/dw脚本生成页面


<a name="generatedwinitscriptusingpost"></a>
#### 生成dw初始化脚本
```
POST /generateScript/generateDwInitScript
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/generateDwInitScript
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="generatesqoopscriptusingpost"></a>
#### 生成ods初始化脚本
```
POST /generateScript/generateSqoopScript
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/generateSqoopScript
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwlistbyfilterusingpost"></a>
#### dw脚本生成页面按系统名筛选接口
```
POST /generateScript/getDwListByFilter
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[Page](#page)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getDwListByFilter
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : [ "string" ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwsystemfilterlistusingget"></a>
#### dw脚本生成页面获取筛选列表接口
```
GET /generateScript/getDwSystemFilterList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getDwSystemFilterList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwtablistusingget_1"></a>
#### 获取dw脚本生成页面表清单
```
GET /generateScript/getDwTabList
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**pagenum**  <br>*可选*|integer (int32)|
|**Query**|**pagesize**  <br>*可选*|integer (int32)|
|**Query**|**query**  <br>*可选*|< string > array(multi)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getDwTabList
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodstableinfousingget"></a>
#### 获取ods脚本生成页面表清单接口
```
GET /generateScript/getODSTableInfo
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**pagenum**  <br>*可选*|integer (int32)|
|**Query**|**pagesize**  <br>*可选*|integer (int32)|
|**Query**|**query**  <br>*可选*|< string > array(multi)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getODSTableInfo
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodslistbyfilterusingpost"></a>
#### ods脚本生成页面按系统名筛选接口
```
POST /generateScript/getOdsListByFilter
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[Page](#page)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getOdsListByFilter
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : [ "string" ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodssystemfilterlistusingget"></a>
#### ods脚本生成页面获取筛选列表接口
```
GET /generateScript/getOdsSystemFilterList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateScript/getOdsSystemFilterList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getsourcemetadata_resource"></a>
### GetSourceMetaData
初始化业务元数据


<a name="setstautsusingpost"></a>
#### 生成schema数据信息
```
POST /getSourceMetaData/getConnection
```


##### 说明
List<ViewSourceSystemEntity> 复杂对象


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**sourcesysteminfo**  <br>*必填*|sourcesysteminfo|< [ViewSourceSystemEntity](#viewsourcesystementity) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/json`
* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/getConnection
```


###### 请求 body
```
json :
[ {
  "business_system_ID" : "string",
  "business_system_name_short_name" : "string",
  "data_base_type" : "string",
  "status" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdatasourceinfousingget"></a>
#### 获取配置的参数
```
GET /getSourceMetaData/getDataInfo
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**pagenum**  <br>*必填*|当前页数|integer (int32)|
|**Query**|**pagesize**  <br>*必填*|页面大小|integer (int32)|
|**Query**|**query**  <br>*必填*|数据|object|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/getDataInfo
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "object"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getschemausingget_1"></a>
#### 获取 schema信息表
```
GET /getSourceMetaData/getSchema
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**pagenum**  <br>*必填*|当前页数|integer (int32)|
|**Query**|**pagesize**  <br>*必填*|页面大小|integer (int32)|
|**Query**|**query**  <br>*必填*|数据|object|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/getSchema
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "object"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdatainfobyfilterusingpost"></a>
#### 获取表及字段的查询
```
POST /getSourceMetaData/getSchemaByFilter
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[PageGeorge<T>«List«string»»](#2781b8276c5dfef0265e3b538d82ed91)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/getSchemaByFilter
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : [ "string" ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getsystemfilterlistusingget"></a>
#### 获取源系统数据模式
```
GET /getSourceMetaData/getSystemFilterList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/getSystemFilterList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="importingmetadatausingpost"></a>
#### 按schema导入元数据
```
POST /getSourceMetaData/importingMetadata
```


##### 说明
List<CjDataSourceSystemInfo> 复杂对象


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**sourcesysteminfo**  <br>*必填*|sourcesysteminfo|< [CjDataSourceSystemInfo](#cjdatasourcesysteminfo) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/json`
* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getSourceMetaData/importingMetadata
```


###### 请求 body
```
json :
[ {
  "businessSystemId" : "string",
  "businessSystemNameShortName" : "string",
  "dataSourceSchema" : "string",
  "lastModifyBy" : "string",
  "lastModifyDt" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="hivecreatetable_resource"></a>
### HiveCreateTable
hive建表


<a name="createodstableusingpost"></a>
#### ods建表接口
```
POST /hiveCreateTable/createODSTable
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/createODSTable
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="dwcreatetableusingpost"></a>
#### dw建表接口
```
POST /hiveCreateTable/dWCreateTable
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**data**  <br>*必填*|data|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/dWCreateTable
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwcreatetablistusingget"></a>
#### dw建表页面获取表清单接口
```
GET /hiveCreateTable/getDWCreateTabList
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**pagenum**  <br>*可选*|integer (int32)|
|**Query**|**pagesize**  <br>*可选*|integer (int32)|
|**Query**|**query**  <br>*可选*|< string > array(multi)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getDWCreateTabList
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwcreatetablistbyfilterusingpost"></a>
#### dw建表页面按系统名和schema筛选接口
```
POST /hiveCreateTable/getDWCreateTabListByFilter
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[PageGeorge<T>«List«string»»](#2781b8276c5dfef0265e3b538d82ed91)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getDWCreateTabListByFilter
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : [ "string" ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getdwsystemandschemafilterlistusingget"></a>
#### 获取dw建表页面的筛选列表
```
GET /hiveCreateTable/getDWSystemAndSchemaFilterList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getDWSystemAndSchemaFilterList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodscreatetablistbyfilterusingpost"></a>
#### ODS建表页面按系统名和schema筛选接口
```
POST /hiveCreateTable/getODSCreateTabListByFilter
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**reqParams**  <br>*必填*|reqParams|[Page](#page)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getODSCreateTabListByFilter
```


###### 请求 body
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : [ "string" ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodssystemandschemafilterlistusingget"></a>
#### 获取ods建表页面的筛选列表
```
GET /hiveCreateTable/getODSSystemAndSchemaFilterList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getODSSystemAndSchemaFilterList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getodstableusingget"></a>
#### ods建表页面获取表清单接口
```
GET /hiveCreateTable/getODSTableInfo
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**pagenum**  <br>*必填*|当前页数|integer (int32)|
|**Query**|**pagesize**  <br>*必填*|页面大小|integer (int32)|
|**Query**|**query**  <br>*必填*|数据|object|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/hiveCreateTable/getODSTableInfo
```


###### 请求 query
```
json :
{
  "pagenum" : 0,
  "pagesize" : 0,
  "query" : "object"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="kafka-test-controller_resource"></a>
### Kafka-test-controller
Kafka Test Controller


<a name="getdwsystemandschemafilterlistusingget_1"></a>
#### getDWSystemAndSchemaFilterList
```
GET /kafka/sender
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/kafka/sender
```




<a name="definitions"></a>
## 定义

<a name="cjdatasourcesysteminfo"></a>
### CjDataSourceSystemInfo

|名称|说明|类型|
|---|---|---|
|**businessSystemId**  <br>*可选*|**样例** : `"string"`|string|
|**businessSystemNameShortName**  <br>*可选*|**样例** : `"string"`|string|
|**dataSourceSchema**  <br>*可选*|**样例** : `"string"`|string|
|**lastModifyBy**  <br>*可选*|**样例** : `"string"`|string|
|**lastModifyDt**  <br>*可选*|**样例** : `"string"`|string|


<a name="cjdatasourcetabinfo"></a>
### CjDataSourceTabInfo

|名称|说明|类型|
|---|---|---|
|**businessSystemId**  <br>*可选*|**样例** : `"string"`|string|
|**businessSystemNameShortName**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtDwDll**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtDwHive**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtDwScript**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtOdsDll**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtOdsHive**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForCrtOdsScript**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForGetCols**  <br>*可选*|**样例** : `"string"`|string|
|**dataFlagForGetRows**  <br>*可选*|**样例** : `"string"`|string|
|**dataSourceSchema**  <br>*可选*|**样例** : `"string"`|string|
|**dataSourceTable**  <br>*可选*|**样例** : `"string"`|string|
|**dataSourceTableComment**  <br>*可选*|**样例** : `"string"`|string|
|**date**  <br>*可选*|**样例** : `"string"`|string|
|**dwCount**  <br>*可选*|**样例** : `"string"`|string|
|**lastModifyBy**  <br>*可选*|**样例** : `"string"`|string|
|**lastModifyDt**  <br>*可选*|**样例** : `"string"`|string|
|**odsCount**  <br>*可选*|**样例** : `"string"`|string|
|**tableCount**  <br>*可选*|**样例** : `"string"`|string|


<a name="exclepropertymodel"></a>
### ExclePropertyModel

|名称|说明|类型|
|---|---|---|
|**businessSystemNameShortName**  <br>*可选*|**样例** : `"string"`|string|
|**dataSourceSchema**  <br>*可选*|**样例** : `"string"`|string|
|**date**  <br>*可选*|**样例** : `"string"`|string|
|**dwCount**  <br>*可选*|**样例** : `"string"`|string|
|**odsCount**  <br>*可选*|**样例** : `"string"`|string|
|**tableCount**  <br>*可选*|**样例** : `"string"`|string|


<a name="page"></a>
### Page

|名称|说明|类型|
|---|---|---|
|**pagenum**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pagesize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**query**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|


<a name="4a9fcd93d7736708c93e006f933f578c"></a>
### PageGeorge<T>«CjDataSourceTabInfo»
page筛选对象


|名称|说明|类型|
|---|---|---|
|**pagenum**  <br>*必填*|当前页数  <br>**样例** : `0`|integer (int32)|
|**pagesize**  <br>*必填*|页面大小  <br>**样例** : `0`|integer (int32)|
|**query**  <br>*必填*|数据  <br>**样例** : `"[cjdatasourcetabinfo](#cjdatasourcetabinfo)"`|[CjDataSourceTabInfo](#cjdatasourcetabinfo)|


<a name="2781b8276c5dfef0265e3b538d82ed91"></a>
### PageGeorge<T>«List«string»»
page筛选对象


|名称|说明|类型|
|---|---|---|
|**pagenum**  <br>*必填*|当前页数  <br>**样例** : `0`|integer (int32)|
|**pagesize**  <br>*必填*|页面大小  <br>**样例** : `0`|integer (int32)|
|**query**  <br>*必填*|数据  <br>**样例** : `[ "string" ]`|< string > array|


<a name="result"></a>
### Result

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="viewsourcesystementity"></a>
### ViewSourceSystemEntity

|名称|说明|类型|
|---|---|---|
|**business_system_ID**  <br>*可选*|**样例** : `"string"`|string|
|**business_system_name_short_name**  <br>*可选*|**样例** : `"string"`|string|
|**data_base_type**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|





