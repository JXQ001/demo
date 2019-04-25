package demo.easyexcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

public class Main {

	public static void main(String[] args) throws Exception {

		List<Goods> goodsList = initData();

		List<WriteModel> writeModels = new ArrayList<>();
		List<Merge> merges = new ArrayList<>();

		int firstRow = 2;
		int sum = 0;
		boolean flag = false;

		int schoolFirstRow = 2;
		int schoolSum = 0;

		for (Goods goods : goodsList) {
			String goodsName = goods.getGoodsName();
			String goodsStyle = goods.getGoodsStyle();
			String goodsNumber = goods.getGoodsNumber();
			String goodsSizeType = goods.getGoodsSizeType();

			List<School> schools = goods.getSchools();
			int step = -1;
			for (School school : schools) {
				String schoolName = school.getSchoolName();

				List<Size> sizes = school.getSizes();
				int schoolStep = -1;

				schoolFirstRow = 2 + schoolSum;

				for (Size size : sizes) {
					String sizeName = size.getSizeName();
					String sizeTotal = size.getSizeTotal();
					WriteModel writeModel = new WriteModel(goodsName, goodsStyle, goodsNumber, goodsSizeType,
							schoolName, sizeName, sizeTotal);
					writeModels.add(writeModel);
					sum++;
					schoolSum++;
					step++;
					schoolStep++;
				}
				// writer.merge(2, 3, 4, 4);
				// writer.merge(4, 5, 4, 4);
				// if (!schoolFlag) {
				// schoolFlag = true;
				// schoolSum = 0;
				// } else {
				// schoolFirstRow = 2 + schoolSum;
				// }
				// writer.merge(6, 7, 4, 4);
				// writer.merge(8, 9, 4, 4);
				int schoolLastRow = schoolFirstRow + schoolStep;
				merges.add(new Merge(schoolFirstRow, schoolLastRow, 4, 4));
			}
			if (!flag) {
				flag = true;
				sum = 0;
			} else {
				firstRow = 2 + sum;
			}
			int lastRow = firstRow + step;
			merges.add(new Merge(firstRow, lastRow, 0, 0));
			merges.add(new Merge(firstRow, lastRow, 1, 1));
			merges.add(new Merge(firstRow, lastRow, 2, 2));
			merges.add(new Merge(firstRow, lastRow, 3, 3));
		}

		generateExcel(writeModels, merges);
	}

	private static List<Goods> initData() {
		Size size1 = new Size("170", "1");
		Size size2 = new Size("180", "3");
		Size size3 = new Size("150", "2");
		Size size4 = new Size("160", "5");
		Size size5 = new Size("150", "15");

		List<Size> sizes1 = Arrays.asList(size1, size2, size5);
		List<Size> sizes2 = Arrays.asList(size3, size4, size5);
		List<Size> sizes3 = Arrays.asList(size3, size5);

		School school1 = new School("北京市海淀区北京大学", sizes1);
		School school2 = new School("北京市海淀区清华大学", sizes2);
		School school3 = new School("北京市海淀区北京理工大学", sizes3);
		List<School> schools = Arrays.asList(school1, school2, school3);

		Goods goods = new Goods("纯棉蓝白条男生T恤商品007", "男款", "TM10086", "平台尺码", schools);
		System.out.println("====================初始化数据完成====================");
		return Arrays.asList(goods, goods);
	}

	private static void generateExcel(List<WriteModel> writeModels, List<Merge> merges)
			throws FileNotFoundException, IOException {
		OutputStream out = new FileOutputStream("C:/Users/liya/Desktop/2007.xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(out);

		Sheet sheet = new Sheet(1, 3, WriteModel.class, "零售商品生产明细表", null);
		writer.write(writeModels, sheet);

		// TODO 合并单元格
		for (Merge merge : merges) {
			int firstRow = merge.getFirstRow();
			int lastRow = merge.getLastRow();
			int firstCol = merge.getFirstCol();
			int lastCol = merge.getLastCol();
			writer.merge(firstRow, lastRow, firstCol, lastCol);
		}

		writer.finish();
		out.close();
		System.out.println("====================生成excel完成====================");
	}

}
