<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报价表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcOfferMoneyController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${cvcOfferMoneyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							销售不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="xiaoshoubuhanshuijia" name="xiaoshoubuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">销售不含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							销售的增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="xiaoshoudezhengzhishui" name="xiaoshoudezhengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">销售的增值税</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							销售含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="xiaoshouhanshuijia" name="xiaoshouhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">销售含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							采购不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="caigoubuhanshuijia" name="caigoubuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购不含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购的增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="caigoudezengzhishui" name="caigoudezengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购的增值税</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							采购的含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="caigoudehanshuijia" name="caigoudehanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购的含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运费不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="yunfeibuhanshuijia" name="yunfeibuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运费不含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							运费增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="yunfeizengzhishui" name="yunfeizengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运费增值税</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运费含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="yunfeihanshuijia" name="yunfeihanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运费含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							包装费不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="baozhuangfeibuhanshuijia" name="baozhuangfeibuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">包装费不含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							包装费增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="baozhuangfeizengzhishui" name="baozhuangfeizengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">包装费增值税</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							包装费含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="baozhuangfeihanshuijia" name="baozhuangfeihanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">包装费含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装卸费不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="zhuangxiefeibuhanshuijia" name="zhuangxiefeibuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装卸费不含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							装卸费增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="zhuangxiefeizengzhishui" name="zhuangxiefeizengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装卸费增值税</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装卸费含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="zhuangxiefeihanshuijia" name="zhuangxiefeihanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装卸费含税价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							仓储费不含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="cangchufeibuhanshuijia" name="cangchufeibuhanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓储费不含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓储费增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="cangchufeizengzhishui" name="cangchufeizengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓储费增值税</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							仓储费含税价:
						</label>
					</td>
					<td class="value">
					     	 <input id="cangchufeihanshuijia" name="cangchufeihanshuijia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓储费含税价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本次货物缴纳的增值税:
						</label>
					</td>
					<td class="value">
					     	 <input id="bencihuowunashuidezengzhishui" name="bencihuowunashuidezengzhishui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本次货物缴纳的增值税</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							增值税附加税:
						</label>
					</td>
					<td class="value">
					     	 <input id="zengzhishuifujiashui" name="zengzhishuifujiashui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值税附加税</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							经营成本标准:
						</label>
					</td>
					<td class="value">
					     	 <input id="jinyingchenbenbiaozhun" name="jinyingchenbenbiaozhun" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经营成本标准</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单经营成本:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanjinyinchengben" name="bendanjinyinchengben" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单经营成本</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单收入:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanshouru" name="bendanshouru" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单收入</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单成本:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanchengben" name="bendanchengben" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单成本</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单利润:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanlirun" name="bendanlirun" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单利润</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单所得税:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendansuodeshui" name="bendansuodeshui" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单所得税</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单净利润:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanjinlirun" name="bendanjinlirun" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单净利润</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单现金流入:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanxianjinliuru" name="bendanxianjinliuru" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单现金流入</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单成本现金流出:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanchenbenxianjinliuchu" name="bendanchenbenxianjinliuchu" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单成本现金流出</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单净现金流:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanjinxianjinliu" name="bendanjinxianjinliu" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单净现金流</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单税金流出:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanshuijinliuchu" name="bendanshuijinliuchu" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单税金流出</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单毛利率:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendanmaolilv" name="bendanmaolilv" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单毛利率</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本单单位产品不含税售价:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendandanweichanpinbuhssj" name="bendandanweichanpinbuhssj" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单单位产品不含税售价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本单单位产品含税售价:
						</label>
					</td>
					<td class="value">
					     	 <input id="bendandanweichanpinhssj" name="bendandanweichanpinhssj" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本单单位产品含税售价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="goodName" name="goodName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品名称</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/offermoney/cvcOfferMoney.js"></script>		
