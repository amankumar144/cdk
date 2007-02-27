/* $Revision: 7691 $ $Author: egonw $ $Date: 2007-01-11 12:47:48 +0100 (Thu, 11 Jan 2007) $
 * 
 * Copyright (C) 2007  Egon Willighagen <egonw@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA. 
 */
package org.openscience.cdk.test.validate;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openscience.cdk.ChemObject;
import org.openscience.cdk.interfaces.IChemObject;
import org.openscience.cdk.test.CDKTestCase;
import org.openscience.cdk.validate.ProblemMarker;

/**
 * @cdk.module test-standard
 */
public class ProblemMarkerTest extends CDKTestCase {
    
    public ProblemMarkerTest(String name) {
        super(name);
    }
    
	public static Test suite() {
		return new TestSuite(ProblemMarkerTest.class);
	}

	public void testUnmarkWithError_IChemObject() {
		IChemObject object = new ChemObject();
		assertNull(object.getProperty(ProblemMarker.ERROR_MARKER));
		ProblemMarker.markWithError(object);
		assertNotNull(object.getProperty(ProblemMarker.ERROR_MARKER));
		ProblemMarker.unmarkWithError(object);
		assertNull(object.getProperty(ProblemMarker.ERROR_MARKER));
	}
	
	public void testUnmarkWithWarning_IChemObject() {
		IChemObject object = new ChemObject();
		assertNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		ProblemMarker.markWithWarning(object);
		assertNotNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		ProblemMarker.unmarkWithWarning(object);
		assertNull(object.getProperty(ProblemMarker.WARNING_MARKER));
	}
	
	public void testUnmark_IChemObject() {
		IChemObject object = new ChemObject();
		assertNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		ProblemMarker.markWithWarning(object);
		assertNotNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		ProblemMarker.markWithError(object);
		assertNotNull(object.getProperty(ProblemMarker.ERROR_MARKER));
		ProblemMarker.unmark(object);
		assertNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		assertNull(object.getProperty(ProblemMarker.ERROR_MARKER));
	}
	
	public void testMarkWithError_IChemObject() {
		IChemObject object = new ChemObject();
		assertNull(object.getProperty(ProblemMarker.ERROR_MARKER));
		ProblemMarker.markWithError(object);
		assertNotNull(object.getProperty(ProblemMarker.ERROR_MARKER));
	}
	
	public void testMarkWithWarning_IChemObject() {
		IChemObject object = new ChemObject();
		assertNull(object.getProperty(ProblemMarker.WARNING_MARKER));
		ProblemMarker.markWithWarning(object);
		assertNotNull(object.getProperty(ProblemMarker.WARNING_MARKER));
	}
	
}


