package patterns.composite;

public abstract class Figure {
	public abstract void draw(String prefix);
	public boolean isGrouped;

	public boolean isGrouped() {
		return isGrouped;
	}

	public void setGrouped(boolean grouped) {
		isGrouped = grouped;
	}
}
