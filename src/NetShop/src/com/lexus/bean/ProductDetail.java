package com.lexus.bean;
// Generated by MyEclipse - Hibernate Tools



/**
 * ProductDetail generated by MyEclipse - Hibernate Tools
 */
public class ProductDetail extends AbstractProductDetail implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
    public ProductDetail() {
    }

	/** minimal constructor */
    public ProductDetail(Product product) {
        super(product);        
    }
    
    /** full constructor */
    public ProductDetail(Product product, Long productPrice, String productHabitat) {
        super(product, productPrice, productHabitat);        
    }
   
}
