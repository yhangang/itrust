package com.itrust.util;

/**
 * 消息类，包含消息头与消息体，消息头表示状态，消息体是实际数据
 * 
 * @author yanghang
 * @date 20160317
 *
 */
public class SimpleMessage {
	public String flag;
	public Object object;

	public SimpleMessage(String flag, Object object) {
		this.flag = flag;
		this.object = object;
	};

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("{\"").append(Constant.FLAG).append("\":\"").append(flag).append("\",\"")
				.append(Constant.MESSAGE).append("\":").append(JsonUtil.toJson(object)).append("}").toString();
	}

}
