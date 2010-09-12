
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 10:05:23 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "updateCluCluRelation", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCluCluRelation", namespace = "http://student.kuali.org/wsdl/lu", propOrder = {"cluCluRelationId","cluCluRelationInfo"})

public class UpdateCluCluRelation {

    @XmlElement(name = "cluCluRelationId")
    private java.lang.String cluCluRelationId;
    @XmlElement(name = "cluCluRelationInfo")
    private org.kuali.student.lum.lu.dto.CluCluRelationInfo cluCluRelationInfo;

    public java.lang.String getCluCluRelationId() {
        return this.cluCluRelationId;
    }

    public void setCluCluRelationId(java.lang.String newCluCluRelationId)  {
        this.cluCluRelationId = newCluCluRelationId;
    }

    public org.kuali.student.lum.lu.dto.CluCluRelationInfo getCluCluRelationInfo() {
        return this.cluCluRelationInfo;
    }

    public void setCluCluRelationInfo(org.kuali.student.lum.lu.dto.CluCluRelationInfo newCluCluRelationInfo)  {
        this.cluCluRelationInfo = newCluCluRelationInfo;
    }

}

