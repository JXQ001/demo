package demo.logistics;

/**
 * 环境类（持有物流策略）
 * 
 * @author liya
 *
 */
public class Context {

	private Logistics logistics;

	public Context(Logistics logistics) {
		this.logistics = logistics;
	}

	// 在线预约
	public String zaiXianYuYue(String jiAddress, String shouAddress) {
		return logistics.zaiXianYuYue(jiAddress, shouAddress);
	}

	// 电子面单
	public String dianZiMianDan(String jiAddress, String shouAddress) {
		return logistics.dianZiMianDan(jiAddress, shouAddress);
	}

	// 查询物流轨迹
	public String chaXunWuLiuGuiJi(String willBill) {
		return logistics.chaXunWuLiuGuiJi(willBill);
	}

}
