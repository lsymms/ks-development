
package org.kuali.student.lum.lo.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Feb 19 15:17:58 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getLoCategoryType", namespace = "http://student.kuali.org/wsdl/lo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLoCategoryType", namespace = "http://student.kuali.org/wsdl/lo")

public class GetLoCategoryType {

    @XmlElement(name = "loCategoryTypeKey")
    private java.lang.String loCategoryTypeKey;

    public java.lang.String getLoCategoryTypeKey() {
        return this.loCategoryTypeKey;
    }

    public void setLoCategoryTypeKey(java.lang.String newLoCategoryTypeKey)  {
        this.loCategoryTypeKey = newLoCategoryTypeKey;
    }

}

