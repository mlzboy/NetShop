package com.lexus.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * AbstractDictionaryLib generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractDictionaryLib  implements java.io.Serializable {

	private int hashValue=0;
    // Fields    

     private Integer pkDictionaryLibId;
     //父类
     private DictionaryLib dictionaryLib;
     //关联的字典
     private Dictionary dictionary;
     private String name;
     private String description;
     private Integer sequence;
     private Short depth;
     private Date checkinTime;
     private Date updateTime;
     private Short version;
     private String status;
     private Set attachmentsForExtendName = new HashSet(0);
     private Set attachmentsForAttachmentType = new HashSet(0);
     //子类的集合
     private Set dictionaryLibs = new HashSet(0);


    // Constructors

    /** default constructor */
    public AbstractDictionaryLib() {
    }

	/** minimal constructor */
    public AbstractDictionaryLib(Dictionary dictionary, String name) {
        this.dictionary = dictionary;
        this.name = name;
    }
    
    /** full constructor */
    public AbstractDictionaryLib(DictionaryLib dictionaryLib, Dictionary dictionary, String name, String description, Integer sequence, Short depth, Date checkinTime, Date updateTime, Short version, String status, Set attachmentsForExtendName, Set attachmentsForAttachmentType, Set dictionaryLibs) {
        this.dictionaryLib = dictionaryLib;
        this.dictionary = dictionary;
        this.name = name;
        this.description = description;
        this.sequence = sequence;
        this.depth = depth;
        this.checkinTime = checkinTime;
        this.updateTime = updateTime;
        this.version = version;
        this.status = status;
        this.attachmentsForExtendName = attachmentsForExtendName;
        this.attachmentsForAttachmentType = attachmentsForAttachmentType;
        this.dictionaryLibs = dictionaryLibs;
    }

   
    // Property accessors

    public Integer getPkDictionaryLibId() {
        return this.pkDictionaryLibId;
    }
    
    public void setPkDictionaryLibId(Integer pkDictionaryLibId) {
        this.pkDictionaryLibId = pkDictionaryLibId;
    }

    public DictionaryLib getDictionaryLib() {
        return this.dictionaryLib;
    }
    
    public void setDictionaryLib(DictionaryLib dictionaryLib) {
        this.dictionaryLib = dictionaryLib;
    }

    public Dictionary getDictionary() {
        return this.dictionary;
    }
    
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSequence() {
        return this.sequence;
    }
    
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Short getDepth() {
        return this.depth;
    }
    
    public void setDepth(Short depth) {
        this.depth = depth;
    }

    public Date getCheckinTime() {
        return this.checkinTime;
    }
    
    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getVersion() {
        return this.version;
    }
    
    public void setVersion(Short version) {
        this.version = version;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Set getAttachmentsForExtendName() {
        return this.attachmentsForExtendName;
    }
    
    public void setAttachmentsForExtendName(Set attachmentsForExtendName) {
        this.attachmentsForExtendName = attachmentsForExtendName;
    }

    public Set getAttachmentsForAttachmentType() {
        return this.attachmentsForAttachmentType;
    }
    
    public void setAttachmentsForAttachmentType(Set attachmentsForAttachmentType) {
        this.attachmentsForAttachmentType = attachmentsForAttachmentType;
    }

    public Set getDictionaryLibs() {
        return this.dictionaryLibs;
    }
    
    public void setDictionaryLibs(Set dictionaryLibs) {
        this.dictionaryLibs = dictionaryLibs;
    }

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if(object==null)
			return false;
		if (!(object instanceof AbstractDictionaryLib)) {
			return false;
		}
		DictionaryLib that= (DictionaryLib) object;
		if(this.getPkDictionaryLibId()==null||that.getPkDictionaryLibId()==null)
			return false;
		return this.getPkDictionaryLibId().equals(that.getPkDictionaryLibId());
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if(this.hashValue==0)
		{
			int result=17;
			int idValue=this.getPkDictionaryLibId()==null?0:this.getPkDictionaryLibId().hashCode();
			result=result*37+idValue;
			this.hashValue=result;
		}
		return this.hashValue;
	}
   








}