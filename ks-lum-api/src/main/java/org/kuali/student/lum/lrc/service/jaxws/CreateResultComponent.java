
package org.kuali.student.lum.lrc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed Apr 22 09:59:25 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "createResultComponent", namespace = "http://student.kuali.org/lum/lrc")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createResultComponent", namespace = "http://student.kuali.org/lum/lrc", propOrder = {"resultComponentTypeKey","resultComponentInfo"})

public class CreateResultComponent {

    @XmlElement(name = "resultComponentTypeKey")
    private java.lang.String resultComponentTypeKey;
    @XmlElement(name = "resultComponentInfo")
    private org.kuali.student.lum.lrc.dto.ResultComponentInfo resultComponentInfo;

    public java.lang.String getResultComponentTypeKey() {
        return this.resultComponentTypeKey;
    }

    public void setResultComponentTypeKey(java.lang.String newResultComponentTypeKey)  {
        this.resultComponentTypeKey = newResultComponentTypeKey;
    }

    public org.kuali.student.lum.lrc.dto.ResultComponentInfo getResultComponentInfo() {
        return this.resultComponentInfo;
    }

    public void setResultComponentInfo(org.kuali.student.lum.lrc.dto.ResultComponentInfo newResultComponentInfo)  {
        this.resultComponentInfo = newResultComponentInfo;
    }

}

