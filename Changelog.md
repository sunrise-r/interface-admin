### Last changes from 2019/12/06

* Added inheritable String actionUrl field to form projection 

### Last changes from 2019/11/22 

* Added inheritable defaultSortOrder and defaultSortField to list projections

### Last changes from 2019/11/15

* serializable interface added to DTO 

### Last changes from 2019/09/16
* Added "defaultValue" property to dataProjection and dataProjectionDTO
* Added "datasourcePath" property to dataProjection and dataProjectionDTO
* Added inheritance to formProjection from and dataProjection and to formProjectionDTO from dataProjectionDTO. They both have same fields and may behave identically in some cases; It may help to make projection fields identical in the future.

### Last changes from 2019/09/05
* Added "infoUrl" property to listProjection and listProjectionDTO
* Added inheritance for "infoUrl"