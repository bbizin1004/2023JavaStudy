package ex09package;

import ex09package.study.buyer.FruitBuyer4;
import ex09package.study.seller.FruitSeller4;

public class E03FruitSalesMain4 {

	public static void main(String[] args) {

		/*생성자를 사용해서 인스턴스를 생성하면 아래와 같이 생성과 동시에 
		  초기화까지 할수 있다. 따라서 초기화 메서드를 사용하는것보다 적은
		  코드로 작성하 수 있는 장점이 있다.*/
		FruitSeller4 seller1 = new FruitSeller4(0,100,1000);
		FruitSeller4 seller2 = new FruitSeller4(0,80,500);
		FruitBuyer4 buyer = new FruitBuyer4(10000,0);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showbuyResult();

		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();//5개를 판매한다.
		seller2.showSaleResult();//10개를 판매한다.
		buyer.showbuyResult();

	}

}
