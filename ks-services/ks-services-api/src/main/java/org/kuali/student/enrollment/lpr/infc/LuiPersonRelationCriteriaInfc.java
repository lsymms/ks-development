/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.enrollment.lpr.infc;

//import com.sun.xml.internal.bind.AnyTypeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@XmlJavaTypeAdapter(AnyTypeAdapter.class)
@XmlAccessorType(XmlAccessType.PROPERTY)
public interface LuiPersonRelationCriteriaInfc {

    /**
     * Set ????
     * <p/>
     * Type: String
     * <p/>
     * Name: Field
     * Dot path notation to identity the name of field to be compared
     */
    public void setFieldKey(String fieldKey);

    /**
     * Get ????
     * <p/>
     * Type: String
     * <p/>
     * Name: Field
     * Dot path notation to identity the name of field to be compared
     */
    public String getFieldKey();

    /**
     * Set ????
     * <p/>
     * Type: String
     * <p/>
     * Name: Criteria
     * Value to be compared
     */
    public void setValue(String value);

    /**
     * Get ????
     * <p/>
     * Type: String
     * <p/>
     * Name: Criteria
     * Value to be compared
     */
    public String getValue();
}

