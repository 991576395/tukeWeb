package com.appinterface.app.base.core.contant;

/**
 * @ClassName: Contant 
 * @Description: 基本静态资源
 * @author xuzhenyao
 * @date 2015-5-4 下午4:09:13 
 *
 */
public class Contant {
	/**
	 * 交互成功
	 */
	public static final String CODE_SUCCESS = "200"; 
	/**
	 * 交互失败
	 */
	public static final String CODE_FAIL = "999"; 
	
	/**
	 * 强制更新
	 */
	public static final String VERSIONUPDATE = "66666"; 
	
	/**
	 * 参数错误
	 */
	public static final String CODE_FAIL_FIELD_ERROR = "300";
	/**
	 * 服务器异常
	 */
	public static final String CODE_ERROR = "500";
	/**
	 * 更新密码--旧密码和新密码相同
	 */
	public static final String CODE_FAIL_UPDATE_PASS_WORD_SAME = "1001";
	
	/**
	 * 更新密码--原始密码错误
	 */
	public static final String CODE_FAIL_UPDATE_PASS_WORD_ERROR = "1002";
	
	/**
	 * 更新密码--用户名不存在
	 */
	public static final String CODE_FAIL_UPDATE_PASS_WORD_UER_NOT_FOUND = "1003";
	
	/**
	 * 更新密码--不能使用前六次使用的密码
	 */
	public static final String CODE_FAIL_UPDATE_PASS_WORD_UER_NOT_USEFUL = "1004";
	
	/**
	 * 更新密码--长度8-12位，字母和数字组合
	 */
	public static final String CODE_FAIL_UPDATE_PASS_WORD_CHECK = "1005";
	
	/**
	 * 签到-- 重复签到
	 */
	public static final String CODE_FAIL_SIGN_REPEAT_IN = "0901";
	
	/**
	 * 签到-- 当前状态和操作不符合
	 */
	public static final String CODE_FAIL_SIGN_STATUS_ERROR = "0902";
	
	/**
	 * 签到-- 重复签到
	 */
	public static final String CODE_FAIL_SIGN_REPEAT_OUT = "0903";
	
	/**
	 * 更新分享状态--sid不存在
	 */
	public static final String CODE_FAIL_UPDATE_SHARE_SID_NOT_FOUND = "2201";
	
	/**
	 * 5.37.获取审核信息--图片未上传，无法审核
	 */
	public static final String CODE_FAIL_IMAGE_NOT_FOUND = "3701";
	
	/**
	 * 5.38.确认审核结果接口--结果已上传
	 */
	public static final String CODE_FAIL_CHECK_REPEAT = "3801";
	
	/**
	 * 超期未审核
	 */
	public static final String CODE_FAIL_CHECK_OUTOFDATE = "3803";
	
	/**
	 * 5.38.确认审核结果接口--调用wap接口异常
	 */
	public static final String CODE_FAIL_CHECK_CALL_WAP_ERROR = "3802";
}
