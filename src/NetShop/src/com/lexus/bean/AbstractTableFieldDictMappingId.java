package com.lexus.bean;



/**
 * AbstractTableFieldDictMappingId generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractTableFieldDictMappingId  implements java.io.Serializable {


    // Fields    

     private Integer pkFkTableNameId;
     private Integer pkFkFieldNameId;


    // Constructors

    /** default constructor */
    public AbstractTableFieldDictMappingId() {
    }

    
    /** full constructor */
    public AbstractTableFieldDictMappingId(Integer pkFkTableNameId, Integer pkFkFieldNameId) {
        this.pkFkTableNameId = pkFkTableNameId;
        this.pkFkFieldNameId = pkFkFieldNameId;
    }

   
    // Property accessors

    public Integer getPkFkTableNameId() {
        return this.pkFkTableNameId;
    }
    
    public void setPkFkTableNameId(Integer pkFkTableNameId) {
        this.pkFkTableNameId = pkFkTableNameId;
    }

    public Integer getPkFkFieldNameId() {
        return this.pkFkFieldNameId;
    }
    
    public void setPkFkFieldNameId(Integer pkFkFieldNameId) {
        this.pkFkFieldNameId = pkFkFieldNameId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AbstractTableFieldDictMappingId) ) return false;
		 AbstractTableFieldDictMappingId castOther = ( AbstractTableFieldDictMappingId ) other; 
         
		 return ( (this.getPkFkTableNameId()==castOther.getPkFkTableNameId()) || ( this.getPkFkTableNameId()!=null && castOther.getPkFkTableNameId()!=null && this.getPkFkTableNameId().equals(castOther.getPkFkTableNameId()) ) )
 && ( (this.getPkFkFieldNameId()==castOther.getPkFkFieldNameId()) || ( this.getPkFkFieldNameId()!=null && castOther.getPkFkFieldNameId()!=null && this.getPkFkFieldNameId().equals(castOther.getPkFkFieldNameId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPkFkTableNameId() == null ? 0 : this.getPkFkTableNameId().hashCode() );
         result = 37 * result + ( getPkFkFieldNameId() == null ? 0 : this.getPkFkFieldNameId().hashCode() );
         return result;
   }   





}