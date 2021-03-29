package org.jeecgframework;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class CityModule {
	private String code;
	
	private String name;
	
	private List<CityModule> child;

	
	
	public CityModule() {
		super();
	}

	public CityModule(String name) {
		super();
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CityModule> getChild() {
		return child;
	}

	public void setChild(List<CityModule> child) {
		this.child = child;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		CityModule them = (CityModule) obj;
		if(StringUtils.isEmpty(them.getName())) {
			return false;
		}
		
		if(name.equals(them.getName())) {
			return true;
		}
		
		if(CollectionUtils.isNotEmpty(child)) {
			return child.contains(them);
		}else if(CollectionUtils.isNotEmpty(them.getChild())) {
			return them.getChild().contains(this);
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "CityModule [code=" + code + ", name=" + name + ", child=" + child + "]";
	}
	
	
	
}
