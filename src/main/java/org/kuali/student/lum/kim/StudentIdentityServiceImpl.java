/**
 * 
 */
package org.kuali.student.lum.kim;

import java.security.GeneralSecurityException;

import org.kuali.rice.kim.bo.entity.dto.KimPrincipalInfo;
import org.kuali.rice.kim.service.impl.IdentityServiceImpl;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.kns.service.impl.DocumentServiceImpl;

/**
 * This service override is used to facilitate a fix to the encrypted passwords in the
 * Rice database.
 * 
 * @author delyea
 *
 */
public class StudentIdentityServiceImpl extends IdentityServiceImpl {
    private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(DocumentServiceImpl.class);

	/* (non-Javadoc)
	 * @see org.kuali.rice.kim.service.impl.IdentityServiceImpl#getPrincipalByPrincipalNameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public KimPrincipalInfo getPrincipalByPrincipalNameAndPassword(String principalName, String password) {
		try {
			return super.getPrincipalByPrincipalNameAndPassword(principalName, KNSServiceLocator.getEncryptionService().encrypt(password));
		} catch (GeneralSecurityException e) {
			String message = "Caught Exception attempting to encrypt password (with length " + password.length() + ") for principalName: " + principalName;
			LOG.error(message, e);
			throw new RuntimeException(e);
		}
	}

}
