
package org.kuali.student.rules.rulemanagement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.2
 * Fri Nov 14 10:07:45 EST 2008
 * Generated source version: 2.1.2
 */

@XmlRootElement(name = "findAnchorsByAnchorType", namespace = "http://student.kuali.org/poc/wsdl/brms/rulemanagement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAnchorsByAnchorType", namespace = "http://student.kuali.org/poc/wsdl/brms/rulemanagement")

public class FindAnchorsByAnchorType {

    @XmlElement(name = "anchorTypeKey")
    private java.lang.String anchorTypeKey;

    public java.lang.String getAnchorTypeKey() {
        return this.anchorTypeKey;
    }

    public void setAnchorTypeKey(java.lang.String newAnchorTypeKey)  {
        this.anchorTypeKey = newAnchorTypeKey;
    }

}

