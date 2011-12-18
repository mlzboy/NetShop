package com.lexus.bean;
// Generated by MyEclipse - Hibernate Tools

import java.util.Date;
import java.util.Set;


/**
 * DictionaryLib generated by MyEclipse - Hibernate Tools
 */
public class DictionaryLib extends AbstractDictionaryLib implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
    public DictionaryLib() {
    }

	/** minimal constructor */
    public DictionaryLib(Dictionary dictionary, String name) {
        super(dictionary, name);        
    }
    
    /** full constructor */
    public DictionaryLib(DictionaryLib dictionaryLib, Dictionary dictionary, String name, String description, Integer sequence, Short depth, Date checkinTime, Date updateTime, Short version, String status, Set attachmentsForExtendName, Set attachmentsForAttachmentType, Set dictionaryLibs) {
        super(dictionaryLib, dictionary, name, description, sequence, depth, checkinTime, updateTime, version, status, attachmentsForExtendName, attachmentsForAttachmentType, dictionaryLibs);        
    }
   
}