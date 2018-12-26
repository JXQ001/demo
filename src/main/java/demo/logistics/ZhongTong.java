package demo.logistics;

/**
 * 具体策略类（中通服务）
 * @author liya
 *
 */
public class ZhongTong implements Logistics {

	@Override
	public String zaiXianYuYue(String jiAddress, String shouAddress) {
		System.out.println("中通在线预约下单...");
		System.out.println("寄件人："+jiAddress);
		System.out.println("收件人："+shouAddress);
		return "中通在线预约下单";
	}

	@Override
	public String dianZiMianDan(String jiAddress, String shouAddress) {
		System.out.println("中通电子面单下单...");
		System.out.println("寄件人："+jiAddress);
		System.out.println("收件人："+shouAddress);
		return "中通电子面单下单";
	}

	@Override
	public String chaXunWuLiuGuiJi(String willBill) {
		System.out.println("中通查询物流轨迹...");
		System.out.println("willBill："+willBill);
		return "中通查询物流轨迹";
	}
}
