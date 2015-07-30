public List<String> fullJustify(String[] words, int maxWidth) {

	List<String> res = new ArrayList<String>();

	if (words == null || words.length == 0) return res;

	int last = 0;
	int count = 0;

	for (int i = 0; i< words.length; i++) {

		// count is length of words[last]...words[i-1]
		// i - last is the number of intervals between words
		// if sum > maxWidth, we should put words[i] in a new line
		if (count+words[i].length()+i-last > maxWidth) {

			int spaceNum = 0;
			int extraNum = 0;

			if (i-last-1 > 0) {
				spaceNum = (maxWidth-count) / (i-last-1);
				extraNum = (maxWidth-count) % (i-last-1);
			}

			StringBuilder sb = new StringBuilder();
			for (int j = last; j < i; j++) {

				sb.append(words[j]);

				// There are no spaces after words[i-1]
				if (j < i-1) {
					for (int k = 0; k < spaceNum; k++) {
						sb.append(" ");
					}

					if (extraNum > 0) {
						sb.append(" ");
					}
					extraNum--;
				}
			}

			// There is only one word in a line
	        for(int j = sb.length(); j < maxWidth; j++) {
	            sb.append(" ");
	        }

			res.add(sb.toString());
			count = 0;
			last = i;
		}
		count += words[i].length();
	}

	// Last line
	StringBuilder sb = new StringBuilder();
	for (int i = last; i < words.length; i++) {
		sb.append(words[i]);
		if (sb.length() < maxWidth) {
			sb.append(" ");
		}
	}

	for (int i = sb.length(); i < maxWidth; i++) {
		sb.append(" ");
	}

	res.add(sb.toString());
	return res;
}