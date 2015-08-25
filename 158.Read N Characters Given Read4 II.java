private char[] buffer = new char[4];
private int offset = 0;
private int bufsize = 0;

public int read(char[] buf, int n) {

	int readBytes = 0;
	boolean eof = false;

	while (!eof && readBytes < n) {

		if (bufsize == 0) {
			bufsize = read4(buffer);
			eof = bufsize < 4;
		}

		int bytes = Math.min(n - readBytes, bufsize);
		System.arraycopy(buffer, offset, buf, readBytes, bytes);
		offset = (offset + bytes) % 4;
		bufsize -= bytes;
		readBytes += bytes;
	}
	return readBytes;
}