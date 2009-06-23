package org.kuali.student.lum.lu.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class NLTranslationNodeInfo {
    @XmlAttribute
	private String id;

    @XmlAttribute
    private String referenceId;

    @XmlAttribute
    private String operator;

	@XmlElement
	private String booleanExpr;

    @XmlElement
	private String nlTranslation;

    @XmlElement
    private NLTranslationNodeInfo parentNode;

	@XmlElement
    private List<NLTranslationNodeInfo> childNodeList = new ArrayList<NLTranslationNodeInfo>();

	public NLTranslationNodeInfo() {
	}

	public NLTranslationNodeInfo(String id, String referenceId, String operator) {
		this.id = id;
		this.referenceId = referenceId;
		this.operator = operator;
	}

	public String getId() {
		return this.id;
	}

	public String getProperBooleanExpression() {
		return (this.booleanExpr == null ? null : this.booleanExpr.replaceAll("\\*", "and").replaceAll("\\+", "or"));
	}

	public String getBooleanExpression() {
		return this.booleanExpr;
	}

	public void setBooleanExpression(String booleanExpression) {
		this.booleanExpr = booleanExpression;
	}
	
	public String getOperator() {
		return this.operator;
	}

	public String getNLTranslation() {
		return this.nlTranslation;
	}
	
	public void setNLTranslation(String nlTranslation) {
		this.nlTranslation = nlTranslation;
	}
	
	public void addChildNode(NLTranslationNodeInfo child) {
		this.childNodeList.add(child);
	}
	
	public List<NLTranslationNodeInfo> getChildNodes() {
		return this.childNodeList;
	}
	
	public void setChildNodes(List<NLTranslationNodeInfo> children) {
		this.childNodeList = children;
	}

	public NLTranslationNodeInfo getParent() {
		return this.parentNode;
	}

	public void setParent(NLTranslationNodeInfo parent) {
		this.parentNode = parent;
	}

	public String getReferenceId() {
		return this.referenceId;
	}
	
	public String toString() {
		return "id="+this.id+", referenceId="+this.referenceId+", translation="+this.nlTranslation;
	}
}
