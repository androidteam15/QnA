package QnA.android;

public class Vehicle {
    private String name;

    private String group;

    
    public Vehicle(String name, String group) {
		super();
		this.name = name;
		this.group = group;
	}

	public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}