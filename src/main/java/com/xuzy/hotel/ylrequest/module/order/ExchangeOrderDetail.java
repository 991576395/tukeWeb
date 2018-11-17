package com.xuzy.hotel.ylrequest.module.order;

public class ExchangeOrderDetail {
    /// <summary>
    /// ID
    /// </summary>
    public int ID = 0;
    /// <summary>
    /// 礼品编号
    /// </summary>
    public String Product = "";

    /// <summary>
    /// 订购数量
    /// </summary>
    public int BookQuantity = 0;

    /// <summary>
    /// 实际签收数量
    /// 新增订单时，默认为0
    /// </summary>
    public int SignInQuantity = 0;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public int getBookQuantity() {
		return BookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		BookQuantity = bookQuantity;
	}

	public int getSignInQuantity() {
		return SignInQuantity;
	}

	public void setSignInQuantity(int signInQuantity) {
		SignInQuantity = signInQuantity;
	}

}
