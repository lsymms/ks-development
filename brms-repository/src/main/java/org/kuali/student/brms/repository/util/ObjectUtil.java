/*
 * Copyright 2007 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.brms.repository.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This is an object utility class. 
 * 
 * @author Kuali Student Team (len.kuali@googlegroups.com)
 *
 */
public class ObjectUtil {

    /**
     * Private constructor.
     */
    private ObjectUtil() {
    }

    /**
     * Creates a deep copy of an object by serialization.
     * 
     * @param object object to do a deep copy of
     * @return A copy of <code>object</code>
     * @throws Exception
     */
    public static Object deepCopy( final Serializable object ) throws Exception {
        if ( object == null ) {
            throw new IllegalArgumentException( "object cannot be null" );
        }
        
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // Serialize the object
            oos.writeObject( object );
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            // Return the new object
            return ois.readObject();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }
}
