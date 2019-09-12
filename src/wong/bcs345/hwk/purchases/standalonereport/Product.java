package wong.bcs345.hwk.purchases.standalonereport;

/**
 * The <strong>Product</strong> class.
 * <p>
 * Contains attributes for a product.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#1
 * @since Sep 11, 2019
 */
public class Product {
	private String productDescription;
	private double productPrice;
	private int productQuantity;
	
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}
	
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
	
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
}