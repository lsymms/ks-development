
package org.kuali.student.poc.personidentity.person.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by the CXF 2.0.4-incubator
 * Thu Mar 27 11:42:25 EDT 2008
 * Generated source version: 2.0.4-incubator
 * 
 */

@XmlRootElement(name = "updatePerson", namespace = "http://student.kuali.org/poc/wsdl/personidentity/person/service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePerson", namespace = "http://student.kuali.org/poc/wsdl/personidentity/person/service")

public class UpdatePerson {

    @XmlElement(name = "personId")
    private java.lang.String personId;
    @XmlElement(name = "personUpdateInfo")
    private org.kuali.student.poc.personidentity.person.dto.PersonUpdateInfo personUpdateInfo;

    public java.lang.String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId( java.lang.String newPersonId ) {
        this.personId = newPersonId;
    }
    
    public org.kuali.student.poc.personidentity.person.dto.PersonUpdateInfo getPersonUpdateInfo() {
        return this.personUpdateInfo;
    }
    
    public void setPersonUpdateInfo( org.kuali.student.poc.personidentity.person.dto.PersonUpdateInfo newPersonUpdateInfo ) {
        this.personUpdateInfo = newPersonUpdateInfo;
    }
    
}

