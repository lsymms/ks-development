/*
 * Copyright 2009 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.core.comment.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Jun 05 15:33:47 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "removeTag", namespace = "http://student.kuali.org/wsdl/commentService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeTag", namespace = "http://student.kuali.org/wsdl/commentService", propOrder = {"tagId","referenceId","referenceTypeKey"})

public class RemoveTag {

    @XmlElement(name = "tagId")
    private java.lang.String tagId;
    @XmlElement(name = "referenceId")
    private java.lang.String referenceId;
    @XmlElement(name = "referenceTypeKey")
    private java.lang.String referenceTypeKey;

    public java.lang.String getTagId() {
        return this.tagId;
    }

    public void setTagId(java.lang.String newTagId)  {
        this.tagId = newTagId;
    }

    public java.lang.String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(java.lang.String newReferenceId)  {
        this.referenceId = newReferenceId;
    }

    public java.lang.String getReferenceTypeKey() {
        return this.referenceTypeKey;
    }

    public void setReferenceTypeKey(java.lang.String newReferenceTypeKey)  {
        this.referenceTypeKey = newReferenceTypeKey;
    }

}

