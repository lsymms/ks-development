/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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

package org.kuali.student.common.util.security;

import org.kuali.rice.kim.KimAuthenticationProvider;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

public class SecurityUtils {
	public static String getCurrentUserId() {
        String username=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
        	Object obj = auth.getPrincipal();
        	if(obj instanceof KimAuthenticationProvider.UserWithId){
        		//This is actually the user Id
        		username = ((KimAuthenticationProvider.UserWithId)obj).getUserId();
        	}else if (obj instanceof UserDetails) {
            	username = ((UserDetails)obj).getUsername();
            } else {
            	username = obj.toString();
            }
        }
		return username;
	}
}
