package org.kuali.student.core.dictionary.poc.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class FieldDefinition extends Constraint {
	// name (used in the path to identify this field within an object structure)
	protected String name;

	// Datatypes
	protected DataType dataType;// SHould be
								// DATE,STRING,INTEGER,BOOLEAN,COMPLEX,...
	protected ObjectStructureDefinition dataObjectStructure;

	//Dynamic attribute flag (SG wanted incase user typos the field name and all of a sudden all fields are attributes)
	protected boolean dynamic;
	
	// Default values
	protected Object defaultValue;// Set the default value
	protected String defaultValuePath;// obtain the default value from another
										// field? how will this work? some
										// xpath-like syntax which might be able
										// to access elements above this element
										// like the //root/course/desc

	// AuthZ
//	protected WriteAccess writeAccess; // Can we replace readOnly with the
//										// writeaccess? a writeAccess of never
//										// is readOnly=true, otherwise oncreate,
//										// when null, required will imply
//										// readOnly=false
	boolean readOnly = false;
	boolean hide = false;
	boolean mask = false;
	boolean partialMask = false;
	String partialMaskFormatter;//Regex replace to do a partial mask  
	String maskFormatter;//Regex replace to do a mask
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public ObjectStructureDefinition getDataObjectStructure() {
		return dataObjectStructure;
	}
	public void setDataObjectStructure(ObjectStructureDefinition dataObjectStructure) {
		this.dataObjectStructure = dataObjectStructure;
	}
	public Object getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDefaultValuePath() {
		return defaultValuePath;
	}
	public void setDefaultValuePath(String defaultValuePath) {
		this.defaultValuePath = defaultValuePath;
	}
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	public boolean isHide() {
		return hide;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	public boolean isMask() {
		return mask;
	}
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	public boolean isPartialMask() {
		return partialMask;
	}
	public void setPartialMask(boolean partialMask) {
		this.partialMask = partialMask;
	}

	public boolean isDynamic() {
		return dynamic;
	}
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}
	public String getPartialMaskFormatter() {
		return partialMaskFormatter;
	}
	public void setPartialMaskFormatter(String partialMaskFormatter) {
		this.partialMaskFormatter = partialMaskFormatter;
	}
	public String getMaskFormatter() {
		return maskFormatter;
	}
	public void setMaskFormatter(String maskFormatter) {
		this.maskFormatter = maskFormatter;
	}
}