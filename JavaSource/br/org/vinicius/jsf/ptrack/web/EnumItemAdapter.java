package br.org.vinicius.jsf.ptrack.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.jia.ptrack.domain.ArtifactType;
import org.jia.ptrack.domain.EnumeratedType;
import org.jia.ptrack.domain.ProjectType;
import org.jia.ptrack.domain.RoleType;


public class EnumItemAdapter {

	private Map itemLists = new HashMap();

	public EnumItemAdapter() {
		addType(ProjectType.class, ProjectType.getEnumManager());
		addType(ArtifactType.class, ArtifactType.getEnumManager());
		addType(RoleType.class, RoleType.getEnumManager());
	}

	protected void addType(Class clazz, EnumeratedType.EnumManager enumManager) {
		Iterator types = enumManager.getInstances().iterator();
		List selectItems = new ArrayList();
		while (types.hasNext()) {
			EnumeratedType type = (EnumeratedType) types.next();
			SelectItem item = new SelectItem(type, type.getDescription(),
					type.getDescription());
			selectItems.add(item);
		}
		itemLists.put(clazz, selectItems);
	}

	public List getArtifacts() {
		return (List) itemLists.get(ArtifactType.class);
	}

	public List getRoles() {
		return (List) itemLists.get(RoleType.class);
	}

	public List getProjectTypes() {
		return (List) itemLists.get(ProjectType.class);
	}

}
