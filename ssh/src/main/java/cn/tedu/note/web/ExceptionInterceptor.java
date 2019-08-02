package cn.tedu.note.web;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
@Component
public class ExceptionInterceptor implements Interceptor{

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			//µ÷ÓÃ¿ØÖÆÆ÷
			String str = invocation.invoke();
			return str;
		}catch(Exception e) {
			e.printStackTrace();
			Object obj = invocation.getAction();
			if(obj instanceof JsonAction) {
				JsonAction action = (JsonAction)obj;
				action.setResult(e);
				return JsonAction.JSON;
			}
			throw e;
		}
		
	}
	
}
