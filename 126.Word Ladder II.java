public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {

        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

    void dfs(List<List<String>> ladders, List<String> path, String s,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(s);
        if (s.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String prev : map.get(s)) {
                if (distance.containsKey(prev) && distance.get(s) == distance.get(prev) + 1) { 
                    dfs(ladders, path, prev, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
            String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String s = q.poll();

            List<String> nextList = expand(s, dict);
            for (String next : nextList) {
                map.get(next).add(s);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(s) + 1);
                    q.offer(next);
                }
            }
        }
    }

    List<String> expand(String s, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != s.charAt(i)) {
                    String expanded = s.substring(0, i) + c
                            + s.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
}