package br.org.vinicius.jsf.ptrack.model;

public class RoleType extends EnumeratedType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7142683010627762588L;

	public final static RoleType UPPER_MANAGER = new RoleType(0,
			"Upper Manager", "/images/inbox.png");
	public final static RoleType PROJECT_MANAGER = new RoleType(10,
			"Project Manager", "/images/inbox.png");
	public final static RoleType BUSINESS_ANALYST = new RoleType(20,
			"Business Analyst", "/images/inbox.png");
	public final static RoleType DEVELOPMENT_MANAGER = new RoleType(30,
			"Development Manager", "/images/inbox.png");
	public final static RoleType SYSTEMS_MANAGER = new RoleType(40,
			"Systems Manager", "/images/inbox.png");
	public final static RoleType QA_MANAGER = new RoleType(50, "QA Manager",
			"/images/inbox.png");
	private String iconUrl = null;

	private static EnumManager enumManager;

	static {
		enumManager = new EnumManager();
		enumManager.addInstance(PROJECT_MANAGER);
		enumManager.addInstance(BUSINESS_ANALYST);
		enumManager.addInstance(DEVELOPMENT_MANAGER);
		enumManager.addInstance(SYSTEMS_MANAGER);
		enumManager.addInstance(QA_MANAGER);
	}

	private RoleType(int value, String description) {
		super(value, description);
	}

	private RoleType(int value, String description, String iconUrl) {
		super(value, description);
		this.iconUrl = iconUrl;
	}

	public static EnumManager getEnumManager() {
		return enumManager;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

}
