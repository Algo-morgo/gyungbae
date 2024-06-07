class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArr = sentence.split(" ");
        StringBuilder answer = new StringBuilder();

        for(String derivative : wordArr) {

            String replace = "";
            for(String root : dictionary) {
                if(derivative.startsWith(root) && (replace.equals("") || replace.length() > root.length())) {
                    replace = root;
                }
            }

            if(replace.equals("")) {
                answer.append(derivative).append(" ");
            }
            else {
                answer.append(replace).append(" ");
            }
        }

        return answer.toString().trim();
    }
}