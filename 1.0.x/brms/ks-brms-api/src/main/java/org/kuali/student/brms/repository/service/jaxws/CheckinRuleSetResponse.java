
package org.kuali.student.brms.repository.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Mon Jul 13 20:53:46 PDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "checkinRuleSetResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleRepository")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkinRuleSetResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleRepository")

public class CheckinRuleSetResponse {

    @XmlElement(name = "return")
    private long _return;

    public long getReturn() {
        return this._return;
    }

    public void setReturn(long new_return)  {
        this._return = new_return;
    }

}

