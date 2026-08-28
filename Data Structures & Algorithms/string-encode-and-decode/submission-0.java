class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(int i = strs.size() - 1; i >= 0; i--) {
            result += strs.get(i);
            result += "\n";
        }
        return result;
    }

    public List<String> decode(String str) {
        Scanner stringScan = new Scanner(str);
        Stack<String> tempResult = new Stack<>();
        List<String> result = new ArrayList<>();

        while(stringScan.hasNextLine()) {
            String next = stringScan.nextLine();
            tempResult.push(next);
        }

        while(!tempResult.isEmpty()) {
            result.add(tempResult.pop());
        }

        return result;
    }
}
