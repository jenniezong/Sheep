import java.util.ArrayList;
import java.util.List;

public class IfInfo {

	private int x;
	private int y;
	private List<IfInfo> children;
	private int depth;
	private int braceCount;
	private boolean hasBrace;
	private boolean isElse;
	private boolean isElseIf;

	public IfInfo(int x, int y, boolean isElse) {
		this.x = x;
		this.y = y;
		this.isElse = isElse;
		hasBrace = true;
		children = new ArrayList<IfInfo>();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<IfInfo> getChildren() {

		return children;
	}

	public void addChildren(IfInfo child) {

		this.children.add(child);
	}

	public int getBraceCount() {
		return braceCount;
	}

	public void setBraceCount(int braceCount) {
		this.braceCount = braceCount;
	}

	public boolean hasBrace() {
		return hasBrace;
	}

	public void setHasBrace(boolean isNew) {
		this.hasBrace = isNew;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isElse() {
		return isElse;
	}

	public void setElse(boolean isElse) {
		this.isElse = isElse;
	}

	public boolean isElseIf() {
		return isElseIf;
	}

	public void setElseIf(boolean isElseIf) {
		this.isElseIf = isElseIf;
	}

	public String toString() {
		String result = "";
		result = "(" + this.x + ", " + this.y + ")";
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IfInfo other = (IfInfo) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
