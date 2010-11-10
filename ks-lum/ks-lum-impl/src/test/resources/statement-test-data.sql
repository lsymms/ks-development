--
-- Copyright 2010 The Kuali Foundation Licensed under the
-- Educational Community License, Version 2.0 (the "License"); you may
-- not use this file except in compliance with the License. You may
-- obtain a copy of the License at
--
-- http://www.osedu.org/licenses/ECL-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an "AS IS"
-- BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
-- or implied. See the License for the specific language governing
-- permissions and limitations under the License.
--

// Natural Language Translation Test Data

// Type Configuration
INSERT INTO KSST_REQ_COM_TYPE (TYPE_KEY, NAME, TYPE_DESC, EFF_DT, EXPIR_DT, VER_NBR) VALUES ('kuali.reqComponent.type.test', 'None of required courses', 'Must completed all courses from <org>', null, null, 0)

// 'kuali.reqComponent.field.type.org.id' is used in class 'org.kuali.student.lum.statement.config.context.OrganizationContextImpl'
INSERT INTO KSST_REQ_COM_FIELD_TYPE (ID, NAME, DESCR, DATA_TYPE, MIN_VALUE, MAX_VALUE, MIN_LENGTH, MAX_LENGTH, VALID_CHARS, INVALID_CHARS, MIN_OCCURS, MAX_OCCURS, READ_ONLY, VER_NBR) VALUES ('kuali.reqComponent.field.type.org.id', 'Organization Id', 'Organization identifier', 'string', null,null,null,null,null,null,null,null, 0, 0)

INSERT INTO KSST_RCTYP_JN_RCFLDTYP (REQ_COMP_TYPE_ID,REQ_COMP_FIELD_TYPE_ID) VALUES ('kuali.reqComponent.type.test', 'kuali.reqComponent.field.type.org.id')

INSERT INTO KSST_NL_USAGE_TYPE (TYPE_KEY, TYPE_DESC, NAME, EFF_DT, EXPIR_DT, VER_NBR) VALUES ('KUALI.RULE', 'Kuali Rule Edit', 'Rule Edit', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 0)
INSERT INTO KSST_REQ_COM_TYPE_NL_TMPL (ID, NL_USUAGE_TYPE_KEY, TEMPLATE, OWNER, LANGUAGE, VER_NBR) VALUES ('TEST-1', 'KUALI.RULE', 'Must completed all courses from $org.getLongName()', 'kuali.reqComponent.type.test', 'en', 0)

// Actual Data
INSERT INTO KSST_REQ_COM (ID, CREATEID, CREATETIME, UPDATEID, UPDATETIME, VER_NBR, RT_DESCR_ID, ST, EFF_DT, EXPIR_DT, REQ_COM_TYPE_ID) VALUES ('TEST-REQCOMP-1', 'CREATEID', null, 'UPDATEID', null, 1, null, 'ACTIVE', null, null, 'kuali.reqComponent.type.test')
INSERT INTO KSST_REQ_COM_FIELD (ID, REQ_COM_FIELD_TYPE, VALUE,VER_NBR) VALUES ('TEST-FIELD-1', 'kuali.reqComponent.field.type.org.id', '50',0)
INSERT INTO KSST_RC_JN_RC_FIELD (REQ_COM_ID, REQ_COM_FIELD_ID) VALUES ('TEST-REQCOMP-1', 'TEST-FIELD-1')
