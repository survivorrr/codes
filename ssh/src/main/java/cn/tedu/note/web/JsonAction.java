package cn.tedu.note.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class JsonAction extends ActionSupport implements SessionAware,RequestAware,ApplicationAware{
	public Map<String,Object> result = new HashMap<String,Object>();
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;

	public static final String JSON="json";
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	/**
	 * ������ȷ����ֵ
	 * @param value
	 */
	protected void setResult(Object value) {
		result.put("status", 0);
		result.put("message", "");
		result.put("data", value);  //������ʵ��ʱ����ҳ������ʾ����һ��ѵ����ݣ����Կ��ǿ��ǰ����ݷ���map��Ҫʲôȡʲô
	}
	/**
	 * ���ô��󷵻�ֵ
	 * @param error
	 */
	protected void setResult(String error) {
		result.put("status", 1);
		result.put("message", error);
		result.put("data", null);
	}
	/**
	 * ���ô��󷵻�ֵ
	 * @param e
	 */
	protected void setResult(Throwable e) {
		this.setResult(e.getMessage());
	}
	
}
