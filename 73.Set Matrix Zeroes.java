// Time O(m*n)   Space O(m+n)
public void setZeroes(int[][] matrix) {

	if (matrix == null || matrix.length == 0 || matrix[0].length) return;

	boolean[] row = new boolean[matrix.length];
	boolean[] col = new boolean[matrix[0].length];

	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] == 0)  {
				row[i] = true;
				col[j] = true;
			}
		}
	}

	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (row[i] || col[j]) {
				matrix[i][j] = 0;
			}
		}
	}
}

// Time O(m*n)   Space O(1)
public void setZeroes(int[][] matrix) {

	//To achieve constant space, we need to use the space of the first row and first col
    //to store information
    if(matrix==null || matrix.length==0 || matrix[0].length==0) {
        return;
    }
     
    //1. determine if the first row needs to be set zero because of itself
    //which means are there any zeros in the first row
    boolean zeroFirstRow = false;
    for(int i = 0; i < matrix[0].length; i++){
        if(matrix[0][i] == 0){
            zeroFirstRow = true;
            break;
        }
    }

    //2. determine if the first col needs to be set zero because of itself
    //which means are there any zeros in the first col
    boolean zeroFirstCol = false;
    for(int i = 0; i< matrix.length; i++){
        if(matrix[i][0] == 0){
            zeroFirstCol = true;
            break;
        }
    }

    //3. then we can use the first row and first col to store the information of 
    //the rest elements
    for(int i = 1; i < matrix.length; i++){
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }

    //4. set the matrix to zero according to the information stored in the first row and first col
    for(int i = 1; i < matrix.length; i++){
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] ==0 || matrix[i][0] == 0){
                matrix[i][j] = 0;
            }    
        }
    }

    //set the first row
    if(zeroFirstRow){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[0][i] = 0;
        }
    }

    //set the first col
    if(zeroFirstCol){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = 0;
        }
    }
}