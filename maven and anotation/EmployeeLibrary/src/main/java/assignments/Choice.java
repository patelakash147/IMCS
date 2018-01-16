package assignments;

public enum Choice {

	ENTER(1), FINDID(2), FINDNAME(3), DELETE(4), UPDATE(5), GROSS(6), DISPLAYALL(7), SORT(8), UNIQUENAME(9), AGERANGE(
			10), EXIT(11), UNKNOWN(-1);

	int val;

	private Choice(int val) {
		this.val = val;
	}

	public static Choice getDepartmentName(int val) {
		Choice ch = null;
		for (Choice dep : Choice.values()) {
			if (dep.val == val) {
				ch = dep;
			}
		}
		return ch;
	}
}
