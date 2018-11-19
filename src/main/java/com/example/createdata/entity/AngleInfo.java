
/**    
* @Title: AcAngle.java  
* @Package com.sensetime.fis.senseguard.ac.entity  
* @Description: TODO(用一句话描述该文件做什么)  
* @author liufulu_vendor  
* @date 2018年6月22日  
* @version V1.0    
*/

package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: AcAngle
 * @Description: 人脸角度信息(姿态变化角度,俯仰变化角度,平面旋转角度)
 * @author liufulu_vendor
 * @date 2018年6月22日
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AngleInfo {

	  
	/**  
	* @Fields yaw:人脸姿态变化角度
	*/  
	    
	private Float yaw;
	  
	/**  
	* @Fields pitch:人脸俯仰变化角度
	*/  
	    
	private Float pitch;
	  
	/**  
	* @Fields roll:人脸平面旋转角度
	*/  
	    
	private Float roll;
}
