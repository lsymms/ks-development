
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.4
 * Tue Feb 24 12:25:30 EST 2009
 * Generated source version: 2.1.4
 */

@XmlRootElement(name = "getLrScaleTypesForClu", namespace = "http://student.kuali.org/lum/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLrScaleTypesForClu", namespace = "http://student.kuali.org/lum/lu", propOrder = {"cluId","lrTypeKey"})

public class GetLrScaleTypesForClu {

    @XmlElement(name = "cluId")
    private java.lang.String cluId;
    @XmlElement(name = "lrTypeKey")
    private java.lang.String lrTypeKey;

    public java.lang.String getCluId() {
        return this.cluId;
    }

    public void setCluId(java.lang.String newCluId)  {
        this.cluId = newCluId;
    }

    public java.lang.String getLrTypeKey() {
        return this.lrTypeKey;
    }

    public void setLrTypeKey(java.lang.String newLrTypeKey)  {
        this.lrTypeKey = newLrTypeKey;
    }

}

