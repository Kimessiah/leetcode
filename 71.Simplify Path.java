public String simplifyPath(String path) {

	if (path == null || path.length() == 0) return path;

	String[] paths = path.split("/");
	LinkedList<String> stack = new LinkedList<String>();

	for (String s : paths) {
		if (s.equals("..")) {
			if (!stack.isEmpty()) {
				stack.removeLast();
			}
		} else if (s.length() != 0 && !s.equals(".")) {
			stack.add(s);
		}
	}

	if (stack.isEmpty()) return "/";

	StringBuilder sb = new StringBuilder();

	for (String s : stack) {
		sb.append("/" + s);
	}
	return sb.toString();
}