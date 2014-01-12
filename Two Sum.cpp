vector<int> twoSum(vector<int> &numbers, int target) {
        hash_map<int, int> hashtable;
        vector<int> index;
        
        for (int i=0; i<numbers.size(); i++) {
            int num = numbers[i];
            if (hashtable.find(num) == hashtable.end()) {
                hashtable.insert( {target-num, i} );
            }
            else {
                index.push_back(hashtable[num]+1);
                index.push_back(i+1);
                return index;
            }
            
        }
        
}
