class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> match = new HashMap<>();
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');
        Stack<Character> opens = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(match.containsKey(s.charAt(i))) {
                opens.push(s.charAt(i));
            } else if(opens.isEmpty() || match.get(opens.pop()) != s.charAt(i)) {
                return false;
            }
        }

        return opens.isEmpty();
    }
}
