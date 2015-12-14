package com.nan.netty.study.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 字符串长度，不足部分左对齐，右补空格；整数数字型字段以NX格式表示，其中X代表数字型字符串长度，不足部分右对齐，左补空格；浮点数字型字段以NX
 * (Y)格式表示
 * ，其中X代表数字型字符串总长度，Y代表小数位数，X包括一位小数点，整数部分最多不超过X-Y-1位，小数部分最多不超过Y位，不足部分右对齐，左补空格； <br>
 * （五）每行以二进制0x0A结束，最后一行也以0x0A结束。 <br>
 * <br>
 * <strong>文件描述：</strong> <br>
 * （一）行情文件包含文件头、文件体、文件尾三个部分； <br>
 * （二）注意行情文件可扩展性，文件记录尾部可能随时增加扩展字段，接收处理方应能向下兼容处理，即增加扩展字段后，对新增字段无需识别处理的用户，不需要升级系统；
 * 注意根据文件体首字段MDStreamID取值解析不同的文件体记录格式； <br>
 * （三）文件体中，对于不同的行情数据类型，分别定义记录格式，接收处理方应能根据行情数据类型识别处理； <br>
 * （四）文件体记录按行情数据类型递增，同一行情数据类型按证券代码递增； <br>
 * （五）对于暂停上市的股票，文件中不包含该股票的记录。发行期内对于未设定开始上市交易的产品，文件中不包含该产品的记录。对于摘牌后的产品，
 * 文件中不包含该产品的记录； <br>
 * （六）如文件中数值字段取值超过约定格式最大值，取最大值，如N10取9999999999； <br>
 * （七）前收盘价格，在开市之前即行发布。 <br>
 * （八）当产品代码为债券（国债、企债、可转债）时，由于债券交易的数量以手为单位，成交金额为该债券每笔成交的价格*数量*10的总和；
 * 当产品代码为席位质押式国债回购代码201
 * ***、席位质押式企业债回购代码202***以及账户质押式国债回购代码204***时，成交金额为100*成交数量*10；
 * 当产品代码为买断式国债回购代码203***时，成交金额为其基础产品昨日收盘价*成交数量*10； <br>
 * （九）对于产品价格、金额数据单位，除B股为美元外，其他为人民币元。对于产品数量数据单位，股票为股，基金、权证为份，债券与回购为手。
 * 对于产品TradeVolume成交数量单位，股票为股，基金为份，债券与回购为手，权证为100份；对于指数价格、金额、数量单位，详见表格具体定义说明； <br>
 * （十）在集合竞价时段内，当前买入价和当前卖出价中同时为虚拟开盘参考价格，即根据集合竞价算法计算得出的虚拟撮合价格。
 * 同时申买量一和申卖量一为行情发布时刻的虚拟匹配量。申买量二为行情发布时刻的买方虚拟未匹配量。申卖量二为行情发布时刻的卖方虚拟未匹配量； <br>
 * （十一）在开盘集合竞价之后的短暂休市和中午休市期间同样揭示各档买卖价格数量等全部信息； <br>
 * （十二）临时停牌期间不揭示五档行情； <br>
 * （十三）字段无意义或无该字段行情数据时，字符填空格，数值填0； <br>
 * （十四）交易所具体产品代码，参见相关发文通知，并参考以上处理。
 * 
 * 
 * <p>
 * MDStreamID:行情数据类型标识符，取值 MD001 表示指数行情数据格式类型，其中指数目前实际精度为4位小数；MD002
 * 表示股票（A、B股）行情数据格式类型； MD003 表示债券行情数据格式类型； MD004 表示基金行情数据格式类型；
 * </P>
 * 
 * @author wangzhimin
 * @since 2015年8月11日
 */
public class Mktdt00TXT {

	public static Object[] readTxtFile(File file) {
		InputStreamReader read = null;
		List<StockRealtime> srRS = null;
		List<FigureRealtime> frRS = null;
		Object[] rs = new Object[2];
		try {
			String encoding = "GBK";
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int num = 0;
				Date d = new Date();
				srRS = Lists.newLinkedList();
				frRS = Lists.newLinkedList();

				while ((lineTxt = bufferedReader.readLine()) != null) {
					// 判断是否停牌 2015-10-22  王志敏： 不管怎么样数据都还是要读的，至于处不处理应该是由处理程序判定，这里太早了
					/*if (num == 0 && !lineTxt.split("\\|")[8].startsWith("T")) {
						break;
					}*/
					if (lineTxt.startsWith("MD001|000001|") || lineTxt.startsWith("MD001|000300|")) {
						frRS.add(getfigureObject(lineTxt, d));
					} else if (lineTxt.startsWith("MD002|6")) {
						StockRealtime sr = Mktdt00TXT.getObject(lineTxt, d);
						if (sr != null)
							srRS.add(sr);
					} else if (lineTxt.startsWith("MD002|9")) {
						break;
					}
					num++;

				}
				rs[0] = srRS;
				rs[1] = frRS;

			} else {
				System.out.println("找不到指定的文件");
//				log.error("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
//			log.error("读取文件内容出错");
			e.printStackTrace();
		} finally {
			try {
				if (read != null)
					read.close();
			} catch (Exception e) {
			}
		}
		return rs;
	}

	public static StockRealtime getObject(String line, Date d) {
		String[] object = line.split("\\|");
		StockRealtime sr = new StockRealtime();
		sr.setCode("SH" + object[1].toString().trim());
		String name = object[2].toString().replaceAll(" ", "");
//		name = CharacterConverUtils.QiaoJiao2BanJiao(name);
		sr.setName(name);

		// ‘P’表示产品停牌。
		if (object[31].toString().trim().startsWith("P")) {
			sr.setYesClose(new BigDecimal(object[5].toString().trim()));
			sr.setTodOpen(new BigDecimal(object[5].toString().trim()));
			sr.setTempAmount(new BigDecimal(0));
			sr.setTodHigh(new BigDecimal(object[5].toString().trim()));
			sr.setTodLow(new BigDecimal(object[5].toString().trim()));
			try {
				sr.setCurrent(new BigDecimal(object[5].toString().trim()));
			} catch (Exception e) {
				System.out.println("解析股票行情当前价异常");
//				log.error("解析股票行情当前价异常", e);
				return null;
			}
			sr.setTempVolume(new BigDecimal(0));
			sr.setTradeType(StockTradeType.T.value());
			// sr.setProfitRate(new BigDecimal(0));
		} else {
			sr.setTempVolume(new BigDecimal(object[3].toString().trim()));
			sr.setTempAmount(new BigDecimal(object[4].toString().trim()));
			sr.setYesClose(new BigDecimal(object[5].toString().trim()));
			sr.setTodOpen(new BigDecimal(object[6].toString().trim()));
			sr.setTodHigh(new BigDecimal(object[7].toString().trim()));
			sr.setTodLow(new BigDecimal(object[8].toString().trim()));
			try {
				BigDecimal closed = null;
				try {
					closed = new BigDecimal(object[10].toString().trim());
				} catch (Exception e) {

				}
				if (closed == null || closed.compareTo(new BigDecimal(0)) < 1)
					sr.setCurrent(new BigDecimal(object[9].toString().trim()));
				else
					sr.setCurrent(closed);
			} catch (Exception e) {
				System.out.println("解析股票行情当前价异常");
//				log.error("解析股票行情当前价异常", e);
				return null;
			}

			sr.setCurrentBuy(new BigDecimal(object[11].toString().trim()));
			sr.setApplyBuyVol1(new BigDecimal(object[12].toString().trim()));

			sr.setCurrentSold(new BigDecimal(object[13].toString().trim()));
			sr.setApplySoldVol1(new BigDecimal(object[14].toString().trim()));
			// sr.setProfitRate(new BigDecimal(object[11].toString().trim()));

			sr.setApplyBuyPri2(new BigDecimal(object[15].toString().trim()));
			sr.setApplyBuyVol2(new BigDecimal(object[16].toString().trim()));

			sr.setApplySoldPri2(new BigDecimal(object[17].toString().trim()));
			sr.setApplySoldVol2(new BigDecimal(object[18].toString().trim()));

			sr.setApplyBuyPri3(new BigDecimal(object[19].toString().trim()));
			sr.setApplyBuyVol3(new BigDecimal(object[20].toString().trim()));
			sr.setApplySoldPri3(new BigDecimal(object[21].toString().trim()));
			sr.setApplySoldVol3(new BigDecimal(object[22].toString().trim()));

			sr.setApplyBuyPri4(new BigDecimal(object[23].toString().trim()));
			sr.setApplyBuyVol4(new BigDecimal(object[24].toString().trim()));
			sr.setApplySoldPri4(new BigDecimal(object[25].toString().trim()));
			sr.setApplySoldVol4(new BigDecimal(object[26].toString().trim()));

			sr.setApplyBuyPri5(new BigDecimal(object[27].toString().trim()));
			sr.setApplyBuyVol5(new BigDecimal(object[28].toString().trim()));
			sr.setApplySoldPri5(new BigDecimal(object[29].toString().trim()));
			sr.setApplySoldVol5(new BigDecimal(object[30].toString().trim()));

			sr.setTradeType(StockTradeType.F.value());

		}
		sr.setTime(d);
		sr.setMarket(Market.CN.value());
//		sr.setDbType(Market.CN.value());
		return sr;
	}

	/**
	 * 取出指数
	 * 
	 * @param o
	 * @return
	 */
	public static FigureRealtime getfigureObject(String line, Date d) {
		String[] o = line.split("\\|");
		FigureRealtime sr = new FigureRealtime();
		sr.setCode("SH" + o[1].toString());
		sr.setName(o[1].toString());

		sr.setVolume(new BigDecimal(o[3].toString().trim()));
		sr.setAmount(new BigDecimal(o[4].toString().trim()));

		sr.setYesClose(new BigDecimal(o[5].toString().trim()));
		sr.setTodOpen(new BigDecimal(o[6].toString().trim()));

		sr.setHigh(new BigDecimal(o[7].toString().trim()));
		sr.setLow(new BigDecimal(o[8].toString().trim()));

		sr.setCurrent(new BigDecimal(o[9].toString().trim()));

		sr.setTradeTime(d);

		sr.setMarket(Market.CN.value());
//		sr.setDbType(Market.CN.value());
		// 指数没有申买信息
		return sr;
	}
}
