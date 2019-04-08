package demo.logistics;

/**
 * 抽象策略角色
 * @author liya
 */
public interface Logistics {

	// 在线预约
	public String zaiXianYuYue(String jiAddress,String shouAddress);
	
	// 电子面单
	public String dianZiMianDan(String jiAddress,String shouAddress);
	
	// 查询物流轨迹
	public String chaXunWuLiuGuiJi(String willBill);
	
}
